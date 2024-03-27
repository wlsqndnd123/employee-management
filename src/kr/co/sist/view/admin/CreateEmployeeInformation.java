package kr.co.sist.view.admin;

import kr.co.sist.controller.event.CreateEmployeeInformationEvent;
import kr.co.sist.dao.CheckEmployeeInformationDAO;
import kr.co.sist.view.util.JFrameComponent;
import kr.co.sist.vo.EmpInfoVO;

import java.sql.SQLException;
import java.util.List;

import javax.swing.*;

public class CreateEmployeeInformation extends JFrame {
    private JLabel jlEmpno, jlName, jlPosition, jlJob, jlTel, jlDep;
    private JTextField tfEmpno, tfName, tfPosition, tfJob, tfTel, tfDep;
    private JButton jbtnAdd, jbtnCancel;
    private JComboBox<String> cbDept, cbPosition;
    public CreateEmployeeInformation() {
        super("사원등록");
        setLayout(null);
        cbDept = JFrameComponent.createStringCombobox(getContentPane(),170,160,170,25);
        cbPosition = JFrameComponent.createStringCombobox(getContentPane(), 170,70,170,25);
        createComboBoxContent();
        createLabel();
        createTextField();
        createButton();
        createEvent();

        setBounds(300, 100, 400, 300);
        setVisible(true);
    }
    private void createComboBoxContent() {
        try {
            CheckEmployeeInformationDAO ciDAO = CheckEmployeeInformationDAO.getInstance();

            List<EmpInfoVO> dept = ciDAO.selectInfo("dept");

            for (EmpInfoVO emp : dept) {
                cbDept.addItem(emp.getDept());
            }

            cbDept.setSelectedIndex(0);

            List<EmpInfoVO> pos = ciDAO.selectInfo("pos");

            for (EmpInfoVO emp : pos) {
                cbPosition.addItem(emp.getPosition());
            }

            cbPosition.setSelectedIndex(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createLabel() {
        jlEmpno = JFrameComponent.createLabel(getContentPane(),"사원번호",40,10,100,25);
        jlName = JFrameComponent.createLabel(getContentPane(),"사원이름",40,40,100,25);
        jlPosition = JFrameComponent.createLabel(getContentPane(),"직급",40,70,100,25);
        jlJob = JFrameComponent.createLabel(getContentPane(),"직무",40,100,100,25);
        jlTel = JFrameComponent.createLabel(getContentPane(),"내선번호",40,130,100,25);
        jlDep = JFrameComponent.createLabel(getContentPane(),"부서",40,160,100,25);
    }

    private void createTextField() {
        tfEmpno = JFrameComponent.createTextField(getContentPane(),170,10,170,25);
        tfName = JFrameComponent.createTextField(getContentPane(),170,40,170,25);
        tfJob = JFrameComponent.createTextField(getContentPane(),170,100,170,25);
        tfTel = JFrameComponent.createTextField(getContentPane(),170,130,170,25);
        tfEmpno.setEditable(false);
    }

    private void createButton() {
        jbtnAdd = JFrameComponent.createButton(getContentPane(),"등록",50,210,100,30);
        jbtnCancel = JFrameComponent.createButton(getContentPane(),"취소",220,210,100,30);
    }

    private void createEvent() {
        CreateEmployeeInformationEvent cei = new CreateEmployeeInformationEvent(this);

        addWindowListener(cei);
        jbtnAdd.addActionListener(cei);
        jbtnCancel.addActionListener(cei);
        cbDept.addActionListener(cei);
        cbPosition.addActionListener(cei);
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
	public JComboBox<String> getCbDept() {
		return cbDept;
	}
	public JComboBox<String> getCbPosition() {
		return cbPosition;
	}

}