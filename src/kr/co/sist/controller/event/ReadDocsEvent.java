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
    		try {
				disableDocs();
				rd.dispose();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
    		
    	}
    	if(e.getSource() == rd.getjbtnChg()) {
    		//수정된 내용이 db에 update
    		try {
				modifyDocs();
				rd.dispose();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
    	}
    }
    
    public void modifyDocs() throws SQLException {
    	String content=rd.getJta().getText();
		String docNo=rd.getjtfDocNo().getText();
		DocumentVO dVO= new DocumentVO(docNo, content);
		
		ReadDocsDAO rdDAO= ReadDocsDAO.getInstance();
		rdDAO.updateDoc(dVO);
		
    }
    public void disableDocs() throws SQLException {
    	int docNo=Integer.parseInt(rd.getjtfDocNo().getText());
    	
    	ReadDocsDAO rdDAO= ReadDocsDAO.getInstance();
    	rdDAO.deleteDoc(docNo);
    	
    }

    @Override
    public void windowClosing(WindowEvent e) {
        rd.dispose();
    }

}

