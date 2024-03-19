package kr.co.sist.view.admin;

import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import kr.co.sist.controller.event.UpdateEmployeeInformationEvent;
import kr.co.sist.vo.EmpInfoVO;


public class UpdateEmployeeInformation extends JFrame {
	private JTextField InputJtPosition,InputJtJob,InputJtDept;
	private JTextField tfEmpno, tfName,tfPosition, tfJob, tfTel,tfDep;
	private JButton jbtnChange,jbtnDelete,jbtnCancel;
	private EmpInfoVO eVO;
	public UpdateEmployeeInformation() {
		 super("사원 변경 및 삭제");
		 //입력받는 사원정보
		 JLabel InputJlPosition = new JLabel("직급");
		 JLabel   InputJlJob = new JLabel("직무");
		 JLabel   InputJlDept = new JLabel("부서");
		 InputJtPosition = new JTextField(10);
		 InputJtJob = new JTextField(10);
		 InputJtDept = new JTextField(10);
		 
	     //창에 출력하는 사원 정보
		 JLabel jlEmpno = new JLabel("사원번호");
		 JLabel jlName = new JLabel("사원이름");
		 JLabel jlPosition = new JLabel("직급");
		 JLabel jlJob = new JLabel("직무");
		 JLabel jlTel = new JLabel("내선번호");
		 JLabel jlDept = new JLabel("부서");
	        tfEmpno = new JTextField(10);
	        tfName= new JTextField(10);
	        tfPosition= new JTextField(10);
	        tfJob = new JTextField(10);
	        tfTel= new JTextField(10);
	        tfDep= new JTextField(10);


	        jbtnChange = new JButton("변경");
	        jbtnDelete = new JButton("삭제");
	        jbtnCancel = new JButton("취소");

	        // 수동으로 위치와 크기 설정하여 배치
	        jlEmpno.setBounds(25,20,60,30);
	        tfEmpno.setBounds(100, 20, 100, 30);
	        jlName.setBounds(25,60,60,30);
	        tfName.setBounds(100, 60, 100, 30);
	        jlPosition.setBounds(25,100,60,30);
	        tfPosition.setBounds(100,100,100,30);
	        
	        jlJob.setBounds(210, 20, 60, 30);
	        tfJob.setBounds(280, 20, 100, 30);
	        jlTel.setBounds(210, 60, 60, 30);
	        tfTel.setBounds(280, 60, 100, 30);
	        jlJob.setBounds(210, 20, 60, 30);
	        tfJob.setBounds(280, 20, 100, 30);
	        jlDept.setBounds(210, 100, 60, 30);
	        tfDep.setBounds(280, 100, 100, 30);
	        
	        InputJlPosition.setBounds(90, 150, 60, 30); // 레이블: 직급
	        InputJtPosition.setBounds(150, 150, 150, 30); // 텍스트 필드: 직급
	        InputJlJob.setBounds(90, 190, 60, 30); // 레이블: 직무
	        InputJtJob.setBounds(150, 190, 150, 30); // 텍스트 필드: 직무
	        InputJlDept.setBounds(90, 230, 60, 30); // 레이블: 부서
	        InputJtDept.setBounds(150, 230, 150, 30); // 텍스트 필드: 부서
	        jbtnChange.setBounds(50, 280, 90, 30); // 버튼: 변경
	        jbtnDelete.setBounds(150, 280, 90, 30); // 버튼: 삭제
	        jbtnCancel.setBounds(250, 280, 90, 30); // 버튼: 취소

	        // 프레임에 컴포넌트 추가
	        add(jlEmpno);
	        add(tfEmpno);
	        add(jlName);
	        add(tfName);
	        add(jlPosition);
	        add(tfPosition);
	        add(jlJob);
	        add(tfJob);
	        
	        add(jlTel);
	        add(tfTel);
	        
	        add(jlDept);
	        add(tfDep);
	        
	        add(InputJlPosition);
	        add(InputJtPosition);
	        add(InputJlJob);
	        add(InputJtJob);
	        add(InputJlDept);
	        add(InputJtDept);
	        add(jbtnChange);
	        add(jbtnDelete);
	        add(jbtnCancel);
	        UpdateEmployeeInformationEvent uei = new UpdateEmployeeInformationEvent(this);
	       
	        jbtnChange.addActionListener(uei);
	        jbtnDelete.addActionListener(uei);
	        jbtnCancel.addActionListener(uei);
	        
	        
	        setLayout(null); // 수동 레이아웃 설정

	        setSize(430, 440); // 프레임 크기 설정
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 동작 설정
	        setVisible(true); // 프레임을 화면에 보이게 함
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


		public static void main(String[] args) {
			new UpdateEmployeeInformation();
	    }
}