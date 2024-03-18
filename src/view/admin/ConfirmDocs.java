package view.admin;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConfirmDocs extends JFrame {
	private JButton jbtnShape;
	private JButton jbtnAppval;
	private JButton jbtnCompanion;
	private JButton jbtnCheck;
	private JTextField jtfFile;
	private JTextField jtfcontents;
	
	
	
	public ConfirmDocs() {
		super("문서확인");
		setLayout(null);
		
		createClickButton();
		
		setBounds(300,100,1000,650);
		  setVisible(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void createClickButton() {
		 jbtnShape=new JButton("공유");
		 jbtnAppval=new JButton("승인");
		 jbtnCompanion=new JButton("반려");
		 jbtnCheck=new JButton("확인");
		 jtfFile=new JTextField();
		 jtfcontents=new JTextField();
		
		 
		 
		 jbtnShape.setBounds(50, 500, 100, 50);
		 jbtnAppval.setBounds(340, 500, 100, 50);
		 jbtnCompanion.setBounds(570, 500, 100, 50);
		 jbtnCheck.setBounds(800, 500, 100, 50);
		 jtfFile.setBounds(100, 50, 800, 50);
		 jtfcontents.setBounds(100, 180, 800, 300);
		 
		 
		 
		 add(jbtnShape);
		 add(jbtnAppval);
		 add(jbtnCompanion);
		 add(jbtnCheck);
		 add(jtfFile);
		 add(jtfcontents);
		 
		
	}
	
	
	 public static void main(String[] args) {
	        new ConfirmDocs();
	    }
	
}
