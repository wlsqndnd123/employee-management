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
	private List<DocumentVO> dVOList;
	
	public DocsManagementEvent(DocsManagement dmm) {
		this.dmm =dmm;
	}
	
	
//
//	@Override
//	public void actionPerformed(ActionEvent ae) {
//		if(ae.getSource()==dmm.getJbtnBackhome()) {
//			System.out.println("메인으로");
//		}
//		if(ae.getSource()==dmm.getJbtnSearch()) {
//			System.out.println("찾기");
//		
//			
//		}
//		
//		
//		
//	}
//	
	public void addCombobox(String col) {
		List<DocumentVO> colList;
		
		colList = DocsManagementDAO.getInstance().selectInfo(col);
	}
	
	
	public void searchDocument()throws SQLException{
	  Object[] content = new Object[8];
	  DocsManagementDAO dmmDAO = DocsManagementDAO.getInstance();
	  dVOList = dmmDAO.searchDocument();
	  
	  if(dVOList.isEmpty()) {
		  JOptionPane.showMessageDialog(null, "해당 문서가 없습니다");
	  } else {
		  for(DocumentVO dVO :dVOList) {
			  content[0] = dVO.getDocNo();
			  content[1] = dVO.getTitle();
	          content[2] = dVO.getFileName();  
			  content[3] = dVO.getDept();
	            content[4] = dVO.getDocDate();
	            content[5] = dVO.getApprDesc();
	            content[6] = dVO.getEmpNo();
	            content[7] = dVO.getDocDate();
	            
	            dmm.getDtmjtabResult().addRow(content);
		  }
	  }
	}//searchDocument




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void selectDocument()throws SQLException{
		String dept = dmm.getJcbSelectDep().getSelectedItem().toString();
		String fileType = dmm.getJcbSelectFileType().getSelectedItem().toString();
		String appr = dmm.getJcbSelectApprovalState().getSelectedItem().toString();
		Object[] content = new Object[7];
		
		if(dept == null&& fileType == null && appr == null) {
			JOptionPane.showMessageDialog(null, "모두 선택을 해주세요.");
			return;
		}
		DocsManagementDAO dmDAO = DocsManagementDAO.getInstance();
		dVOList = dmDAO.selectDocInfo(dept, fileType, appr); 
		dmm.getDtmjtabResult().setRowCount(0);
		if(dVOList == null) {
			JOptionPane.showMessageDialog(null, "문서정보가 없음");
		}else {
			for(DocumentVO dVO :dVOList) {
				  content[0] = dVO.getDocNo();
				  content[1] = dVO.getTitle();
		          content[2] = dVO.getFileName();  
				  content[3] = dVO.getDept();
		            content[4] = dVO.getDocDate();
		            content[5] = dVO.getApprDesc();
		            content[6] = dVO.getEmpNo();
		            content[7] = dVO.getDocDate();
		            
		            dmm.getDtmjtabResult().addRow(content);
		}
		
	}
	
	
	
}
}
