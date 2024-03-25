package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.LoginVO;
import kr.co.sist.vo.UpdatePasswordVO;

public class UpdatePasswordDAO {

	private static UpdatePasswordDAO updatePasswordDAO;
//	private LoginVO lVO;
	
	private UpdatePasswordDAO() {
	}
	
	public static UpdatePasswordDAO getInstance() {
		if(updatePasswordDAO ==null ) {
			updatePasswordDAO = new UpdatePasswordDAO();
		}
		return updatePasswordDAO;
	}
	
	/**
	 * 텍스트필드로 입력받은 사원의 비번으로 db내 정보를 변경하는 메서드
	 * 
	 * @param lVO
	 * @return
	 * @throws SQLException
	 */
	public int updatePassword(LoginVO lVO) throws SQLException {
		int cnt=0;
		
		Connection con = DbConnection.getCon();
		PreparedStatement psmt = null;
		
		try {
			
			String str =
					"	update    account	"
							+ "		set     pass = 	?	"
							+ "		where emp_no = 	? 	";
			
			psmt=con.prepareStatement(str);
			psmt.setString(1, lVO.getPassword());
			psmt.setString(2, lVO.getEmp_no());
			
			cnt=psmt.executeUpdate();
		}finally {
			DbConnection.dbClose(null, psmt, con);
		}
		return cnt;
		
	}
	
	
}
