package kr.co.sist.view.common;

import kr.co.sist.controller.event.FindPasswordEvent;
import kr.co.sist.view.util.JFrameComponent;

import javax.swing.*;

public class FindPassword extends JDialog {
    private JLabel findPassword, idLabel, phoneNumberLabel;
    private JTextField jtfemp_no, jtfPhoneNumber;
    private JButton jbCheckPw, jbExit;

    public FindPassword(Login pf) {
        super(pf, "비밀번호 찾기", true);

        setLayout(null);

        createLabel();
        createTextField();
        createButton();
        createEvent();

        setBounds(300, 120, 450, 300);
        setLocationRelativeTo(pf);
        setVisible(true);
    }

    private void createLabel() {
        findPassword = JFrameComponent.createLabel(getContentPane(), "비밀번호 찾기", 90, 50, 100, 30);
        idLabel = JFrameComponent.createLabel(getContentPane(), "아이디", 30, 80, 60, 40);
        phoneNumberLabel = JFrameComponent.createLabel(getContentPane(), "전화번호", 30, 130, 60, 40);
    }

    private void createTextField() {
        jtfemp_no = JFrameComponent.createTextField(getContentPane(), 90, 80, 200, 40);
        jtfPhoneNumber = JFrameComponent.createTextField(getContentPane(), 90, 130, 200, 40);
    }

    private void createButton() {
        jbCheckPw = JFrameComponent.createButton(getContentPane(), "확인", 320, 105, 80, 40);
        jbExit = JFrameComponent.createButton(getContentPane(), "종료", 180, 190, 60, 30);
    }

    public JTextField getEmpNoField() {
        return jtfemp_no;
    }

    public String getPassword() {
        return ""; // 임시 반환값
    }

    public JTextField getPhoneNumber() {
        return jtfPhoneNumber; // 입력된 전화번호 반환
    }

    public JButton getJbCheckPw() {
        return jbCheckPw;
    }

    public JButton getJbExit() {
        return jbExit;
    }

    public void showErrorMessage() {
        JOptionPane.showMessageDialog(this, "비밀번호를 찾을 수 없습니다."); // 에러 메시지 표시
    }

    private void createEvent() {
        FindPasswordEvent fpe = new FindPasswordEvent(this);
        addWindowListener(fpe);
        jbCheckPw.addActionListener(fpe);
        jbExit.addActionListener(fpe);
    }
}