package kr.co.sist.view.admin;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import kr.co.sist.controller.event.ReturnReasonEvent;



public class ReturnReason extends JDialog{
	private JTextArea jtaContent;
	private JButton jbInput;
	private JButton jbCancel;
	private String dNum;

	public ReturnReason(ConfirmVacation cv, String docNum) {
		super(cv,"반려사유작성",true);
		dNum = docNum;
		
		setLayout(new BorderLayout());
		
		jtaContent = new JTextArea();
		jbInput = new JButton("입력");
		jbCancel = new JButton("취소");
		JScrollPane jspJtaResult = new JScrollPane(jtaContent);
        jspJtaResult.setBorder(new TitledBorder("반려사유"));
		
		JPanel jp = new JPanel();
		jp.setLayout(null);
		
		jtaContent.setLineWrap(true);
		jtaContent.setWrapStyleWord(true);
		
		
		jspJtaResult.setBounds(10,20,445,250);
		
		jbInput.setBounds(80, 285, 100, 30);
		jbCancel.setBounds(280, 285, 100, 30);
		
		jp.add(jbCancel);
		jp.add(jbInput);

		jp.add(jspJtaResult);
		
		add(jp, BorderLayout.CENTER);
		
		
		
		ReturnReasonEvent rre = new ReturnReasonEvent(cv,this,dNum);
		jbInput.addActionListener(rre);
		jbCancel.addActionListener(rre);
	
		


		setBounds(cv.getX(),cv.getY()+50,480,400);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		
		
	}
	
	
	
	public ReturnReason(ConfirmDocs cd, String docNum) {
		super(cd,"반려사유작성",true);
		dNum = docNum;
		setLayout(new BorderLayout());
		
		jtaContent = new JTextArea();
		jbInput = new JButton("입력");
		jbCancel = new JButton("취소");
		JScrollPane jspJtaResult = new JScrollPane(jtaContent);
        jspJtaResult.setBorder(new TitledBorder("반려사유"));
		
		JPanel jp = new JPanel();
		jp.setLayout(null);
		
		jtaContent.setLineWrap(true);
		jtaContent.setWrapStyleWord(true);
		
		jspJtaResult.setBounds(10,20,445,250);
		
		jbInput.setBounds(80, 285, 100, 30);
		jbCancel.setBounds(280, 285, 100, 30);
		
		jp.add(jbCancel);
		jp.add(jbInput);

		jp.add(jspJtaResult);
		
		add(jp, BorderLayout.CENTER);
		
		
		
		ReturnReasonEvent rre = new ReturnReasonEvent(cd,this,dNum);
		jbInput.addActionListener(rre);
		jbCancel.addActionListener(rre);
	
		


		setBounds(cd.getX(),cd.getY()+50,480,400);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		
		
	}


	public JTextArea getJtaContent() {
		return jtaContent;
	}


	public JButton getJbInput() {
		return jbInput;
	}


	public JButton getJbCancel() {
		return jbCancel;
	}




}
