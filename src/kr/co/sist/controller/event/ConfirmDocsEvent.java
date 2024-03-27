package kr.co.sist.controller.event;

import kr.co.sist.dao.ConfirmDocsDAO;
import kr.co.sist.view.admin.ConfirmDocs;
import kr.co.sist.view.admin.DocsManagement;
import kr.co.sist.view.admin.ReturnReason;
import kr.co.sist.view.admin.ShareDept;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class ConfirmDocsEvent extends WindowAdapter implements ActionListener {
    private final ConfirmDocs cfdocs;

    public ConfirmDocsEvent(ConfirmDocs cfdocs) {
        super();
        this.cfdocs = cfdocs;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cfdocs.getJbtnShare()) {
            new ShareDept();
            cfdocs.dispose();
        }

        if (ae.getSource() == cfdocs.getJbtnApproval()) {
            String docNum = cfdocs.getJtfdocnum().getText();
            if (docNum.isBlank()) {
                JOptionPane.showMessageDialog(cfdocs, "문서 번호를 입력하세요.");
                return;
            }
            try {
                acceptDoc(docNum);
                new DocsManagement();
                cfdocs.dispose();;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (ae.getSource() == cfdocs.getJbtncompanion()) {
            String docNum = cfdocs.getJtfdocnum().getText();
            if (docNum.isEmpty()) {
                JOptionPane.showMessageDialog(cfdocs, "문서 번호를 입력하세요.");
                return;
            }
            new ReturnReason(cfdocs, docNum);
        }

        if (ae.getSource() == cfdocs.getJbtncheck()) {
            cfdocs.dispose();
            new DocsManagement();
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        cfdocs.dispose();
    }

    public void acceptDoc(String docNum) throws SQLException {
        ConfirmDocsDAO cfDAO = ConfirmDocsDAO.getInstance();
        cfDAO.updateConfirmDoc(docNum);
    }
}
