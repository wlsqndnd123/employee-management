package kr.co.sist.view.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import kr.co.sist.controller.event.UpdateTelNumberEvent;

public class UpdateTelNumber extends JFrame implements ActionListener {

	private JButton goHome, save, excPw;
	private JTable jtbl;
	private JLabel jlInfo, jlExcNo;

	public UpdateTelNumber() {
		super("사원창(정보변경)");
		setLayout(null);

		
		String contents[][] = { { "240001", "박사장", "노예굴리기", "직급", "부서명", "내선번호", "입사일" } };
		String header[] = { "번호", "이름", "직무", "직급", "부서명", "내선번호", "입사일" };
		JTable jtbl = new JTable(contents, header);

		goHome = new JButton("메인으로");
		save = new JButton("저장");
		excPw = new JButton("비밀번호 변경");

		JTextField jtf = new JTextField();
		jlInfo = new JLabel("저장된 정보");
		jlExcNo = new JLabel("변경할 내선번호");

		add(jlInfo);
		add(jtbl);
		add(jlExcNo);
		add(jtf);

		add(goHome);
		add(save);
		add(excPw);

		jlInfo.setBounds(30, 20, 100, 20);
		jtbl.setBounds(30, 50, 400, 80);
		jlExcNo.setBounds(180, 140, 120, 20);
		jtf.setBounds(150, 170, 160, 30);

		goHome.setBounds(350, 20, 100, 30);
		save.setBounds(80, 260, 100, 30);
		excPw.setBounds(240, 260, 150, 30);

		UpdateTelNumberEvent utne= new UpdateTelNumberEvent(this);
		goHome.addActionListener(utne);
		
		setSize(500, 600);
		setBounds(300,100,650,550);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	
	
	/**
	 * @return the jtbl
	 */
	public JTable getJtbl() {
		return jtbl;
	}



	/**
	 * @return the jlInfo
	 */
	public JLabel getJlInfo() {
		return jlInfo;
	}



	/**
	 * @return the jlExcNo
	 */
	public JLabel getJlExcNo() {
		return jlExcNo;
	}



	/**
	 * @return the goHome
	 */
	public JButton getGoHome() {
		return goHome;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new UpdateTelNumber();
	}

}
