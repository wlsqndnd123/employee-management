package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import kr.co.sist.dao.CheckEmployeeInformationDAO;
import kr.co.sist.dao.UpdateTelNumberDAO;
import kr.co.sist.view.admin.UpdateEmployeeInformation;
import kr.co.sist.view.common.Login;
import kr.co.sist.view.user.UpdateTelNumber;
import kr.co.sist.view.user.UserMenu;
import kr.co.sist.vo.EmpInfoVO;
import kr.co.sist.vo.LoginVO;

public class UpdateTelNumberEvent extends JFrame implements ActionListener{
	private Login l;
	private UpdateTelNumber utn;
	
	public UpdateTelNumberEvent() {
		
	}
	public UpdateTelNumberEvent(UpdateTelNumber utn) {
		this.utn = utn;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==utn.getJbtnsave()) {
			updateTelInfo();
			JOptionPane.showMessageDialog(null,"내선번호가 변경되었습니다." );
			utn.dispose();
			new UserMenu();
		}
		
	}
	public void updateTelInfo() {
		int empno = Integer.parseInt(LoginEvent.getEmpno());
		String tel = utn.getInputJtTel().getText();
		
		try {
			EmpInfoVO eVO = new EmpInfoVO(empno,  tel);
			UpdateTelNumberDAO.getInstance().updateTel(eVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public EmpInfoVO setPersonalInfo() {
		String empno = LoginEvent.getEmpno();
		EmpInfoVO eVO = null;
		try {
			eVO =CheckEmployeeInformationDAO.getInstance().selectEmpInfo(Integer.parseInt(empno));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eVO;
	}
	
}
