package kr.co.sist.dao;

import kr.co.sist.controller.event.LoginEvent;
import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.LoginVO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Desc : Login 기능에 필요한 DB 쿼리
 * 작성자 : 김도원
 * 작성일 : 2024.03.20
 */
public class LoginDAO {
    private String emp_no, password;
    private static LoginEvent loginEvent;
    private static LoginDAO lDAO;

    public static LoginDAO getInstance() {
        if (lDAO == null) {
            lDAO = new LoginDAO();
        }//end if
        return lDAO;
    }//end LoginDAO

    /**
     * 사번과 비번을 입력받은 정보로 저장
     */

    public class Validation {
        /**
         * Desc. : 인자로 넘어온 str에 값이 없으면 true return
         *
         * @param str
         * @return
         */
        public boolean isEmpty(String str) {
            return str == null || str.isEmpty();
        }
    }//Validation


    /**
     * 유효성 검사 1)
     * 사번, 비번이 모두 입력되었는지 확인
     */
    public void checkEmpty() {
        Validation validator = new Validation();

        boolean idEmpty = validator.isEmpty(emp_no);
        boolean passwordEmpty = validator.isEmpty(password);

        if (idEmpty || passwordEmpty) {
            JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 모두 입력해주세요.");
        }
    }


    public LoginVO confirmUser(String emp_no) {
        LoginVO lVO = null;


        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DbConnection.getCon();


            String query = "	select a.emp_no, a.pass, ua.auth_code "
                    + "	from  account a, USER_AUTH ua "
                    + "	where    (a.emp_no= ua.emp_no) AND (a.emp_no = ?) and a.logic ='N'";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, emp_no);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                lVO = new LoginVO(rs.getString("emp_no"),
                        rs.getString("pass"),
                        rs.getString("auth_code"));
                // 다른 필드도 필요하다면 추가로 설정
            }
//            if(lVO != null) {
//            }
//            JOptionPane.showMessageDialog(null, "아이디, 비밀번호를 모두 입력해 주세요.");
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DbConnection.dbClose(rs, pstmt, con);
        }
        return lVO;

    }//confirmUser

    public static void main(String[] args) {
    }
}


