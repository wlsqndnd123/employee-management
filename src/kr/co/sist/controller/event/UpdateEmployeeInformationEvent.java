package kr.co.sist.controller.event;

import kr.co.sist.dao.UpdateEmployeeInformationDAO;
import kr.co.sist.view.admin.CheckEmployeeInformation;
import kr.co.sist.view.admin.UpdateEmployeeInformation;
import kr.co.sist.vo.EmpInfoVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;


public class UpdateEmployeeInformationEvent extends WindowAdapter implements ActionListener {
    UpdateEmployeeInformation upEmpInfo;

    public UpdateEmployeeInformationEvent() {

    }

    public UpdateEmployeeInformationEvent(UpdateEmployeeInformation upEmpInfo) {
        this.upEmpInfo = upEmpInfo;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == upEmpInfo.getJbtnCancel()) {
            new CheckEmployeeInformation();
            upEmpInfo.dispose();
        }//end if

        if (ae.getSource() == upEmpInfo.getJbtnChange()) {
            modifyEmpInfo();
            new CheckEmployeeInformation();
            upEmpInfo.dispose();
            
            

        }//end if
        if (ae.getSource() == upEmpInfo.getJbtnDelete()) {
        	 int askagain = JOptionPane.showConfirmDialog(null, " 해당 정보의 사원을 삭제 하시겠습니까? \n 삭제를 원하시면 확인을 눌러주세요." ,"확인",JOptionPane.YES_NO_OPTION);
             if(askagain ==JOptionPane.YES_OPTION) {
            	 
            disableEmpInfo();
            new CheckEmployeeInformation();
            upEmpInfo.dispose();
             }
        }//end if
    }//actionPerformed

    /**
     * 선택한 사원의 직무,직급,부서를 변경하는 method
     */
    public void modifyEmpInfo() {
    	String dept = upEmpInfo.getCbDept().getSelectedItem().toString();
        String position = upEmpInfo.getCbPosition().getSelectedItem().toString();
        String job = upEmpInfo.getInputJtJob().getText().trim();
        
        if((job.isEmpty()||dept.isEmpty()||position.isEmpty())){
        	JOptionPane.showMessageDialog(upEmpInfo, "모든 칸이 입력되어야 합니다.");
        	return;
        }
        	
        try {
            EmpInfoVO eVO = new EmpInfoVO
                    (Integer.parseInt(upEmpInfo.getTfEmpno().getText()), null, job, position, dept, null, position, null);
            UpdateEmployeeInformationDAO upDAO = UpdateEmployeeInformationDAO.getInstance();
            int cnt = upDAO.updateEmpInfo(eVO);
            if (cnt == 1) {
                JOptionPane.showMessageDialog(upEmpInfo, "해당 사원의 정보가 변경되었습니다.");
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
    }

    /**
     * 입력한(사원번호) 사원의 논리삭제
     */
    public void disableEmpInfo() {
        try {
            int empno = Integer.parseInt(upEmpInfo.getTfEmpno().getText());
            UpdateEmployeeInformationDAO upDAO = UpdateEmployeeInformationDAO.getInstance();
            int cnt = upDAO.deleteEmpInfo(empno);
            int cnt2 = upDAO.deleteAccountEMP(empno);
            int cnt3 = upDAO.deleteUserAuthEmp(empno);

            if (cnt == 1 && cnt2 == 1 && cnt3 == 1) {
                JOptionPane.showMessageDialog(upEmpInfo, "해당 사원이 삭제되었습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//disableEmpInfo

    @Override
    public void windowClosing(WindowEvent e) {
        upEmpInfo.dispose();
        new CheckEmployeeInformation();
    }
    
}
