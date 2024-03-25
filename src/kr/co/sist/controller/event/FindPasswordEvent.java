package kr.co.sist.controller.event;

import kr.co.sist.dao.FindPasswordDAO;
import kr.co.sist.view.common.FindPassword;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FindPasswordEvent extends WindowAdapter implements ActionListener {
    private FindPassword dialog;
    private static String empno;

    public FindPasswordEvent(FindPassword dialog) {
        this.dialog = dialog;
    }

    @Override
    public void windowClosing(WindowEvent we) {
        dialog.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == dialog.getJbCheckPw()) {
            checkPw();
        }//end if
        if (ae.getSource() == dialog.getJbExit()) {
            dialog.dispose();
        }
    }

    public void checkPw() {
        empno = dialog.getEmpNoField().getText();
        String phoneNumber = dialog.getPhoneNumber().getText();

        FindPasswordDAO fpDAO = FindPasswordDAO.getInstance();

        String savedPn = fpDAO.getPassword(empno).getTel();

        if (phoneNumber.equals(savedPn)) {
            JOptionPane.showMessageDialog(dialog, "귀하의 비밀번호는 " + fpDAO.getPassword(empno).getPassword() + "입니다.");
            dialog.dispose();
        } else {
            JOptionPane.showMessageDialog(dialog, "입력하신 정보가 올바르지 않습니다.");
        }
    }

    public static String getEmpno() {
        return empno;
    }
}
