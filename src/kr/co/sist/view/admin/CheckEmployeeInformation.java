package kr.co.sist.view.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JYearChooser;

import kr.co.sist.controller.event.CheckEmployeeInformationEvent;


public class CheckEmployeeInformation extends JFrame {
	private JTextField jtInputEmpno;
	private JComboBox<String> cbDept, cbPosition;
	private JYearChooser jycHiredateYear;
	private JButton jbtnAddEmp,jbtnSearch,jbtnMain;
	private DefaultTableModel dtmEmpTable;
	private JTable jtEmpInfo;
	

	public CheckEmployeeInformation() {
		super("사원정보관리");
        setLayout(null); // 레이아웃을 null로 설정하여 컴포넌트의 위치를 직접 지정할 수 있도록 함
        
        CheckEmployeeInformationEvent checkEmpevt = new CheckEmployeeInformationEvent(this);
        String[] depts= {"대표이사","정비본부","정비기획부문","안전정비부문","정비지원팀",
        "정비통제팀","예방정비팀","중정비팀","인천운항정비팀","김포운항정비팀","부품정비팀"};
        String[] positions = {"사원","대리","과장","부장","사장"};
        String[] header = {"사번","이름","직무","직급","부서","입사일","전화번호","최종 수정 날짜"};
        
        // 우측 상단에 제이버튼 배치
        jbtnMain = new JButton("메인으로");
        jbtnMain.setBounds(550, 50, 100, 30); // 위치와 크기 설정
        add(jbtnMain); // 프레임에 버튼 추가
        
        // 중하단에 제이테이블 크게 배치
        
        DefaultTableModel model = new DefaultTableModel(header,0);
        jtEmpInfo = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(jtEmpInfo);
        scrollPane.setBounds(50, 175, 600, 250); // 위치와 크기 설정
        add(scrollPane); // 프레임에 스크롤 가능한 리스트 추가

        // 제이리스트 위에 콤보박스 일렬로 배치
        cbDept = new JComboBox<String>(depts);
        cbDept.setSelectedIndex(0);
        
        cbDept.setBounds(50, 125, 150, 30); // 위치와 크기 설정
        add(cbDept); // 프레임에 콤보 박스 추가

        cbPosition = new JComboBox<String>(positions);
        cbDept.setSelectedIndex(0);
        cbPosition.setBounds(220, 125, 150, 30); // 위치와 크기 설정
        add(cbPosition); // 프레임에 콤보 박스 추가

        jycHiredateYear = new JYearChooser();
        jycHiredateYear.setBounds(390, 125, 150, 30); // 위치와 크기 설정
        add(jycHiredateYear); // 프레임에 콤보 박스 추가

        jtInputEmpno = new JTextField(10);
        jtInputEmpno.setBounds(50, 50, 150, 30); // 위치와 크기 설정
        add(jtInputEmpno); // 프레임에 텍스트 필드 추가

        jbtnAddEmp = new JButton("사원추가");
        jbtnAddEmp.setBounds(390, 50, 100, 30); // 위치와 크기 설정
        add(jbtnAddEmp); // 프레임에 버튼 추가

        jbtnSearch = new JButton("사원검색");
        jbtnSearch.setBounds(220, 50, 100, 30); // 위치와 크기 설정
        add(jbtnSearch); // 프레임에 버튼 추가
        
        jbtnMain.addActionListener(checkEmpevt);
        jbtnSearch.addActionListener(checkEmpevt);
        jbtnAddEmp.addActionListener(checkEmpevt);
        cbDept.addActionListener(checkEmpevt);
        cbPosition.addActionListener(checkEmpevt);
        
        

        setSize(700, 500); // 프레임 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 동작 설정
        setVisible(true); // 프레임을 화면에 보이게 함
    }
	
	public JTextField getJtInputEmpno() {
		return jtInputEmpno;
	}
	
	
	public JComboBox<String> getCbDept() {
		return cbDept;
	}
	
	public JComboBox<String> getCbPosition() {
		return cbPosition;
	}
	

    public JButton getJbtnAddEmp() {
		return jbtnAddEmp;
	}

	public JButton getJbtnSearch() {
		return jbtnSearch;
	}

	public JYearChooser getJycHiredateYear() {
		return jycHiredateYear;
	}

	public DefaultTableModel getDtmEmpTable() {
		return dtmEmpTable;
	}

	public JTable getJtEmpInfo() {
		return jtEmpInfo;
	}

	public JButton getJbtnMain() {
		return jbtnMain;
	}
	

	public void setDtmEmpTable(DefaultTableModel dtmEmpTable) {
		this.dtmEmpTable = dtmEmpTable;
	}

	public static void main(String[] args) {
        SwingUtilities.invokeLater(CheckEmployeeInformation::new);
    }
}