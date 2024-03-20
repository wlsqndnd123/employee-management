package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import kr.co.sist.view.user.UpdateTelNumber;

public class UpdateTelNumberEvent extends JFrame implements ActionListener{

	private UpdateTelNumber utn;
	
	public UpdateTelNumberEvent(UpdateTelNumber utn) {
		this.utn = utn;
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		
	}

}
