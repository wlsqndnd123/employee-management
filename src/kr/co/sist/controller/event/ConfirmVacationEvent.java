package kr.co.sist.controller.event;

import kr.co.sist.dao.VacationStatusDAO;
import kr.co.sist.view.admin.ConfirmVacation;
import kr.co.sist.view.admin.ReturnReason;
import kr.co.sist.view.admin.VacationStatus;
import kr.co.sist.vo.VacationVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;


public class ConfirmVacationEvent extends WindowAdapter implements ActionListener {

    private ConfirmVacation cv;
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
