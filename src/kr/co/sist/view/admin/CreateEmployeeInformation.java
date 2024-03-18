package kr.co.sist.view.admin;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import kr.co.sist.controller.event.CreateEmployeeInformationEvent;

public class CreateEmployeeInformation extends JFrame{
	private JTextField tfEmpno, tfName,tfPosition, tfJob, tfTel,tfDep;
	private JButton jbtnAdd,jbtnCancel;
	public CreateEmployeeInformation(){
		super("사원등록");

        // 레이블 생성
        JLabel jlEmpno = new JLabel("사원번호");
        JLabel jlName = new JLabel("사원이름");
        JLabel jlPosition = new JLabel("직급");
        JLabel jlJob = new JLabel("직무");
        JLabel jlTel = new JLabel("내선번호");
        JLabel jlDep = new JLabel("부서");

        // 텍스트 필드 생성
        tfEmpno = new JTextField(20);
        tfName = new JTextField(20);
        tfPosition = new JTextField(20);
        tfJob = new JTextField(20);
        tfTel = new JTextField(20);
        tfDep = new JTextField(20);

        // 버튼 생성
        jbtnAdd = new JButton("등록");
        jbtnCancel = new JButton("취소");

        // 패널 생성
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10)); // 그리드 레이아웃 설정

        // 패널에 컴포넌트 추가
        panel.add(jlEmpno);
        panel.add(tfEmpno);
        panel.add(jlName);
        panel.add(tfName);
        panel.add(jlPosition);
        panel.add(tfPosition);
        panel.add(jlJob);
        panel.add(tfJob);
        panel.add(jlTel);
        panel.add(tfTel);
        panel.add(jlDep);
        panel.add(tfDep);
        panel.add(jbtnAdd);
        panel.add(jbtnCancel);

        // 프레임에 패널 추가
        add(panel);
        CreateEmployeeInformationEvent cei = new CreateEmployeeInformationEvent(this);
        jbtnAdd.addActionListener(cei);
        jbtnCancel.addActionListener(cei);
        

        setSize(400, 300); // 프레임 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 동작 설정
        setVisible(true); // 프레임을 화면에 보이게 함
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