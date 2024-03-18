package kr.co.sist.controller.event;

import kr.co.sist.view.admin.AdminMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdminMenuEvent extends WindowAdapter implements ActionListener {
    private AdminMenu adminMenu;

    public AdminMenuEvent(AdminMenu adminMenu) {
        this.adminMenu = adminMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == adminMenu.getEmployeeInformationJbtn()){
            System.out.println("사원정보 연결");
        }
        if (e.getSource() == adminMenu.getWorkAttendanceJbtn()){
            System.out.println("근태관리 연결");
        }
        if (e.getSource() == adminMenu.getDocumentsJbtn()){
            System.out.println("문서관리 연결");
        }
        if (e.getSource() == adminMenu.getCloseJbtn()){
            adminMenu.dispose();
        }
        if (e.getSource() == adminMenu.getPasswordJbtn()){
            System.out.println("비밀번호 변경 연결");
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        adminMenu.dispose();
    }
}
