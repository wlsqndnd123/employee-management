package kr.co.sist.view.admin;

import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import kr.co.sist.controller.event.UpdateEmployeeInformationEvent;
import kr.co.sist.vo.EmpInfoVO;


public class UpdateEmployeeInformation extends JFrame {
	private TextField jtPosition,jtJob,jtDept;
	private JButton jbtnChange,jbtnDelete,jbtnCancel;
	private JList<EmpInfoVO> jlSelectedEmpInfo;
	private EmpInfoVO eVO;
	public UpdateEmployeeInformation() {
		 super("사원 변경 및 삭제");

		 JLabel jlPosition = new JLabel("직급");
		 JLabel   jlJob = new JLabel("직무");
		 JLabel   jlDept = new JLabel("부서");

	        jtPosition = new TextField(10);
	        jtJob = new TextField(10);
	        jtDept = new TextField(10);

	        jbtnChange = new JButton("변경");
	        jbtnDelete = new JButton("삭제");
	        jbtnCancel = new JButton("취소");
	        jlSelectedEmpInfo = new JList<>();

	        // 수동으로 위치와 크기 설정하여 배치
	        jlSelectedEmpInfo.setBounds(20, 20, 350, 100); // 제이리스트
	        jlPosition.setBounds(50, 130, 60, 30); // 레이블: 직급
	        jtPosition.setBounds(130, 130, 150, 30); // 텍스트 필드: 직급
	        jlJob.setBounds(50, 170, 60, 30); // 레이블: 직무
	        jtJob.setBounds(130, 170, 150, 30); // 텍스트 필드: 직무
	        jlDept.setBounds(50, 210, 60, 30); // 레이블: 부서
	        jtDept.setBounds(130, 210, 150, 30); // 텍스트 필드: 부서
	        jbtnChange.setBounds(50, 250, 90, 30); // 버튼: 변경
	        jbtnDelete.setBounds(150, 250, 90, 30); // 버튼: 삭제
	        jbtnCancel.setBounds(250, 250, 90, 30); // 버튼: 취소

	        // 프레임에 컴포넌트 추가
	        add(jlSelectedEmpInfo);
	        add(jlPosition);
	        add(jtPosition);
	        add(jlJob);
	        add(jtJob);
	        add(jlDept);
	        add(jtDept);
	        add(jbtnChange);
	        add(jbtnDelete);
	        add(jbtnCancel);
	        UpdateEmployeeInformationEvent uei = new UpdateEmployeeInformationEvent(this);
	       
	        jbtnChange.addActionListener(uei);
	        jbtnDelete.addActionListener(uei);
	        jbtnCancel.addActionListener(uei);
	        
	        
	        setLayout(null); // 수동 레이아웃 설정

	        setSize(400, 330); // 프레임 크기 설정
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 동작 설정
	        setVisible(true); // 프레임을 화면에 보이게 함
	    }

	    public TextField getJtPosition() {
		return jtPosition;
	}

	public TextField getJtJob() {
		return jtJob;
	}

	public TextField getJtDept() {
		return jtDept;
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

	public JList<EmpInfoVO> getJlSelectedEmpInfo() {
		return jlSelectedEmpInfo;
	}

		public static void main(String[] args) {
			new UpdateEmployeeInformation();
	    }
}