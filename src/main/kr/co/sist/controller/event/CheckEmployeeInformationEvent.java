package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.view.admin.CheckEmployeeInformation;

public class CheckEmployeeInformationEvent extends WindowAdapter implements ActionListener {
	private CheckEmployeeInformation checkEmpview;
	public CheckEmployeeInformationEvent() {
		
	}
	public CheckEmployeeInformationEvent(CheckEmployeeInformation checkEmpview) {
		this.checkEmpview=checkEmpview;
	}
	
	
	
	@Override
	public void windowClosing(WindowEvent e) {
		
	}



	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() ==checkEmpview.getJbtnAddEmp()) {
			System.out.println("사원추가");
		}
		if(ae.getSource() ==checkEmpview.getJbtnMain()) {
			System.out.println("메인으로");
			
		}
		if(ae.getSource() ==checkEmpview.getJbtnSearch()) {
			System.out.println("사원검색");
			
		}
		
	}
}
