package kr.co.sist.view.common;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login extends JFrame implements ActionListener {
    private JLabel jlLogin;
    private JTextField jtfEmp_no;
    private JPasswordField jpwfPass;
    private JButton jbLogin, jbExit, jbFindPassword;
    private JLabel jlResult;

    public Login() {
        super("Login");

        setLayout(null); // LayoutManager를 null로 설정하여 수동으로 위치와 크기를 조절할 수 있도록 합니다.

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
        jbLogin.addActionListener(this);
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

        setBounds(300,120,500,400);
        setVisible(true); // 프레임을 표시합니다.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }//Login


    public static void main(String[] args) {
        new Login();
    }//main


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}//class
