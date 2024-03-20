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
    	if(e.getSource() == rd.getjbtnOk()) {
    		System.out.println("확인버튼");
    		rd.dispose();
    	}
    	if(e.getSource() == rd.getjbtnDel()) {
    		System.out.println("삭제버튼");
    		rd.remove(0);	//dao에서 논리삭제 코드 작성 후 처리
    	}
    	if(e.getSource() == rd.getjbtnChg()) {
    		System.out.println("수정버튼");
    		rd.add(rd);
    	}
    	
    }

    @Override
    public void windowClosing(WindowEvent e) {
        rd.dispose();
    }
}

