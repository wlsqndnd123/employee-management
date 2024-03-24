package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import kr.co.sist.dao.UpdatePasswordDAO;
import kr.co.sist.view.common.UpdatePassword;
import kr.co.sist.view.user.UserMenu;
import kr.co.sist.vo.LoginVO;
import kr.co.sist.vo.UpdatePasswordVO;

public class UpdatePasswordEvent extends JFrame implements ActionListener{
	private UpdatePassword up;
	private UpdatePasswordEvent() {
	}
	
	public UpdatePasswordEvent(UpdatePassword up) {
		this.up = up;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==up.getJbtnsave()) {
			updatePasswordInfo();
			JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다.");
			up.dispose();
			new UserMenu();
		}
	}
	
	public void updatePasswordInfo() {
		int empno = Integer.parseInt(LoginEvent.getEmpno());
		String pass = up.getUpdatePw().getText();
		
		try {
		UpdatePasswordVO upVO = new UpdatePasswordVO(empno, pass);
		UpdatePasswordDAO.getInstance().updatePassword(upVO);
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public LoginVO setPasswordInfo() {
		String empno = LoginEvent.getEmpno();
		LoginVO lVO = null;
		try {
			lVO=UpdatePasswordDAO.getInstance().selectLoginInfo(Integer.parseInt(empno));
		}catch(NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		return lVO;
	}
	


}
