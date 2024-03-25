package kr.co.sist.view.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import kr.co.sist.controller.event.UpdatePasswordEvent;
import kr.co.sist.dao.UpdatePasswordDAO;
import kr.co.sist.vo.LoginVO;
import kr.co.sist.vo.UpdatePasswordVO;

public class UpdatePassword extends JFrame{
//	private JLabel jlCurrentPw, jlUpdatePw;
	private JTextField jtfUpdatePw;
	private JTextField jtfCurrentPw;
	private JButton UpdateButton, ExitButton;
	private String password;
	
	private static UpdatePasswordVO upVO;
	public UpdatePassword(LoginVO lVO) {
		super("비밀번호 변경");
		
		
		
//		try {
//			password="현재 비밀번호 : " + UpdatePasswordDAO.getInstance().getPassword();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		//입력받는 변경할 비밀번호
		JLabel jlUpdatePw = new JLabel("변경할 비밀번호");
		jtfUpdatePw = new JTextField();

		//창에 출력하는 현재 비밀번호
		JLabel jlCurrentPw = new JLabel("현재 비밀번호");
		jtfCurrentPw = new JTextField();
		jtfCurrentPw.setText(lVO.getPassword());
		jtfCurrentPw.setEditable(false);
		
		//버튼
		UpdateButton = new JButton("변경");
		ExitButton = new JButton("취소");
		
		//수동 배치
		jlCurrentPw.setBounds(50, 80, 90, 40);
		jtfCurrentPw.setBounds(150, 80, 200, 40);
		jlUpdatePw.setBounds(50, 130, 90, 40);
		jtfUpdatePw.setBounds(150, 130, 200, 40);
		
		UpdateButton.setBounds(170, 200, 60, 30);
		ExitButton.setBounds(260, 200, 60, 30);
		
		
		//컴포넌트 추가
		add(jlCurrentPw);
		add(jlUpdatePw);
		add(jtfUpdatePw);
		add(UpdateButton);
		add(ExitButton);

		
		//액션리스너
		UpdatePasswordEvent evt = new UpdatePasswordEvent(this);
		UpdateButton.addActionListener(evt);
		ExitButton.addActionListener(evt);
		
		setLayout(null);
		setBounds(300,120,500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); 
		
	}//UpdatePassword
	public JTextField getJtfUpdatePw() {
		return jtfUpdatePw;
	}
	public JTextField getJtfCurrentPw() {
		return jtfCurrentPw;
	}
	public JButton getUpdateButton() {
		return UpdateButton;
	}
	public JButton getExitButton() {
		return ExitButton;
	}
	public String getPassword() {
		return password;
	}
	public static UpdatePasswordVO getUpVO() {
		return upVO;
	}
	
}//class
