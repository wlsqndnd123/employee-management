package kr.co.sist.view.common;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindPassword extends JDialog implements ActionListener {
    private JLabel findPassword, idLabel, phoneNumberLabel;
    private JTextField jtfemp_no, jtfPhoneNumber;
    private JButton jbCheckPw, jbExit;

    public FindPassword(Login pf) {
        super(pf, "비밀번호 찾기", true); // 부모 프레임, 타이틀, 모달 다이얼로그 여부 설정

        setLayout(null);


        // 비밀번호 찾기 라벨
        findPassword = new JLabel("비밀번호 찾기");
        findPassword.setBounds(90, 50, 100, 30);
        add(findPassword);
//        add(new JLabel()); // 빈 라벨


        // 사원번호 입력 라벨 및 필드
        idLabel = new JLabel("아이디");
        idLabel.setBounds(30, 80, 60, 40);
        add(idLabel);
        jtfemp_no = new JTextField();
        jtfemp_no.setBounds(90, 80, 200, 40);
        add(jtfemp_no);


        // 전화번호 입력 라벨 및 필드
        phoneNumberLabel = new JLabel("전화번호");
        phoneNumberLabel.setBounds(30, 130, 60, 40);
        add(phoneNumberLabel);
        jtfPhoneNumber = new JTextField();
        jtfPhoneNumber.setBounds(90, 130, 200, 40);


        add(jtfPhoneNumber);


        // 비밀번호 확인 버튼
        jbCheckPw = new JButton("확인");
        jbCheckPw.setBounds(320, 105, 80, 40);
        jbCheckPw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 비밀번호 확인 기능 구현
                // getId(), getPassword() 등의 메서드 활용
            }
        });
        add(jbCheckPw);


        // 종료 버튼
        jbExit = new JButton("종료");
        jbExit.setBounds(180,190,60,30);
        jbExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // 다이얼로그 닫기
            }
        });
        add(jbExit);



        setBounds(300,120,450,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setLocationRelativeTo(pf); // 부모 프레임의 가운데에 다이얼로그 위치
        setVisible(true); // 다이얼로그 표시
    }

    public FindPassword() {
        // TODO Auto-generated constructor stub
    }

    public String getId() {
        return jtfemp_no.getText().trim(); // 입력된 아이디 반환
    }

    public String getPassword() {
        return ""; // 임시 반환값
    }

    public String getPhoneNumber() {
        return jtfPhoneNumber.getText().trim(); // 입력된 전화번호 반환
    }

    public void showErrorMessage() {
        JOptionPane.showMessageDialog(this, "비밀번호를 찾을 수 없습니다."); // 에러 메시지 표시
    }
    public static void main(String[] args) {
        new FindPassword();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}