package kr.co.sist.view.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import kr.co.sist.controller.event.UpdateTelNumberEvent;
import kr.co.sist.vo.EmpInfoVO;

public class UpdateTelNumber extends JFrame  {
	private JTextField tfEmpno, tfName,tfPosition, tfJob, tfTel,tfDep;
	private JTextField inputJtTel;
	private JButton goHome, jbtnsave, jbtnexcPw;
	private JLabel jlInfo, jlNewTel;





	private EmpInfoVO eVO;
	public UpdateTelNumber(EmpInfoVO eVO) {
		super("사원창(정보변경)");
		
		setLayout(null);

		 
	     //창에 출력하는 사원 정보
		 JLabel jlEmpno = new JLabel("사원번호");
		 JLabel jlName = new JLabel("사원이름");
		 JLabel jlPosition = new JLabel("직급");
		 JLabel jlJob = new JLabel("직무");
		 JLabel jlTel = new JLabel("내선번호");
		 JLabel jlDept = new JLabel("부서");
		 tfEmpno = new JTextField(10);
	        tfEmpno.setText(String.valueOf(eVO.getEmpno()));
	        tfName= new JTextField(10);
	        tfName.setText(eVO.getName());
	        tfPosition= new JTextField(10);
	        tfPosition.setText(eVO.getPosition());
	        tfJob = new JTextField(10);
	        tfJob.setText(eVO.getJob());
	        tfTel= new JTextField(10);
	        tfTel.setText(eVO.getTel());
	        tfDep= new JTextField(10);
	        tfDep.setText(eVO.getDept());
	        tfEmpno.setEditable(false);
	        tfName.setEditable(false);
	        tfPosition.setEditable(false);
	        tfJob.setEditable(false);
	        tfTel.setEditable(false);
	        tfDep.setEditable(false);
	        //사원정보 표시창 위치조정
	        jlEmpno.setBounds(100,65,60,30);
	        tfEmpno.setBounds(175, 65, 100, 30);
	        jlName.setBounds(100,120,60,30);
	        tfName.setBounds(175, 120, 100, 30);
	        jlPosition.setBounds(100,175,60,30);
	        tfPosition.setBounds(175,175,100,30);
	        
	        jlJob.setBounds(300, 65, 60, 30);
	        tfJob.setBounds(370, 65, 100, 30);
	        jlTel.setBounds(300, 120, 60, 30);
	        tfTel.setBounds(370, 120, 100, 30);
	        jlDept.setBounds(300, 175, 60, 30);
	        tfDep.setBounds(370, 175, 100, 30);
		 
	        jlNewTel = new JLabel("변경 할 내선번호");
		 inputJtTel = new JTextField(10);
		 
		 jlNewTel.setBounds(250,250,100,30);
		 inputJtTel.setBounds(250, 280, 100, 30);
		 add(jlNewTel);
		 add(inputJtTel);
		 
		 //라벨
		 goHome = new JButton("돌아가기");
		 jbtnsave = new JButton("저장");
		 jbtnexcPw = new JButton("비밀번호 변경");
		 //액션리스너 등록
		 UpdateTelNumberEvent evt = new UpdateTelNumberEvent(this);
		 jbtnsave.addActionListener(evt);
		 goHome.addActionListener(evt);
		 jbtnexcPw.addActionListener(evt);
		 
		 jbtnsave.setBounds(80, 350, 150, 30);
		 add(jbtnsave);
		 
		 goHome.setBounds(250, 350, 150, 30);
		 add(goHome);
		 
		 jbtnexcPw.setBounds(420, 350, 150, 30);
		 add(jbtnexcPw);
		 
//	        tfEmpno = new JTextField(10);
//	        tfEmpno.setText(String.valueOf(eVO.getEmpno()));
//	        tfName= new JTextField(10);
//	        tfName.setText(eVO.getName());
//	        tfPosition= new JTextField(10);
//	        tfPosition.setText(eVO.getPosition());
//	        tfJob = new JTextField(10);
//	        tfJob.setText(eVO.getJob());
//	        tfTel= new JTextField(10);
//	        tfTel.setText(eVO.getTel());
//	        tfDep= new JTextField(10);
//	        tfDep.setText(eVO.getDept());
//	        tfEmpno.setEditable(false);
//	        tfName.setEditable(false);
//	        tfPosition.setEditable(false);
//	        tfJob.setEditable(false);
//	        tfTel.setEditable(false);
//	        tfDep.setEditable(false);
	        //본인의 개인정보를 받아서 JTF에 뿌려야함
	        //loginVO의 EMPNO?
	        //TEL 입력받는 부분
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
	        
		setSize(500, 600);
		setBounds(300,100,650,550);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	



	/**
	 * @return the goHome
	 */
	public JButton getGoHome() {
		return goHome;
	}
	public JTextField getInputJtTel() {
		return inputJtTel;
	}





	public JButton getJbtnexcPw() {
		return jbtnexcPw;
	}





	public JButton getJbtnsave() {
		return jbtnsave;
	}





}
