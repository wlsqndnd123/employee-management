package kr.co.sist.view.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import kr.co.sist.dao.UpdatePasswordDAO;

public class UpdatePassword extends JFrame {
	private JLabel jlPass;
	private JTextField jtfUpdatePass;
	private JButton jbUpdate, jbExit;
	private String password;
	
	public UpdatePassword() {
		super("비밀번호 변경");
		
		setLayout(null);
		
		try {
			password="현재 비밀번호 : " + UpdatePasswordDAO.getInstance().getPassword();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//현재 비밀번호 라벨
		jlPass = new JLabel(password);
		jlPass.setBounds(100, 80, 200, 40);
		add(jlPass);
		
		//바꿀 비밀번호 입력필드 생성
		jtfUpdatePass = new JTextField();
		jtfUpdatePass.setBounds(100, 130, 200, 40);
		add(jtfUpdatePass);
		
		//변경하기 버튼
		jbUpdate = new JButton("변경");
		jbUpdate.setBounds(150, 200, 60, 30);
		add(jbUpdate);
		
		//취소 버튼
		jbExit = new JButton("취소");
		jbExit.setBounds(240, 200, 60, 30);
		jbExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(jbExit);
		
		setBounds(300,120,500,400);
        setVisible(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UpdatePassword
	public static void main(String[] args) {
        new UpdatePassword();
    }
}
