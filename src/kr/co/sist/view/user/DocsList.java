package kr.co.sist.view.user;

import kr.co.sist.controller.event.DocsListEvent;
import kr.co.sist.view.util.JFrameComponent;
import kr.co.sist.vo.DocumentVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class DocsList extends JFrame {
	private JCheckBox cbcheck;
	private JButton jbtnAddDoc;
	private JButton jbtnGoMain;
	private JTable jtDoc;
	private DefaultTableModel dtmjtabResult;


	public DocsList() {
		setTitle("사원문서리스트");
		setLayout(null);
		cbcheck = new JCheckBox("공유문서");
		add(cbcheck);
		cbcheck.setBounds(30, 20, 100, 20);
		createTable();
		addButtons();
		createEvents();

		setBounds(300, 100, 700, 570);
		setVisible(true);
	}

	private void addButtons() {
		jbtnAddDoc = JFrameComponent.createButton(getContentPane(), "문서등록", 550, 60, 100, 30);
		jbtnGoMain = JFrameComponent.createButton(getContentPane(), "메인으로", 550, 20, 100, 30);

	}

	private void createEvents() {
		DocsListEvent dle = new DocsListEvent(this);

		addWindowListener(dle);
		jbtnAddDoc.addActionListener(dle);
		jbtnGoMain.addActionListener(dle);
		cbcheck.addItemListener(dle);
		jtDoc.addMouseListener(dle);
		try {
			dle.printDocs(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void createTable() {
		String[] columnName = { "문서번호", "문서제목", "신청부서", "신청날짜", "결제상태", "최종수정일" };
		dtmjtabResult = new DefaultTableModel(columnName, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		jtDoc = new JTable(dtmjtabResult);
		jtDoc.getTableHeader().setReorderingAllowed(false);
		jtDoc.getTableHeader().setResizingAllowed(false);

		for (int i = 0; i < columnName.length; i++) {
			jtDoc.getColumnModel().getColumn(i).setPreferredWidth(60);
		}
		JScrollPane scrollPane = new JScrollPane(jtDoc);
		scrollPane.setBounds(30, 110, 600, 400);
		add(scrollPane);
	}

	public JCheckBox getCbcheck() {
		return cbcheck;
	}

	public JButton getJbtnAddDoc() {
		return jbtnAddDoc;
	}

	public JButton getJbtnGoMain() {
		return jbtnGoMain;
	}

	public JTable getJtaDob() {
		return jtDoc;
	}

	public DefaultTableModel getDtmjtabResult() {
		return dtmjtabResult;
	}

}