package kr.co.sist.view.admin;

import kr.co.sist.controller.event.ReturnReasonEvent;
import kr.co.sist.view.util.JFrameComponent;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class ReturnReason extends JDialog {
    private JTextArea jtaContent;
    private JButton jbInput;
    private JButton jbCancel;
    private String dNum;

    public ReturnReason(ConfirmVacation cv, String docNum) {
        super(cv, "반려사유작성", true);
        this.dNum = docNum;
        setLayout(null);

        jtaContent = new JTextArea();
        JScrollPane jspJtaResult = JFrameComponent.createPane(getContentPane(), jtaContent,10, 20, 445, 250,true,true,true);
        jspJtaResult.setBorder(new TitledBorder("반려사유"));

        jbInput = JFrameComponent.createButton(getContentPane(), "입력", 80, 285, 100, 30);
        jbCancel = JFrameComponent.createButton(getContentPane(), "취소", 280, 285, 100, 30);

        ReturnReasonEvent rre = new ReturnReasonEvent(cv, this, dNum);
        jbInput.addActionListener(rre);
        jbCancel.addActionListener(rre);

        setBounds(cv.getX(), cv.getY() + 50, 480, 400);
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public ReturnReason(ConfirmDocs cd, String docNum) {
        super(cd, "반려사유작성", true);
        this.dNum = docNum;
        setLayout(null);

        jtaContent = new JTextArea();
        JScrollPane jspJtaResult = JFrameComponent.createPane(getContentPane(), jtaContent,10, 20, 445, 250,true,true,true);
        jspJtaResult.setBorder(new TitledBorder("반려사유"));

        jbInput = JFrameComponent.createButton(getContentPane(), "입력", 80, 285, 100, 30);
        jbCancel = JFrameComponent.createButton(getContentPane(), "취소", 280, 285, 100, 30);

        ReturnReasonEvent rre = new ReturnReasonEvent(cd, this, dNum);
        jbInput.addActionListener(rre);
        jbCancel.addActionListener(rre);

        setBounds(cd.getX(), cd.getY() + 50, 480, 400);
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public JTextArea getJtaContent() {
        return jtaContent;
    }

    public JButton getJbInput() {
        return jbInput;
    }

    public JButton getJbCancel() {
        return jbCancel;
    }
}
