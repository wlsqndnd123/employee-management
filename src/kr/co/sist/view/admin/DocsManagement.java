package kr.co.sist.view.admin;

import kr.co.sist.controller.event.DocsManagementEvent;
import kr.co.sist.dao.DocsManagementDAO;
import kr.co.sist.view.util.JFrameComponent;
import kr.co.sist.vo.DocumentVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

/**
 * 문서의 정보를 관리하는 view
 * 작성자 : 김일신
 * 작성일 :2024.03.23
 */
public class DocsManagement extends JFrame {

    private JComboBox<String> jcbSelectDep;
    private JComboBox<String> jcbSelectFileType;
    private JComboBox<String> jcbSelectApprovalState;
    private JButton jbtnBackhome;
    private JButton jbtnSearch;
    private JTable jtaDob;
    private DefaultTableModel dtmjtabResult;

    public DocsManagement() {
        super("관리자문서관리메뉴");
        setLayout(null);
        createTable();

        jcbSelectDep = JFrameComponent.createStringCombobox(getContentPane(), 60, 60, 150, 30);
        jcbSelectFileType = JFrameComponent.createStringCombobox(getContentPane(), 220, 60, 150, 30);
        jcbSelectApprovalState = JFrameComponent.createStringCombobox(getContentPane(), 380, 60, 150, 30);

        addComboBox();
        addButton();
        addEvents();

        setBounds(300, 80, 800, 470);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createTable() {
        String[] columnName = {"문서번호", "문서제목", "종류", "신청부서", "신청날짜", "결제상태", "최종수정일"};
        dtmjtabResult = new DefaultTableModel(columnName, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jtaDob = new JTable(dtmjtabResult);

        for (int i = 0; i < 7; i++) {
            jtaDob.getColumnModel().getColumn(i).setPreferredWidth(60);
        }

        JScrollPane scrollPane = new JScrollPane(jtaDob);
        scrollPane.setBounds(30, 120, 700, 300);
        add(scrollPane);
    }

    private void addButton() {
        jbtnBackhome = JFrameComponent.createButton(getContentPane(), "메인으로", 610, 20, 100, 30);
        jbtnSearch = JFrameComponent.createButton(getContentPane(), "찾기", 610, 60, 100, 30);
    }

    private void addEvents() {
        DocsManagementEvent dme = new DocsManagementEvent(this);

        jbtnBackhome.addActionListener(dme);
        jbtnSearch.addActionListener(dme);
        jcbSelectDep.addActionListener(dme);
        jcbSelectApprovalState.addActionListener(dme);
        jcbSelectFileType.addActionListener(dme);
        jtaDob.addMouseListener(dme);

        try {
            dme.searchDocument();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addComboBox() {
        try {
            // 부서
            List<DocumentVO> dept = DocsManagementDAO.getInstance().selectInfo("dept");
            for (DocumentVO docs : dept) {
                jcbSelectDep.addItem(docs.getDept());
            }
            jcbSelectDep.setSelectedIndex(0);

            //// 승인상태
            List<DocumentVO> code = DocsManagementDAO.getInstance().selectInfo("apprv");
            for (DocumentVO dVO : code) {
                jcbSelectApprovalState.addItem(dVO.getApprDesc());
            }
            jcbSelectApprovalState.setSelectedIndex(0);

            //// 타입
            List<DocumentVO> paperType = DocsManagementDAO.getInstance().selectInfo("paperType");
            for (DocumentVO dVO : paperType) {
                jcbSelectFileType.addItem(dVO.getPaperType());
            }
            jcbSelectFileType.setSelectedIndex(0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public JComboBox<String> getJcbSelectDep() {
        return jcbSelectDep;
    }

    public JComboBox<String> getJcbSelectFileType() {
        return jcbSelectFileType;
    }

    public JComboBox<String> getJcbSelectApprovalState() {
        return jcbSelectApprovalState;
    }

    public JButton getJbtnBackhome() {
        return jbtnBackhome;
    }

    public JButton getJbtnSearch() {
        return jbtnSearch;
    }

    public JTable getJtaDob() {
        return jtaDob;
    }

    public DefaultTableModel getDtmjtabResult() {
        return dtmjtabResult;
    }
}