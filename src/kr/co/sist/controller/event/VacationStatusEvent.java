package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.co.sist.dao.VacationStatusDAO;
import kr.co.sist.view.admin.ConfirmVacation;
import kr.co.sist.view.admin.VacationStatus;
import kr.co.sist.view.admin.WorkStatus;
import kr.co.sist.vo.CommuteVO;
import kr.co.sist.vo.VacationVO;

public class VacationStatusEvent extends WindowAdapter implements ActionListener, MouseListener{
	private List<VacationVO>  vVOList;
	private VacationStatus vs;
	
	public VacationStatusEvent(VacationStatus vs) {
		this.vs = vs;
	}
	


	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == vs.getJbBack()) {
			try {
				new WorkStatus();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vs.dispose();
		}
		
	}


	@Override
	public void mouseReleased(MouseEvent me) {
		int row = vs.getJtVacationStatus().rowAtPoint(me.getPoint());
		int column =  vs.getJtVacationStatus().columnAtPoint(me.getPoint());
		String item = vs.getJtVacationStatus().getValueAt(row, column).toString();
		
		if(me.getSource() == vs.getJtVacationStatus()) {
			if(column == 0) {
				System.out.println("문서번호");
				System.out.println(item);
				
				
				
				new ConfirmVacation();
				vs.dispose();
				
			}
			
			if(column == 5) {
				if(item.equals("반려"))
				RejetView();
			}
	
		}
		
	}
	
	public void ContentsView() throws SQLException {
		Object[] content = new Object[6];
		VacationStatusDAO vsDAO = VacationStatusDAO.getInstance();
		vVOList = vsDAO.selectVOinfo();
		
		
		if(vVOList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "내용이 업습니다.");
		}else {
			for(VacationVO vVO : vVOList) {
				content[0] = vVO.getDocNo();
				content[1] = vVO.getEmpNo();
				content[2] = vVO.getTitle();
				content[3] = vVO.getStartDate();
				content[4] = vVO.getDetp_name();
				if(vVO.getCode2() == 1) {
					content[5] = "대기";
				}
				else if(vVO.getCode2() == 2) {
					content[5] = "승인";
				}
				else if(vVO.getCode2() == 3) {
					content[5] = "반려";
				}
				vs.getDtmVacationStatus().addRow(content);
				
			}
		}
		
	}
	
	
	
	public void RejetView() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
