package kr.co.sist.controller.event;

import kr.co.sist.dao.CheckEmployeeInformationDAO;
import kr.co.sist.view.admin.AdminMenu;
import kr.co.sist.view.admin.CheckEmployeeInformation;
import kr.co.sist.view.admin.CreateEmployeeInformation;
import kr.co.sist.view.admin.UpdateEmployeeInformation;
import kr.co.sist.vo.EmpInfoVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckEmployeeInformationEvent extends WindowAdapter implements ActionListener, MouseListener, FocusListener {
    private CheckEmployeeInformation checkEmp;
    private EmpInfoVO eVO;
    DefaultTableModel model;

    public CheckEmployeeInformationEvent() {

    }

    public CheckEmployeeInformationEvent(CheckEmployeeInformation checkEmpview) {
        this.checkEmp = checkEmpview;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        checkEmp.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkEmp.getJbtnAddEmp()) {
            new CreateEmployeeInformation();
            checkEmp.dispose();

        } // end if

        if (ae.getSource() == checkEmp.getJbtnMain()) {
            new AdminMenu();
            checkEmp.dispose();

        } // end if

        if (ae.getSource() == checkEmp.getJbtnSearch()) {
            try {
                searchEmp();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } // end if

    }// actionPerformed

    private void searchEmp() throws SQLException {
        if (checkEmp.getJtInputEmpno().getText().isBlank()) {
            resetTable();
            searchEmpInfo();
        } else {
            int empno = Integer.parseInt(checkEmp.getJtInputEmpno().getText());
            resetTable();
            searchEmpInfo(empno);
        }
    }

    private void resetTable() {
        model = (DefaultTableModel) checkEmp.getJtEmpInfo().getModel();
        model.setNumRows(0);
    }

    public static void allEmployeePrint(DefaultTableModel model) {
        try {
            CheckEmployeeInformationDAO ciDAO = CheckEmployeeInformationDAO.getInstance();
            List<EmpInfoVO> list = ciDAO.selectAllEmpInfo();

            Object[] content = new Object[8];

            for (EmpInfoVO emp : list) {
                content[0] = emp.getEmpno();
                content[1] = emp.getName();
                content[2] = emp.getJob();
                content[3] = emp.getPosition();
                content[4] = emp.getDept();
                content[5] = emp.getHiredate();
                content[6] = emp.getTel();
                content[7] = emp.getModifiedDate();
                model.addRow(content);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 텍스트필드로 입력된 값(empno)로 검색된 사원정보를 출력하는 method
     *
     * @throws SQLException
     */
    public void searchEmpInfo(int empno) throws SQLException {
        CheckEmployeeInformationDAO ciDAO = CheckEmployeeInformationDAO.getInstance();
        EmpInfoVO eVO = ciDAO.selectEmpInfo(empno);

        if (eVO == null) {
            JOptionPane.showMessageDialog(null, "해당 사번을 가진 사원의 정보가 존재하지 않습니다.");
            return;
        }

        printEmpInfo(eVO);
    }

    /**
     * 부서/직급/입사년도 모두를 선택하여 검색된 사원정보를 출력하는 method (부서,직급,입사년도)모두를 선택해야 결과가 나옴
     *
     * @throws SQLException
     */
    public void searchEmpInfo() throws SQLException {
        String dept = checkEmp.getCbDept().getSelectedItem().toString();
        String position = checkEmp.getCbPosition().getSelectedItem().toString();
        int year = checkEmp.getJycHiredateYear().getYear();

        boolean isYear = dept.equals("전체") && position.equals("전체");
        boolean isDept = !dept.equals("전체") && position.equals("전체");
        boolean isPosition = dept.equals("전체") && !position.equals("전체");

        CheckEmployeeInformationDAO ciDAO = CheckEmployeeInformationDAO.getInstance();

        List<EmpInfoVO> empInfoVOList;
        checkEmp.getDtmEmpTable().setRowCount(0);

        Object[] content = new Object[8];

        if (isYear) {
            empInfoVOList = ciDAO.selectYearEmpInfo(year);
        } else if (isDept) {
            empInfoVOList = ciDAO.selectDeptEmpInfo(dept);
        } else if (isPosition) {
            empInfoVOList = ciDAO.selectPositionEmpInfo(position);
        } else {
            empInfoVOList = ciDAO.selectEmpInfo(dept, position, year);
        }

        if (empInfoVOList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "선택한 사원의 정보가 존재하지 않습니다.");
            return;
        }

        for (EmpInfoVO empInfoVO : empInfoVOList) {
            content[0] = empInfoVO.getEmpno();
            content[1] = empInfoVO.getName();
            content[2] = empInfoVO.getJob();
            content[3] = empInfoVO.getPosition();
            content[4] = empInfoVO.getDept();
            content[5] = empInfoVO.getHiredate();
            content[6] = empInfoVO.getTel();
            content[7] = empInfoVO.getModifiedDate();
            checkEmp.getDtmEmpTable().addRow(content);
        }
    }

    private void printEmpInfo(EmpInfoVO eVO) {
        Object[] content = new Object[8];
        content[0] = eVO.getEmpno();
        content[1] = eVO.getName();
        content[2] = eVO.getJob();
        content[3] = eVO.getPosition();
        content[4] = eVO.getDept();
        content[5] = eVO.getHiredate();
        content[6] = eVO.getTel();
        content[7] = eVO.getModifiedDate();

        checkEmp.getDtmEmpTable().addRow(content);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int selectedRow = checkEmp.getJtEmpInfo().getSelectedRow();

        if (me.getButton() == MouseEvent.BUTTON1) {
            int userChoice = JOptionPane.showConfirmDialog(checkEmp, "해당 사원의 정보를 수정하시겠습니까?", null, JOptionPane.OK_CANCEL_OPTION);

            if (userChoice == JOptionPane.OK_OPTION) {
                updateEmployeeInfo(selectedRow);
            }
        }
    }

    private void updateEmployeeInfo(int selectedRow) {
        int empno = (int) checkEmp.getJtEmpInfo().getValueAt(selectedRow, 0);
        try {
            CheckEmployeeInformationDAO ciDAO = CheckEmployeeInformationDAO.getInstance();
            new UpdateEmployeeInformation(ciDAO.selectEmpInfo(empno));
            checkEmp.dispose();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {
        checkEmp.getJtInputEmpno().setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}
