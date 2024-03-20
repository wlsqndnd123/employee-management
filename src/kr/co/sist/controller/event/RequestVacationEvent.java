package kr.co.sist.controller.event;

import kr.co.sist.view.user.RequestVacation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Desc : 사원의 휴가 신청 창의 Event 처리를 위한 클래스
 * 작성일 : 2024.03.19
 * 작성자 : 고한별
 */
public class RequestVacationEvent extends WindowAdapter implements ActionListener {
    private RequestVacation requestVacation;

    public RequestVacationEvent(RequestVacation requestVacation) {
        this.requestVacation = requestVacation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==requestVacation.getRequestJbtn()){
            System.out.println("신청 이벤트 아마 문서리스트 연결?");
        }
        if(e.getSource() == requestVacation.getCancelJbtn()){
            System.out.println("취소 이벤트 이것도 아마 문서리스트");
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        closeFrame();
    }

    /**
     * Desc : 창 닫기 *******구현필요
     */
    public void closeFrame(){
        requestVacation.dispose();
    }
}
