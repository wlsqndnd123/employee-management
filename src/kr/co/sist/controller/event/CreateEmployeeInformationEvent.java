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
    private EmpInfoVO eVO;

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
            System.out.println("추가");
        } // end if
        if (ae.getSource() == ceiv.getJbtnCancel()) {
            System.out.println("취소 버튼 누름");
            ceiv.dispose();
            new CheckEmployeeInformation();
        } // end if
    }// actionPerformed

    /**
     * 입력받은 사원의 정보를 정리하고, DAO와 연결하는 method
     *
     * @param eVO
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

        }
    }

    public int convertDept(String dept) {
        int deptnum = 0;
        switch (dept) {
            case "정비본부":
                deptnum = 1;
                break;
            case "정비기획부문":
                deptnum = 2;
                break;
            case "안전정비부문":
                deptnum = 3;
                break;
            case "정비지원팀":
                deptnum = 4;
                break;
            case "정비통제팀":
                deptnum = 5;
                break;
            case "예방정비팀":
                deptnum = 6;
                break;
            case "중정비팀":
                deptnum = 7;
                break;
            case "인천운항정비팀":
                deptnum = 8;
                break;
            case "김포운항정비팀":
                deptnum = 9;
                break;
            case "부품정비팀":
                deptnum = 10;
                break;

        }

        return deptnum;
    }

    public int convertposition(String position) {
        int positionnum = 0;
        switch (position) {
            case "사원":
                positionnum = 1;
                break;
            case "대리":
                positionnum = 2;
                break;
            case "과장":
                positionnum = 3;
                break;
            case "부장":
                positionnum = 4;
                break;
            case "사장":
                positionnum = 5;
                break;
        }

        return positionnum;
    }
}// class
