package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

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
			System.out.println("취소");
		}//end if
		if(ae.getSource()==upEmpInfo.getJbtnChange()) {
			System.out.println("변경");
			
		}//end if
		if(ae.getSource()==upEmpInfo.getJbtnDelete()) {
			System.out.println("삭제");
			
		}//end if
	}//actionPerformed
	
	/**
	 * 선택한 사원의 직무,직급,부서를 변경하는 method
	 * @param eVO
	 */
	public void modifyEmpInfo(EmpInfoVO eVO) {
		
	}
	
	/**
	 * 입력한(사원번호) 사원의 논리삭제
	 * @param empno
	 */
	public void disableEmpInfo(int empno) {
		
	}//disableEmpInfo
}
