package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JFrame;

import kr.co.sist.dao.UpdateTelNumberDAO;
import kr.co.sist.view.user.UpdateTelNumber;
import kr.co.sist.view.user.UserMenu;

public class UpdateTelNumberEvent extends JFrame implements ActionListener{

	private UpdateTelNumber utn;
	
	public UpdateTelNumberEvent() {
		
	}
	public UpdateTelNumberEvent(UpdateTelNumber utn) {
		this.utn = utn;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==utn.getJbtnsave()) {
			updateTelInfo1();
			
			System.out.println("ok");
		}
		
	}
	public void updateTelInfo() {
		String tel = utn.getInputJtTel().getText();
		
	}
	
	/**
	 * 하드코딩용
	 */
	public void updateTelInfo1() {
//		String tel = utn.getInputJtTel().getText();
		String tel = "1111";
		int empno = 160002;
		
		try {
			UpdateTelNumberDAO utnDAO = UpdateTelNumberDAO.getInstance();
			utnDAO.updateTel(tel, empno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		UpdateTelNumberEvent evt = new UpdateTelNumberEvent();
		evt.updateTelInfo1();
	}
}
