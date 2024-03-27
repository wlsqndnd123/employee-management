package kr.co.sist.controller.event;

import kr.co.sist.dao.WorkStatusDAO;
import kr.co.sist.view.admin.AdminMenu;
import kr.co.sist.view.admin.VacationStatus;
import kr.co.sist.view.admin.WorkStatus;
import kr.co.sist.vo.CommuteVO;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

public class WorkStatusEvent extends WindowAdapter implements ActionListener, FocusListener {
    private List<CommuteVO> cVOList;
    private WorkStatus ws;

    public WorkStatusEvent(WorkStatus ws) {
        this.ws = ws;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ws.getJbCheck()) {
            ws.getDtmDailyStatus().setNumRows(0);

            try {
                int empno;
                if (ws.getJtfEmpNum().getText().isBlank() || ws.getJtfEmpNum().getText().equals("사원번호")) {
                    empno = 0;
                } else {

                    empno = Integer.parseInt(ws.getJtfEmpNum().getText());
                }
                CheckWS(empno, ws.getJcbDateRange().getSelectedItem().toString());
            } catch (NumberFormatException | SQLException e) {
            	JOptionPane.showMessageDialog(ws, "사원번호를 적어주세요");
            }
        }

        if (ae.getSource() == ws.getJbVacationStatus()) {
            new VacationStatus();
            ws.dispose();
        }

        if (ae.getSource() == ws.getJbGoMain()) {
            new AdminMenu();
            ws.dispose();
        }
    }

    public void CheckWS(int empNum, String selectedDateRange) throws SQLException {
        Object[] content = new Object[7];
        WorkStatusDAO wsDAO = WorkStatusDAO.getInstance();
        cVOList = wsDAO.selectWSInfo(empNum, selectedDateRange);

        if (cVOList.isEmpty()) {
            return;
        }

        for (CommuteVO cVO : cVOList) {
            content[0] = cVO.getEmpNo();
            content[1] = cVO.getEmpName();
            content[2] = cVO.getAttendTime();
            content[3] = cVO.getQuitTime();
            content[4] = cVO.getUse_count();
            content[5] = cVO.getAssign_count();
            content[6] = cVO.getCommuteDate();
            ws.getDtmDailyStatus().addRow(content);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        ws.getJtfEmpNum().setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        ws.dispose();
    }
}
