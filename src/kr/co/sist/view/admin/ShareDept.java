package kr.co.sist.view.admin;

import kr.co.sist.controller.event.ShareDeptEvent;
import kr.co.sist.dao.CheckEmployeeInformationDAO;
import kr.co.sist.dao.ShareDeptDAO;
import kr.co.sist.view.util.JFrameComponent;
import kr.co.sist.vo.DocumentVO;
import kr.co.sist.vo.EmpInfoVO;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.sql.SQLException;
import java.util.List;

public class ShareDept extends JFrame {
    private JButton jbtncheck, jbtncancel;
    private JList<Object> jlDept, jlSelectedDept;
    private DefaultListModel<Object> dlmDept, dlmSelectedDept;

    public ShareDept() {
        super("공유부서설정");
        setLayout(null);

        jbtncheck = JFrameComponent.createButton(getContentPane(),"공유",75, 250, 100, 30);
        jbtncancel = JFrameComponent.createButton(getContentPane(),"취소",250, 250, 100, 30);

        dlmDept = new DefaultListModel<>();
        jlDept = new JList<>(dlmDept);
        JScrollPane jsp = new JScrollPane(jlDept);
        jsp.setBorder(new TitledBorder("부서리스트"));
        jsp.setBounds(40, 40, 150, 200);

        dlmSelectedDept = new DefaultListModel<>();
        jlSelectedDept = new JList<>(dlmSelectedDept);
        JScrollPane jsp1 = new JScrollPane(jlSelectedDept);
        jsp1.setBorder(new TitledBorder("선택 된 부서리스트"));
        jsp1.setBounds(250, 40, 150, 200);
        add(jsp);
        add(jsp1);

        createTableContents();
        createEvent();

        setBounds(150, 150, 450, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createEvent(){
        ShareDeptEvent sde = new ShareDeptEvent(this);

        jbtncheck.addActionListener(sde);
        jbtncancel.addActionListener(sde);
        jlDept.addMouseListener(sde);
        jlSelectedDept.addMouseListener(sde);
    }

    private void createTableContents(){
        CheckEmployeeInformationDAO ciDAO = CheckEmployeeInformationDAO.getInstance();
        try {
            List<EmpInfoVO> dept = ciDAO.selectInfo("dept");
            for (EmpInfoVO empInfoVO : dept) {
                dlmDept.addElement(empInfoVO.getDept());
            }
            List<DocumentVO> selectedDept =
            		ShareDeptDAO.getInstance().getSharedDepts(Integer.parseInt(ConfirmDocs.getDocNum()));
           if(selectedDept!=null) {
        	   
            for(DocumentVO dVO :selectedDept)
            	dlmDept.removeElement(dVO.getDept());
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
}
