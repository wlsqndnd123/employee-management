package kr.co.sist.controller.event;

import kr.co.sist.dao.ReadDocsDAO;
import kr.co.sist.view.user.ReadDocs;
import kr.co.sist.vo.DocumentVO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class ReadDocsEvent extends WindowAdapter implements ActionListener {

    private ReadDocs rd;

    public ReadDocsEvent(ReadDocs rd) {
        this.rd = rd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rd.getjbtnOk()) {
            rd.dispose();
        }

        if (e.getSource() == rd.getjbtnDel()) {
            disableDocs();
            rd.dispose();
        }

        if (e.getSource() == rd.getjbtnChg()) {
            modifyDocs();
            rd.dispose();
        }
    }

    public void modifyDocs() {
        String content = rd.getJta().getText();
        String docNo = rd.getjtfDocNo().getText();
        DocumentVO dVO = new DocumentVO(docNo, content);

        ReadDocsDAO rdDAO = ReadDocsDAO.getInstance();

        try {
            rdDAO.updateDoc(dVO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void disableDocs() {
        int docNo = Integer.parseInt(rd.getjtfDocNo().getText());

        ReadDocsDAO rdDAO = ReadDocsDAO.getInstance();

        try {
            rdDAO.deleteDoc(docNo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        rd.dispose();
    }
}

