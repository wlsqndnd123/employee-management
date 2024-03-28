package kr.co.sist.controller.event;

import kr.co.sist.dao.VacationStatusDAO;
import kr.co.sist.view.admin.ConfirmVacation;
import kr.co.sist.view.admin.ReturnReason;
import kr.co.sist.view.admin.VacationStatus;
import kr.co.sist.view.common.Login;
import kr.co.sist.vo.VacationVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.SQLException;

import java.time.temporal.ChronoUnit;
import java.util.List;


public class ConfirmVacationEvent extends WindowAdapter implements ActionListener {

    private ConfirmVacation cv;
    private int assign_count;
    private int use_count;
    
    
    
    private List<VacationVO> vVOList;

    public ConfirmVacationEvent(ConfirmVacation cv) {
        this.cv = cv;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cv.getJbReturn()) {
            String docNum = cv.getJtfDocNum().getText();
            new ReturnReason(cv, docNum);
        }

        if (ae.getSource() == cv.getJbApprove()) {
        	if(assign_count-use_count  < 0) {
        		
        		JOptionPane.showMessageDialog(cv, "연차를 모두 사용했습니다.");
        		
        		return;
        	}
        	
            int result = JOptionPane.showConfirmDialog(cv, "승인하시겠습니까?.", "확인", JOptionPane.YES_NO_OPTION);
            if (result != JOptionPane.YES_OPTION) {
                return;
            }
            ApproveVacation(Integer.parseInt(cv.getJtfDocNum().getText()));
            cv.dispose();
            new VacationStatus();
        }

        if (ae.getSource() == cv.getJbCancel()) {
            cv.dispose();
            new VacationStatus();
        }
    }


    public void ApproveVacation(int docNum) {
        VacationStatusDAO vsDAO = VacationStatusDAO.getInstance();
        try {
            vsDAO.approveVS(docNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    
//    public void UpdateVacationCount() {
//    	VacationStatusDAO vsDAO = VacationStatusDAO.getInstance();
//    	 long useDateMillis = endDate.getTime() - startDate.getTime();
//    	 long useDate = useDateMillis / (1000 * 60 * 60 * 24);
//    	 int usedCount = (int)(useDate + use_count);
//    	 int empNum = Integer.parseInt(cv.getJtfEmpNum().getText());
//    	 try {
//    	 vsDAO.UpdateUsedcount(empNum, usedCount);
//    	 } catch (SQLException e) {
//             e.printStackTrace();
//         }
//    	
//    	
//    }
    
   
    public int VDocStatus(String item) throws SQLException {
        VacationStatusDAO vsDAO = VacationStatusDAO.getInstance();
        vVOList = vsDAO.selectedDoc_numInfo(item);
        int check_code = 0;

        if (vVOList.isEmpty()) {
            JOptionPane.showMessageDialog(cv, "내용이 없습니다.");
        } else {
            for (VacationVO vVO : vVOList) {
                cv.getJtaContent().setText(vVO.getWorkLog());
                cv.getJtfEmpName().setText(vVO.getEmpName());
                cv.getJtfEmpNum().setText("" + vVO.getEmpNo());
                cv.getJtfLeftVaction().setText("" + (vVO.getAssignCount() - vVO.getUseCount()));
                cv.getJtfApplyDate().setText(vVO.getCreatedDate().toString());
                
                assign_count = vVO.getAssignCount();
                use_count = vVO.getUseCount();
              
                
                check_code = vVO.getCode2();
               
            }
        }
        return check_code;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        cv.dispose();
    }

    
    
}
