package view.admin;


import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class DocsManagement extends JFrame {

	private  JComboBox<String> jcbSelectDep;
	private  JComboBox<String> jcbSelectFileType;
	private JComboBox<String> jcbSelectApprovalState;
	private JButton jbtnGoMain;
	private JButton jbtnSearch;
	private JTable jtaDob;
	private DefaultTableModel dtmjtabResult;
	
	public DocsManagement() {
		
		super("관리자문서관리메뉴");
		setLayout(null);
		
		createClickButton();
	
		
        setBounds(300,100,850,650);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void createClickButton() {
		
		 jcbSelectDep=new JComboBox<>();
		 jcbSelectFileType=new JComboBox<>();
		 jcbSelectApprovalState=new JComboBox<>();
		 jbtnGoMain=new JButton("메인으로");
		 jbtnSearch=new JButton("찾기");
		 
		 String[]columnName= {"문서번호","문서제목","결재상태","신청부서","신청날짜","공유상태","결재상태","최종수정일"};
			dtmjtabResult=new DefaultTableModel(columnName,0);
			jtaDob=new JTable(dtmjtabResult);
	
			
			jtaDob.getColumnModel().getColumn(0).setPreferredWidth(60);
			jtaDob.getColumnModel().getColumn(1).setPreferredWidth(60);
			jtaDob.getColumnModel().getColumn(2).setPreferredWidth(60);
			jtaDob.getColumnModel().getColumn(3).setPreferredWidth(60);
			jtaDob.getColumnModel().getColumn(4).setPreferredWidth(60);
			jtaDob.getColumnModel().getColumn(5).setPreferredWidth(60);
			jtaDob.getColumnModel().getColumn(6).setPreferredWidth(60);
			jtaDob.getColumnModel().getColumn(7).setPreferredWidth(60);
		 
		 
		
		 jcbSelectDep.setBounds(60, 80, 120, 50);
		 jcbSelectFileType.setBounds(250, 80, 120, 50);
		 jcbSelectApprovalState.setBounds(400, 80, 120, 50);
		 jbtnGoMain.setBounds(700, 20, 100, 50);
		 jbtnSearch.setBounds(550, 80, 100, 50);
		 
		 JScrollPane scrollPane = new JScrollPane(jtaDob);
	        scrollPane.setBounds(50, 150, 700, 400);
	        add(scrollPane);
		 
		 add(jcbSelectDep);
		 add(jcbSelectFileType);
		 add(jcbSelectApprovalState);
		 add(jbtnGoMain);
		 add(jbtnSearch);
		
	}
	
	

	
	
	
	
	
	 public static void main(String[] args) {
	        new DocsManagement();
	    }

	
}

