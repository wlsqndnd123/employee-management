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

public class UpdateTelNumber extends JFrame implements ActionListener {
	private JTextField tfEmpno, tfName,tfPosition, tfJob, tfTel,tfDep;
	private JTextField inputJtTel;
	private JButton goHome, save, excPw;
	private JLabel jlInfo, jlExcNo;
	private EmpInfoVO eVO;
	public UpdateTelNumber() {
		super("사원창(정보변경)");
		setLayout(null);

		 
	     //창에 출력하는 사원 정보
		 JLabel jlEmpno = new JLabel("사원번호");
		 JLabel jlName = new JLabel("사원이름");
		 JLabel jlPosition = new JLabel("직급");
		 JLabel jlJob = new JLabel("직무");
		 JLabel jlTel = new JLabel("내선번호");
		 JLabel jlDept = new JLabel("부서");
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
	        JLabel InputJlTel = new JLabel("변경할 내선번호");
	        inputJtTel = new JTextField(10); 
	        tfEmpno = new JTextField(10);
	        tfEmpno.setText("240001");
	        tfName= new JTextField(10);
	        tfName.setText("고한별");
	        tfPosition= new JTextField(10);
	        tfPosition.setText("하드캐리조장");
	        tfJob = new JTextField(10);
	        tfJob.setText("사장넴");
	        tfTel= new JTextField(10);
	        tfTel.setText("1015");
	        tfDep= new JTextField(10);
	        tfDep.setText("7강의실 브레");
	        tfEmpno.setEditable(false);
	        tfName.setEditable(false);
	        tfPosition.setEditable(false);
	        tfJob.setEditable(false);
	        tfTel.setEditable(false);
	        tfDep.setEditable(false);



		goHome = new JButton("메인으로");
		save = new JButton("저장");
		excPw = new JButton("비밀번호 변경");

		jlExcNo = new JLabel("변경할 내선번호");
		jlEmpno.setBounds(100,20,60,30);
        tfEmpno.setBounds(175, 20, 100, 30);
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
        
		add(jlExcNo);

		add(goHome);
		add(save);
		add(excPw);

		jlExcNo.setBounds(180, 140, 120, 20);

		goHome.setBounds(350, 20, 100, 30);
		save.setBounds(80, 260, 100, 30);
		excPw.setBounds(240, 260, 150, 30);

		UpdateTelNumberEvent utne= new UpdateTelNumberEvent(this);
		goHome.addActionListener(utne);
		
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



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}


}
