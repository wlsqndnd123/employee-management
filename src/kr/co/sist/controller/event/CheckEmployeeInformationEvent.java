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

public class CheckEmployeeInformationEvent extends WindowAdapter implements ActionListener, MouseListener {
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
            searchEmp();
        } // end if

    }// actionPerformed

    private void searchEmp() {
        if (checkEmp.getJtInputEmpno().getText().isEmpty()) {
            try {
                resetTable();
                searchEmpInfo(eVO);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            int empno = Integer.parseInt(checkEmp.getJtInputEmpno().getText());
            try {
                resetTable();
                searchEmpInfo(empno);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void resetTable() {
        model = (DefaultTableModel) checkEmp.getJtEmpInfo().getModel();
        model.setNumRows(0);
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
     * @param eVO
     * @throws SQLException
     */
    public void searchEmpInfo(EmpInfoVO eVO) throws SQLException {
        this.eVO = eVO;
        String dept = checkEmp.getCbDept().getSelectedItem().toString();
        String position = checkEmp.getCbPosition().getSelectedItem().toString();
        int year = checkEmp.getJycHiredateYear().getYear();

        if (dept == null && position == null && year == 0) {
            JOptionPane.showMessageDialog(null, "부서,직급,입사년도를 모두 선택해주세요.");
            return;
        }

        CheckEmployeeInformationDAO ciDAO = CheckEmployeeInformationDAO.getInstance();
        eVO = ciDAO.selectEmpInfo(dept, position, year);

        if (eVO == null) {
            JOptionPane.showMessageDialog(null, "선택한 사원의 정보가 존재하지 않습니다.");
            return;
        }

        printEmpInfo(eVO);
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

    // 이거 아주 수정하고 싶게 생겼구만... 근데 잘 모르겠당ㅎㅎ
    @Override
    public void mouseClicked(MouseEvent me) {
        int row = checkEmp.getJtEmpInfo().getSelectedRow();

        if (me.getButton() == 1) {
            switch (JOptionPane.showConfirmDialog(checkEmp, "해당 사원의 정보를 수정하시겠습니까?", null, JOptionPane.OK_CANCEL_OPTION)) {
                case 0:
                    int empno = (int) checkEmp.getJtEmpInfo().getValueAt(row, 0);
                    try {
                        CheckEmployeeInformationDAO ciDAO = CheckEmployeeInformationDAO.getInstance();
                        new UpdateEmployeeInformation(ciDAO.selectEmpInfo(empno));
                        checkEmp.dispose();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    break;
            }
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

}
