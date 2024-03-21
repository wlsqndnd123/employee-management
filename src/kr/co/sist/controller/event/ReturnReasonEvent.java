package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;

<<<<<<< HEAD
import kr.co.sist.dao.VacationStatusDAO;
=======
import kr.co.sist.view.admin.ConfirmDocs;
>>>>>>> ec9a74a97cedf8b7db4167a40d73b30f0976aefa
import kr.co.sist.view.admin.ConfirmVacation;
import kr.co.sist.view.admin.ReturnReason;
import kr.co.sist.view.admin.VacationStatus;

public class ReturnReasonEvent extends WindowAdapter implements ActionListener{

	private ReturnReason rr;
	private ConfirmVacation cv;
	private ConfirmDocs cd;
	
	public ReturnReasonEvent(ConfirmVacation cv, ReturnReason rr) {
		this.cv = cv;
		this.rr=rr;
	}
	
	public ReturnReasonEvent(ConfirmDocs cd, ReturnReason rr) {
		this.cd = cd;
		this.rr=rr;
	}
	



	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == rr.getJbInput()) {
	
			
			
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
		}
		
		if(ae.getSource() == rr.getJbCancel()) {
			
			rr.dispose();
		}
		
		
		
	}
	
	
	
	public void inputReason() throws SQLException {
		cv.dispose();
		rr.dispose();
		
		
		new VacationStatus();
		
	}
	public void inputReason2() throws SQLException {
		rr.dispose();

		
	}
	
	
	
	
	
	
	
	
	

}
