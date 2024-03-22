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

import kr.co.sist.controller.event.SubmitDocsEvent;

public class SubmitDocs extends JFrame implements ActionListener {

    private JButton btn_regist, btn_cancel, attAdd, attRemove;
    private JTextField jtfTitle, jtfFileNm;
    private JComboBox<String> jcb;
    private  JTextArea jta;
    
    public SubmitDocs() {
        super("문서등록");
        setLayout(null);

        JPanel jpNorth= new JPanel();

        btn_regist=new JButton("등록");
        btn_cancel=new JButton("취소");
        attAdd= new JButton("추가");
        attRemove= new JButton("취소");


        jtfTitle= new JTextField();
        jtfFileNm= new JTextField();


        jta= new JTextArea();

        DefaultComboBoxModel<String> dcbm= new DefaultComboBoxModel<String>();
        jcb= new JComboBox<String>(dcbm);

        jpNorth.add(jcb);
        jpNorth.add(jtfTitle);
        jpNorth.add(jtfFileNm);
        jpNorth.add(attAdd);
        jpNorth.add(attRemove);

        dcbm.addElement("업무일지");
        dcbm.addElement("휴가신청");
        dcbm.addElement("보고서");

        jpNorth.setBounds(10, 30, 150, 35);
        jtfTitle.setBounds(140, 30, 60, 30);
        jtfFileNm.setBounds(225,30,80,30);
        jta.setBounds(50, 100, 400, 300);

        btn_regist.setBounds(120, 450, 80, 30);	//등록버튼
        btn_cancel.setBounds(280, 450, 80, 30);	//취소버튼

        attAdd.setBounds(315, 30, 60, 30);		//추가버튼
        attRemove.setBounds(380, 30, 60, 30);	//취소버튼

        SubmitDocsEvent smde= new SubmitDocsEvent(this);
        
        attAdd.addActionListener(smde);
        attRemove.addActionListener(smde);
        
        jcb.addItemListener(smde);
        btn_regist.addActionListener(smde);
        btn_cancel.addActionListener(smde);
        
        jtfTitle.addActionListener(smde);
        
        //파일다이얼로그 창 띄우기
        FileDialog fd= new FileDialog(this,"첨부파일 선택" , FileDialog.LOAD);
        fd.setVisible(false);
        String path= fd.getDirectory();
        String name=fd.getFile();
        
        setSize(500,600);
        setBounds(300,100,650,550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(btn_regist);
        add(btn_cancel);
        add(attAdd);
        add(attRemove);
        add("North", jpNorth);
        add("Center", jta);
        add(jtfTitle);
        add(jtfFileNm);

    }

    
    
    /**
	 * @return the btn_regist
	 */
	public JButton getBtn_regist() {
		return btn_regist;
	}



	/**
	 * @return the btn_cancel
	 */
	public JButton getBtn_cancel() {
		return btn_cancel;
	}



	/**
	 * @return the attAdd
	 */
	public JButton getAttAdd() {
		return attAdd;
	}



	/**
	 * @return the attRemove
	 */
	public JButton getAttRemove() {
		return attRemove;
	}



	/**
	 * @return the jtfTitle
	 */
	public JTextField getJtfTitle() {
		return jtfTitle;
	}



	/**
	 * @return the jtfFileNm
	 */
	public JTextField getJtfFileNm() {
		return jtfFileNm;
	}



	/**
	 * @return the jta
	 */
	public JTextArea getJta() {
		return jta;
	}



	/**
	 * @return the jcb
	 */
	public JComboBox<String> getJcb() {
		return jcb;
	}



	@Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new SubmitDocs();
    }

}
