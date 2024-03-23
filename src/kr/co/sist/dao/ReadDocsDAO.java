package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.DocumentVO;

public class ReadDocsDAO {
	
	private static ReadDocsDAO rdDAO;
	
	private ReadDocsDAO() {
		
	}
	
	public static ReadDocsDAO getInstance() {
		if(rdDAO == null) {
			rdDAO = new ReadDocsDAO();
		}
		return rdDAO;
	}
	
	public void updateDoc(DocumentVO dVO) throws SQLException{
		
		Connection con=null;
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		
		try {
			con = DbConnection.getCon();
			
			StringBuilder updateDoc= new StringBuilder();
			
			updateDoc
			.append(" update  BUSSINESS_LOG ")
			.append(" set  WORK_LOG = ? ")
			.append(" where doc_no=? ");
			
			pstmt = con.prepareStatement(updateDoc.toString());
			
			pstmt.setString(1, dVO.getWorkLog());
			pstmt.setString(2, dVO.getDocNo());
			
			pstmt.executeUpdate();
		}finally {
			DbConnection.dbClose(rs, pstmt, con);
		}
	}
	public void deleteDoc(DocumentVO dVO) throws SQLException{
		
		Connection con=null;
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		
		try {
			con = DbConnection.getCon();
			
			StringBuilder updateDoc= new StringBuilder();
			
			updateDoc
			.append(" update  BUSSINESS_LOG ")
			.append(" set  logic = 'y' ")
			.append(" where doc_no=? ");
			
			pstmt = con.prepareStatement(updateDoc.toString());
			
			pstmt.setString(1, dVO.getDocNo());
			
			pstmt.executeUpdate();
		}finally {
			DbConnection.dbClose(rs, pstmt, con);
		}
	}
	

}