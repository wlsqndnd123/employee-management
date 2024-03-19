package kr.co.sist.view.user;

import com.toedter.calendar.JCalendar;
import kr.co.sist.controller.event.UserMenuEvent;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Desc : 사원으로 로그인 하는 경우 처음 보이는 view<br>
 * 작성자 : 고한별<br>
 * 작성일 : 2024.03.15
 */
public class UserMenu extends JFrame {
    private JButton closeJbtn;
    private JButton docsListJbtn;
    private JButton vacationJbtn;
    private JButton informationJbtn;
    private JCalendar workCalendar;
    private DefaultListModel<String> workStatusModel;
    private JList<String> workStatusList;
    private JScrollPane workStatusPad;

    /**
     * Desc : 사원 메뉴 main frame 구현
     */
    public UserMenu(){
        setTitle("사원 메뉴");
        setLayout(null);

        createWorkCalendar();
        createGoToButton();
        createWorkStatusList();
        createEvent();

        setBounds(300, 100, 650, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Desc : 근무일정을 표시하는 JCalendar 생성
     */
    public void createWorkCalendar(){
        workCalendar = new JCalendar();

        workCalendar.setBorder(new TitledBorder("근무일정"));
        workCalendar.setBounds(20,150,290,350);

        add(workCalendar);
    }

    /**
     * Desc : 다른 view로 연결되는 버튼들 생성
     */
    public void createGoToButton(){
        closeJbtn = new JButton("종료");
        docsListJbtn = new JButton("문서 리스트");
        vacationJbtn = new JButton("휴가 신청");
        informationJbtn = new JButton("정보 변경");

        closeJbtn.setBounds(500,10,100,40);
        docsListJbtn.setBounds(100,70,100,40);
        vacationJbtn.setBounds(270,70,100,40);
        informationJbtn.setBounds(440,70,100,40);

        add(closeJbtn);
        add(docsListJbtn);
        add(vacationJbtn);
        add(informationJbtn);
    }

    /**
     * Desc : 이 달의 근무 일정을 표시하는 리스트 생성
     */
    public void createWorkStatusList(){
        workStatusModel = new DefaultListModel<>();
        workStatusList = new JList<>(workStatusModel);
        workStatusPad = new JScrollPane(workStatusList);

        workStatusPad.setBorder(new TitledBorder("이달의 근무"));
        workStatusPad.setBounds(330,150,290,350);

        add(workStatusPad);
    }

    /**
     * Desc : 이벤트 등록
     */
    public void createEvent(){
        UserMenuEvent userMenuEvent = new UserMenuEvent(this);

        docsListJbtn.addActionListener(userMenuEvent);
        vacationJbtn.addActionListener(userMenuEvent);
        informationJbtn.addActionListener(userMenuEvent);
        closeJbtn.addActionListener(userMenuEvent);

    }

    public JButton getCloseJbtn() {
        return closeJbtn;
    }

    public JButton getDocsListJbtn() {
        return docsListJbtn;
    }

    public JButton getVacationJbtn() {
        return vacationJbtn;
    }

    public JButton getInformationJbtn() {
        return informationJbtn;
    }

    public static void main(String[] args) {
        new UserMenu();
    }
}
