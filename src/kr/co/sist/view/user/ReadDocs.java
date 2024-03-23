package kr.co.sist.view.user;

import kr.co.sist.controller.event.ReadDocsEvent;
import kr.co.sist.vo.DocumentVO;

import javax.swing.*;

public class ReadDocs extends JFrame {


    private JButton jbtnChg, jbtnDel, jbtnOk;
    private JLabel jldocNo, jlempNo, jlempNm, jldate;
    private JTextField jtfDocNo, jtfEmpNo, jtfEmpNm, jtfDate;
    private JTextArea jta;

    public ReadDocs() {

    }

    public ReadDocs( DocumentVO dVO) {

        super("문서 확인");

        setLayout(null);

        JPanel jpNorth = new JPanel();

        jtfDocNo = new JTextField(15);
        jtfDocNo.setText(dVO.getDocNo());
        jtfEmpNo = new JTextField(10);
        jtfEmpNo.setText(String.valueOf(dVO.getEmpNo()));

        jtfEmpNm = new JTextField(10);
        jtfEmpNm.setText(dVO.getName());

        jtfDate = new JTextField(10);
        jtfDate.setText(String.valueOf(dVO.getDocDate()));

        jldocNo = new JLabel("문서번호:");
        jlempNo = new JLabel("사번:");
        jlempNm = new JLabel("사원명:");
        jldate = new JLabel("날짜");
        jtfDocNo.setEditable(false);
        jtfEmpNo.setEditable(false);
        jtfEmpNm.setEditable(false);
        jtfDate.setEditable(false);
        jpNorth.add(jldocNo);
        jpNorth.add(jtfDocNo);
        jpNorth.add(jlempNo);
        jpNorth.add(jtfEmpNo);
        jpNorth.add(jlempNm);
        jpNorth.add(jtfEmpNm);
        jpNorth.add(jldate);
        jpNorth.add(jtfDate);

        jbtnChg = new JButton("수정");
        jbtnDel = new JButton("삭제");
        jbtnOk = new JButton("확인");


        jta = new JTextArea();
        jta.setText(dVO.getWorkLog());

        setSize(500, 600);

        jpNorth.setBounds(10, 30, 30, 30);

        jldocNo.setBounds(50, 30, 200, 30);
        jlempNo.setBounds(220, 30, 100, 30);
        jlempNm.setBounds(330, 30, 100, 30);
        jldate.setBounds(480, 30, 100, 30);

        jtfDocNo.setBounds(110, 30, 100, 30);
        jtfEmpNo.setBounds(250, 30, 70, 30);
        jtfEmpNm.setBounds(370, 30, 100, 30);
        jtfDate.setBounds(510, 30, 70, 30);


        jta.setBounds(70, 130, 500, 300);


        jbtnChg.setBounds(150, 460, 80, 30);
        jbtnDel.setBounds(250, 460, 80, 30);
        jbtnOk.setBounds(350, 460, 80, 30);

        add("North", jpNorth);
        add("Center", jta);
        add(jbtnChg);
        add(jbtnDel);
        add(jbtnOk);
        add(jldocNo);
        add(jlempNo);
        add(jlempNm);
        add(jldate);
        add(jtfDocNo);
        add(jtfEmpNo);
        add(jtfEmpNm);
        add(jtfDate);

        ReadDocsEvent rde = new ReadDocsEvent(this);
        jbtnOk.addActionListener(rde);
        jbtnChg.addActionListener(rde);
        jbtnDel.addActionListener(rde);

        setVisible(true);
        setBounds(300, 100, 650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * @return the jbtnChg
     */
    public JButton getjbtnChg() {
        return jbtnChg;
    }

    /**
     * @return the jbtnDel
     */
    public JButton getjbtnDel() {
        return jbtnDel;
    }

    /**
     * @return the jbtnOk
     */
    public JButton getjbtnOk() {
        return jbtnOk;
    }

    /**
     * @return the jtfDocNo
     */
    public JTextField getjtfDocNo() {
        return jtfDocNo;
    }

    /**
     * @return the jtfEmpNo
     */
    public JTextField getjtfEmpNo() {
        return jtfEmpNo;
    }

    /**
     * @return the jtfEmpNm
     */
    public JTextField getjtfEmpNm() {
        return jtfEmpNm;
    }

    /**
     * @return the jtfDate
     */
    public JTextField getjtfDate() {
        return jtfDate;
    }


    /**
     * @return the jta
     */
    public JTextArea getJta() {
        return jta;
    }


}
