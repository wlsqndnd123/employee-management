package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import org.w3c.dom.events.MouseEvent;

import kr.co.sist.dao.ReadDocsDAO;
import kr.co.sist.view.user.ReadDocs;
import kr.co.sist.vo.DocumentVO;

public class ReadDocsEvent extends WindowAdapter implements ActionListener {

    private ReadDocs rd;

    public ReadDocsEvent(ReadDocs rd) {	
    	this.rd= rd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == rd.getjbtnOk()) {
    		rd.dispose();
    	}
    	if(e.getSource() == rd.getjbtnDel()) {
    		//dao에서 논리삭제 코드 작성 후 처리
    	}
    	if(e.getSource() == rd.getjbtnChg()) {
    		//수정된 내용이 db에 update
    		try {
				modifyDocs();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	
    }
    
    public void modifyDocs() throws SQLException {
    	String content=rd.getJta().getText();
		//String docNo=rd.getjtfDocNo().getText();
		
    	String docNo="0000000009";
		DocumentVO dVO= new DocumentVO(docNo, content);
		
		ReadDocsDAO rdDAO= ReadDocsDAO.getInstance();
		rdDAO.updateDoc(dVO);
		
    }

    @Override
    public void windowClosing(WindowEvent e) {
        rd.dispose();
    }

	

	
}

