package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.co.sist.dao.VacationStatusDAO;
import kr.co.sist.view.admin.ConfirmVacation;
import kr.co.sist.view.admin.ReturnReason;
import kr.co.sist.view.admin.VacationStatus;
import kr.co.sist.vo.CommuteVO;
import kr.co.sist.vo.VacationVO;


public class ConfirmVacationEvent extends WindowAdapter implements ActionListener{
	
	private ConfirmVacation cv;
	private List<VacationVO>  vVOList;
	
	public ConfirmVacationEvent(ConfirmVacation cv) {
		this.cv=cv;
	}

	

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == cv.getJbReturn()){
	
			new ReturnReason(cv);
		
			
		}
		
		if(ae.getSource() == cv.getJbApprove()) {
			
			ApproveVacation(Integer.parseInt(cv.getJtfDocNum().getText()));
			
			
			cv.dispose();
			try {
				new VacationStatus();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		if(ae.getSource() == cv.getJbCancel()) {
			
			cv.dispose();
			try {
				new VacationStatus();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}

		
	}


	public void ApproveVacation(int docNum) {
		VacationStatusDAO vsDAO = VacationStatusDAO.getInstance();
		try {
			vsDAO.approveVS(docNum);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void ReturnVacation(int a) {
		
	}
	
	
	
	public void VDocStatus(String item) throws SQLException {
		VacationStatusDAO vsDAO = VacationStatusDAO.getInstance();
		vVOList = vsDAO.selectedDoc_numInfo(item);
		
		
		
		if(vVOList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "내용이 없습니다.");
		}else {
				for(VacationVO vVO : vVOList) {
					
					
					
					cv.getJtfEmpName().setText(vVO.getEmpName());
					cv.getJtfEmpNum().setText(""+vVO.getEmpNo());
					cv.getJtfLeftVaction().setText(""+(vVO.getAssignCount() - vVO.getUseCount()));
					cv.getJtfApplyDate().setText(vVO.getCreatedDate().toString());
					
					
					
				}
				
				
							
//				(vVO.getAssignCount() - vVO.getUseCount());
			
			}			
		
		
		;
		
	}

	
}
