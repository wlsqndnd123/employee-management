package view.admin;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.toedter.calendar.JYearChooser;

import controller.event.CheckEmployeeInformationEvent;

public class CheckEmployeeInformation extends JFrame {
	private JTextField jtInputEmpno;
	private JList<String> jlEmpInfo;
	private JComboBox<String> cbDept, cbPosition;
	private JYearChooser cbHiredate;
	private JButton jbtnAddEmp,jbtnSearch,jbtnMain;

	public CheckEmployeeInformation() {
		super("사원정보관리");
        setLayout(null); // 레이아웃을 null로 설정하여 컴포넌트의 위치를 직접 지정할 수 있도록 함

        // 우측 상단에 제이버튼 배치
        jbtnMain = new JButton("메인으로");
        jbtnMain.setBounds(550, 50, 100, 30); // 위치와 크기 설정
        add(jbtnMain); // 프레임에 버튼 추가

        // 중하단에 제이리스트 크게 배치
        jlEmpInfo = new JList<>();
        JScrollPane scrollPane = new JScrollPane(jlEmpInfo);
        scrollPane.setBounds(50, 175, 600, 250); // 위치와 크기 설정
        add(scrollPane); // 프레임에 스크롤 가능한 리스트 추가

        // 제이리스트 위에 콤보박스 일렬로 배치
        cbDept = new JComboBox<>();
        cbDept.setBounds(50, 125, 150, 30); // 위치와 크기 설정
        add(cbDept); // 프레임에 콤보 박스 추가

        cbPosition = new JComboBox<>();
        cbPosition.setBounds(220, 125, 150, 30); // 위치와 크기 설정
        add(cbPosition); // 프레임에 콤보 박스 추가

        cbHiredate = new JYearChooser();
        cbHiredate.setBounds(390, 125, 150, 30); // 위치와 크기 설정
        add(cbHiredate); // 프레임에 콤보 박스 추가

        jtInputEmpno = new JTextField(10);
        jtInputEmpno.setBounds(50, 50, 150, 30); // 위치와 크기 설정
        add(jtInputEmpno); // 프레임에 텍스트 필드 추가

        jbtnAddEmp = new JButton("사원추가");
        jbtnAddEmp.setBounds(390, 50, 100, 30); // 위치와 크기 설정
        add(jbtnAddEmp); // 프레임에 버튼 추가

        jbtnSearch = new JButton("사원검색");
        jbtnSearch.setBounds(220, 50, 100, 30); // 위치와 크기 설정
        add(jbtnSearch); // 프레임에 버튼 추가
        
        CheckEmployeeInformationEvent checkEmpevt = new CheckEmployeeInformationEvent(this);
        jbtnMain.addActionListener(checkEmpevt);
        jbtnSearch.addActionListener(checkEmpevt);
        jbtnAddEmp.addActionListener(checkEmpevt);

        setSize(700, 500); // 프레임 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 동작 설정
        setVisible(true); // 프레임을 화면에 보이게 함
    }
	
	public JTextField getJtInputEmpno() {
		return jtInputEmpno;
	}
	
	public JList<String> getJlEmpInfo() {
		return jlEmpInfo;
	}
	
	public JComboBox<String> getCbDept() {
		return cbDept;
	}
	
	public JComboBox<String> getCbPosition() {
		return cbPosition;
	}
	
	public JYearChooser getCbHiredate() {
		return cbHiredate;
	}

    public JButton getJbtnAddEmp() {
		return jbtnAddEmp;
	}

	public JButton getJbtnSearch() {
		return jbtnSearch;
	}

	public JButton getJbtnMain() {
		return jbtnMain;
	}

	public static void main(String[] args) {
        SwingUtilities.invokeLater(CheckEmployeeInformation::new);
    }
}