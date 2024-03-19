package kr.co.sist.controller.event;

import kr.co.sist.view.admin.CreateEmployeeInformation;
import kr.co.sist.vo.EmpInfoVO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CreateEmployeeInformationEvent extends WindowAdapter implements ActionListener {
	private CreateEmployeeInformation ceiv;
	public CreateEmployeeInformationEvent() {
		
	}//CreateEmployeeInformationEvent

	public CreateEmployeeInformationEvent(CreateEmployeeInformation ceiv) {
		this.ceiv = ceiv;
	}//CreateEmployeeInformationEvent
	


	@Override
	public void windowClosing(WindowEvent e) {
		ceiv.dispose();
	}//windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==ceiv.getJbtnAdd()) {
			System.out.println("등록 버튼 누름");
		}//end if
		if(ae.getSource()==ceiv.getJbtnCancel()) {
			System.out.println("취소 버튼 누름");
			ceiv.dispose();
		}//end if
	}//actionPerformed
	
	
	/**
	 * 입력받은 사원의 정보를 정리하고, DAO와 연결하는 method
	 * @param eVO
	 */
	public void addEmp(EmpInfoVO eVO) {
		
	}
	
}//class
