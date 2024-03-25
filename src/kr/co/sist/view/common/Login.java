package kr.co.sist.view.common;


import kr.co.sist.controller.event.LoginEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {
    private JLabel jlLogin;
    private JTextField jtfEmp_no;
    private JPasswordField jpwfPass;
    private JButton jbLogin, jbExit, jbFindPassword;
    private JLabel jlResult;

    public Login() throws SQLException {
        super("Login");

        setLayout(null);

        // 로그인 라벨 생성 및 설정
        jlLogin = new JLabel("로그인");
        jlLogin.setBounds(100, 50, 100, 30);
        add(jlLogin);

        //'아이디' 라벨 추가
        JLabel idLabel = new JLabel("아이디");
        idLabel.setBounds(40, 80, 60, 40); // 위치 설정
        add(idLabel);

        //'비밀번호' 라벨 추가
        JLabel passwordLabel = new JLabel("비밀번호");
        passwordLabel.setBounds(40, 130, 60, 40); // 위치 설정
        add(passwordLabel);

        // 사원 번호 입력 필드 생성 및 설정
        jtfEmp_no = new JTextField();
        jtfEmp_no.setBounds(100, 80, 200, 40);

        add(jtfEmp_no);

        // 비밀번호 입력 필드 생성 및 설정
        jpwfPass = new JPasswordField();
        jpwfPass.setBounds(100, 130, 200, 40);
        add(jpwfPass);

        // 비밀번호 찾기 버튼 생성 및 설정
        jbFindPassword = new JButton("비밀번호 찾기");
        jbFindPassword.setBounds(100, 200, 120, 30);
        jbFindPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FindPassword(Login.this); // FindPassword 다이얼로그 열기
            }
        });
        add(jbFindPassword);

        // 로그인 버튼 생성 및 설정
        jbLogin = new JButton("로그인");
        jbLogin.setBounds(320, 105, 80, 40);
        LoginEvent le = new LoginEvent(this);

        jbLogin.addActionListener(le);

        add(jbLogin);

        // 종료 버튼 생성 및 설정
        jbExit = new JButton("종료");
        jbExit.setBounds(240, 200, 60, 30);

        jbExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(jbExit);
        setBounds(300, 120, 500, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }//Login

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void applyEvent() throws SQLException {
        LoginEvent le = new LoginEvent(this);
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

}//class
