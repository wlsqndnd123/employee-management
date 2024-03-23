package kr.co.sist.view.admin;


import java.awt.Dialog;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.controller.event.DocsManagementEvent;
import kr.co.sist.view.user.DocsList;
import kr.co.sist.vo.DocumentVO;

@SuppressWarnings("serial")
public class DocsManagement extends JFrame {
	
	private  JComboBox<String> jcbSelectDep;
	private  JComboBox<String> jcbSelectFileType;
	private JComboBox<String> jcbSelectApprovalState;
	private JButton jbtnBackhome;
	private JButton jbtnSearch;
	private JTable jtaDob;
    private DefaultTableModel dtmjtabResult;
    private DocumentVO dVO;
	
	public DocsManagement() {
		
		super("관리자문서관리메뉴");
		setLayout(null);
		DocsManagementEvent dme = new DocsManagementEvent(this);
		 jcbSelectDep=new JComboBox<>();
		 jcbSelectFileType=new JComboBox<>();
		 jcbSelectApprovalState=new JComboBox<>();
		 jbtnBackhome=new JButton("메인으로");
		 jbtnSearch=new JButton("찾기");
		 
		 String[]columnName= {"문서번호","문서제목","종류","신청부서","신청날짜","공유상태","결제상태","최종수정일"};
	        dtmjtabResult=new DefaultTableModel(columnName,0);
	        jtaDob=new JTable(dtmjtabResult);
	        Object[] depts;
	        Object[] content = new Object[8];
	        
	        
	        
	        jtaDob.getColumnModel().getColumn(0).setPreferredWidth(60);
	        jtaDob.getColumnModel().getColumn(1).setPreferredWidth(60);
	        jtaDob.getColumnModel().getColumn(2).setPreferredWidth(60);
	        jtaDob.getColumnModel().getColumn(3).setPreferredWidth(60);
	        jtaDob.getColumnModel().getColumn(4).setPreferredWidth(60);
	        jtaDob.getColumnModel().getColumn(5).setPreferredWidth(60);
	        jtaDob.getColumnModel().getColumn(6).setPreferredWidth(60);
	        jtaDob.getColumnModel().getColumn(7).setPreferredWidth(60);
	        
	        
	        
	        
		
		 jcbSelectDep.setBounds(60, 60, 150, 30);
		 jcbSelectFileType.setBounds(220, 60, 150, 30);
		 jcbSelectApprovalState.setBounds(380, 60, 150, 30);
		
		 jbtnBackhome.setBounds(610, 20, 100, 30);
		 jbtnSearch.setBounds(610, 60, 100, 30);
		 
		 JScrollPane scrollPane = new JScrollPane(jtaDob);
	        scrollPane.setBounds(30, 120, 700, 300);
	        add(scrollPane);
		
		 add(jcbSelectDep);
		 add(jcbSelectFileType);
		 add(jcbSelectApprovalState);
		
		 add(jbtnBackhome);
		 add(jbtnSearch);
		 
		 dme=new DocsManagementEvent(this);
		 
		 jbtnBackhome.addActionListener(dme);
		 jbtnSearch.addActionListener(dme);
		 
		 try {
			dme.searchDocument();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 setLayout(null);
		
        setBounds(300,80,800,470);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	 public JComboBox<String> getJcbSelectDep() {
		return jcbSelectDep;
	}


	public JComboBox<String> getJcbSelectFileType() {
		return jcbSelectFileType;
	}


	public JComboBox<String> getJcbSelectApprovalState() {
		return jcbSelectApprovalState;
	}


	public JButton getJbtnBackhome() {
		return jbtnBackhome;
	}


	public JButton getJbtnSearch() {
		return jbtnSearch;
	}



	public JTable getJtaDob() {
		return jtaDob;
	}



	public DefaultTableModel getDtmjtabResult() {
		return dtmjtabResult;
	}




	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				new DocsManagement();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}