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
	
	
//	/**
//	 * ********************수정 필요***********************
//	 * @return
//	 * @throws SQLException
//	 */
//	public String getPassword() throws SQLException {
//		
//		String password = "";
//		
//		Connection con = null;
//		PreparedStatement psmt = null;
//		ResultSet rs = null;
//		
//		try {
//			con = DbConnection.getCon();
//			
//			String nowPass = " select pass from ACCOUNT where emp_no = 240003 "; 
//			
//			psmt = con.prepareStatement(nowPass);
//			rs = psmt.executeQuery();
//			
////			UpdatePasswordVO upVO=null;
//			while(rs.next()) {
//				password=rs.getString("pass");
//			}
//		}finally {
//			DbConnection.dbClose(rs, psmt, con);
//		}
//		
//		return password; 
//		
//	}
	
	
//	public LoginVO selectLoginInfo(int empno) throws SQLException {
//		lVO =null;
//		Connection con = null;
//		PreparedStatement psmt = null;
//		ResultSet rs = null;
//		
//		try {
//			con = DbConnection.getCon();
//			String selectEmp = "	select a.emp_no, a.pass, ua.auth_code "
//            		+ "	from  account a, USER_AUTH ua "
//            		+ "	where    (a.emp_no= ua.emp_no) AND (a.emp_no = ?) ";
//			psmt = con.prepareStatement(selectEmp);
//			psmt.setInt(1, empno);
//			rs = psmt.executeQuery();
//			if(rs.next()) {
//				lVO = new LoginVO(rs.getString("emp_no"), rs.getString("pass"), rs.getString("auth_code"));
//			}
//	
//		} finally {
//			DbConnection.dbClose(rs, psmt, con);
//		}
//		return lVO;
//	}
	
	
//	public static void main(String ...args) {
//		UpdatePasswordDAO updao = new UpdatePasswordDAO();
//		try {
//			updao.getPassword();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
