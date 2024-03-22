package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.dao.VacationStatusDAO;
import kr.co.sist.view.admin.ConfirmDocs;
import kr.co.sist.view.admin.ConfirmVacation;
import kr.co.sist.view.admin.ReturnReason;
import kr.co.sist.view.admin.VacationStatus;

public class ReturnReasonEvent extends WindowAdapter implements ActionListener{

	private ReturnReason rr;
	private ConfirmVacation cv;
	private ConfirmDocs cd;
	private String docNum;
	
	public ReturnReasonEvent(ConfirmVacation cv, ReturnReason rr,String dNum) {
		this.cv = cv;
		this.rr=rr;
		this.docNum = dNum;
	}
	
	public ReturnReasonEvent(ConfirmDocs cd, ReturnReason rr,String dNum) {
		this.cd = cd;
		this.rr=rr;
		this.docNum = dNum;
	}
	



	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == rr.getJbInput()) {
	
			if(rr.getJtaContent().getText().isBlank()) {
				JOptionPane.showMessageDialog(null, "내용을 적어야합니다.");
				return;
			}
			int result = JOptionPane.showConfirmDialog(null, "반려하시겠습니까?.","확인",JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				
				if(this.cv == null) {
					try {
						inputReason2();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
				try {
					inputReason();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
		
			}else {
				
			return;
			
			}
			
		}
		
		if(ae.getSource() == rr.getJbCancel()) {
			
			rr.dispose();
		}
		
		
		
	}
	
	
	
	public void inputReason() throws SQLException {
		VacationStatusDAO vsDAO = VacationStatusDAO.getInstance();

		vsDAO.InsertReturnReason(docNum, rr.getJtaContent().getText());
		
		
		cv.dispose();
		rr.dispose();
		
		
		new VacationStatus();
		
	}
	public void inputReason2() throws SQLException {
		VacationStatusDAO vsDAO = VacationStatusDAO.getInstance();

		vsDAO.InsertReturnReason(docNum, rr.getJtaContent().getText());
		
		
		rr.dispose();

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
