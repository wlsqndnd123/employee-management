package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import kr.co.sist.view.admin.ConfirmVacation;
import kr.co.sist.view.admin.ReturnReason;

public class ConfirmVacationEvent extends WindowAdapter implements ActionListener{
	
	private ConfirmVacation cv;
	
	public ConfirmVacationEvent(ConfirmVacation cv) {
		this.cv=cv;
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == cv.getJbReturn()){
			new ReturnReason(cv);
		}
		
		if(ae.getSource() == cv.getJbApprove()) {
			System.out.println("1");
		}

		
	}

	

	
	
	
}
