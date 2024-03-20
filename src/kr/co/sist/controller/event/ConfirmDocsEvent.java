package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import kr.co.sist.view.admin.ConfirmDocs;

public class ConfirmDocsEvent implements ActionListener {
	private ConfirmDocs cfdocs;
	private JButton jbtnShape,jbtnApproval,jbtncompanion,jbtncheck;
	
	public ConfirmDocsEvent(ConfirmDocs cfdocs) {
		this.cfdocs = cfdocs;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==cfdocs.getJbtnShape()) {
			System.out.println("공유");
		}
		if(ae.getSource()==cfdocs.getJbtnApproval()) {
			System.out.println("승인");
		}
		if(ae.getSource()==cfdocs.getJbtncompanion()) {
			System.out.println("반려");
		}
		if(ae.getSource()==cfdocs.getJbtncheck()) {
			System.out.println("확인");
		}
	}
	

}
