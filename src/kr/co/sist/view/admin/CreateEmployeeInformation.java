package kr.co.sist.view.admin;

import kr.co.sist.controller.event.CreateEmployeeInformationEvent;

import javax.swing.*;

public class CreateEmployeeInformation extends JFrame {
    private JLabel jlEmpno, jlName, jlPosition, jlJob, jlTel, jlDep;
    private JTextField tfEmpno, tfName, tfPosition, tfJob, tfTel, tfDep;
    private JButton jbtnAdd, jbtnCancel;

    public CreateEmployeeInformation() {
        super("사원등록");
        setLayout(null);

        createLabel();
        createTextField();
        createButton();
        createEvent();

        jlEmpno = new JLabel("사원번호");
        jlName = new JLabel("사원이름");
        jlPosition = new JLabel("직급");
        jlJob = new JLabel("직무");
        jlTel = new JLabel("내선번호");
        jlDep = new JLabel("부서");

        add(jlEmpno);
        add(jlName);
        add(jlPosition);
        add(jlJob);
        add(jlTel);
        add(jlDep);

        tfEmpno = new JTextField();
        tfName = new JTextField();
        tfPosition = new JTextField();
        tfJob = new JTextField();
        tfTel = new JTextField();
        tfDep = new JTextField();

        add(tfEmpno);
        add(tfName);
        add(tfPosition);
        add(tfJob);
        add(tfTel);
        add(tfDep);

        jbtnAdd = new JButton("등록");
        jbtnCancel = new JButton("취소");

        add(jbtnAdd);
        add(jbtnCancel);

        CreateEmployeeInformationEvent cei = new CreateEmployeeInformationEvent(this);
        jbtnAdd.addActionListener(cei);
        jbtnCancel.addActionListener(cei);

        setBounds(300, 100, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createLabel() {

    }

    private void createTextField() {

    }

    private void createButton() {

    }

    private void createEvent() {

    }

    public JTextField getTfEmpno() {
        return tfEmpno;
    }

    public JTextField getTfName() {
        return tfName;
    }

    public JTextField getTfPosition() {
        return tfPosition;
    }

    public JTextField getTfJob() {
        return tfJob;
    }

    public JTextField getTfTel() {
        return tfTel;
    }

    public JTextField getTfDep() {
        return tfDep;
    }

    public JButton getJbtnAdd() {
        return jbtnAdd;
    }

    public JButton getJbtnCancel() {
        return jbtnCancel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CreateEmployeeInformation::new);
    }
}