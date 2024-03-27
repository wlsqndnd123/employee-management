package kr.co.sist.service;

import kr.co.sist.dao.AdminMenuDAO;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Desc : 관리자에게 업무 알람 관련한 내용을 DAO를 통해 처리하게 하는 클래스<br>
 * 작성자 : 고한별<br>
 * 작성일 : 2024.03.15<br>
 * 수정자 : 고한별<br>
 * 수정일 : 2024.03.28
 */
public class RunAdminMenuDAO {
    public String loadWorkAlert(boolean isVacation) {
        String msg = "";
        try {
            AdminMenuDAO adminMenuDAO = AdminMenuDAO.getInstance();
            int cnt = adminMenuDAO.alertWork(isVacation);
            if (isVacation) {
                msg = "승인 대기 중인 휴가 신청 ";
            } else {
                msg = "승인 대기 중인 업무 일지 ";
            }
            msg += cnt + " 건 조회";
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"데이터베이스 오류");
        }
        return msg;
    }
}
