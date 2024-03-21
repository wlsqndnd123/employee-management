package kr.co.sist.view.admin;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import kr.co.sist.controller.event.ConfirmDocsEvent;

public class ConfirmDocs extends JFrame {
	
	private JButton jbtnShape,jbtnApproval,jbtncompanion,jbtncheck;
	private JTextField jtfcontants,jtfdocnum,jtfempno,jtfempname,jtfdate;
	private JLabel jldocnum,jlempno,jlempname,jldate;
	
	public ConfirmDocs() {
		 super("관리자문서확인");
	        
	    	jbtnShape=new JButton("공유");
			jbtnApproval=new JButton("승인");
			jbtncompanion=new JButton("반려");
			jbtncheck=new JButton("확인");
			jtfcontants=new JTextField();
			jldocnum=new JLabel("문서번호:");
			jlempno=new JLabel("사번:");
			jlempname=new JLabel("사원명:");
			jldate=new JLabel("신청날짜:");
			jtfdocnum=new JTextField();
			jtfempno=new JTextField();
			jtfempname=new JTextField();
			jtfdate=new JTextField();
			
			ConfirmDocsEvent cfdevt=new ConfirmDocsEvent(this);
			jbtnShape.addActionListener(cfdevt);
			jbtnApproval.addActionListener(cfdevt);
			jbtncompanion.addActionListener(cfdevt);
			jbtncheck.addActionListener(cfdevt);
			
			jbtnShape.setBounds(30, 360, 100, 30);
			jbtnApproval.setBounds(180, 360, 100, 30);
			jbtncompanion.setBounds(340, 360, 100, 30);
			jbtncheck.setBounds(500, 360, 100, 30);
			jtfcontants.setBounds(20, 80, 600, 250);
			
			jldocnum.setBounds(30, 30, 100, 20);
			jlempno.setBounds(180, 30, 100, 20);
			jlempname.setBounds(290, 30, 100, 20);
			jldate.setBounds(420, 30, 100, 20);
			jtfdocnum.setBounds(90, 30, 80, 20);
			jtfempno.setBounds(210, 30, 80, 20);
			jtfempname.setBounds(335, 30, 80, 20);
			jtfdate.setBounds(480, 30, 80, 20);
			
			jtfdocnum.setEditable(false);
			jtfempno.setEditable(false);
			jtfempname.setEditable(false);
			jtfdate.setEditable(false);
			
			
			add(jbtnShape);
	        add(jbtnApproval);
	        add(jbtncompanion);
	        add(jbtncheck);
	        add(jtfcontants);
	        add(jldocnum);
	        add(jlempno);
	        add(jlempname);
	        add(jldate);
	        add(jtfdocnum);
	        add(jtfempno);
	        add(jtfempname);
	        add(jtfdate);
	        
	        
	        
	        
	        setLayout(null);
	        
	        setBounds(300,100,650,460);
	        setVisible(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public JButton getJbtnShape() {
		return jbtnShape;
	}
	public JButton getJbtnApproval() {
		return jbtnApproval;
	}
	public JButton getJbtncompanion() {
		return jbtncompanion;
	}
	public JButton getJbtncheck() {
		return jbtncheck;
	}
	public JTextField getJtfcontants() {
		return jtfcontants;
	}
	public JTextField getJtfdocnum() {
		return jtfdocnum;
	}
	public JTextField getJtfempno() {
		return jtfempno;
	}
	public JTextField getJtfempname() {
		return jtfempname;
	}
	public JTextField getJtfdate() {
		return jtfdate;
	}
	public JLabel getJldocnum() {
		return jldocnum;
	}
	public JLabel getJlempno() {
		return jlempno;
	}
	public JLabel getJlempname() {
		return jlempname;
	}
	public JLabel getJldate() {
		return jldate;
	}
	public static void main(String[] args) {
		new ConfirmDocs();
	}
}
