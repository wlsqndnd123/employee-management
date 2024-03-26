package kr.co.sist.view.admin;

import kr.co.sist.controller.event.AdminMenuEvent;
import kr.co.sist.service.RunAdminMenuDAO;
import kr.co.sist.view.common.Login;
import kr.co.sist.view.util.JFrameComponent;

import java.sql.SQLException;

import javax.swing.*;

/**
 * Desc : 관리자로 로그인 하면 보이는 메뉴 view<br>
 * 작성자 : 고한별<br>
 * 작성일 : 2024.03.15<br>
 * 수정자 : 고한별<br>
 * 수정일 : 2024.03.24<br>
 */
public class AdminMenu extends JFrame {
    private JButton employeeInformationJbtn;
    private JButton workAttendanceJbtn;
    private JButton documentsJbtn;
    private JButton closeJbtn;
    private JButton passwordJbtn;
    private JTextArea workNotifications;

    /**
     * Desc : 관리자 메뉴 main frame 구현
     */
    public AdminMenu() {
        setTitle("관리자 메뉴");
        setLayout(null);

        createGoToButton();
        workNotifications = new JTextArea();
        JFrameComponent.createPane(getContentPane(), workNotifications, 250, 80, 320, 350);
        loadWorkAlerts();
        createEvent();

        setBounds(300, 100, 650, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Desc : 다른 view로 연결되는 버튼 생성
     */
    public void createGoToButton() {
        employeeInformationJbtn = JFrameComponent.createButton(getContentPane(), "사원정보", 80, 110, 100, 40);
        workAttendanceJbtn = JFrameComponent.createButton(getContentPane(), "근태 관리", 80, 230, 100, 40);
        documentsJbtn = JFrameComponent.createButton(getContentPane(), "문서 관리", 80, 350, 100, 40);
        closeJbtn = JFrameComponent.createButton(getContentPane(), "종료", 520, 20, 100, 40);
        passwordJbtn = JFrameComponent.createButton(getContentPane(), "비밀번호 변경", 500, 460, 120, 40);
    }

    /**
     * Desc: 업무 알람 내용 로드
     */
    private void loadWorkAlerts() {
        RunAdminMenuDAO runAdminMenuDAO = new RunAdminMenuDAO();
        String vacationAlert = runAdminMenuDAO.loadWorkAlert(true);
        String workAlert = runAdminMenuDAO.loadWorkAlert(false);
        displayWorkAlerts(vacationAlert, workAlert);
    }

    /**
     * Desc: 업무 알람 내용 표시
     *
     * @param vacationAlert 승인 대기 중인 휴가
     * @param workAlert     승인 대기 중인 보고서
     */
    private void displayWorkAlerts(String vacationAlert, String workAlert) {
        workNotifications.setText(vacationAlert + "\n\n" + workAlert);
    }

    /**
     * Desc : 이벤트 등록
     */
    public void createEvent() {
        AdminMenuEvent adminMenuEvent = new AdminMenuEvent(this);

        employeeInformationJbtn.addActionListener(adminMenuEvent);
        workAttendanceJbtn.addActionListener(adminMenuEvent);
        documentsJbtn.addActionListener(adminMenuEvent);
        closeJbtn.addActionListener(adminMenuEvent);
        passwordJbtn.addActionListener(adminMenuEvent);
    }

    public JButton getEmployeeInformationJbtn() {
        return employeeInformationJbtn;
    }

    public JButton getWorkAttendanceJbtn() {
        return workAttendanceJbtn;
    }

    public JButton getDocumentsJbtn() {
        return documentsJbtn;
    }

    public JButton getCloseJbtn() {
        return closeJbtn;
    }

    public JButton getPasswordJbtn() {
        return passwordJbtn;
    }
    
   
    
    
}
