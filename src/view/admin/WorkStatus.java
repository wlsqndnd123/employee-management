package view.admin;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class WorkStatus extends JFrame{
    private JTable jtDailyStatus;
    private DefaultTableModel dtmDailyStatus;
    private JTextField jtfEmpNum;
    private JComboBox<String> jcbDateRange;
    private DefaultComboBoxModel<String> dcbmDateRange;
    private JButton jbCheck;
    private JButton jbVacationStatus;
    private JButton jbGoMain;

    
    
    public WorkStatus() {
        setTitle("근태 관리");
        setLayout(new BorderLayout());
        
        String[] coloumnName = {"사번","이름","출근시간","퇴근시간","사용연차","연차"}; 
        dtmDailyStatus = new DefaultTableModel(coloumnName,0);
        jtDailyStatus = new JTable(dtmDailyStatus);
        JScrollPane jspJtaResult = new JScrollPane(jtDailyStatus);
        jspJtaResult.setBorder(new TitledBorder("근태정보"));
        
        jbGoMain = new JButton("메뉴창으로");
        jtfEmpNum = new JTextField("사번입력");
        jcbDateRange = new JComboBox<String>();
        jbCheck = new JButton("조회");
        jbVacationStatus = new JButton("휴가관리");
        
        jtDailyStatus.getColumnModel().getColumn(0).setPreferredWidth(80);
        
        dcbmDateRange = new DefaultComboBoxModel<String>();
        jcbDateRange = new JComboBox<String>(dcbmDateRange);
        dcbmDateRange.addElement("오늘");
        dcbmDateRange.addElement("1주일");
        dcbmDateRange.addElement("1달");
        dcbmDateRange.addElement("1년");
		
      
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        jbGoMain.setBounds(510, 20, 100, 30);
        jtfEmpNum.setBounds(510, 60, 100, 30);
        jcbDateRange.setBounds(510, 100, 100, 30);
        jbCheck.setBounds(510,200, 100, 30);
        jbVacationStatus.setBounds(510,270, 100, 30);
        jspJtaResult.setBounds(10,10, 490, 480);
        
        panel.add(jbGoMain);
        panel.add(jtfEmpNum);
        panel.add(jcbDateRange);
        panel.add(jbCheck);
        panel.add(jbVacationStatus);
        panel.add(jspJtaResult);
        
        add(panel, BorderLayout.CENTER);
        
        setBounds(300, 100, 650, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }

    public static void main(String[] args) {
        new WorkStatus();
    }
    
    
}
