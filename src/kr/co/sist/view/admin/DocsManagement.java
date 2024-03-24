package kr.co.sist.view.admin;

import kr.co.sist.controller.event.DocsManagementEvent;
import kr.co.sist.dao.DocsManagementDAO;
import kr.co.sist.vo.DocumentVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class DocsManagement extends JFrame {

    private JComboBox<Object> jcbSelectDep;
    private JComboBox<Object> jcbSelectFileType;
    private JComboBox<Object> jcbSelectApprovalState;
    private JButton jbtnBackhome;
    private JButton jbtnSearch;
    private JTable jtaDob;
    private DefaultTableModel dtmjtabResult;
    private DocumentVO dVO;

    public DocsManagement() {

        super("관리자문서관리메뉴");
        setLayout(null);
        DocsManagementEvent dme = new DocsManagementEvent(this);

        try {
            ////부서
            List<DocumentVO> dept = DocsManagementDAO.getInstance().selectInfo("dept");
            Object[] deptarr = new Object[dept.size()];
            dVO = new DocumentVO();
            for (int i = 0; i < dept.size(); i++) {
                dVO = dept.get(i);
                deptarr[i] = dVO.getDept();
                jcbSelectDep = new JComboBox<>(deptarr);
                jcbSelectDep.addItem(deptarr[i]);
            }
            jcbSelectDep.removeItemAt(dept.size());

            ////승인상태
            List<DocumentVO> code;
            code = DocsManagementDAO.getInstance().selectInfo("apprv");
            Object[] codearr = new Object[code.size()];
            dVO = new DocumentVO();
            for (int i = 0; i < code.size(); i++) {
                dVO = code.get(i);
                codearr[i] = dVO.getApprDesc();
                jcbSelectApprovalState = new JComboBox<>(codearr);
                jcbSelectApprovalState.addItem(codearr[i]);
            }
            jcbSelectApprovalState.removeItemAt(code.size());

            ////타입
            List<DocumentVO> paperType = DocsManagementDAO.getInstance().selectInfo("paperType");
            Object[] paperarr = new Object[paperType.size()];
            dVO = new DocumentVO();
            for (int i = 0; i < paperType.size(); i++) {
                dVO = paperType.get(i);
                paperarr[i] = dVO.getPaperType();
                jcbSelectFileType = new JComboBox<>(paperarr);
                jcbSelectFileType.addItem(paperarr[i]);
            }
            jcbSelectFileType.removeItemAt(paperType.size());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        jbtnBackhome = new JButton("메인으로");
        jbtnSearch = new JButton("찾기");

        String[] columnName = {"문서번호", "문서제목", "종류", "신청부서", "신청날짜",  "결제상태", "최종수정일"};
        dtmjtabResult = new DefaultTableModel(columnName, 0);
        jtaDob = new JTable(dtmjtabResult);
        Object[] content = new Object[7];

        jtaDob.getColumnModel().getColumn(0).setPreferredWidth(60);
        jtaDob.getColumnModel().getColumn(1).setPreferredWidth(60);
        jtaDob.getColumnModel().getColumn(2).setPreferredWidth(60);
        jtaDob.getColumnModel().getColumn(3).setPreferredWidth(60);
        jtaDob.getColumnModel().getColumn(4).setPreferredWidth(60);
        jtaDob.getColumnModel().getColumn(5).setPreferredWidth(60);
        jtaDob.getColumnModel().getColumn(6).setPreferredWidth(60);

        jcbSelectDep.setBounds(60, 60, 150, 30);
        jcbSelectFileType.setBounds(220, 60, 150, 30);
        jcbSelectApprovalState.setBounds(380, 60, 150, 30);

        jbtnBackhome.setBounds(610, 20, 100, 30);
        jbtnSearch.setBounds(610, 60, 100, 30);

        JScrollPane scrollPane = new JScrollPane(jtaDob);
        scrollPane.setBounds(30, 120, 700, 300);
        add(scrollPane);

        add(jcbSelectDep);
        add(jcbSelectFileType);
        add(jcbSelectApprovalState);

        add(jbtnBackhome);
        add(jbtnSearch);

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

        setLayout(null);

        setBounds(300, 80, 800, 470);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public JComboBox<Object> getJcbSelectDep() {
        return jcbSelectDep;
    }

    public JComboBox<Object> getJcbSelectFileType() {
        return jcbSelectFileType;
    }

    public JComboBox<Object> getJcbSelectApprovalState() {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new DocsManagement();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}