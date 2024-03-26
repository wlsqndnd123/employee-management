package kr.co.sist.view.admin;

import kr.co.sist.controller.event.WorkStatusEvent;
import kr.co.sist.view.util.JFrameComponent;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class WorkStatus extends JFrame {
    private JTable jtDailyStatus;
    private DefaultTableModel dtmDailyStatus;
    private JTextField jtfEmpNum;
    private JComboBox<String> jcbDateRange;
    private DefaultComboBoxModel<String> dcbmDateRange;
    private JButton jbCheck;
    private JButton jbVacationStatus;
    private JButton jbGoMain;

    public WorkStatus() throws SQLException {
        setTitle("근태 관리");
        setLayout(null);

        String[] coloumnName = {"사번", "이름", "출근시간", "퇴근시간", "사용연차", "연차"};
        dtmDailyStatus = new DefaultTableModel(coloumnName, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jtDailyStatus = new JTable(dtmDailyStatus);
        JScrollPane jspJtaResult = new JScrollPane(jtDailyStatus);
        jspJtaResult.setBorder(new TitledBorder("근태정보"));

        jtDailyStatus.getColumnModel().getColumn(0).setPreferredWidth(50);
        jtDailyStatus.getColumnModel().getColumn(1).setPreferredWidth(50);
        jtDailyStatus.getColumnModel().getColumn(3).setPreferredWidth(120);
        jtDailyStatus.getColumnModel().getColumn(2).setPreferredWidth(120);
        jtDailyStatus.getColumnModel().getColumn(4).setPreferredWidth(50);
        jtDailyStatus.getColumnModel().getColumn(5).setPreferredWidth(50);

        createButton();

        jcbDateRange = new JComboBox<>();

        dcbmDateRange = new DefaultComboBoxModel<>();
        jcbDateRange = new JComboBox<>(dcbmDateRange);
        dcbmDateRange.addElement("오늘");
        dcbmDateRange.addElement("1주일");
        dcbmDateRange.addElement("1달");
        dcbmDateRange.addElement("1년");

        jtDailyStatus.getTableHeader().setReorderingAllowed(false);
        jtDailyStatus.getTableHeader().setResizingAllowed(false);

        jcbDateRange.setBounds(510, 100, 100, 30);
        add(jcbDateRange);
        jspJtaResult.setBounds(10, 10, 490, 480);
        add(jspJtaResult);

        jtfEmpNum = JFrameComponent.createTextField(getContentPane(),"사원번호",510, 60, 100, 30);

        createEvent();

        setBounds(300, 100, 650, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createButton(){
        jbGoMain = JFrameComponent.createButton(getContentPane(),"메뉴창으로",510, 20, 100, 30);
        jbCheck = JFrameComponent.createButton(getContentPane(),"조회",510, 200, 100, 30);
        jbVacationStatus = JFrameComponent.createButton(getContentPane(),"휴가관리",510, 270, 100, 30);
    }

    private void createEvent(){
        WorkStatusEvent wse = new WorkStatusEvent(this);
        jbCheck.addActionListener(wse);
        jbGoMain.addActionListener(wse);
        jbVacationStatus.addActionListener(wse);
        try {
            wse.CheckWS(0, "오늘");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public JTable getJtDailyStatus() {
        return jtDailyStatus;
    }

    public DefaultTableModel getDtmDailyStatus() {
        return dtmDailyStatus;
    }

    public JTextField getJtfEmpNum() {
        return jtfEmpNum;
    }

    public JComboBox<String> getJcbDateRange() {
        return jcbDateRange;
    }

    public DefaultComboBoxModel<String> getDcbmDateRange() {
        return dcbmDateRange;
    }

    public JButton getJbCheck() {
        return jbCheck;
    }

    public JButton getJbVacationStatus() {
        return jbVacationStatus;
    }

    public JButton getJbGoMain() {
        return jbGoMain;
    }
}
