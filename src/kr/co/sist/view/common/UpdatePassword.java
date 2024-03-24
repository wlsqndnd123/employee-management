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
import kr.co.sist.vo.UpdatePasswordVO;

public class UpdatePassword extends JFrame{
	private JLabel jlCurrentPw, jlUpdatePw;
	private JTextField jtfUpdatePw;
	private JButton UpdateButton, ExitButton;
	private String password;
	
	private static UpdatePasswordVO upVO;
	public UpdatePassword(UpdatePasswordVO upVO) {
		super("비밀번호 변경");
		
		setLayout(null);
		
		try {
			password="현재 비밀번호 : " + UpdatePasswordDAO.getInstance().getPassword();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//현재 비밀번호 라벨
		jlCurrentPw = new JLabel("현재 비밀번호; "+jlCurrentPw);
		jlCurrentPw.setBounds(150, 80, 200, 40);
		add(jlCurrentPw);
		
		
		//바꿀 비밀번호 라벨 및 입력필드 생성
		jlUpdatePw = new JLabel("변경할 비밀번호");
		jlUpdatePw.setBounds(50, 130, 90, 40);
		add(jlUpdatePw);
		jtfUpdatePw = new JTextField();
		jtfUpdatePw.setBounds(150, 130, 200, 40);
		add(jtfUpdatePw);
		
		//변경하기 버튼
		UpdateButton = new JButton("변경");
		UpdateButton.setBounds(170, 200, 60, 30);
		add(UpdateButton);
		
		//취소 버튼
		ExitButton = new JButton("취소");
		ExitButton.setBounds(260, 200, 60, 30);
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(ExitButton);
		
		//액션리스너
		UpdatePasswordEvent evt = new UpdatePasswordEvent(this);
		UpdateButton.addActionListener(evt);
		
		setBounds(300,120,500,400);
        setVisible(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UpdatePassword
	
	public UpdatePassword() {
		// TODO Auto-generated constructor stub
	}

	public JButton getJbtnsave() {
		return UpdateButton;
	}
	
	public JTextField getUpdatePw() {
		return jtfUpdatePw;
	}
	
//	public static void main(String[] args) {
//        try {
//			new UpdatePassword(upVO);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
	
	
}
