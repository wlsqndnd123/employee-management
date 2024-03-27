package kr.co.sist.view.admin;

import kr.co.sist.controller.event.ConfirmVacationEvent;
import kr.co.sist.view.util.JFrameComponent;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.sql.SQLException;

/**
 * Desc : 관리자가 휴가 승인처리를 하는 view<br>
 * *******************추가 수정 필요*********************<br>
 * 작성자 : 진수현<br>
 * 작성일 : 2024.03.15<br>
 * 수정자 : 고한별<br>
 * 수정일 : 2024.03.24<br>
 */
public class ConfirmVacation extends JFrame {
    private JLabel jlDocNum, jlEmpNum, jlEmpName, jlLeftVaction, jlApplyDate;
    private JTextField jtfDocNum, jtfEmpNum, jtfEmpName, jtfLeftVaction, jtfApplyDate;
    private JTextArea jtaContent;
    private JButton jbApprove, jbReturn, jbCancel;
    private JScrollPane jspJtaResult;
    private int check_code;

    public ConfirmVacation(String item) {
        setTitle("휴가 결재창");
        setLayout(null);

        jtaContent = new JTextArea();
        jspJtaResult = JFrameComponent.createPane(getContentPane(), jtaContent, 10, 50, 610, 350, false, true, true);
        jspJtaResult.setBorder(new TitledBorder("휴가신청사유"));

        createLabel();

        jtfDocNum = JFrameComponent.createTextField(getContentPane(), item, 60, 20, 80, 20, false);
        jtfEmpName = JFrameComponent.createTextField(getContentPane(), "이름", 185, 20, 60, 20, false);
        jtfEmpNum = JFrameComponent.createTextField(getContentPane(), "사번", 300, 20, 60, 20, false);
        jtfLeftVaction = JFrameComponent.createTextField(getContentPane(), "연차", 447, 20, 20, 20, false);
        jtfApplyDate = JFrameComponent.createTextField(getContentPane(), "날짜", 520, 20, 100, 20, false);

        jbCancel = JFrameComponent.createButton(getContentPane(), "뒤로", 450, 420, 100, 30);

        ConfirmVacationEvent cve = new ConfirmVacationEvent(this);
        try {
            check_code = cve.VDocStatus(item);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (check_code == 1) {
            jbApprove = JFrameComponent.createButton(getContentPane(), "승인", 50, 420, 100, 30);
            jbReturn = JFrameComponent.createButton(getContentPane(), "반려", 250, 420, 100, 30);
            jbReturn.addActionListener(cve);
            jbApprove.addActionListener(cve);
        }

        addWindowListener(cve);
        jbCancel.addActionListener(cve);

        setBounds(300, 100, 650, 550);
        setVisible(true);
    }

    private void createLabel() {
        jlDocNum = JFrameComponent.createLabel(getContentPane(), "문서번호", 10, 20, 60, 20);
        jlEmpName = JFrameComponent.createLabel(getContentPane(), "사원명", 145, 20, 40, 20);
        jlEmpNum = JFrameComponent.createLabel(getContentPane(), "사원번호", 250, 20, 50, 20);
        jlLeftVaction = JFrameComponent.createLabel(getContentPane(), "남은 연차", 367, 20, 80, 20);
        jlApplyDate = JFrameComponent.createLabel(getContentPane(), "신청날짜", 470, 20, 50, 20);
    }

    public JButton getJbCancel() {
        return jbCancel;
    }

    public JTextField getJtfDocNum() {
        return jtfDocNum;
    }


    public JTextField getJtfEmpNum() {
        return jtfEmpNum;
    }


    public JTextField getJtfEmpName() {
        return jtfEmpName;
    }

    public JTextField getJtfLeftVaction() {
        return jtfLeftVaction;
    }

    public JTextField getJtfApplyDate() {
        return jtfApplyDate;
    }

    public JTextArea getJtaContent() {
        return jtaContent;
    }

    public JButton getJbApprove() {
        return jbApprove;
    }

    public JButton getJbReturn() {
        return jbReturn;
    }
}
