package kr.co.sist.view.admin;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class reject extends JDialog implements ActionListener {
    private JTextArea jtaContent;
    private JButton jbCancel;


    public reject(VacationStatus vs, String regetDetail) {
        super(vs, "반려 사유", true);

        setLayout(new BorderLayout());

        jtaContent = new JTextArea(regetDetail);
        jtaContent.setEditable(false);
        jbCancel = new JButton("확인");
        JScrollPane jspJtaResult = new JScrollPane(jtaContent);
        jspJtaResult.setBorder(new TitledBorder("반려사유"));

        JPanel jp = new JPanel();
        jp.setLayout(null);

        jtaContent.setLineWrap(true);
        jtaContent.setWrapStyleWord(true);


        jspJtaResult.setBounds(10, 20, 445, 250);


        jbCancel.setBounds(180, 285, 100, 30);

        jp.add(jbCancel);


        jp.add(jspJtaResult);

        add(jp, BorderLayout.CENTER);


        jbCancel.addActionListener(this);


        setBounds(vs.getX() + 100, vs.getY() + 50, 480, 400);
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        dispose();

    }


}
