package kr.co.sist.controller.event;

import kr.co.sist.dao.DocsListDAO;
import kr.co.sist.dao.VacationStatusDAO;
import kr.co.sist.view.common.SubmitDocs;
import kr.co.sist.view.user.DocsList;
import kr.co.sist.view.user.ReadDocs;
import kr.co.sist.view.user.Reject;
import kr.co.sist.view.user.UserMenu;
import kr.co.sist.vo.DocumentVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

public class DocsListEvent extends WindowAdapter implements ActionListener, ItemListener, MouseListener {
    private final DocsList dclist;
    private final DefaultTableModel dtmjtabResult;

    public DocsListEvent(DocsList dclist) {
        this.dclist = dclist;
        this.dtmjtabResult = dclist.getDtmjtabResult();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == dclist.getJbtnAddDoc()) {
        	dclist.dispose();
            new SubmitDocs();
        }
        if (ae.getSource() == dclist.getJbtnGoMain()) {
        	dclist.dispose();
            new UserMenu();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            try {
                printDocs(false);
            } catch (SQLException e1) {
                throw new RuntimeException(e1);
            }
        } else {
            try {
                printDocs(true);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void showDocument(List<DocumentVO> documentVOList) {
        Object[] content = new Object[6];

        dtmjtabResult.setRowCount(0);

        if (documentVOList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "해당 문서가 없습니다");
        } else {
            for (DocumentVO dVO : documentVOList) {
                content[0] = dVO.getDocNo();
                content[1] = dVO.getTitle();
                content[2] = dVO.getDept();
                content[3] = dVO.getDocDate();
                if (dVO.getCode2() == 1) {
                    content[4] = "대기";
                } else if (dVO.getCode2() == 2) {
                    content[4] = "승인";
                } else if (dVO.getCode2() == 3) {
                    content[4] = "반려";
                }
                content[5] = dVO.getModifiedDate();
                dclist.getDtmjtabResult().addRow(content);
            }
        }
    }

    public void printDocs(boolean selectMine) throws SQLException {
        DocsListDAO dlDAO = DocsListDAO.getInstance();
        List<DocumentVO> dVOList = null;

        if (selectMine) {
            dVOList = dlDAO.selectAllDocument();
        } else {
            dVOList = dlDAO.selectMyDocinfo(LoginEvent.getEmpno());
        }

        showDocument(dVOList);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int column = dclist.getJtaDob().columnAtPoint(me.getPoint());
        int row = dclist.getJtaDob().rowAtPoint(me.getPoint());
        String item = dclist.getJtaDob().getValueAt(row, column).toString();
        String DocNum = (String) dclist.getJtaDob().getValueAt(row, 0);
        if (column == 0) { // 1st column
            try {
                new ReadDocs(DocsListDAO.getInstance().selectDocinfo(DocNum));
                dclist.dispose();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (item.equals("반려")) {
            try {
                Rejet(DocNum);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void Rejet(String doc_no) throws SQLException {
        VacationStatusDAO vsDAO = VacationStatusDAO.getInstance();
        String regetDetail = vsDAO.selectRejetDetail(doc_no);

        new Reject(dclist, regetDetail);
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

    @Override
    public void windowClosing(WindowEvent e) {
        dclist.dispose();
    }
}