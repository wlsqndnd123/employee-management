package kr.co.sist.view.admin;

import kr.co.sist.controller.event.UpdateEmployeeInformationEvent;
import kr.co.sist.view.util.JFrameComponent;
import kr.co.sist.vo.EmpInfoVO;

import javax.swing.*;

public class UpdateEmployeeInformation extends JFrame {
    private JTextField InputJtPosition, InputJtJob, InputJtDept;
    private JTextField tfEmpno, tfName, tfPosition, tfJob, tfTel, tfDep;
    private JButton jbtnChange, jbtnDelete, jbtnCancel;
    private JLabel InputJlPosition, InputJlJob, InputJlDept, jlEmpno, jlName, jlPosition, jlJob, jlTel, jlDept;
    private EmpInfoVO eVO;

    public UpdateEmployeeInformation(EmpInfoVO eVO) {
        super("사원 변경 및 삭제");
        setLayout(null);

        this.eVO = eVO;

        createButton();
        createLabel();
        createText();
        createEvent();

        setSize(430, 440);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createText() {
        InputJtPosition = JFrameComponent.createTextField(getContentPane(), 150, 170, 150, 30);
        InputJtJob = JFrameComponent.createTextField(getContentPane(), 150, 210, 150, 30);
        InputJtDept = JFrameComponent.createTextField(getContentPane(), 150, 250, 150, 30);

        tfEmpno = JFrameComponent.createTextField(getContentPane(), String.valueOf(eVO.getEmpno()), 100, 20, 100, 30, false);
        tfName = JFrameComponent.createTextField(getContentPane(), eVO.getName(), 100, 60, 100, 30, false);
        tfPosition = JFrameComponent.createTextField(getContentPane(), eVO.getPosition(), 100, 100, 100, 30, false);
        tfJob = JFrameComponent.createTextField(getContentPane(), eVO.getJob(), 280, 20, 100, 30, false);
        tfTel = JFrameComponent.createTextField(getContentPane(), eVO.getTel(), 280, 60, 100, 30, false);
        tfDep = JFrameComponent.createTextField(getContentPane(), eVO.getDept(), 280, 100, 100, 30, false);
    }

    private void createLabel() {
        InputJlPosition = JFrameComponent.createLabel(getContentPane(), "직급", 90, 170, 60, 30);
        InputJlJob = JFrameComponent.createLabel(getContentPane(), "직무", 90, 210, 60, 30);
        InputJlDept = JFrameComponent.createLabel(getContentPane(), "부서", 90, 250, 60, 30);
        jlEmpno = JFrameComponent.createLabel(getContentPane(), "사원번호", 25, 20, 60, 30);
        jlName = JFrameComponent.createLabel(getContentPane(), "사원이름", 25, 60, 60, 30);
        jlPosition = JFrameComponent.createLabel(getContentPane(), "직급", 25, 100, 60, 30);
        jlJob = JFrameComponent.createLabel(getContentPane(), "직무", 210, 20, 60, 30);
        jlTel = JFrameComponent.createLabel(getContentPane(), "내선번호", 210, 60, 60, 30);
        jlDept = JFrameComponent.createLabel(getContentPane(), "부서", 210, 100, 60, 30);
    }

    private void createButton() {
        jbtnChange = JFrameComponent.createButton(getContentPane(), "변경", 50, 320, 90, 30);
        jbtnDelete = JFrameComponent.createButton(getContentPane(), "삭제", 160, 320, 90, 30);
        jbtnCancel = JFrameComponent.createButton(getContentPane(), "취소", 270, 320, 90, 30);
    }

    private void createEvent() {
        UpdateEmployeeInformationEvent uei = new UpdateEmployeeInformationEvent(this);

        jbtnChange.addActionListener(uei);
        jbtnDelete.addActionListener(uei);
        jbtnCancel.addActionListener(uei);
    }

    public JButton getJbtnChange() {
        return jbtnChange;
    }

    public JButton getJbtnDelete() {
        return jbtnDelete;
    }

    public JButton getJbtnCancel() {
        return jbtnCancel;
    }

    public JTextField getTfEmpno() {
        return tfEmpno;
    }

    public JTextField getInputJtPosition() {
        return InputJtPosition;
    }

    public JTextField getInputJtJob() {
        return InputJtJob;
    }

    public JTextField getInputJtDept() {
        return InputJtDept;
    }
}