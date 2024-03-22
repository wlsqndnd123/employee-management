package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

import kr.co.sist.view.admin.ConfirmDocs;
import kr.co.sist.view.admin.DocsManagement;
import kr.co.sist.view.admin.ReturnReason;
import kr.co.sist.view.admin.ShareDept;

public class ConfirmDocsEvent extends WindowAdapter implements ActionListener {
	private ConfirmDocs cfdocs;
	private JButton jbtnShape,jbtnApproval,jbtncompanion,jbtncheck;
	
	public ConfirmDocsEvent(ConfirmDocs cfdocs) {
		super();
		this.cfdocs = cfdocs;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==cfdocs.getJbtnShape()) {
			new ShareDept();
			cfdocs.dispose();
		}
		if(ae.getSource()==cfdocs.getJbtnApproval()) {
			System.out.println("승인하는 매서드 연결해야함");
			new DocsManagement();
			cfdocs.dispose();
		}
		if(ae.getSource()==cfdocs.getJbtncompanion()) {
			String docNum = cfdocs.getJtfdocnum().getText();
			new ReturnReason(cfdocs, docNum);
		}
		if(ae.getSource()==cfdocs.getJbtncheck()) {
			new DocsManagement();
			cfdocs.dispose();
			
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}
	

}
