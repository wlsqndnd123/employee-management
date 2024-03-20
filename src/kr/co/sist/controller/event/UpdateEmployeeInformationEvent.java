package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.dao.UpdateEmployeeInformationDAO;
import kr.co.sist.view.admin.CheckEmployeeInformation;
import kr.co.sist.view.admin.UpdateEmployeeInformation;
import kr.co.sist.vo.EmpInfoVO;



public class UpdateEmployeeInformationEvent extends WindowAdapter implements ActionListener{
	UpdateEmployeeInformation upEmpInfo;
	public UpdateEmployeeInformationEvent() {
		
	}
	
	public UpdateEmployeeInformationEvent(UpdateEmployeeInformation upEmpInfo) {
		this.upEmpInfo = upEmpInfo;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==upEmpInfo.getJbtnCancel()) {
			new CheckEmployeeInformation();
			upEmpInfo.dispose();
		}//end if
		if(ae.getSource()==upEmpInfo.getJbtnChange()) {
			System.out.println("변경");
			modifyEmpInfo();
			
		}//end if
		if(ae.getSource()==upEmpInfo.getJbtnDelete()) {
			System.out.println("삭제");
			disableEmpInfo();
		}//end if
	}//actionPerformed
	
	/**
	 * 선택한 사원의 직무,직급,부서를 변경하는 method
	 * @param eVO
	 */
	public void modifyEmpInfo() {
		String job = upEmpInfo.getInputJtJob().getText().trim();
		String dept = upEmpInfo.getInputJtDept().getText().trim();
		String position = upEmpInfo.getInputJtPosition().getText().trim();
		try {
		EmpInfoVO eVO = new EmpInfoVO
		(Integer.parseInt(upEmpInfo.getTfEmpno().getText()), null, job, position, dept, null, position, null);
			UpdateEmployeeInformationDAO upDAO = UpdateEmployeeInformationDAO.getInstance();
			int cnt = upDAO.updateEmpInfo(eVO);
			if (cnt ==1) {
				JOptionPane.showMessageDialog(upEmpInfo, "해당 사원의 정보가 변경되었습니다.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	/**
	 * 입력한(사원번호) 사원의 논리삭제
	 * @param empno
	 */
	public void disableEmpInfo() {
		try {
			int empno =Integer.parseInt(upEmpInfo.getTfEmpno().getText());
			UpdateEmployeeInformationDAO upDAO = UpdateEmployeeInformationDAO.getInstance();
			int cnt = upDAO.deleteEmpInfo(empno);
			if (cnt ==1) {
				JOptionPane.showMessageDialog(upEmpInfo, "해당 사원이 삭제되었습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//disableEmpInfo
}
