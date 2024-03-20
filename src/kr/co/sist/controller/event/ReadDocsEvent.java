package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;

import kr.co.sist.view.user.ReadDocs;

public class ReadDocsEvent extends WindowAdapter implements ActionListener {

    private ReadDocs rd;


    public ReadDocsEvent(ReadDocs rd) {	
    	this.rd= rd;
    }

    public void readDoc(int Empno) {	//제목클릭시 글정보 가져오기
    	
   
    	

    }

    public void updateDoc() {	//수정버튼 눌렸을때

    }

    public void deleteDoc() {	//삭제버튼 눌렸을때

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == rd.getJbtn_verify() ) {
    		System.out.println("cccc");
    		rd.dispose();
    	}
    
    }

    @Override
    public void windowClosing(WindowEvent e) {
        rd.dispose();
    }

}

