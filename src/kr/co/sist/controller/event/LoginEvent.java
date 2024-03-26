package kr.co.sist.controller.event;

import kr.co.sist.dao.LoginDAO;
import kr.co.sist.view.admin.AdminMenu;
import kr.co.sist.view.common.FindPassword;
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
    private static String empno;

    public LoginEvent(Login login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login.getJbLogin()) {
            login();
        }//end if

        if (ae.getSource() == login.getJbExit()) {
            login.dispose();
        }

        if (ae.getSource() == login.getJbFindPassword()) {
            try {
                new FindPassword(new Login());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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

        if (Password.equals(savedPw)) {
            if (authcode.equals("SUPER") || authcode.equals("ADMIN")) {
                new AdminMenu();
                login.dispose();
            } else {
                new UserMenu();
                login.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "비번확인하쇼");
        }
    }

    public static String getEmpno() {
        return empno;
    }
}//LoginEvent
