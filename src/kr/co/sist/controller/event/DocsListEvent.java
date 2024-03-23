package kr.co.sist.controller.event;

import kr.co.sist.dao.DocsListDAO;
import kr.co.sist.dao.VacationStatusDAO;
import kr.co.sist.view.admin.VacationStatus;
import kr.co.sist.view.admin.reject;
import kr.co.sist.view.user.DocsList;
import kr.co.sist.view.user.ReadDocs;
import kr.co.sist.vo.DocumentVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

public class DocsListEvent implements ActionListener, ItemListener, MouseListener {
    private final DocsList dclist;
    private final DefaultTableModel dtmjtabResult;
    private DocumentVO dVO;
    private List<DocumentVO> dVOList;
    private VacationStatus vs;

    public DocsListEvent(DocsList dclist) {
        this.dclist = dclist;
        this.dtmjtabResult = dclist.getDtmjtabResult();
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == dclist.getJbtnAddDoc()) {
            System.out.println("문서등록");
        }
        if (ae.getSource() == dclist.getJbtnGoMain()) {
            System.out.println("메인으로");
        }
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            try {
                selectDocInfo();
            } catch (SQLException e1) {
                throw new RuntimeException(e1);
            }
        } else {
            try {
                showAllDocs();
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

    public void showAllDocs() throws SQLException {
        DocsListDAO dlDAO = DocsListDAO.getInstance();
        List<DocumentVO> dVOList = dlDAO.selectAllDocument();
        showDocument(dVOList);
    }

    public void selectDocInfo() throws SQLException {
        DocsListDAO dlDAO = DocsListDAO.getInstance();
        List<DocumentVO> dVOList = dlDAO.selectMyDocinfo(LoginEvent.getEmpno());
        showDocument(dVOList);
    }
    //////////////////////////to 키미시시////////////////////////////////////////////////
    //////////////////////////////////// 이런건 중복이 심하니까 제거!////////////////////////
    //////////////////////////////////// 위에 메서드 정리한거 참고로 구경해보기/////////////////
//    public void showAllDocs() throws SQLException {
//        Object[] content = new Object[6];
//        DocsListDAO dlDAO = DocsListDAO.getInstance();
//        dVOList = dlDAO.selectAllDocument();
//
//        dtmjtabResult.setRowCount(0);
//
//        // 문서 목록이 비어 있는 경우
//        if (dVOList.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "해당 문서가 없습니다");
//        } else {
//            for (DocumentVO dVO : dVOList) {
//
//                content[0] = dVO.getDocNo();
//                content[1] = dVO.getTitle();
//                content[2] = dVO.getDept();
//                content[3] = dVO.getDocDate();
//                if (dVO.getCode2() == 1) {
//                    content[4] = "대기";
//                } else if (dVO.getCode2() == 2) {
//                    content[4] = "승인";
//                } else if (dVO.getCode2() == 3) {
//                    content[4] = "반려";
//                }
//
//                content[5] = dVO.getModifiedDate();
//
//                dclist.getDtmjtabResult().addRow(content);
//            }
//        }
//    }
//
//    public void selectDocInfo() throws SQLException {
//        Object[] content = new Object[6];
//        DocsListDAO dlDAO = DocsListDAO.getInstance();
//        dVOList = dlDAO.selectMyDocinfo(LoginEvent.getEmpno());
//
//        dtmjtabResult.setRowCount(0);
//
//        // 문서 목록이 비어 있는 경우
//        if (dVOList.isEmpty()) {
//
//            JOptionPane.showMessageDialog(null, "해당 문서가 없습니다");
//        } else {
//            for (DocumentVO dVO : dVOList) {
//
//                content[0] = dVO.getDocNo();
//                content[1] = dVO.getTitle();
//                content[2] = dVO.getDept();
//                content[3] = dVO.getDocDate();
//                if (dVO.getCode2() == 1) {
//                    content[4] = "대기";
//                } else if (dVO.getCode2() == 2) {
//                    content[4] = "승인";
//                } else if (dVO.getCode2() == 3) {
//                    content[4] = "반려";
//                }
//
//                content[5] = dVO.getModifiedDate();
//
//                dclist.getDtmjtabResult().addRow(content);
//            }
//        }
//    }


    @Override
    public void mouseClicked(MouseEvent me) {
//        int row = dclist.getJtaDob().rowAtPoint(me.getPoint());
//        int col = dclist.getJtaDob().columnAtPoint(me.getPoint());
//        
//        if (row == 2) {
//        	String DocNum =  (String) dclist.getJtaDob().getValueAt(row, 0);
//        	System.out.println("?");
//        	try {
//				DocumentVO dVO = DocsListDAO.getInstance().selectDocinfo(DocNum);
////				new ReadDocs(dVO);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} 
////        	new ReadDocs(DocumentVO dVO);
        int column = dclist.getJtaDob().columnAtPoint(me.getPoint());
        int row = dclist.getJtaDob().rowAtPoint(me.getPoint());
        String DocNum = (String) dclist.getJtaDob().getValueAt(row, 0);
        if (column == 0) { // 2nd column
            try {
                new ReadDocs(DocNum, DocsListDAO.getInstance().selectDocinfo(DocNum));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (column == 3) { // 4th column
        }
    }


    public void Rejet(String doc_no) throws SQLException {
        VacationStatusDAO vsDAO = VacationStatusDAO.getInstance();
        String regetDetail = vsDAO.selectRejetDetail(doc_no);

        new reject(vs, regetDetail);
    }


    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }


}