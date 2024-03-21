package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.EmpInfoVO;

public class UpdateTelNumberDAO {
	private static UpdateTelNumberDAO utnDAO;
	private EmpInfoVO eVO;
	private UpdateTelNumberDAO() {
		
	}
	
	public static UpdateTelNumberDAO getInstance() {
		if(utnDAO ==null) {
			utnDAO = new UpdateTelNumberDAO();
		}
		return utnDAO;
	}
	
	public int updateTel () throws SQLException {
		int cnt =0;
		StringBuilder sb = new StringBuilder();
		Connection con =DbConnection.getCon();
		PreparedStatement pstmt = null;
		try {
		sb.append("	update    EMP_INFO	")
		.append("	set      tel = ? , EDIT_DATE =sysdate	")
		.append("	where emp_no = ?	");
		
		pstmt= con.prepareStatement(sb.toString());
		pstmt.setString(1, eVO.getTel());
		pstmt.setInt(2, eVO.getEmpno());
		
		cnt =pstmt.executeUpdate();
		
		}finally {
			DbConnection.dbClose(null, pstmt, con);
		}
		
		 
		return cnt;
	}
	public int updateTel (EmpInfoVO eVO) throws SQLException {
		
		int cnt =0;
		Connection con =DbConnection.getCon();
		PreparedStatement pstmt = null;
		
		try {
			
			String str =
			"	update    EMP_INFO	"
			+ "		set     tel = 	? , EDIT_DATE =sysdate	"
			+ "		where emp_no = 	? 	";
			
			pstmt= con.prepareStatement(str);
			pstmt.setString(1, eVO.getTel());
			pstmt.setInt(2, eVO.getEmpno());
			
			cnt =pstmt.executeUpdate();
			System.out.println("12131");
		}finally {
			DbConnection.dbClose(null, pstmt, con);
		}
		
		return cnt;
	}
}
