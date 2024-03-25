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
		
		if(ae.getSource() == up.getExitButton()) {
			new UserMenu();
			up.dispose();
		}//end if
		if(ae.getSource() == up.getUpdateButton()) {
			modifyPassword();
		}
	}//actionPerformed
	
	
	/**
	 * 로그인한 사원의 비밀번호를 변경하는 method
	 */
	public void modifyPassword() {
		String pass = up.getJtfUpdatePw().getText().trim();
		
		try {
			LoginVO lVO = new LoginVO
					(up.getJtfCurrentPw().getText(), pass);
			UpdatePasswordDAO upDAO = UpdatePasswordDAO.getInstance();
			int cnt = upDAO.updatePassword(lVO);
			if(cnt == 1) {
				JOptionPane.showMessageDialog(up, "해당 사원의 정보가 변경되었습니다.");
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
//	public LoginVO setPasswordInfo() {
//		String empno = LoginEvent.getEmpno();
//		LoginVO lVO = null;
//		try {
//			lVO=UpdatePasswordDAO.getInstance().selectLoginInfo(Integer.parseInt(empno));
//		}catch(NumberFormatException | SQLException e) {
//			e.printStackTrace();
//		}
//		return lVO;
//	}
//	


}
