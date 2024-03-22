package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.controller.event.FindPasswordEvent;
import kr.co.sist.util.DbConnection;

public class FindPasswordDAO {
    private static FindPasswordDAO fpDAO;

    public static FindPasswordDAO getInstance() {
        if (fpDAO == null) {
            fpDAO = new FindPasswordDAO();
        }
        return fpDAO;
    }

    public String getPassword(String emp_no, String phoneNumber) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String password = null;

        try {
            con = DbConnection.getCon();

            // 쿼리 작성
            String query = "SELECT ei.emp_no, ei.tel, a.pass "
                    + "FROM emp_info ei, account a "
                    + "WHERE (ei.emp_no = a.emp_no) AND (ei.emp_no = ?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, emp_no);

            // 쿼리 실행
            rs = pstmt.executeQuery();

            // 결과 확인
            if (rs.next()) {
                password = rs.getString("pass");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제
            DbConnection.dbClose(rs, pstmt, con);
        }

        return password; // 찾아온 비밀번호 반환
    }
}
