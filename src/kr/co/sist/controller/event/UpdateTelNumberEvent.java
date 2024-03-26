package kr.co.sist.controller.event;

import kr.co.sist.dao.CheckEmployeeInformationDAO;
import kr.co.sist.dao.LoginDAO;
import kr.co.sist.dao.UpdateTelNumberDAO;
import kr.co.sist.view.common.UpdatePassword;
import kr.co.sist.view.user.UpdateTelNumber;
import kr.co.sist.view.user.UserMenu;
import kr.co.sist.vo.EmpInfoVO;
import kr.co.sist.vo.LoginVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdateTelNumberEvent extends JFrame implements ActionListener {
    private UpdateTelNumber utn;

    public UpdateTelNumberEvent() {

    }

    public UpdateTelNumberEvent(UpdateTelNumber utn) {
        this.utn = utn;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == utn.getJbtnexcPw()) {
            new UpdatePassword
                    (new LoginVO(
                            LoginEvent.getEmpno(),
                            LoginDAO.getInstance().confirmUser
                                    (LoginEvent.getEmpno()).getPassword()
                    ));
            utn.dispose();
        }
        if (e.getSource() == utn.getGoHome()) {
            new UserMenu();
            utn.dispose();

        }
        if (e.getSource() == utn.getJbtnsave()) {
            updateTelInfo();
            JOptionPane.showMessageDialog(null, "내선번호가 변경되었습니다.");
            utn.dispose();
            new UserMenu();
        }

    }

    public void updateTelInfo() {
        int empno = Integer.parseInt(LoginEvent.getEmpno());
        String tel = utn.getInputJtTel().getText();

        try {
            EmpInfoVO eVO = new EmpInfoVO(empno, tel);
            UpdateTelNumberDAO.getInstance().updateTel(eVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public EmpInfoVO setPersonalInfo() {
        String empno = LoginEvent.getEmpno();
        EmpInfoVO eVO = null;
        try {
            eVO = CheckEmployeeInformationDAO.getInstance().selectEmpInfo(Integer.parseInt(empno));
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
        return eVO;
    }

}
