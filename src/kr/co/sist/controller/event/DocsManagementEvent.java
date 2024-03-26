package kr.co.sist.controller.event;

import kr.co.sist.dao.DocsListDAO;
import kr.co.sist.dao.DocsManagementDAO;
import kr.co.sist.view.admin.AdminMenu;
import kr.co.sist.view.admin.ConfirmDocs;
import kr.co.sist.view.admin.DocsManagement;
import kr.co.sist.vo.DocumentVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

public class DocsManagementEvent implements ActionListener, MouseListener {
    private DocsManagement dmm;

    public DocsManagementEvent(DocsManagement dmm) {
        this.dmm = dmm;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == dmm.getJbtnBackhome()) {
        	dmm.dispose();
            new AdminMenu();
        }
        if (ae.getSource() == dmm.getJbtnSearch()) {
            try {
                selectDocument();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void searchDocument() throws SQLException {
        Object[] content = new Object[7];
        DocsManagementDAO dmmDAO = DocsManagementDAO.getInstance();
        List<DocumentVO> dVOList = dmmDAO.searchDocument();

        if (dVOList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "해당 문서가 없습니다");
        } else {
			createContents(content, dVOList);
		}
    }// searchDocument

	private void createContents(Object[] content, List<DocumentVO> dVOList) {
		for (DocumentVO dVO : dVOList) {
			content[0] = dVO.getDocNo();
			content[1] = dVO.getTitle();
			content[2] = filetype(dVO.getCode());
			content[3] = dVO.getDept();
			content[4] = dVO.getDocDate();
			content[5] = apprtype(dVO.getCode2());
			content[6] = dVO.getDocDate();

			dmm.getDtmjtabResult().addRow(content);
		}
	}

	public void selectDocument() throws SQLException {
        String dept = dmm.getJcbSelectDep().getSelectedItem().toString();
        String fileType = dmm.getJcbSelectFileType().getSelectedItem().toString();
        String appr = dmm.getJcbSelectApprovalState().getSelectedItem().toString();

        if (dept == null && fileType == null && appr == null) {
            JOptionPane.showMessageDialog(null, "모두 선택을 해주세요.");
            return;
        }

        DocsManagementDAO dmDAO = DocsManagementDAO.getInstance();
        List<DocumentVO> dVOList = dmDAO.selectDocInfo(dept, filetype(fileType), apprtype(appr));
        dmm.getDtmjtabResult().setRowCount(0);

        Object[] content = new Object[7];

        if (dVOList == null) {
            JOptionPane.showMessageDialog(null, "문서정보가 없음");
        } else {
			createContents(content, dVOList);
		}

    }

    /**
     * 문서의 형식을 문자에서 숫자로 변환하여 DAO에서 select를 돕는 method
     *
     * @param fileType
     * @return
     */
    public int filetype(String fileType) {
        return switch (fileType) {
            case "일일업무보고" -> 1;
            case "출장보고" -> 2;
            case "구매신청" -> 3;
            case "출장비정산요청" -> 4;
            case "휴가신청서" -> 5;
            default -> 0;
        };
    }

    /**
     * 문서의 형식을 숫자에서 문자로 변환하여 view에서 출력을 도와
     * 이용자의 가독성을 높이는 매서드
     *
     * @param filetype
     * @return
     */
    public String filetype(int filetype) {
        return switch (filetype) {
            case 1 -> "일일업무보고";
            case 2 -> "출장보고";
            case 3 -> "구매신청";
            case 4 -> "출장비정산요청";
            case 5 -> "휴가신청서";
            default -> "";
        };
    }

    /**
     * 승인 상태를 문자에서 숫자로 변환하여 DAO에서 select를 돕는 method
     *
     * @param appr
     * @return
     */
    public int apprtype(String appr) {
        return switch (appr) {
            case "대기" -> 1;
            case "승인" -> 2;
            case "반려" -> 3;
            default -> 0;
        };
    }

    /**
     * 승인상태를 숫자에서 문자로 변환하여 view에서 출력을 도와
     * 이용자의 가독성을 높이는 매서드
     *
     * @param appr
     * @return
     */
    public String apprtype(int appr) {
        return switch (appr) {
            case 1 -> "대기";
            case 2 -> "승인";
            case 3 -> "반려";
            default -> "";
        };
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int column = dmm.getJtaDob().columnAtPoint(me.getPoint());
        int row = dmm.getJtaDob().rowAtPoint(me.getPoint());
        String DocNum = (String) dmm.getJtaDob().getValueAt(row, 0);
        if (column == 1) { // 2nd column
            try {
                new ConfirmDocs(DocsListDAO.getInstance().selectDocinfo(DocNum));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
}
