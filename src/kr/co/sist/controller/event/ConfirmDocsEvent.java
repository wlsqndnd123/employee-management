package kr.co.sist.controller.event;

import kr.co.sist.dao.ConfirmDocsDAO;
import kr.co.sist.view.admin.ConfirmDocs;
import kr.co.sist.view.admin.DocsManagement;
import kr.co.sist.view.admin.ReturnReason;
import kr.co.sist.view.admin.ShareDept;

import java.awt.event.*;
import java.sql.SQLException;

public class ConfirmDocsEvent extends WindowAdapter implements ActionListener, MouseListener {
    private ConfirmDocs cfdocs;
    private String docNum;

    public ConfirmDocsEvent(ConfirmDocs cfdocs) {
        super();
        this.cfdocs = cfdocs;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cfdocs.getJbtnShare()) {
            new ShareDept();
        }

        if (ae.getSource() == cfdocs.getJbtnApproval()) {
            try {
                docNum = cfdocs.getJtfdocnum().getText();
                acceptDoc(docNum);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            new DocsManagement();
            cfdocs.dispose();
        }

        if (ae.getSource() == cfdocs.getJbtncompanion()) {
            docNum = cfdocs.getJtfdocnum().getText();
            new ReturnReason(cfdocs, docNum);
        }

        if (ae.getSource() == cfdocs.getJbtncheck()) {
            new DocsManagement();
            cfdocs.dispose();
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        cfdocs.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void acceptDoc(String docNum) throws SQLException {
        ConfirmDocsDAO cfDAO = ConfirmDocsDAO.getInstance();
        cfDAO.updateConfirmDoc(docNum);
    }

}
