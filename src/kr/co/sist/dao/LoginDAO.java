package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.util.DbConnection;

public class LoginDAO {
	private static LoginDAO loginDAO;
	
	private LoginDAO() {
	}

	public static LoginDAO getInstance() {
		if(loginDAO == null) {
			loginDAO = new LoginDAO();
		}//end if
		return loginDAO;
	}//end LoginDAO
	
	public String getLogInfo() throws SQLException{
		String authCode = "";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DbConnection.getCon();

            // 아이디와 비밀번호로 인증코드를 가져오는 쿼리 실행
            String query = "SELECT auth_code FROM user_auth WHERE emp_no = ? AND pass = ?";
            pstmt = con.prepareStatement(query);
            
            String emp_no = null;
            String password = null;
			pstmt.setString(1, emp_no);
			pstmt.setString(2, password);
			
            rs = pstmt.executeQuery();

            if (rs.next()) {
                authCode = rs.getString("auth_code");
            }
        } finally {
            DbConnection.dbClose(rs, pstmt, con);
        }

        return authCode;
    }
	
	
	
}//class
