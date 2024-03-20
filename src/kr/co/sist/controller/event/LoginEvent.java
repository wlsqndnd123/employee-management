package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.ObjectInputValidation;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import kr.co.sist.dao.LoginDAO;
import kr.co.sist.view.admin.AdminMenu;
import kr.co.sist.view.common.Login;
import kr.co.sist.view.user.UserMenu;



public class LoginEvent extends WindowAdapter implements ActionListener{
	private String emp_no, password;
	private Login login;
	
	
	public LoginEvent(Login login) throws SQLException {
		this.login = login;
		
	}
	

	
	public void setInputInfo() {
		// 입력받은 아이디와 비밀번호를 변수에 저장
        emp_no = login.getEmpNoField().getText();
        password = login.getPasswordField().getText();
	}
	
//	public class Validation {
//
//	    /**
//	     * Desc. : 인자로 넘어온 str에 값이 없으면 true return
//	     */
//	    public boolean isEmpty(String str){
//	        return str == null || str.isEmpty();
//	    }
//	}
	
	/**
	 * 유효성 검사
	 */
	public void chkIdNull() {
//		
//		Validation validator = new Validation();
//		boolean idEmpty = validator.isEmpty(emp_no);
//        boolean passwordEmpty = validator.isEmpty(password);

        if (emp_no.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null,"아이디와 비밀번호를 모두 입력해주세요.");
        }
		
	}//chkIdNull
	
	public boolean confirmUserPassword() throws SQLException {
		// 아이디와 비밀번호가 맞는지 확인하는 로직 추가
        LoginDAO loginDAO = LoginDAO.getInstance();
        String authCode = loginDAO.getLogInfo();

        // 관리자인 경우
        if (authCode.equals("ADMIN")) {
            return true;
        }
        // 일반 사용자인 경우
        else if (authCode.equals("USER")) {
            return false;
        }
        // 인증 실패
        else {
            JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 잘못되었습니다.");
            return false;
        }
	}
	
	public void loginClik() throws SQLException {
		setInputInfo();
        chkIdNull();

        if (confirmUserPassword()) {
            // 관리자 계정으로 로그인한 경우
            SwingUtilities.invokeLater(AdminMenu::new);
        } else {
            // 사용자 계정으로 로그인한 경우
            SwingUtilities.invokeLater(UserMenu::new);
        }
	}//loginClik

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == login.getJbLogin()) {
            try {
                loginClik();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
}//LoginEvent
