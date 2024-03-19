package kr.co.sist.view.admin;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import kr.co.sist.controller.event.ReturnReasonEvent;



public class ReturnReason extends JDialog{
//public class ReturnReason extends JDialog{
	private JTextArea jtaContent;
	private JButton jbInput;
	private JButton jbCancel;
	

	public ReturnReason(ConfirmVacation cv) {
		super(cv,"반려사유작성",true);
		
		setLayout(new BorderLayout());
		
		jtaContent = new JTextArea();
		jbInput = new JButton("입력");
		jbCancel = new JButton("취소");
		JScrollPane jspJtaResult = new JScrollPane(jtaContent);
        jspJtaResult.setBorder(new TitledBorder("반려사유"));
		
		JPanel jp = new JPanel();
		jp.setLayout(null);
		jspJtaResult.setBounds(10,20,445,250);
		
		jbInput.setBounds(80, 285, 100, 30);
		jbCancel.setBounds(280, 285, 100, 30);
		
		jp.add(jbCancel);
		jp.add(jbInput);

		jp.add(jspJtaResult);
		
		add(jp, BorderLayout.CENTER);
		
		
		
		ReturnReasonEvent rre = new ReturnReasonEvent(this);
		jbInput.addActionListener(rre);
		jbCancel.addActionListener(rre);
	
		


		setBounds(cv.getX(),cv.getY()+50,480,400);
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
