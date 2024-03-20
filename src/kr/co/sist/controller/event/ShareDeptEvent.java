package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;

import kr.co.sist.view.admin.ConfirmDocs;
import kr.co.sist.view.admin.ShareDept;

public class ShareDeptEvent extends WindowAdapter implements ActionListener, MouseListener {
	ShareDept dept;
	public ShareDeptEvent(ShareDept dept) {
		this.dept =dept;
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent me) {
		if(me.getSource()==dept.getJlDept()) {
			
		int index = dept.getJlDept().getSelectedIndex();
		if(index !=1) {
			String strdept = (String) dept.getDlmDept().getElementAt(index);
		dept.getDlmSelectedDept().addElement(strdept);
		dept.getDlmDept().remove(index);
		}
		}//end if
		if(me.getSource()==dept.getJlSelectedDept()) {
		int index = dept.getJlSelectedDept().getSelectedIndex();
		if(index !=1) {
			String strdept = (String) dept.getDlmSelectedDept().getElementAt(index);
		dept.getDlmDept().addElement(strdept);
		dept.getDlmSelectedDept().remove(index);
		}
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent me) {
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

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==dept.getJbtncancel()) {
			dept.dispose();
			new ConfirmDocs();
		}
		if(ae.getSource()==dept.getJbtncheck()) {
			System.out.println("이벤트연결 해야해");
		}
	}

}
