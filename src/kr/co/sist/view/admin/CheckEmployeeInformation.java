package kr.co.sist.view.admin;

import com.toedter.calendar.JYearChooser;
import kr.co.sist.controller.event.CheckEmployeeInformationEvent;
import kr.co.sist.dao.CheckEmployeeInformationDAO;
import kr.co.sist.view.util.JFrameComponent;
import kr.co.sist.vo.EmpInfoVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

/**
 * Desc : 사원의 정보를 관리하는 view<br>
 * 작성자 : 김일신<br>
 * 작성일 : 2024.03.15<br>
 * 수정자 : 고한별<br>
 * 수정일 : 2024.03.25<br>
 */
public class CheckEmployeeInformation extends JFrame {
    private JTextField jtInputEmpno;
    private JComboBox<String> cbDept, cbPosition;
    private JYearChooser jycHiredateYear;
    private JButton jbtnAddEmp, jbtnSearch, jbtnMain;
    private DefaultTableModel dtmEmpTable;
    private JTable jtEmpInfo;

    /**
     * Desc : 사원 정보 관리 창을 열었을 때 실행되는 생성자
     */
    public CheckEmployeeInformation() {
        super("사원정보관리");
        setLayout(null);
        createTable();

        cbDept = JFrameComponent.createStringCombobox(getContentPane(), 30, 125, 150, 30);
        cbPosition = JFrameComponent.createStringCombobox(getContentPane(), 200, 125, 150, 30);

        jycHiredateYear = JFrameComponent.createYearChooser(getContentPane(), 370, 125, 150, 30);

        jtInputEmpno = JFrameComponent.createTextField(getContentPane(), "사번", 30, 50, 150, 30);

        createComboBoxContent();
        createEmployeeTable();
        createButton();
        createEvent();

        setBounds(300, 100, 650, 550);
        setVisible(true);
    }

    /**
     * Desc : 콤보박스 내부 데이터 DAO 객체 생성하여 DB에서 불러오기
     */
    private void createComboBoxContent() {
        try {
            CheckEmployeeInformationDAO ciDAO = CheckEmployeeInformationDAO.getInstance();

            List<EmpInfoVO> dept = ciDAO.selectInfo("dept");

            for (EmpInfoVO emp : dept) {
                cbDept.addItem(emp.getDept());
            }

            cbDept.setSelectedIndex(0);

            List<EmpInfoVO> pos = ciDAO.selectInfo("pos");

            for (EmpInfoVO emp : pos) {
                cbPosition.addItem(emp.getPosition());
            }

            cbPosition.setSelectedIndex(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Desc : 사원 정보가 기록된 테이블을 생성
     */
    private void createTable() {
        String[] header = {"사번", "이름", "직무", "직급", "부서", "입사일", "전화번호", "최종 수정 날짜"};
        dtmEmpTable = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jtEmpInfo = new JTable(dtmEmpTable);
        jtEmpInfo.getTableHeader().setReorderingAllowed(false);
        jtEmpInfo.getTableHeader().setResizingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(jtEmpInfo);
        scrollPane.setBounds(30, 175, 600, 250);
        add(scrollPane);
    }

    /**
     * Desc : 사원 정보 테이블에 들어갈 내용을 DAO를 통해 DB에서 받아오기
     */
    private void createEmployeeTable() {
        try {
            CheckEmployeeInformationDAO ciDAO = CheckEmployeeInformationDAO.getInstance();
            List<EmpInfoVO> list = ciDAO.selectAllEmpInfo();

            Object[] content = new Object[8];

            for (EmpInfoVO emp : list) {
                content[0] = emp.getEmpno();
                content[1] = emp.getName();
                content[2] = emp.getJob();
                content[3] = emp.getPosition();
                content[4] = emp.getDept();
                content[5] = emp.getHiredate();
                content[6] = emp.getTel();
                content[7] = emp.getModifiedDate();
                dtmEmpTable.addRow(content);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Desc : 버튼 생성
     */
    private void createButton() {
        jbtnMain = JFrameComponent.createButton(getContentPane(), "메인으로", 520, 50, 100, 30);
        jbtnAddEmp = JFrameComponent.createButton(getContentPane(), "사원추가", 370, 50, 100, 30);
        jbtnSearch = JFrameComponent.createButton(getContentPane(), "사원검색", 200, 50, 100, 30);
    }

    /**
     * Desc : 이벤트 추가
     */
    private void createEvent() {
        CheckEmployeeInformationEvent checkEmpevt = new CheckEmployeeInformationEvent(this);

        addWindowListener(checkEmpevt);
        jbtnMain.addActionListener(checkEmpevt);
        jbtnSearch.addActionListener(checkEmpevt);
        jbtnAddEmp.addActionListener(checkEmpevt);
        cbDept.addActionListener(checkEmpevt);
        cbPosition.addActionListener(checkEmpevt);
        jtEmpInfo.addMouseListener(checkEmpevt);
    }

    public JTextField getJtInputEmpno() {
        return jtInputEmpno;
    }

    public JComboBox<String> getCbDept() {
        return cbDept;
    }

    public JComboBox<String> getCbPosition() {
        return cbPosition;
    }

    public JButton getJbtnAddEmp() {
        return jbtnAddEmp;
    }

    public JButton getJbtnSearch() {
        return jbtnSearch;
    }

    public JYearChooser getJycHiredateYear() {
        return jycHiredateYear;
    }

    public DefaultTableModel getDtmEmpTable() {
        return dtmEmpTable;
    }

    public JTable getJtEmpInfo() {
        return jtEmpInfo;
    }

    public JButton getJbtnMain() {
        return jbtnMain;
    }
}