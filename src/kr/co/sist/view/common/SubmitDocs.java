package kr.co.sist.view.common;


import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SubmitDocs extends JFrame implements ActionListener {

    private JButton btn_regist, btn_cancel, attAdd, attRemove;
    private JTextField jtf1, jtf2;
    private JComboBox<String> jcb;

    public SubmitDocs() {
        super("문서등록");
        setLayout(null);

        JPanel jpNorth= new JPanel();

        btn_regist=new JButton("등록");
        btn_cancel=new JButton("취소");
        attAdd= new JButton("추가");
        attRemove= new JButton("취소");


        jtf1= new JTextField();
        jtf2= new JTextField();

        //파일다이얼로그 창 띄우기
        FileDialog fd= new FileDialog(this,"첨부파일 선택" , FileDialog.LOAD);
        fd.setVisible(false);
        String path= fd.getDirectory();
        String name=fd.getFile();

        JTextArea jta= new JTextArea();

        DefaultComboBoxModel<String> dcbm= new DefaultComboBoxModel<String>();
        JComboBox<String> jcb= new JComboBox<String>(dcbm);

        jpNorth.add(jcb);
        jpNorth.add(jtf1);
        jpNorth.add(jtf2);
        jpNorth.add(attAdd);
        jpNorth.add(attRemove);

        dcbm.addElement("업무일지");
        dcbm.addElement("휴가신청");
        dcbm.addElement("보고서");

        jpNorth.setBounds(10, 30, 150, 35);
        jtf1.setBounds(130, 30, 60, 30);
        jtf2.setBounds(225,30,80,30);
        jta.setBounds(50, 100, 400, 300);

        btn_regist.setBounds(120, 480, 80, 30);	//등록버튼
        btn_cancel.setBounds(280, 480, 80, 30);	//취소버튼

        attAdd.setBounds(315, 30, 60, 30);		//추가버튼
        attRemove.setBounds(380, 30, 60, 30);	//취소버튼




        setSize(500,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(btn_regist);
        add(btn_cancel);
        add(attAdd);
        add(attRemove);
        add("North", jpNorth);
        add("Center", jta);
        add(jtf1);
        add(jtf2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new view.common.SubmitDocs();
    }

}
