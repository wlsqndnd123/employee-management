package kr.co.sist.service;

import kr.co.sist.dao.AdminMenuDAO;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Desc : 관리자에게 업무 알람 관련한 내용을 DAO를 통해 처리하게 하는 클래스<br>
 * 작성자 : 고한별<br>
 * 작성일 : 2024.03.15
 */
public class RunAdminMenuDAO {
    public String loadWorkAlert(boolean isVacation) {
        String msg="";
        try {
            AdminMenuDAO adminMenuDAO = AdminMenuDAO.getInstance();
            int cnt = adminMenuDAO.alertWork(isVacation);
            if (isVacation) {
                msg = "대기중인 휴가신청 ";
            } else {
                msg = "승인 대기 중인 업무 ";
            }
            msg += cnt + " 건 조회";
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return msg;
    }

    public static void main(String[] args) {
        RunAdminMenuDAO runAdminMenuDAO = new RunAdminMenuDAO();
        String msg = runAdminMenuDAO.loadWorkAlert(true);
        System.out.println(msg);
        msg = runAdminMenuDAO.loadWorkAlert(false);
        System.out.println(msg);
    }
}
