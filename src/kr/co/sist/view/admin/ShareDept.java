package kr.co.sist.view.admin;

import kr.co.sist.controller.event.ShareDeptEvent;
import kr.co.sist.dao.CheckEmployeeInformationDAO;
import kr.co.sist.vo.EmpInfoVO;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.sql.SQLException;
import java.util.List;

public class ShareDept extends JFrame {
    private JButton jbtncheck, jbtncancel;
    private JList<Object> jlDept, jlSelectedDept;
    private DefaultListModel<Object> dlmDept, dlmSelectedDept;
    private EmpInfoVO eVO;

    public ShareDept() {
        super("공유부서설정");
        setLayout(null);
        jbtncheck = new JButton("공유");
        jbtncheck.setBounds(75, 250, 100, 30);
        jbtncancel = new JButton("취소");
        jbtncancel.setBounds(250, 250, 100, 30);
        CheckEmployeeInformationDAO ciDAO = CheckEmployeeInformationDAO.getInstance();
        Object[] depts;
        dlmDept = new DefaultListModel<>();
        dlmSelectedDept = new DefaultListModel<>();
        jlDept = new JList<>(dlmDept);
        jlSelectedDept = new JList<>(dlmSelectedDept);
        JScrollPane jsp = new JScrollPane(jlDept);
        JScrollPane jsp1 = new JScrollPane(jlSelectedDept);
        jsp.setBorder(new TitledBorder("부서리스트"));
        jsp1.setBorder(new TitledBorder("선택 된 부서리스트"));

        jsp.setBounds(40, 40, 150, 200);
        jsp1.setBounds(250, 40, 150, 200);
        List<EmpInfoVO> dept;
        try {
            dept = ciDAO.selectInfo("dept");
            depts = new Object[dept.size()];
            eVO = new EmpInfoVO();
            for (int i = 0; i < dept.size(); i++) {
                eVO = dept.get(i);
                depts[i] = eVO.getDept();
                dlmDept.addElement(depts[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ShareDeptEvent sde = new ShareDeptEvent(this);
        jbtncheck.addActionListener(sde);
        jbtncancel.addActionListener(sde);
        jlDept.addMouseListener(sde);
        jlSelectedDept.addMouseListener(sde);
        add(jsp);
        add(jsp1);
        add(jbtncheck);
        add(jbtncancel);
        setBounds(150, 150, 450, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JButton getJbtncheck() {
        return jbtncheck;
    }

    public JButton getJbtncancel() {
        return jbtncancel;
    }

    public JList<Object> getJlDept() {
        return jlDept;
    }

    public DefaultListModel<Object> getDlmDept() {
        return dlmDept;
    }

    public JList<Object> getJlSelectedDept() {
        return jlSelectedDept;
    }

    public DefaultListModel<Object> getDlmSelectedDept() {
        return dlmSelectedDept;
    }

    public static void main(String[] args) {
        new ShareDept();
    }
}
