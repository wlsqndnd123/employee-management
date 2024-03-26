package kr.co.sist.controller.event;

import kr.co.sist.dao.CheckEmployeeInformationDAO;
import kr.co.sist.dao.SubmitDocsDAO;
import kr.co.sist.view.common.SubmitDocs;
import kr.co.sist.vo.DocumentVO;
import kr.co.sist.vo.EmpInfoVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class SubmitDocsEvent extends WindowAdapter implements ActionListener, ItemListener {

    private SubmitDocs smd;

    public SubmitDocsEvent(SubmitDocs smd) {
        this.smd = smd;
    }

    public void insertDoc() throws NumberFormatException, SQLException {
//		String docNo, String title, String workLog, String dept, int empNo
    	SubmitDocsDAO sbDAO = SubmitDocsDAO.getInstance();
        String title = smd.getJtfTitle().getText();
        int docNo = sbDAO.searchMaxDocNum();
        String workLog = smd.getJta().getText();
        CheckEmployeeInformationDAO ceiDAO = CheckEmployeeInformationDAO.getInstance();

        int empNo = Integer.parseInt(LoginEvent.getEmpno());
        EmpInfoVO eVO = ceiDAO.selectEmpInfo(empNo);
        String dept = eVO.getDept();
        String fileNm = smd.getJtfFileNm().getText();

        //String docNo, String title, String workLog, String dept, int empNo)
        DocumentVO dVO = new DocumentVO(null, title, workLog, dept, fileNm, empNo);
        sbDAO.insertBusinessLog(docNo,dVO);
        
    }

    public void deleteFile() {

    }

    public void upload() {

    }

    public void cancel() {

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

        if (e.getSource() == smd.getBtn_regist()) {
            try {
                insertDoc();
                JOptionPane.showMessageDialog(null, "글이 등록되었습니다.");
                smd.dispose();
            } catch (NumberFormatException | SQLException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == smd.getBtn_cancel()) {
            smd.dispose();
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == smd.getJcb() && e.getStateChange() == ItemEvent.SELECTED) {
            System.out.println(smd.getJcb().getSelectedItem());
        }
    }

}
