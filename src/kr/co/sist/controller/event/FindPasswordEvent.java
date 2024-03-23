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
    private static String empno, tel;

    public FindPasswordEvent(FindPassword dialog) {
        this.dialog = dialog;
    }

    @Override
    public void windowClosing(WindowEvent we) {
        dialog.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //확인 클릭 시 id, tel을 저장
        if (ae.getSource() == dialog.getJbCheckPw()) {
            checkPw();
            System.out.println("확인확인확인");
        }//end if
        if (ae.getSource() == dialog.getJbExit()) {
            dialog.dispose();
        }
    }

    //입력한 전화번호가  db에 있다면 올바른 비밀번호 알려주기
    //입력한 전화번호가 db에 없다면 올바르지 않다고 알려주기

    public void checkPw() {
        empno = dialog.getEmpNoField().getText();
//		String emp_no = dialog.getEmpNoField().getText();
        String phoneNumber = dialog.getPhoneNumber().getText();

        FindPasswordDAO fpDAO = FindPasswordDAO.getInstance();

        String savedPn = fpDAO.getPassword(empno).getTel();

        if (phoneNumber.equals(savedPn)) {
            JOptionPane.showMessageDialog(dialog, "귀하의 비밀번호는 " + fpDAO.getPassword(empno).getPassword() + "입니다.");
            System.out.println("zzzzz");
            dialog.dispose();
        } else {
            JOptionPane.showMessageDialog(dialog, "입력하신 정보가 올바르지 않습니다.");
            System.out.println("ggggg");
        }
    }

    public static String getEmpno() {
        return empno;
    }
}
