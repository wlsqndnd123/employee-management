package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.view.user.ReadDocs;

public class ReadDocsEvent extends WindowAdapter implements ActionListener {

    private ReadDocs rd;

    public ReadDocsEvent(ReadDocs rd) {	
    	this.rd= rd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == rd.getJbtn_verify()) {
    		System.out.println("수정버튼");
    	}
    }

    @Override
    public void windowClosing(WindowEvent e) {
        rd.dispose();
    }
}

