package kr.co.sist.controller.event;

import kr.co.sist.dao.RequestVacationDAO;
import kr.co.sist.service.RunRequestVacationDAO;
import kr.co.sist.view.user.DocsList;
import kr.co.sist.view.user.RequestVacation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.SQLException;

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
                RequestVacationDAO.getInstance().vacationData();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

//            String content =requestVacation.getVacContents().getText();
//            String startDate = requestVacation.getStartDate();
//            String endDate = requestVacation.getEndDate();

//            System.out.println(content);
//            System.out.println(startDate);
//            System.out.println(endDate);

//            addVacationDocument();
//            try {
//                new DocsList();
//            } catch (Exception ex) {
//                throw new RuntimeException(ex);
//            }
        }

        if (e.getSource() == requestVacation.getCancelJbtn()) {
            closeFrame();
        }



    }

    @Override
    public void windowClosing(WindowEvent e) {
        closeFrame();
    }

    /**
     * Desc : 창 닫기 *******구현필요
     */
    public void closeFrame() {
        requestVacation.dispose();
    }

    public void addVacationDocument() {
        new RunRequestVacationDAO().createVacDocs();
    }
}
