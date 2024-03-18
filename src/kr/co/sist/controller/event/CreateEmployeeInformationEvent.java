package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.view.admin.CreateEmployeeInformation;

public class CreateEmployeeInformationEvent extends WindowAdapter implements ActionListener {
	private CreateEmployeeInformation ceiv;
	public CreateEmployeeInformationEvent() {
		
	}

	public CreateEmployeeInformationEvent(CreateEmployeeInformation ceiv) {
		this.ceiv = ceiv;
	}
	


	@Override
	public void windowClosing(WindowEvent e) {
		ceiv.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==ceiv.getJbtnAdd()) {
			System.out.println("등록 버튼 누름");
		}
		if(ae.getSource()==ceiv.getJbtnCancel()) {
			System.out.println("취소 버튼 누름");
			
		}
	}

}
