package kr.co.sist.view.admin;

import kr.co.sist.controller.event.VacationStatusEvent;
import kr.co.sist.view.util.JFrameComponent;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class VacationStatus extends JFrame {
    private JTable jtVacationStatus;
    private DefaultTableModel dtmVacationStatus;
    private JButton jbBack;

    public VacationStatus() throws SQLException {
        setTitle("사원 휴가신청 관리");
        setLayout(null);

        createTable();

        jbBack = JFrameComponent.createButton(getContentPane(),"뒤로",510, 20, 100, 30);

        createEvent();

        setBounds(300, 100, 650, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createTable(){
        String[] coloumnName = {"신청문서번호", "사원번호", "제목", "신청날짜", "부서", "결재상태"};
        dtmVacationStatus = new DefaultTableModel(coloumnName, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jtVacationStatus = new JTable(dtmVacationStatus);
        JScrollPane jspJtaResult = new JScrollPane(jtVacationStatus);
        jspJtaResult.setBorder(new TitledBorder("휴가신청표"));
        jtVacationStatus.getTableHeader().setReorderingAllowed(false);
        jtVacationStatus.getTableHeader().setResizingAllowed(false);
        jspJtaResult.setBounds(10, 50, 600, 440);
        add(jspJtaResult);
    }

    private void createEvent(){
        VacationStatusEvent vse = new VacationStatusEvent(this);

        jbBack.addActionListener(vse);
        jtVacationStatus.addMouseListener(vse);

        try {
            vse.ContentsView();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public JTable getJtVacationStatus() {
        return jtVacationStatus;
    }

    public DefaultTableModel getDtmVacationStatus() {
        return dtmVacationStatus;
    }

    public JButton getJbBack() {
        return jbBack;
    }
}
