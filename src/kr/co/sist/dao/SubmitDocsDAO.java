package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.DocumentVO;

public class SubmitDocsDAO {
	
	private static SubmitDocsDAO smdDAO;
	
	private SubmitDocsDAO() {
		
	}
	
	public static SubmitDocsDAO getInstance() {
		if(smdDAO == null) {
			smdDAO= new SubmitDocsDAO();
		}
		return smdDAO;
		
	}
	
	

	//list에 문서등록
	public List<DocumentVO> insertDoc(String workCd, String title, String content, String fileNm) throws SQLException, ClassNotFoundException{
		List<DocumentVO> list= new ArrayList<DocumentVO>();
		DbConnection dbCon= DbConnection.getInstance();
		
		Connection con= null;
		PreparedStatement pstmt=null;
//		ResultSet rs= null;
		
		try {
			
			String id="super";
			String pass="1111";
			con=dbCon.getConnection(id,pass);
			
			StringBuilder insertDoc= new StringBuilder();
			
			insertDoc
			.append(" insert into  ");
		
			
		}finally {
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}
		
	
		return list;
		
	}

	
}
