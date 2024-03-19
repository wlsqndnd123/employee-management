package kr.co.sist.controller.event;

import kr.co.sist.dao.UserMenuDAO;
import kr.co.sist.view.user.UserMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Desc : 사용자 로그인 메뉴 화면에 보이는 내용의 이벤트처리
 * 작성일 : 2024.03.19
 * 작성자 : 고한별
 */
public class UserMenuEvent extends WindowAdapter implements ActionListener {
    private UserMenu userMenu;

    public UserMenuEvent(UserMenu userMenu) {
        this.userMenu = userMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == userMenu.getDocsListJbtn()){
            System.out.println("문서리스트 연결");
        }
        if (e.getSource() == userMenu.getVacationJbtn()){
            System.out.println("휴가신청 연결");
        }
        if (e.getSource() == userMenu.getInformationJbtn()){
            System.out.println("정보 변경 연결");
        }
        if (e.getSource() == userMenu.getCloseJbtn()){
            closeFrame();
        }
    }

    /**
     * Desc : 타이틀 바의 x 누를 경우 창 닫기 기능
     * @param e the event to be processed
     */
    @Override
    public void windowClosing(WindowEvent e) {
        closeFrame();
    }

    /**
     * Desc : 창 닫기 *******구현필요
     */
    public void closeFrame(){
        userMenu.dispose();
    }
}
