package kr.co.sist.controller.event;

import kr.co.sist.dao.ShareDeptDAO;
import kr.co.sist.view.admin.ConfirmDocs;
import kr.co.sist.view.admin.ShareDept;
import kr.co.sist.vo.DocumentVO;

import java.awt.event.*;
import java.sql.SQLException;

public class ShareDeptEvent extends WindowAdapter implements ActionListener, MouseListener {
    ShareDept dept;
    ConfirmDocs cd;

    public ShareDeptEvent(ShareDept dept) {
        this.dept = dept;
    }


    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == dept.getJlDept()) {

            int index = dept.getJlDept().getSelectedIndex();
            if (index != 1) {
                String strdept = (String) dept.getDlmDept().getElementAt(index);
                dept.getDlmSelectedDept().addElement(strdept);
                dept.getDlmDept().remove(index);
            }
        }//end if
        if (me.getSource() == dept.getJlSelectedDept()) {
            int index = dept.getJlSelectedDept().getSelectedIndex();
            if (index != 1) {
                String strdept = (String) dept.getDlmSelectedDept().getElementAt(index);
                dept.getDlmDept().addElement(strdept);
                dept.getDlmSelectedDept().remove(index);
            }

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == dept.getJbtncancel()) {
            dept.dispose();
            new ConfirmDocs();
        }
        if (ae.getSource() == dept.getJbtncheck()) {
            try {
                addSharedDoc();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addSharedDoc() throws NumberFormatException, SQLException {
        String docNum = cd.getJtfdocnum().getText();
        int index = dept.getJlSelectedDept().getSelectedIndex();
        String depts = (String) dept.getDlmDept().getElementAt(index);

        try {
            ShareDeptDAO sdDAO = ShareDeptDAO.getInstance();
            //
            //(String docNo, String title, String workDesc, String workLog, String apprDesc, String fileName, String dept, int empNo, Date docDate)
            DocumentVO dVO = new DocumentVO(docNum, null, null, null, null, null, depts, 0, null, null);
            sdDAO.shareDoc(dVO);
            System.out.println(dVO.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
