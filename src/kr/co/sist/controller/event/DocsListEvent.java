package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import kr.co.sist.view.user.DocsList;

public class DocsListEvent implements ActionListener, ItemListener{
	private DocsList dclist;
	private JButton jbtnAddDoc;
	private JButton jbtnGoMain;
	private JCheckBox cbcheck;
	
	
	public DocsListEvent(DocsList dclist) {
		this.dclist = dclist;
		

	}

	

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==dclist.getJbtnAddDoc()) {
			System.out.println("문서등록");
		}
		if(ae.getSource()==dclist.getJbtnGoMain()) {
			System.out.println("메인으로");
		}

	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==dclist.getCbcheck()) {
			System.out.println("체크");
		}
		
	}
	
	

	
}