package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import kr.co.sist.dao.CheckEmployeeInformationDAO;
import kr.co.sist.view.admin.AdminMenu;
import kr.co.sist.view.admin.CheckEmployeeInformation;
import kr.co.sist.view.admin.CreateEmployeeInformation;
import kr.co.sist.vo.EmpInfoVO;



public class CheckEmployeeInformationEvent extends WindowAdapter implements ActionListener {
	private CheckEmployeeInformation checkEmp;
	private EmpInfoVO eVO;
	public CheckEmployeeInformationEvent() {

	}

	public CheckEmployeeInformationEvent(CheckEmployeeInformation checkEmpview) {
		this.checkEmp = checkEmpview;
	}

	@Override
	public void windowClosing(WindowEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == checkEmp.getJbtnAddEmp()) {
			System.out.println("사원추가");
			new CreateEmployeeInformation();
		} // end if
		if (ae.getSource() == checkEmp.getJbtnMain()) {
			System.out.println("메인으로");
			new AdminMenu();
			checkEmp.dispose();

		} // end if
		if (ae.getSource() == checkEmp.getJbtnSearch()) {
		
			System.out.println("사원검색");
			
			try {
				
				eVO = new EmpInfoVO();
				searchEmpInfo(eVO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // end if

	}// actionPerformed

	/**
	 * 텍스트필드로 입력된 값(empno)로 검색된 사원정보를 출력하는 method
	 */
	public void searchEmpInfo(int empno) {

	}

	/**
	 * 부서/직급/입사년도 모두를 선택하여 검색된 사원정보를 출력하는  method
	 * (부서,직급,입사년도)모두를 선택해야 결과가 나옴
	 * @param eVO
	 * @throws SQLException 
	 */
	public void searchEmpInfo(EmpInfoVO eVO) throws SQLException {
		String dept = checkEmp.getCbDept().getSelectedItem().toString();
		String position = (String)checkEmp.getCbPosition().getSelectedItem().toString();
		int year = checkEmp.getJycHiredateYear().getYear();
		Object[] content = new Object[8];
		//3가지를 모두 선택하게 함
		if (dept ==null&&position==null&&year==0) {
			JOptionPane.showMessageDialog(null, "부서,직급,입사년도를 모두 선택해주세요.");
			return;
		}// end if
		CheckEmployeeInformationDAO ciDAO = CheckEmployeeInformationDAO.getInstance();
		eVO= ciDAO.selectEmpInfo(dept,position,year);
		if(eVO==null) {
			JOptionPane.showMessageDialog(null, "선택한 사원의 정보가 존재하지 않습니다.");
		}else {
			
			content[0] =eVO.getEmpno();
			content[1] =eVO.getName();
			content[2] =eVO.getJob();
			content[3] =eVO.getPosition();
			content[4] =eVO.getDept();
			content[5] =eVO.getHiredate();
			content[6] =eVO.getTel();
			content[7] =eVO.getModifiedDate();
			System.out.println(content[0].toString());
		}
	}
}
