package kr.co.sist.view.admin;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class VacationStatus extends JFrame {
	private JTable jtVacationStatus;
	private DefaultTableModel dtmVacationStatus;
	private JButton jbBack;
	
	public VacationStatus() {
		setTitle("사원 휴가신청 관리");
		setLayout(new BorderLayout());
		
		String[] coloumnName = {"신청번호","사원번호","제목","신청날짜","부서","결재상태"};
		dtmVacationStatus = new DefaultTableModel(coloumnName,0);
		jtVacationStatus = new JTable(dtmVacationStatus);
	    JScrollPane jspJtaResult = new JScrollPane(jtVacationStatus);
	    jspJtaResult.setBorder(new TitledBorder("휴가신청표"));
	    
	    
	    jbBack = new JButton("뒤로");
		
	    
	    JPanel panel = new JPanel();
        panel.setLayout(null);
        jbBack.setBounds(510, 20, 100, 30);
        jspJtaResult.setBounds(10,50, 600, 440);
        
        panel.add(jbBack);
        panel.add(jspJtaResult);
	    
        add(panel, BorderLayout.CENTER);
        
        setBounds(300, 100, 650, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	}
	
	
	 public static void main(String[] args) {
	        new VacationStatus();
	    }
	    
	
	
	
	
	
	
}
