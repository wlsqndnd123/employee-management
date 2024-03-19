package kr.co.sist.view.admin;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ConfirmVacation extends JFrame {
	private JLabel jlDocNum, jlEmpNum, jlEmpName, jlLeftVaction, jlApplyDate;
	private JTextField jtfDocNum, jtfEmpNum, jtfEmpName, jtfLeftVaction, jtfApplyDate;
	private JTextArea jtaContent;
	private JButton jbApprove, jbReturn;
	
	public ConfirmVacation() {
		setTitle("휴가 결재창");
		setLayout(new BorderLayout());
		jtaContent = new JTextArea("이것은 내가 휴가를 하고 싶은 이유다");
		JScrollPane jspJtaResult = new JScrollPane(jtaContent);
		jspJtaResult.setBorder(new TitledBorder("휴가신청사유"));
		
		jlDocNum =new JLabel("문서번호");
		jlEmpName = new JLabel("사원번호");
		jlEmpNum = new JLabel("사원명");
		jlLeftVaction = new JLabel("남은 연차 횟수");
		jlApplyDate = new JLabel("신청날짜");
		
		jtfDocNum =new JTextField("1111");
		jtfEmpName = new JTextField("홍길동");
		jtfEmpNum = new JTextField("2222");
		jtfLeftVaction = new JTextField("2");
		jtfApplyDate = new JTextField("24.03.19");
		
		
		jtfDocNum.setEditable(false);
		jtfEmpName.setEditable(false);
		jtfEmpNum.setEditable(false);
		jtfLeftVaction.setEditable(false);
		jtfApplyDate.setEditable(false);
		
		
		
		
		
		jbApprove = new JButton("승인");
		jbReturn = new JButton("반려");
		
		
		
		JPanel panel = new JPanel();
	    panel.setLayout(null);
		jspJtaResult.setBounds(10,50,610,350);
		
		jlDocNum.setBounds(10, 20, 60, 20);
		jtfDocNum.setBounds(60, 20, 60, 20);
		
		jlEmpNum.setBounds(130, 20, 40, 20);
		jtfEmpNum.setBounds(170, 20, 60, 20);
		
		jlEmpName.setBounds(240, 20, 50, 20);
		jtfEmpName.setBounds(290, 20, 60, 20);
		
		jlLeftVaction.setBounds(360, 20, 80, 20);
		jtfLeftVaction.setBounds(440, 20, 20, 20);
		
		jlApplyDate.setBounds(470, 20, 50, 20);
		jtfApplyDate.setBounds(520, 20, 100, 20);
		
		
		
		jbApprove.setBounds(100,420,100,30);
		jbReturn.setBounds(400,420,100,30);
		
		
		
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
		
		
		panel.add(jbApprove);
		panel.add(jbReturn);
		
		
		
		add(panel, BorderLayout.CENTER);
		
		
		
		
		
		
		
		
		
		
		
		setBounds(300, 100, 650, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
        new ConfirmVacation();
    }
	
	
}
