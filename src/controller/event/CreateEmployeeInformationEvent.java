package controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import view.admin.CreateEmployeeInformation;

public class CreateEmployeeInformationEvent extends WindowAdapter implements ActionListener {
	private CreateEmployeeInformation ceiv;
	public CreateEmployeeInformationEvent() {
		
	}

	public CreateEmployeeInformationEvent(CreateEmployeeInformation ceiv) {
		this.ceiv = ceiv;
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
