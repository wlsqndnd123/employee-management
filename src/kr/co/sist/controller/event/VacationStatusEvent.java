package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;

import kr.co.sist.view.admin.ConfirmVacation;
import kr.co.sist.view.admin.VacationStatus;
import kr.co.sist.view.admin.WorkStatus;

public class VacationStatusEvent extends WindowAdapter implements ActionListener, MouseListener{

	private VacationStatus vs;
	
	public VacationStatusEvent(VacationStatus vs) {
		this.vs = vs;
	}
	

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == vs.getJbBack()) {
			new WorkStatus();
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
				System.out.println("반려");
			}
	
		}
		
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
