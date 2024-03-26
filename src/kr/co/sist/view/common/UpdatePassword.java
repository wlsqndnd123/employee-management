package kr.co.sist.view.common;

import kr.co.sist.controller.event.UpdatePasswordEvent;
import kr.co.sist.view.util.JFrameComponent;
import kr.co.sist.vo.LoginVO;
import kr.co.sist.vo.UpdatePasswordVO;

import javax.swing.*;

public class UpdatePassword extends JFrame {
    private JLabel jlUpdatePw, jlCurrentPw;
    private JTextField jtfUpdatePw;
    private JTextField jtfCurrentPw;
    private JButton UpdateButton, ExitButton;
    private String password;
    private LoginVO lVO;
    private static UpdatePasswordVO upVO;

    public UpdatePassword() {
    }

    public UpdatePassword(LoginVO lVO) {
        super("비밀번호 변경");
        setLayout(null);
        this.lVO = lVO;

        createLabel();
        createTextField();
      createButton();
        createEvent();

        setBounds(300, 120, 500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }//UpdatePassword

    private void createLabel(){
        jlUpdatePw = JFrameComponent.createLabel(getContentPane(),"변경할 비밀번호",50, 130, 90, 40);
        jlCurrentPw = JFrameComponent.createLabel(getContentPane(),"현재 비밀번호",50, 80, 90, 40);
    }

    private void createTextField(){
        jtfUpdatePw = JFrameComponent.createTextField(getContentPane(),150, 130, 200, 40);
        jtfCurrentPw = JFrameComponent.createTextField(getContentPane(),lVO.getPassword(),150, 80, 200, 40,false);
    }

    private void createButton(){
        UpdateButton = JFrameComponent.createButton(getContentPane(),"변경",170, 200, 60, 30);
        ExitButton = JFrameComponent.createButton(getContentPane(),"취소",260, 200, 60, 30);
    }

    private void createEvent(){
        UpdatePasswordEvent evt = new UpdatePasswordEvent(this);

        UpdateButton.addActionListener(evt);
        ExitButton.addActionListener(evt);
    }

    public JTextField getJtfUpdatePw() {
        return jtfUpdatePw;
    }

    public JTextField getJtfCurrentPw() {
        return jtfCurrentPw;
    }

    public JButton getUpdateButton() {
        return UpdateButton;
    }

    public JButton getExitButton() {
        return ExitButton;
    }

    public String getPassword() {
        return password;
    }

    public static UpdatePasswordVO getUpVO() {
        return upVO;
    }

    public LoginVO getLoginVO() {
        return lVO;
    }
}//class
