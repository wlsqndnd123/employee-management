package kr.co.sist.view.user;

import kr.co.sist.controller.event.ReadDocsEvent;
import kr.co.sist.view.util.JFrameComponent;
import kr.co.sist.vo.DocumentVO;

import javax.swing.*;

public class ReadDocs extends JFrame {


    private JButton jbtnChg, jbtnDel, jbtnOk;
    private JLabel jldocNo, jlempNo, jlempNm, jldate;
    private JTextField jtfDocNo, jtfEmpNo, jtfEmpNm, jtfDate;
    private JTextArea jta;

    public ReadDocs() {

    }

    public ReadDocs(DocumentVO dVO) {

        super("문서 확인");

        setLayout(null);
        createTextFiled(dVO);
        jtfDocNo = JFrameComponent.createTextField(getContentPane(),110, 30, 100, 30);
        jtfEmpNo = JFrameComponent.createTextField(getContentPane(),250, 30, 70, 30);
        jtfEmpNm = JFrameComponent.createTextField(getContentPane(),370, 30, 100, 30);
        jtfDate = JFrameComponent.createTextField(getContentPane(),510, 30, 70, 30);

        jldocNo= JFrameComponent.createLabel(getContentPane(), "문서번호:", 50, 30, 200, 30);
        jlempNo= JFrameComponent.createLabel(getContentPane(), "사번:",220, 30, 100, 30);
        jlempNm= JFrameComponent.createLabel(getContentPane(), "사원명:",330, 30, 100, 30);
        jldate= JFrameComponent.createLabel(getContentPane(), "날짜:",480, 30, 100, 30);

        jbtnChg= JFrameComponent.createButton(getContentPane(),"수정" ,150, 460, 80, 30);
        jbtnDel= JFrameComponent.createButton(getContentPane(),"삭제" ,250, 460, 80, 30);
        jbtnOk= JFrameComponent.createButton(getContentPane(),"확인" ,350, 460, 80, 30);
        jta = new JTextArea();
        jta.setText(dVO.getWorkLog());
        addActions();


        setSize(500, 600);






        jta.setBounds(70, 130, 500, 300);
        setVisible(true);
        setBounds(300, 100, 650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void createTextFiled(DocumentVO dVO) {
    	jtfDocNo = new JTextField(15);
    	jtfDocNo.setText(dVO.getDocNo());
    	jtfEmpNo = new JTextField(10);
    	jtfEmpNo.setText(String.valueOf(dVO.getEmpNo()));
    	jtfEmpNm = new JTextField(10);
    	jtfEmpNm.setText(dVO.getName());
    	jtfDate = new JTextField(10);
    	jtfDate.setText(String.valueOf(dVO.getDocDate()));
    	jtfDocNo.setEditable(false);
    	jtfEmpNo.setEditable(false);
    	jtfEmpNm.setEditable(false);
    	jtfDate.setEditable(false);
    	
    }
    private void addActions() {
    	ReadDocsEvent rde = new ReadDocsEvent(this);
    	jbtnOk.addActionListener(rde);
    	jbtnChg.addActionListener(rde);
    	jbtnDel.addActionListener(rde);
    	
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
