package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.UpdatePasswordVO;

public class UpdatePasswordDAO {

	private static UpdatePasswordDAO updatePasswordDAO;
	
	private UpdatePasswordDAO() {
	}
	
	public static UpdatePasswordDAO getInstance() {
		if(updatePasswordDAO ==null ) {
			updatePasswordDAO = new UpdatePasswordDAO();
		}
		return updatePasswordDAO;
	}
	
	/**
	 * ********************수정 필요***********************
	 * @return
	 * @throws SQLException
	 */
	public String getPassword() throws SQLException {
		
		String password = "";
		
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			con = DbConnection.getCon();
			
			String nowPass = " select pass from ACCOUNT where emp_no = 240003 "; 
			
			psmt = con.prepareStatement(nowPass);
			rs = psmt.executeQuery();
			
//			UpdatePasswordVO upVO=null;
			while(rs.next()) {
				password=rs.getString("pass");
			}
		}finally {
			DbConnection.dbClose(rs, psmt, con);
		}
		
		return password; 
		
	}
	
	public static void main(String ...args) {
		UpdatePasswordDAO updao = new UpdatePasswordDAO();
		try {
			updao.getPassword();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
