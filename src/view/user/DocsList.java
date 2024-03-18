package view.user;

import java.awt.Checkbox;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import view.admin.ConfirmDocs;

public class DocsList extends JFrame{
	private JCheckBox cbcheck;
	private JButton jbtnAddDoc;
	private JButton jbtnGoMain;
	private JTable jtaDob;
	private DefaultTableModel dtmjtabResult;
	
	public DocsList() {
		super("사원문서리스트");
		setLayout(null);
		
		createClickButton();
		
		setBounds(300,100,1000,650);
		 setVisible(true);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public void createClickButton() {
		
		cbcheck=new JCheckBox();
		jbtnAddDoc=new JButton("문서등록");
		jbtnGoMain=new JButton("메인으로");
		
		String[]columnName= {"문서번호","문서제목","신청부서","신청날짜","결재상태","공유상태","최종수정일"};
		dtmjtabResult=new DefaultTableModel(columnName,0);
		jtaDob=new JTable(dtmjtabResult);
		
		jtaDob.getColumnModel().getColumn(0).setPreferredWidth(60);
		jtaDob.getColumnModel().getColumn(1).setPreferredWidth(60);
		jtaDob.getColumnModel().getColumn(2).setPreferredWidth(60);
		jtaDob.getColumnModel().getColumn(3).setPreferredWidth(60);
		jtaDob.getColumnModel().getColumn(4).setPreferredWidth(60);
		jtaDob.getColumnModel().getColumn(5).setPreferredWidth(60);
		jtaDob.getColumnModel().getColumn(6).setPreferredWidth(60);
	
		
		cbcheck.setBounds(50, 30, 50, 50);
		jbtnAddDoc.setBounds(800, 80, 100, 50);
		jbtnGoMain.setBounds(800, 20, 100, 50);
		
		JScrollPane scrollPane = new JScrollPane(jtaDob);
        scrollPane.setBounds(50, 100, 600, 400);
        add(scrollPane);
		
		add(cbcheck);
		add(jbtnAddDoc);
		add(jbtnGoMain);
		
		
	}
	
	
	
	
	
	 public static void main(String[] args) {
	        new DocsList();
	    }
	
}
