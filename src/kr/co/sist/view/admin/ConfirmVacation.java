package kr.co.sist.view.admin;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.co.sist.controller.event.ConfirmVacationEvent;


public class ConfirmVacation extends JFrame {
	private JLabel jlDocNum, jlEmpNum, jlEmpName, jlLeftVaction, jlApplyDate;
	private JTextField jtfDocNum, jtfEmpNum, jtfEmpName, jtfLeftVaction, jtfApplyDate;
	private JTextArea jtaContent;
	private JButton jbApprove, jbReturn, jbCancel;
	private int check_code;

	
	public ConfirmVacation(String item) throws SQLException {
		setTitle("휴가 결재창");
		setLayout(new BorderLayout());
		jtaContent = new JTextArea();
		JScrollPane jspJtaResult = new JScrollPane(jtaContent);
		jspJtaResult.setBorder(new TitledBorder("휴가신청사유"));
		
		
		
		
		
		jlDocNum =new JLabel("문서번호");
		jlEmpName = new JLabel("사원명");
		jlEmpNum = new JLabel("사원번호");
		jlLeftVaction = new JLabel("남은 연차 횟수");
		jlApplyDate = new JLabel("신청날짜");
		
		jtfDocNum =new JTextField(item);
		jtfEmpName = new JTextField();
		jtfEmpNum = new JTextField();
		jtfLeftVaction = new JTextField();
		jtfApplyDate = new JTextField();
		
		
		jtfDocNum.setEditable(false);
		jtfEmpName.setEditable(false);
		jtfEmpNum.setEditable(false);
		jtfLeftVaction.setEditable(false);
		jtfApplyDate.setEditable(false);
		
		jtaContent.setEditable(false);
		jtaContent.setLineWrap(true);
		jtaContent.setWrapStyleWord(true);
		
		
		jbApprove = new JButton("승인");
		jbReturn = new JButton("반려");
		jbCancel = new JButton("뒤로");
		
		
		JPanel panel = new JPanel();
	    panel.setLayout(null);
		jspJtaResult.setBounds(10,50,610,350);
		
		jlDocNum.setBounds(10, 20, 60, 20);
		jtfDocNum.setBounds(60, 20, 80, 20);
		
		jlEmpName.setBounds(145, 20, 40, 20);
		jtfEmpName.setBounds(185, 20, 60, 20);
		
		jlEmpNum.setBounds(250, 20, 50, 20);
		jtfEmpNum.setBounds(300, 20, 60, 20);
		
		jlLeftVaction.setBounds(367, 20, 80, 20);
		jtfLeftVaction.setBounds(447, 20, 20, 20);
		
		jlApplyDate.setBounds(470, 20, 50, 20);
		jtfApplyDate.setBounds(520, 20, 100, 20);
		
		
		
		jbApprove.setBounds(50,420,100,30);
		jbReturn.setBounds(250,420,100,30);
		jbCancel.setBounds(450,420,100,30);
		
		
		panel.add(jspJtaResult);
		
		panel.add(jlDocNum);
		panel.add(jtfDocNum);
		
		panel.add(jlEmpNum);
		panel.add(jtfEmpNum);
		
		
		panel.add(jlEmpName);
		panel.add(jtfEmpName);
		
		panel.add(jlLeftVaction);
		panel.add(jtfLeftVaction);
		
		
		panel.add(jlApplyDate);
		panel.add(jtfApplyDate);
		
		ConfirmVacationEvent cve = new ConfirmVacationEvent(this);
		jbReturn.addActionListener(cve);
		jbApprove.addActionListener(cve);
		jbCancel.addActionListener(cve);
		
		check_code = cve.VDocStatus(item);
		if(check_code == 1) {
		panel.add(jbApprove);
		panel.add(jbReturn);
		}
	
		panel.add(jbCancel);
		
		
		add(panel, BorderLayout.CENTER);
		
		
		


		
		setBounds(300, 100, 650, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    
        
        
	}
	
	
	public JButton getJbCancel() {
		return jbCancel;
	}


	public JLabel getJlDocNum() {
		return jlDocNum;
	}


	public JLabel getJlEmpNum() {
		return jlEmpNum;
	}


	public JLabel getJlEmpName() {
		return jlEmpName;
	}


	public JLabel getJlLeftVaction() {
		return jlLeftVaction;
	}


	public JLabel getJlApplyDate() {
		return jlApplyDate;
	}


	public JTextField getJtfDocNum() {
		return jtfDocNum;
	}


	public JTextField getJtfEmpNum() {
		return jtfEmpNum;
	}


	public JTextField getJtfEmpName() {
		return jtfEmpName;
	}


	public JTextField getJtfLeftVaction() {
		return jtfLeftVaction;
	}


	public JTextField getJtfApplyDate() {
		return jtfApplyDate;
	}


	public JTextArea getJtaContent() {
		return jtaContent;
	}


	public JButton getJbApprove() {
		return jbApprove;
	}


	public JButton getJbReturn() {
		return jbReturn;
	}
	
}
