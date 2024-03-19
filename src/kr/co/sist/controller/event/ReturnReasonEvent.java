package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import kr.co.sist.view.admin.ReturnReason;

public class ReturnReasonEvent extends WindowAdapter implements ActionListener{

	private ReturnReason rr;
	
	public ReturnReasonEvent(ReturnReason rr) {
		this.rr=rr;
	}
	
	
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == rr.getJbInput()) {
			System.out.println(1.1);
		}
		
		if(ae.getSource() == rr.getJbCancel()) {
			System.out.println(1.2);
		}
		
		
		
	}
	

}
