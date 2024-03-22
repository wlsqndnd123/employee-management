package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.dao.DocsListDAO;
import kr.co.sist.dao.DocsManagementDAO;
import kr.co.sist.view.admin.DocsManagement;
import kr.co.sist.vo.DocumentVO;

public class DocsManagementEvent implements ActionListener{
	private DocsManagement dmm;
	private JButton jbtnBackhome,jbtnSearch;
	  private JTable jtaDob;
	    private DefaultTableModel dtmjtabResult;
	private DocumentVO dVO;
	private List<DocumentVO> dVOList;
	

	
	
	public DocsManagementEvent(DocsManagement dmm) {
		this.dmm = dmm;
		this.dtmjtabResult = dmm.getDtmjtabResult();
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==dmm.getJbtnBackhome()) {
			System.out.println("메인으로");
		}
		if(ae.getSource()==dmm.getJbtnSearch()) {
			System.out.println("찾기");
		}
	}
	
	
	
	
	public void searchDocument()throws SQLException{
	  Object[] content = new Object[7];
	  DocsManagementDAO dmmDAO = DocsManagementDAO.getInstance();
	  dVOList = dmmDAO.searchDocument();
	  
	  dtmjtabResult.setRowCount(0);
	  
	  if(dVOList.isEmpty()) {
		  JOptionPane.showMessageDialog(null, "해당 문서가 없습니다");
	  } else {
		  for(DocumentVO dVO :dVOList) {
			  content[0] = dVO.getDocNo();
			  content[1] = dVO.getTitle();
	            content[2] = dVO.getDept();
	            content[3] = dVO.getDocDate();
	            content[4] = dVO.getApprDesc();
	            content[5] = dVO.getEmpNo();
	            content[6] = dVO.getDocDate();
	            
	            dtmjtabResult.addRow(content);
		  }
	  }
		
		
	}
	
	
	
}
