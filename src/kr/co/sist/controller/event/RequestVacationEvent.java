package kr.co.sist.controller.event;

import kr.co.sist.dao.RequestVacationDAO;
import kr.co.sist.view.user.RequestVacation;
import kr.co.sist.view.user.UserMenu;
import kr.co.sist.vo.VacationVO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * Desc : 사원의 휴가 신청 창의 Event 처리를 위한 클래스
 * 작성일 : 2024.03.19
 * 작성자 : 고한별
 */
public class RequestVacationEvent extends WindowAdapter implements ActionListener {
    private RequestVacation requestVacation;

    public RequestVacation getRequestVacation() {
        return requestVacation;
    }

    public RequestVacationEvent(RequestVacation requestVacation) {
        this.requestVacation = requestVacation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == requestVacation.getRequestJbtn()) {
            try {
                addVacation();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            
        } catch (NullPointerException ex) {
        	JOptionPane.showMessageDialog(null, "시작 날짜, 끝 날짜\n상세내역을 모두 입력하세요.");
        }
        }

        if (e.getSource() == requestVacation.getCancelJbtn()) {
            closeFrame();
            new UserMenu();
        }
    }

    public void addVacation() throws SQLException,NullPointerException {
        int empNo = Integer.parseInt(LoginEvent.getEmpno());
        java.sql.Date sqlsDate = new Date(requestVacation.getVacStartDate().getDate().getTime());
        java.sql.Date sqleDate = new Date(requestVacation.getVacEndDate().getDate().getTime());
        String vacationLog = requestVacation.getVacContents().getText();
        if(sqlsDate==null||sqleDate==null||vacationLog.isEmpty()) {
        	JOptionPane.showMessageDialog(null, "시작 날짜와 끝 날짜\n상세내역을 모두 입력하세요.");
        }
        VacationVO vVO =
                new VacationVO(empNo,vacationLog,sqlsDate, sqleDate);
        int docNo = RequestVacationDAO.getInstance().searchMaxDocNum();
        RequestVacationDAO.getInstance().insertBusinessLog(docNo,vVO);
        requestVacation.dispose();
        new UserMenu();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        closeFrame();
    }

    /**
     * Desc : 창 닫기
     */
    public void closeFrame() {
        requestVacation.dispose();
    }
}
