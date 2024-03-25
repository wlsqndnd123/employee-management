package kr.co.sist.controller.event;

import kr.co.sist.dao.CreateEmployeeInformationDAO;
import kr.co.sist.view.admin.CheckEmployeeInformation;
import kr.co.sist.view.admin.CreateEmployeeInformation;
import kr.co.sist.vo.EmpInfoVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class CreateEmployeeInformationEvent extends WindowAdapter implements ActionListener {
    private CreateEmployeeInformation ceiv;

    public CreateEmployeeInformationEvent() {
    }// CreateEmployeeInformationEvent

    public CreateEmployeeInformationEvent(CreateEmployeeInformation ceiv) {
        this.ceiv = ceiv;
    }// CreateEmployeeInformationEvent

    @Override
    public void windowClosing(WindowEvent e) {
        ceiv.dispose();
    }// windowClosing

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ceiv.getJbtnAdd()) {
            addEmp();
            new CheckEmployeeInformation();
        } // end if
        if (ae.getSource() == ceiv.getJbtnCancel()) {
            ceiv.dispose();
            new CheckEmployeeInformation();
        } // end if
    }// actionPerformed

    /**
     * 입력받은 사원의 정보를 정리하고, DAO와 연결하는 method
     */
    public void addEmp() {
        String name = ceiv.getTfName().getText().trim();
        String job = ceiv.getTfJob().getText().trim();
        String position = ceiv.getTfPosition().getText().trim();
        String tel = ceiv.getTfTel().getText().trim();
        String dept = ceiv.getTfDep().getText().trim();

        try {
            CreateEmployeeInformationDAO ceDAO = CreateEmployeeInformationDAO.getInstance();
            int empno = ceDAO.selectMaxEmpnum();
            EmpInfoVO eVO = new EmpInfoVO(0, name, job, position, dept, null, tel, null);
            ceDAO.insertEmpInfo(empno,eVO);
            ceDAO.insertAccountEmp(empno);
            ceDAO.insertUserAuthEmp(empno);
            JOptionPane.showMessageDialog(ceiv, "사원 번호 " + empno + " 번, " + name + "님이 등록되었습니다.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int convertDept(String dept) {
        return switch (dept) {
            case "정비본부" -> 1;
            case "정비기획부문" -> 2;
            case "안전정비부문" -> 3;
            case "정비지원팀" -> 4;
            case "정비통제팀" -> 5;
            case "예방정비팀" -> 6;
            case "중정비팀" -> 7;
            case "인천운항정비팀" -> 8;
            case "김포운항정비팀" -> 9;
            case "부품정비팀" -> 10;
            default -> 0;
        };
    }

    public int convertposition(String position) {
        return switch (position) {
            case "사원" -> 1;
            case "대리" -> 2;
            case "과장" -> 3;
            case "부장" -> 4;
            case "사장" -> 5;
            default -> 0;
        };
    }
}// class
