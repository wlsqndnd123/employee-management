package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.util.DbConnection;
import kr.co.sist.view.admin.VacationStatus;
import kr.co.sist.vo.CommuteVO;
import kr.co.sist.vo.VacationVO;

public class VacationStatusDAO {
	
	private static VacationStatusDAO vsDAO;
	private VacationStatus VacationStatus;
	private VacationVO vVO;
	
	private VacationStatusDAO() {
		
	}
	
	public static VacationStatusDAO getInstance() {
		if(vsDAO == null) {
			vsDAO = new VacationStatusDAO();
		}
		return vsDAO;
	}
	
	public List<VacationVO> selectVOinfo() throws SQLException{
		List<VacationVO> list = new ArrayList<VacationVO>();
		vVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getCon();
			String selectVOInfo = null;
			
			
			
			
			pstmt=con.prepareStatement(selectVOInfo);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
			}
		
		}finally {
		DbConnection.dbClose(null, pstmt, con);
		
			}
		return list;
	}
}