package kr.co.sist.controller.event;

import kr.co.sist.dao.LoginDAO;
import kr.co.sist.view.admin.AdminMenu;
import kr.co.sist.view.common.Login;
import kr.co.sist.view.user.UserMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;


public class LoginEvent extends WindowAdapter implements ActionListener {
    private Login login;
    private static String empno, password;


    public LoginEvent(Login login) throws SQLException {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //로그인 버튼 클릭시 id와 pw를 변수에 저장
        if (ae.getSource() == login.getJbLogin()) {

            login();

        }//end if
        //종료버튼 클릭 시 창 닫기
        if (ae.getSource() == login.getJbExit()) {
            login.dispose();
        }

    }//actionPerformed


    @Override
    public void windowClosing(WindowEvent we) {
        login.dispose();
    }

    public void login() {
        empno = login.getEmpNoField().getText();
        String Password = login.getPasswordField().getText();

        LoginDAO lDAO = LoginDAO.getInstance();
        String savedPw = lDAO.confirmUser(empno).getPassword();
        String authcode = lDAO.confirmUser(empno).getAuthCode();
        System.out.println(authcode);

        if (Password.equals(savedPw)) {
            if (authcode.equals("SUPER") || authcode.equals("ADMIN")) {
                new AdminMenu();
            } else {
                new UserMenu();
            }

        } else {
            JOptionPane.showMessageDialog(null, "비번확인하쇼");
        }

    }


    public static String getEmpno() {
        return empno;
    }


////////////////////////////////////////////////////////////////
//	
//	
//	
//	
//	
//	/**
//	 * 유효성 검사
//	 */
//	public void chkIdNull() {
////		
////		Validation validator = new Validation();
////		boolean idEmpty = validator.isEmpty(emp_no);
////        boolean passwordEmpty = validator.isEmpty(password);
//
//        if (emp_no.isEmpty() || password.isEmpty()) {
//            JOptionPane.showMessageDialog(null,"아이디와 비밀번호를 모두 입력해주세요.");
//        }
//		
//	}//chkIdNull
//	
//	public boolean confirmUserPassword() throws SQLException {
//		// 아이디와 비밀번호가 맞는지 확인하는 로직 추가
//        LoginDAO loginDAO = LoginDAO.getInstance();
//        String authCode = loginDAO.getLogInfo();
//
//        // 관리자인 경우
//        if (authCode.equals("ADMIN")) {
//            return true;
//        }
//        // 일반 사용자인 경우
//        else if (authCode.equals("USER")) {
//            return false;
//        }
//        // 인증 실패
//        else {
//            JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 잘못되었습니다.");
//            return false;
//        }
//	}
//	
//	public void loginClik() throws SQLException {
//		setInputInfo();
//        chkIdNull();
//
//        if (confirmUserPassword()) {
//            // 관리자 계정으로 로그인한 경우
//            SwingUtilities.invokeLater(AdminMenu::new);
//        } else {
//            // 사용자 계정으로 로그인한 경우
//            SwingUtilities.invokeLater(UserMenu::new);
//        }
//	}//loginClik


}//LoginEvent
