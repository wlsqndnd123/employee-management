package kr.co.sist.controller.event;

import kr.co.sist.dao.LoginDAO;
import kr.co.sist.dao.ReadDocsDAO;
import kr.co.sist.view.user.DocsList;
import kr.co.sist.view.user.ReadDocs;
import kr.co.sist.vo.DocumentVO;
import kr.co.sist.vo.LoginVO;
import oracle.jdbc.logging.annotations.Log;

import javax.swing.*;
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
            new DocsList();
        }

        if (e.getSource() == rd.getjbtnDel()) {
            if(youReturn()){
                JOptionPane.showMessageDialog(null, "넌 안돼");
                return;
            }

            int result = JOptionPane.showConfirmDialog(null,"삭제하시겠습니까?");
        	
        	if(result == JOptionPane.OK_OPTION){
        		 disableDocs();
                 rd.dispose();
                 new DocsList();	
                }
        	return;
           	
        }

        if (e.getSource() == rd.getjbtnChg()) {
            if(youReturn()){
                JOptionPane.showMessageDialog(null, "넌 안돼");
                return;
            }

            int result = JOptionPane.showConfirmDialog(null,"수정하시겠습니까?");

            if(result == JOptionPane.OK_OPTION){
            modifyDocs();
            rd.dispose();
            new DocsList();
            }

        }
    }

    public boolean youReturn() {
        LoginVO loginVO = LoginDAO.getInstance().confirmUser(LoginEvent.getEmpno());
        String loginId = loginVO.getEmp_no();
        String writeId = rd.getJtfEmpNo().getText();

        return !loginId.equals(writeId);
    }

    public void modifyDocs() {
        String content = rd.getJta().getText();
        String docNo = rd.getjtfDocNo().getText();

        LoginVO loginVO = LoginDAO.getInstance().confirmUser(LoginEvent.getEmpno());
        int empno = Integer.parseInt(loginVO.getEmp_no());

        DocumentVO dVO = new DocumentVO(docNo, content, empno);

        ReadDocsDAO rdDAO = ReadDocsDAO.getInstance();

        try {
            rdDAO.updateDoc(dVO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JOptionPane.showMessageDialog(null, "수정되었습니다.");
    }

    public void disableDocs() {
        int docNo = Integer.parseInt(rd.getjtfDocNo().getText());

        ReadDocsDAO rdDAO = ReadDocsDAO.getInstance();

        try {
            rdDAO.deleteDoc(docNo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        JOptionPane.showMessageDialog(null, "삭제되었습니다.");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        rd.dispose();
        new DocsList();
    }
}

