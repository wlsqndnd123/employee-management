package kr.co.sist.view.admin;

import kr.co.sist.controller.event.AdminMenuEvent;
import kr.co.sist.service.RunAdminMenuDAO;

import javax.swing.*;

/**
 * Desc : 관리자로 로그인 하면 보이는 메뉴 view<br>
 * 작성자 : 고한별<br>
 * 작성일 : 2024.03.15
 */
public class AdminMenu extends JFrame {
    private JButton employeeInformationJbtn;
    private JButton workAttendanceJbtn;
    private JButton documentsJbtn;
    private JButton closeJbtn;
    private JButton passwordJbtn;
    private JTextArea workNotifications;
    private JScrollPane workNotiPad;

    /**
     * Desc : 관리자 메뉴 main frame 구현
     */
    public AdminMenu() {
        setTitle("관리자 메뉴");
        setLayout(null);

        createGoToButton();
        initializeWorkNotifications();
        createEvent();

        setBounds(300, 100, 650, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Desc : 다른 view로 연결되는 버튼 생성
     */
    public void createGoToButton() {
        employeeInformationJbtn = new JButton("사원 정보");
        workAttendanceJbtn = new JButton("근태 관리");
        documentsJbtn = new JButton("문서 관리");
        closeJbtn = new JButton("종료");
        passwordJbtn = new JButton("비밀번호 변경");

        employeeInformationJbtn.setBounds(80, 110, 100, 40);
        workAttendanceJbtn.setBounds(80, 230, 100, 40);
        documentsJbtn.setBounds(80, 350, 100, 40);
        closeJbtn.setBounds(520, 20, 100, 40);
        passwordJbtn.setBounds(500, 460, 120, 40);

        add(employeeInformationJbtn);
        add(workAttendanceJbtn);
        add(documentsJbtn);
        add(closeJbtn);
        add(passwordJbtn);
    }

    /**
     * Desc: 업무 알람을 표시하는 영역 생성 및 초기화
     */
    public void initializeWorkNotifications() {
        createWorkNotificationArea();
        loadWorkAlerts();
    }

    /**
     * Desc: 업무 알람 표시 영역 생성
     */
    private void createWorkNotificationArea() {
        workNotifications = new JTextArea();
        workNotiPad = new JScrollPane(workNotifications);
        workNotiPad.setBounds(250, 80, 320, 350);
        add(workNotiPad);
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
     * @param vacationAlert  승인 대기 중인 휴가
     * @param workAlert 승인 대기 중인 보고서
     */
    private void displayWorkAlerts(String vacationAlert, String workAlert) {
        workNotifications.setText(vacationAlert + "\n" + workAlert);
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

    public static void main(String[] args) {
        new AdminMenu();
    }
}
