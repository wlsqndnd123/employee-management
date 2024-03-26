package kr.co.sist.controller.event;

import kr.co.sist.view.admin.AdminMenu;
import kr.co.sist.view.admin.CheckEmployeeInformation;
import kr.co.sist.view.admin.DocsManagement;
import kr.co.sist.view.admin.WorkStatus;
import kr.co.sist.view.common.UpdatePassword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

/**
 * Desc : 관리자 로그인 메뉴 화면에 보이는 내용의 이벤트처리<br>
 * 작성일 : 2024.03.18<br>
 * 작성자 : 고한별<br>
 * 수정일 : 2024.03.24<br>
 * 수정자 : 고한별<br>
 */
public class AdminMenuEvent extends WindowAdapter implements ActionListener {
    private AdminMenu adminMenu;

    public AdminMenuEvent(AdminMenu adminMenu) {
        this.adminMenu = adminMenu;
    }

    /**
     * Desc : 각각의 버튼에 연결되는 이벤트 관리
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == adminMenu.getEmployeeInformationJbtn()){
        	adminMenu.dispose();
            new CheckEmployeeInformation();
        }
        if (e.getSource() == adminMenu.getWorkAttendanceJbtn()){
            try {
            	adminMenu.dispose();
                new WorkStatus();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == adminMenu.getDocumentsJbtn()){
        	adminMenu.dispose();
            new DocsManagement();
        }
        if (e.getSource() == adminMenu.getCloseJbtn()){
            closeFrame();
        }
        if (e.getSource() == adminMenu.getPasswordJbtn()){
        	
            new UpdatePassword();
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
        adminMenu.dispose();
    }
}
