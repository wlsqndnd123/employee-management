package view.admin;

import javax.swing.*;

/**
 * Desc : 관리자로 로그인 하면 보이는 메뉴 view<br>
 * 작성자 : 고한별<br>
 * 작성일 : 2024.03.15
 */
public class AdminMenu extends JFrame {
    private JButton employeeInformation;
    private JButton workAttendance;
    private JButton documents;
    private JButton workLog;
    private JButton login;
    private JButton password;
    private JTextArea workNotifications;
    private JScrollPane workNotiPad;

    /**
     * Desc : 관리자 메뉴 main frame 구현
     */
    public AdminMenu(){
        setTitle("관리자 메뉴");
        setLayout(null);

        createGoToButton();
        createWorkNotifications();

        setBounds(300,100,650,550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Desc : 다른 view로 연결되는 버튼 생성
     */
    public void createGoToButton(){
        employeeInformation = new JButton("사원 정보");
        workAttendance = new JButton("근태 관리");
        documents = new JButton("문서 관리");
        workLog = new JButton("업무 일지");
        login = new JButton("로그인으로");
        password = new JButton("비밀번호 변경");

        employeeInformation.setBounds(80,80,100,40);
        workAttendance.setBounds(80,180,100,40);
        documents.setBounds(80,280,100,40);
        workLog.setBounds(80,380,100,40);
        login.setBounds(520,20,100,40);
        password.setBounds(500,460,120,40);

        add(employeeInformation);
        add(workAttendance);
        add(documents);
        add(workLog);
        add(login);
        add(password);
    }

    /**
     * Desc : 업무 알람을 표시하는 영역 생성
     */
    public void createWorkNotifications(){
        workNotifications = new JTextArea();
        workNotiPad = new JScrollPane(workNotifications);

        workNotiPad.setBounds(250,80,320,350);

        add(workNotiPad);
    }

    public static void main(String[] args) {
        new AdminMenu();
    }
}
