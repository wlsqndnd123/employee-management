package kr.co.sist.view.admin;

import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import kr.co.sist.dao.CheckEmployeeInformationDAO;
import kr.co.sist.vo.EmpInfoVO;
	
public class ShareDept extends JFrame {
	private JButton jbtncheck,jbtncancel;
	private JList jlDept;
	private DefaultListModel<Object> dlmDept;
	private EmpInfoVO eVO;
	public ShareDept(){
		super("공유부서설정");
		setLayout(null);
		jbtncheck = new JButton("공유");
		jbtncheck.setBounds(50, 250, 100, 30);
		jbtncancel = new JButton("취소");
		jbtncancel.setBounds(200, 250, 100, 30);
		CheckEmployeeInformationDAO ciDAO = CheckEmployeeInformationDAO.getInstance();
		Object[] depts;
		dlmDept = new DefaultListModel<Object>();
		jlDept = new JList<Object>(dlmDept);
		JScrollPane jsp = new JScrollPane(jlDept);
		jsp.setBounds(50, 70, 175, 175);
		List<EmpInfoVO> dept;
		try {
			dept = ciDAO.selectInfo("dept");
			depts = new Object[dept.size()];
			eVO = new EmpInfoVO();
			for(int i =0; i<dept.size();i++) {
				eVO= dept.get(i);
			depts[i] = eVO.getDept();
			dlmDept.addElement(depts[i]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        add(jsp);
		add(jbtncheck);
		add(jbtncancel);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
public static void main(String[] args) {
        
		new ShareDept();
        
    }
}
