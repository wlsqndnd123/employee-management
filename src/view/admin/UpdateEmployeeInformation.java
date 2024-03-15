package view.admin;

import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import vo.EmpInfoVO;

public class UpdateEmployeeInformation extends JFrame {
	private JLabel jlPosition,jlJob,jlDept;
	private TextField jtPosition,jtJob,jtDept;
	private JButton jbtnChange,jbtnDelete,jbtnCancel;
	private JList<EmpInfoVO> jlSelectedEmpInfo;
	
	public UpdateEmployeeInformation() {
		super("사원 변경 및 삭제");
		jlPosition = new JLabel("직급");
		jlJob = new JLabel("직무");
		jlDept = new JLabel("부서");
		
		jtPosition = new TextField(10);
		jtJob = new TextField(10);
		jtDept = new TextField(10);
		
	}
}
