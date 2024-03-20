package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;

import kr.co.sist.view.admin.VacationStatus;
import kr.co.sist.view.admin.WorkStatus;

public class WorkStatusEvent extends WindowAdapter implements ActionListener{

	private WorkStatus ws;
	
	public WorkStatusEvent(WorkStatus ws) {
		this.ws = ws;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == ws.getJbCheck()) {
			System.out.println(3);
			
			CheckWS(Integer.parseInt(ws.getJtfEmpNum().getText()), ws.getJcbDateRange().getSelectedItem().toString());
		}
		
		
		if(ae.getSource() == ws.getJbVacationStatus()) {
			new VacationStatus();
			ws.dispose();
			
		}
		
		
		if(ae.getSource() == ws.getJbGoMain()) {
			System.out.println(5);
		}
		
	}

	
	public void CheckWS(int empNum,String selectedDateRange) {
		System.out.println("checkws");
		
		
		
		
	}

	
}
