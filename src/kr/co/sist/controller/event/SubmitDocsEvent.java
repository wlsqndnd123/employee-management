package kr.co.sist.controller.event;

import java.awt.FileDialog;
//import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FilenameFilter;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import kr.co.sist.dao.CheckEmployeeInformationDAO;
import kr.co.sist.dao.SubmitDocsDAO;
import kr.co.sist.view.common.Login;
import kr.co.sist.view.common.SubmitDocs;
import kr.co.sist.vo.DocumentVO;
import kr.co.sist.vo.EmpInfoVO;

public class SubmitDocsEvent extends WindowAdapter implements ActionListener, ItemListener{

	private SubmitDocs smd;
	
    public SubmitDocsEvent(SubmitDocs smd) {
    	this.smd=smd;
    }
    

	public void insertDoc() throws NumberFormatException, SQLException {
//		String docNo, String title, String workLog, String dept, int empNo
		String title=smd.getJtfTitle().getText();
		String docNo="0000000123";
		String workLog=smd.getJta().getText();
		CheckEmployeeInformationDAO ceiDAO= CheckEmployeeInformationDAO.getInstance();
		
//		EmpInfoVO eVO= ceiDAO.selectEmpInfo(Integer.parseInt(LoginEvent.getEmpno()));
//		int empNo=Integer.parseInt(LoginEvent.getEmpno());
		int empNo=240004;
		EmpInfoVO eVO= ceiDAO.selectEmpInfo(240004);
		String dept=eVO.getDept();
		String fileNm=smd.getJtfFileNm().getText();
		
		//String docNo, String title, String workLog, String dept, int empNo)
		DocumentVO dVO= new DocumentVO(docNo, title, workLog, dept, fileNm, empNo);
		SubmitDocsDAO sbDAO= SubmitDocsDAO.getInstance();
		sbDAO.insertDoc(dVO);
    }

    public void deleteFile() {
    
    }

    public void upload() {
    	
    }
    
    public void cancel() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	if(e.getSource() == smd.getAttAdd()) {
    		 // 파일 다이얼로그 생성
            FileDialog fileDialog = new FileDialog(smd, "파일 선택", FileDialog.LOAD);
            fileDialog.setVisible(true);
            
           
            // 선택된 파일 가져오기
            String selectedFile = fileDialog.getFile();
            
            
            if(selectedFile != null) {
                // 파일이 선택되었을 경우 작업 수행
            	smd.getJtfFileNm().setText(selectedFile);
            }
//            else if(e.getSource() == smd.getAttRemove()) {
//            	
//            	smd.getJtfFileNm().setText("");
//            }
    	}
            
    	if(e.getSource() == smd.getAttRemove()) {
//            	if(smd.getJtfFileNm() == null) {
    		smd.getJtfFileNm().setText("");
    	}
        	
    	if(e.getSource() == smd.getBtn_regist()) {	
//    		리스트에 문서등록 
    		try {
				insertDoc();
				JOptionPane.showMessageDialog(null, "글이 등록되었습니다.");
				smd.dispose();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	if(e.getSource() == smd.getBtn_cancel()) {
    		smd.dispose();
    	}
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        super.windowClosing(e);
    }

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getSource() == smd.getJcb() && e.getStateChange() == ItemEvent.SELECTED) {
			System.out.println(smd.getJcb().getSelectedItem().toString());
		}
		
	}
	

}
