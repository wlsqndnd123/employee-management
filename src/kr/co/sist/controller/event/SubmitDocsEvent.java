package kr.co.sist.controller.event;

import kr.co.sist.dao.CheckEmployeeInformationDAO;
import kr.co.sist.dao.SubmitDocsDAO;
import kr.co.sist.view.common.SubmitDocs;
import kr.co.sist.view.user.DocsList;
import kr.co.sist.vo.DocumentVO;
import kr.co.sist.vo.EmpInfoVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class SubmitDocsEvent extends WindowAdapter implements ActionListener,FocusListener{

    private SubmitDocs smd;
    private int code;

    public SubmitDocsEvent(SubmitDocs smd) {
        this.smd = smd;
    }

    public void insertDoc() throws NumberFormatException, SQLException {
        SubmitDocsDAO sbDAO = SubmitDocsDAO.getInstance();
        String title = smd.getJtfTitle().getText();
        int docNo = sbDAO.searchMaxDocNum();
        String workLog = smd.getJta().getText();
        CheckEmployeeInformationDAO ceiDAO = CheckEmployeeInformationDAO.getInstance();
        int empNo = Integer.parseInt(LoginEvent.getEmpno());
        EmpInfoVO eVO = ceiDAO.selectEmpInfo(empNo);
        String dept = eVO.getDept();
        String fileNm = smd.getJtfFileNm().getText();
        DocumentVO dVO = new DocumentVO(null, title, workLog, fileNm, dept, empNo, code);

        sbDAO.insertBusinessLog(docNo,dVO);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == smd.getAttAdd()) {
            FileDialog fileDialog = new FileDialog(smd, "파일 선택", FileDialog.LOAD);
            fileDialog.setVisible(true);

            String selectedFile = fileDialog.getFile();

            if (selectedFile != null) {
                smd.getJtfFileNm().setText(selectedFile);
            }
        }

        if (e.getSource() == smd.getAttRemove()) {
            smd.getJtfFileNm().setText("");
        }
        if(e.getSource() == smd.getJcb()){
            String workDesc = smd.getJcb().getSelectedItem().toString();
            try {
                code = SubmitDocsDAO.getInstance().translateCode(workDesc);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }


        if (e.getSource() == smd.getBtn_regist()) {
            try {
            	if(!smd.getJta().getText().isBlank()) {
                insertDoc();
                JOptionPane.showMessageDialog(smd, "글이 등록되었습니다.");
                smd.dispose();
                new DocsList();
            	}else {
            		JOptionPane.showMessageDialog(smd, "내용을 입력해주세요.");
            		return;
            	}
            } catch (NumberFormatException | SQLException e1) {
                JOptionPane.showMessageDialog(smd, "오늘의 일일업무보고가 이미 등록되었습니다.");
            }
            
        }
            
        if (e.getSource() == smd.getBtn_cancel()) {
            smd.dispose();
            new DocsList();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource() == smd.getJtfTitle() && smd.getJtfTitle().getText().equals("제목을 입력하세요")){
            smd.getJtfTitle().setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        smd.dispose();
    }

}
