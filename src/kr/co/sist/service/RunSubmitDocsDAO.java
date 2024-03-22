package kr.co.sist.service;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import kr.co.sist.vo.DocumentVO;

public class RunSubmitDocsDAO {
	public void addDoc() {
		//제목과 내용
		String inputData= JOptionPane.showInputDialog("업무분류를 선택해주세요.");
		String[] inputData=
		if(inputData == null) {
			JOptionPane.showMessageDialog(null, "내용을 입력해주세요");
		}
		return;
		
	}//addDoc
	
	try {
		DocumentVO dcVO= new DocumentVO();
		
		
	}
}
