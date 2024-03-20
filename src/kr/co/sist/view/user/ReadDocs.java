package kr.co.sist.view.user;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.controller.event.ReadDocsEvent;

public class ReadDocs extends JFrame{


    private JButton jbtn_verify, jbtn_remove, jbtn_modify;
    private JLabel jldocNo, jlempNo, jlempNm, jldate;
    private JTextField jtf1, jtf2, jtf3, jtf4;

    public ReadDocs() {

        super("문서 확인");

        setLayout(null);

        JPanel jpNorth= new JPanel();

        jtf1=new JTextField();
        jtf2=new JTextField();
        jtf3=new JTextField();
        jtf4=new JTextField();

        jbtn_verify=new JButton();
        jbtn_remove=new JButton();
        jbtn_modify=new JButton();

        jldocNo= new JLabel("문서번호:");
        jlempNo= new JLabel("사번:");
        jlempNm= new JLabel("사원명:");
        jldate= new JLabel("날짜");

        jpNorth.add(jldocNo);
        jpNorth.add(jtf1);
        jpNorth.add(jlempNo);
        jpNorth.add(jtf2);
        jpNorth.add(jlempNm);
        jpNorth.add(jtf3);
        jpNorth.add(jldate);
        jpNorth.add(jtf4);

        jbtn_verify= new JButton("수정");
        jbtn_remove= new JButton("삭제");
        jbtn_modify= new JButton("확인");


        JTextArea jta= new JTextArea();

        setSize(500,600);

        jpNorth.setBounds(10,30,30,30);

        jldocNo.setBounds(50,30,200,30);
        jlempNo.setBounds(150,30,100,30);
        jlempNm.setBounds(240,30,100,30);
        jldate.setBounds(350,30,100,30);
        jtf1.setBounds(110,30,20,30);
        jtf2.setBounds(180,30,40,30);
        jtf3.setBounds(280,30,50,30);
        jtf4.setBounds(380,30,50,30);


        jta.setBounds(50, 150, 400, 300);

        jbtn_verify.setBounds(130, 480, 80, 30);
        jbtn_remove.setBounds(230, 480, 80, 30);
        jbtn_modify.setBounds(330, 480, 80, 30);

        add("North", jpNorth);
        add("Center",jta);
        add(jbtn_verify);
        add(jbtn_remove);
        add(jbtn_modify);
        add(jldocNo);
        add(jlempNo);
        add(jlempNm);
        add(jldate);
        add(jtf1);
        add(jtf2);
        add(jtf3);
        add(jtf4);

        ReadDocsEvent rde = new ReadDocsEvent(this);
        jbtn_verify.addActionListener(rde);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
	 * @return the jbtn_verify
	 */
	public JButton getJbtn_verify() {
		return jbtn_verify;
	}

	/**
	 * @return the jbtn_remove
	 */
	public JButton getJbtn_remove() {
		return jbtn_remove;
	}

	/**
	 * @return the jbtn_modify
	 */
	public JButton getJbtn_modify() {
		return jbtn_modify;
	}

	/**
	 * @return the jtf1
	 */
	public JTextField getJtf1() {
		return jtf1;
	}

	/**
	 * @return the jtf2
	 */
	public JTextField getJtf2() {
		return jtf2;
	}

	/**
	 * @return the jtf3
	 */
	public JTextField getJtf3() {
		return jtf3;
	}

	/**
	 * @return the jtf4
	 */
	public JTextField getJtf4() {
		return jtf4;
	}

    public static void main(String[] args) {
        new ReadDocs();
    }

}
