package kr.co.sist.controller.event;

//import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.view.common.SubmitDocs;

public class SubmitDocsEvent extends WindowAdapter implements ActionListener, ItemListener{

	private SubmitDocs smd;
	
    public SubmitDocsEvent(SubmitDocs smd) {
    	this.smd=smd;
    }
    
    public void attachFile( String path, String name) {
//        FileDialog fd= new FileDialog(this,"첨부파일 선택" , FileDialog.LOAD);
//        fd.setVisible(false);
//        path= fd.getDirectory();
//        name=fd.getFile();
    }

    public void deleteFile() {
    
    }

    public void upload() {
    	
    }
    
    public void cancel() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	if(e.getSource() == smd.getAttAdd() ) {
//    		파일다이얼로그 띄우기
    	}
    	if(e.getSource() == smd.getAttRemove()) {
//    		파일다이얼로그 닫기
    	}
    	if(e.getSource() == smd.getBtn_regist()) {
//    		리스트에 문서등록
    	}
    	if(e.getSource() == smd.getBtn_cancel()) {
//    		
    	}
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        super.windowClosing(e);
    }

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == smd.getJcb()) {
			System.out.println(smd.getJcb().getSelectedItem().toString());
		}
		
	}



}
