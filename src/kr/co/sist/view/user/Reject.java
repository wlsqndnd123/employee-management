package kr.co.sist.view.user;

import kr.co.sist.view.admin.DocsManagement;
import kr.co.sist.view.admin.VacationStatus;
import kr.co.sist.view.util.JFrameComponent;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class Reject extends JDialog implements ActionListener {
    private JTextArea jtaContent;
    private JButton jbCancel;

    public Reject(VacationStatus vs, String regetDetail ) {
        super(vs, "반려 사유", true);
        setLayout(null);

        jtaContent = new JTextArea(regetDetail);
        JScrollPane jspJtaResult = JFrameComponent.createPane(getContentPane(),jtaContent,10, 20, 445, 250,false,true,true);
        jspJtaResult.setBorder(new TitledBorder("반려사유"));

        jbCancel = JFrameComponent.createButton(getContentPane(),"확인",180, 285, 100, 30);

        jbCancel.addActionListener(this);

        setBounds(vs.getX() + 100, vs.getY() + 50, 480, 400);
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    
    public Reject(DocsList dclist, String regetDetail ) {
        super(dclist, "반려 사유", true);
        setLayout(null);

        jtaContent = new JTextArea(regetDetail);
        JScrollPane jspJtaResult = JFrameComponent.createPane(getContentPane(),jtaContent,10, 20, 445, 250,false,true,true);
        jspJtaResult.setBorder(new TitledBorder("반려사유"));

        jbCancel = JFrameComponent.createButton(getContentPane(),"확인",180, 285, 100, 30);

        jbCancel.addActionListener(this);

        setBounds(dclist.getX() + 100, dclist.getY() + 50, 480, 400);
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public Reject(DocsManagement dmm, String regetDetail ) {
        super(dmm, "반려 사유", true);
        setLayout(null);

        jtaContent = new JTextArea(regetDetail);
        JScrollPane jspJtaResult = JFrameComponent.createPane(getContentPane(),jtaContent,10, 20, 445, 250,false,true,true);
        jspJtaResult.setBorder(new TitledBorder("반려사유"));

        jbCancel = JFrameComponent.createButton(getContentPane(),"확인",180, 285, 100, 30);

        jbCancel.addActionListener(this);

        setBounds(dmm.getX() + 100, dmm.getY() + 50, 480, 400);
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
    	dispose();
    }
    
}
