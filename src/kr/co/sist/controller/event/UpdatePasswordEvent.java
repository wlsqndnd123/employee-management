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
//	private LoginVO lVO;
	
	private UpdatePasswordEvent() {
	}
	
	public UpdatePasswordEvent(UpdatePassword up) {
		this.up = up;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == up.getExitButton()) {
			LoginVO loginVO = up.getLoginVO();
			String authCode = loginVO.getAuthCode(); // LoginVO 객체에서 인증 코드를 가져옵니다.
	        if (authCode.equals("admin")||authCode.equals("super")) {
            new AdminMenu();
        } else if (authCode.equals("user")) {
            new UserMenu();
        } else {
            // 다른 경우를 처리하거나 오류 메시지를 표시
            JOptionPane.showMessageDialog(up, "유효하지 않은 인증 코드입니다.");
        }
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
//			LoginVO lVO = new LoginVO
//					(id,up.getJtfCurrentPw().getText());// id, curp,
			System.out.println(up.getLoginVO() + "변경: "+pass);
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
