package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import kr.co.sist.dao.UpdatePasswordDAO;
import kr.co.sist.view.admin.AdminMenu;
import kr.co.sist.view.common.UpdatePassword;
import kr.co.sist.view.user.UserMenu;
import kr.co.sist.vo.LoginVO;
import kr.co.sist.vo.UpdatePasswordVO;

public class UpdatePasswordEvent extends JFrame implements ActionListener{
	private UpdatePassword up;
	
	public UpdatePasswordEvent(UpdatePassword up) {
		this.up = up;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == up.getExitButton()) {
			LoginVO loginVO = up.getLoginVO();
			String authCode = loginVO.getAuthCode();
	        if (authCode.equals("ADMIN")||authCode.equals("SUPER")) {
            new AdminMenu();
        } else if (authCode.equals("USER")) {
            new UserMenu();
        } else {
            JOptionPane.showMessageDialog(up, "유효하지 않은 인증 코드입니다.");
        }
			up.dispose();
		}//end if
		if(ae.getSource() == up.getUpdateButton()) {
			modifyPassword();
			up.dispose();
		}
	}//actionPerformed

	/**
	 * 로그인한 사원의 비밀번호를 변경하는 method
	 */
	public void modifyPassword() {
		String pass = up.getJtfUpdatePw().getText().trim();
		
		try {
			UpdatePasswordDAO upDAO = UpdatePasswordDAO.getInstance();
			int cnt = upDAO.updatePassword(up.getLoginVO(),pass);
			if(cnt == 1) {
				JOptionPane.showMessageDialog(up, "해당 사원의 정보가 변경되었습니다.");
			} else {
				JOptionPane.showMessageDialog(up, "비밀번호를 다시 확인하세요");
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
}
