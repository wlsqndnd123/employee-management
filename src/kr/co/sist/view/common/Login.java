package kr.co.sist.view.common;

import kr.co.sist.controller.event.LoginEvent;
import kr.co.sist.view.util.JFrameComponent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Login extends JFrame {
    private JLabel jlLogin, jlResult, idLabel, passwordLabel;
    private JTextField jtfEmp_no;
    private JPasswordField jpwfPass;
    private JButton jbLogin, jbExit, jbFindPassword;

    public Login() throws SQLException {
        super("Login");

        setLayout(null);

        createLabel();
        createButton();

        jtfEmp_no = JFrameComponent.createTextField(getContentPane(),100, 80, 200, 40);
        jpwfPass = JFrameComponent.createPasswordField(getContentPane(),100, 130, 200, 40);

        createEvent();

        setBounds(300, 120, 500, 400);
        setVisible(true);
    }//Login

    private void createLabel(){
        jlLogin = JFrameComponent.createLabel(getContentPane(),"로그인",100, 50, 100, 30);
        idLabel = JFrameComponent.createLabel(getContentPane(), "아이디",40, 80, 60, 40);
        passwordLabel = JFrameComponent.createLabel(getContentPane(),"비밀번호",40, 130, 60, 40);
    }

    private void createButton(){
        jbFindPassword = JFrameComponent.createButton(getContentPane(),"비밀번호 찾기",100, 200, 120, 30);
        jbLogin = JFrameComponent.createButton(getContentPane(),"로그인",320, 131, 80, 40);
        jbExit = JFrameComponent.createButton(getContentPane(),"종료",240, 200, 60, 30);
    }

    private void createEvent(){
        LoginEvent le = new LoginEvent(this);

        addWindowListener(le);
        jtfEmp_no.addKeyListener(le);
        jpwfPass.addKeyListener(le);
        jbLogin.addActionListener(le);
        jbExit.addActionListener(le);
        jbFindPassword.addActionListener(le);
    }

    public JButton getJbLogin() {
        return jbLogin;
    }

    public JButton getJbExit() {
        return jbExit;
    }

    public JTextField getEmpNoField() {
        return jtfEmp_no;
    }

    public JTextField getPasswordField() {
        return jpwfPass;
    }

    public JButton getJbFindPassword() {
        return jbFindPassword;
    }
}//class
