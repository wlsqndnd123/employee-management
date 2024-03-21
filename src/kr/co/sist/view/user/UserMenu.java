package kr.co.sist.view.user;

import com.toedter.calendar.JCalendar;
import kr.co.sist.controller.event.UserMenuEvent;
import kr.co.sist.service.RunUserMenuDAO;
import kr.co.sist.vo.CommuteVO;
import kr.co.sist.vo.VacationVO;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

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
    private DefaultTableModel workStatusModel;
    private JTable workStatusTable;
    private JScrollPane workStatusPad;

    /**
     * Desc : 사원 메뉴 main frame 구현
     */
    public UserMenu() {
        setTitle("사원 메뉴");
        setLayout(null);

        createWorkCalendar();
        createGoToButton();
        createWorkStatusTable();
        loadWorkStatusTable();
        createEvent();

        setBounds(300, 100, 650, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Desc : 근무일정을 표시하는 JCalendar 생성
     */
    public void createWorkCalendar() {
        workCalendar = new JCalendar();

        workCalendar.setBorder(new TitledBorder("근무일정"));
        workCalendar.setBounds(20, 150, 290, 350);

        add(workCalendar);
        paintVacation();
    }

    /**
     * Desc : 휴가 날짜 색칠
     */
    public void paintVacation() {
        List<VacationVO> list = RunUserMenuDAO.loadMonthlyWorkSchedule();

        for (VacationVO vacation : list) {
            Date startDate = vacation.getStartDate();
            Date endDate = vacation.getEndDate();

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);

            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            workCalendar.getDayChooser().getDayPanel().getComponent(dayOfMonth + 11).setBackground(Color.RED);
        }
    }

    /**
     * Desc : 다른 view로 연결되는 버튼들 생성
     */
    public void createGoToButton() {
        closeJbtn = new JButton("종료");
        docsListJbtn = new JButton("문서 리스트");
        vacationJbtn = new JButton("휴가 신청");
        informationJbtn = new JButton("정보 변경");

        closeJbtn.setBounds(500, 10, 100, 40);
        docsListJbtn.setBounds(100, 70, 100, 40);
        vacationJbtn.setBounds(270, 70, 100, 40);
        informationJbtn.setBounds(440, 70, 100, 40);

        add(closeJbtn);
        add(docsListJbtn);
        add(vacationJbtn);
        add(informationJbtn);
    }

    /**
     * Desc : 이 달의 근무 일정을 표시하는 테이블 생성
     */
    public void createWorkStatusTable() {
        String[] columnName = {"날짜", "출근시간", "퇴근시간", "연차"};

        workStatusModel = new DefaultTableModel(columnName, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        workStatusTable = new JTable(workStatusModel);
        workStatusPad = new JScrollPane(workStatusTable);

        workStatusPad.setBorder(new TitledBorder("이달의 근무"));
        workStatusPad.setBounds(330, 150, 290, 350);

        add(workStatusPad);
    }

    /**
     * Desc : 로그인 한 사번에 맞는 출퇴근 기록 정보를 불러오는 기능
     */
    public void loadWorkStatusTable() {
        List<CommuteVO> commuteData = RunUserMenuDAO.loadStampTime();

        DefaultTableModel model = (DefaultTableModel) workStatusTable.getModel();
        model.setRowCount(0);

        for (CommuteVO commute : commuteData) {
            Object[] rowData = {commute.getCommuteDate(), commute.getAttendTime(), commute.getQuitTime(), commute.getWorkStatus()};
            model.addRow(rowData);
        }
    }

    /**
     * Desc : 이벤트 등록
     */
    public void createEvent() {
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
