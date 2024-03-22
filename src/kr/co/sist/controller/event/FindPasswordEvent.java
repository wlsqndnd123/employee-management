package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import kr.co.sist.dao.FindPasswordDAO;
import kr.co.sist.view.common.FindPassword;

public class FindPasswordEvent implements ActionListener {
    private FindPassword dialog;

    public FindPasswordEvent(FindPassword dialog) {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String emp_no = dialog.getId();
        String phoneNumber = dialog.getPhoneNumber();

        FindPasswordDAO dao = new FindPasswordDAO();
        String nowPassword = dao.getPassword(emp_no, phoneNumber);

        if (nowPassword != null) {
            JOptionPane.showMessageDialog(dialog, "귀하의 비밀번호는 " + nowPassword + "입니다.");
            dialog.dispose();
        } else {
            JOptionPane.showMessageDialog(dialog, "입력하신 정보가 올바르지 않습니다.");
        }
    }

	
}
