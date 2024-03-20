package kr.co.sist.controller.event;

import java.io.ObjectInputValidation;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


import kr.co.sist.view.user.UserMenu;



public class LoginEvent{
	private String emp_no, password;
	
	public LoginEvent() {
		setInputInfo();
		chkIdNull();
		loginClik();
	}
	

	public void setInputInfo() {
		
	}
	
	public class Validation {

	    /**
	     * Desc. : 인자로 넘어온 str에 값이 없으면 true return
	     */
	    public boolean isEmpty(String str){
	        return str == null || str.isEmpty();
	    }
	}
	
	/**
	 * 유효성 검사
	 */
	public void chkIdNull() {
		
		Validation validator = new Validation();
		boolean idEmpty = validator.isEmpty(emp_no);
        boolean passwordEmpty = validator.isEmpty(password);

        if (idEmpty || passwordEmpty) {
            JOptionPane.showMessageDialog(null,"아이디와 비밀번호를 모두 입력해주세요.");
        }
		
	}//chkIdNull
	
	public boolean confirmUserPassword() {
		return true;
	}
	
	public void loginClik() {
		if(confirmUserPassword()) {
			SwingUtilities.invokeLater(UserMenu::new);
		}else {
			
		}
	}//loginClik
	
	
}//LoginEvent
