package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.dao.VacationStatusDAO;
import kr.co.sist.dao.WorkStatusDAO;
import kr.co.sist.view.admin.AdminMenu;
import kr.co.sist.view.admin.VacationStatus;
import kr.co.sist.view.admin.WorkStatus;
import kr.co.sist.vo.CommuteVO;
import kr.co.sist.vo.VacationVO;

public class WorkStatusEvent extends WindowAdapter implements ActionListener{
	private List<CommuteVO>  cVOList;
	private WorkStatus ws;
	
	public WorkStatusEvent(WorkStatus ws) {
		this.ws = ws;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == ws.getJbCheck()) {
			ws.getDtmDailyStatus().setNumRows(0);
			
			try {
				int empno = 0;
				if(!ws.getJtfEmpNum().getText().isEmpty()) {
					empno = Integer.parseInt(ws.getJtfEmpNum().getText());
				}
				
				CheckWS(empno, ws.getJcbDateRange().getSelectedItem().toString());
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
		if(ae.getSource() == ws.getJbVacationStatus()) {
			new VacationStatus();
			ws.dispose();
			
		}
		
		
		if(ae.getSource() == ws.getJbGoMain()) {
			new AdminMenu();
			ws.dispose();
		}
		
	}

	
	public void CheckWS(int empNum,String selectedDateRange) throws SQLException {
		
		Object[] content = new Object[7];
		WorkStatusDAO wsDAO = WorkStatusDAO.getInstance();
		cVOList = wsDAO.selectWSInfo(empNum, selectedDateRange);
		
		
		
		if(cVOList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "내용이 없습니다.");
		}else {
			for(CommuteVO cVO : cVOList) {
			content[0] = cVO.getEmpNo();
			content[1] = cVO.getEmpName();
			content[2] = cVO.getAttendTime().substring(11);
			content[3] = cVO.getQuitTime().substring(11);
			content[4] = cVO.getUse_count();
			content[5] = cVO.getAssign_count();
			content[6] = cVO.getCommuteDate();
			ws.getDtmDailyStatus().addRow(content);
			
			}
			
		}
		
		
		
	}

	
}
