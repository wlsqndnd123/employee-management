package controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import view.admin.UpdateEmployeeInformation;

public class UpdateEmployeeInformationEvent extends WindowAdapter implements ActionListener{
	UpdateEmployeeInformation upEmpInfo;
	public UpdateEmployeeInformationEvent() {
		
	}
	
	public UpdateEmployeeInformationEvent(UpdateEmployeeInformation upEmpInfo) {
		this.upEmpInfo = upEmpInfo;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==upEmpInfo.getJbtnCancel()) {
			System.out.println("취소");
		}
		if(ae.getSource()==upEmpInfo.getJbtnChange()) {
			System.out.println("변경");
			
		}
		if(ae.getSource()==upEmpInfo.getJbtnDelete()) {
			System.out.println("삭제");
			
		}
	}
}
