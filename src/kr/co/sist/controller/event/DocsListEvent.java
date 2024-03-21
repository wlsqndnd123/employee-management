package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.dao.DocsListDAO;
import kr.co.sist.view.user.DocsList;
import kr.co.sist.vo.DocumentVO;

public class DocsListEvent implements ActionListener, ItemListener{
	private DocsList dclist;
	private JButton jbtnAddDoc;
	private JButton jbtnGoMain;
	private JCheckBox cbcheck;
	  private JTable jtaDob;
	    private DefaultTableModel dtmjtabResult;
	private DocumentVO dVO;
	private List<DocumentVO> dVOList;
	
	
	public DocsListEvent(DocsList dclist) {
		this.dclist = dclist;
		this.dtmjtabResult = dclist.getDtmjtabResult();

	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==dclist.getJbtnAddDoc()) {
			System.out.println("문서등록");
		}
		if(ae.getSource()==dclist.getJbtnGoMain()) {
			System.out.println("메인으로");
		}

	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==dclist.getCbcheck()) {
			System.out.println("체크");
		}
		
	}
	
	public void searchDocInfo() throws SQLException {
	    Object[] content = new Object[7];
	    DocsListDAO dlDAO = DocsListDAO.getInstance();
	    dVOList = dlDAO.selectAllDocument();
	    
	    // 문서 목록이 비어 있는 경우
	    if (dVOList.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "해당 문서가 없습니다");
	    } else {
	        for (DocumentVO dVO : dVOList) {
	            content[0] = dVO.getDocNo();
	            content[1] = dVO.getTitle();
	            content[2] = dVO.getDept();
	            content[3] = dVO.getDocDate();
	            content[4] = dVO.getApprDesc();
	            content[5] = dVO.getWorkLog();
	            content[6] = dVO.getDocDate();
	            
	            dtmjtabResult.addRow(content);
	        }
	    }
	}

	
}