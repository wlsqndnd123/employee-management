package kr.co.sist.view.admin;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JYearChooser;

import kr.co.sist.controller.event.CheckEmployeeInformationEvent;
import kr.co.sist.dao.CheckEmployeeInformationDAO;
import kr.co.sist.vo.EmpInfoVO;

public class CheckEmployeeInformation extends JFrame {
	private JTextField jtInputEmpno;
	private JComboBox<Object> cbDept, cbPosition;
	private JYearChooser jycHiredateYear;
	private JButton jbtnAddEmp, jbtnSearch, jbtnMain;
	private DefaultTableModel dtmEmpTable;
	private JTable jtEmpInfo;
	private EmpInfoVO eVO;

	public CheckEmployeeInformation() {
		super("사원정보관리");
		setLayout(null); // 레이아웃을 null로 설정하여 컴포넌트의 위치를 직접 지정할 수 있도록 함

		CheckEmployeeInformationEvent checkEmpevt = new CheckEmployeeInformationEvent(this);
		CheckEmployeeInformationDAO ciDAO = CheckEmployeeInformationDAO.getInstance();

		Object[] depts;
		Object[] positions;
		String[] header = { "사번", "이름", "직무", "직급", "부서", "입사일", "전화번호", "최종 수정 날짜" };
		Object[] content = new Object[8];
		// 우측 상단에 제이버튼 배치
		jbtnMain = new JButton("메인으로");
		jbtnMain.setBounds(550, 50, 100, 30); // 위치와 크기 설정
		add(jbtnMain); // 프레임에 버튼 추가

		// 중하단에 제이테이블 크게 배치

		dtmEmpTable = new DefaultTableModel(header, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		jtEmpInfo = new JTable(dtmEmpTable);
		JScrollPane scrollPane = new JScrollPane(jtEmpInfo);
		scrollPane.setBounds(50, 175, 600, 250); // 위치와 크기 설정
		add(scrollPane); // 프레임에 스크롤 가능한 리스트 추가
		///////////////////////////////////
		List<EmpInfoVO> dept;
		try {
			dept = ciDAO.selectInfo("dept");
			depts = new Object[dept.size()];
			eVO = new EmpInfoVO();
			for (int i = 0; i < dept.size(); i++) {
				eVO = dept.get(i);
				depts[i] = eVO.getDept();
				cbDept = new JComboBox<Object>(depts);
				cbDept.addItem(depts[i]);
			}
			
			cbDept.removeItemAt(dept.size());
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/////////////////////////////////////////
		///////////////////////////////////
		List<EmpInfoVO> pos;
		try {
			pos = ciDAO.selectInfo("pos");
			positions = new Object[pos.size()];
			eVO = new EmpInfoVO();
			for (int i = 0; i < pos.size(); i++) {
				eVO = pos.get(i);
				positions[i] = eVO.getPosition();
				cbPosition = new JComboBox<Object>(positions);
				cbPosition.addItem(positions[i]);

			}
			cbPosition.removeItemAt(pos.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/////////////////////////////////////////
		List<EmpInfoVO> list;
		try {
			list = ciDAO.selectAllEmpInfo();
			eVO = new EmpInfoVO();
			for (int i = 0; i < list.size(); i++) {
				eVO = list.get(i);
				content[0] = eVO.getEmpno();
				content[1] = eVO.getName();
				content[2] = eVO.getJob();
				content[3] = eVO.getPosition();
				content[4] = eVO.getDept();
				content[5] = eVO.getHiredate();
				content[6] = eVO.getTel();
				content[7] = eVO.getModifiedDate();
				dtmEmpTable.addRow(content);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//////////////////////////////////////////////////////////////
//		jtEmpInfo.setEnabled(false);
		// 제이리스트 위에 콤보박스 일렬로 배치
		cbDept.setSelectedIndex(0);

		cbDept.setBounds(50, 125, 150, 30); // 위치와 크기 설정
		add(cbDept); // 프레임에 콤보 박스 추가

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
		jtEmpInfo.addMouseListener(checkEmpevt);

		setSize(700, 500); // 프레임 크기 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 동작 설정
		setVisible(true); // 프레임을 화면에 보이게 함
	}

	public JTextField getJtInputEmpno() {
		return jtInputEmpno;
	}

	public JComboBox<Object> getCbDept() {
		return cbDept;
	}

	public JComboBox<Object> getCbPosition() {
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

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new CheckEmployeeInformation();
		});
	}
}