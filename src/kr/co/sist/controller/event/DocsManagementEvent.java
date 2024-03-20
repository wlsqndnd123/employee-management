package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import kr.co.sist.view.admin.DocsManagement;

public class DocsManagementEvent implements ActionListener{
	private DocsManagement dmm;
	private JButton jbtnBackhome,jbtnSearch;
	
	public DocsManagementEvent(DocsManagement dmm) {
		this.dmm = dmm;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==dmm.getJbtnBackhome()) {
			System.out.println("메인으로");
		}
		if(ae.getSource()==dmm.getJbtnSearch()) {
			System.out.println("찾기");
		}
	}
	
	
	
}
