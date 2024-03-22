package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
	
	//등록버튼 -> DB에 저장 : 문서관련t에 insert

	
	public void insertDoc(DocumentVO dVO) throws SQLException /*, ClassNotFoundException*/{
		List<DocumentVO> list= new ArrayList<DocumentVO>();
		
		Connection con= null;
		PreparedStatement pstmt=null;
//		ResultSet rs= null;
		
		try {
			con= DbConnection.getCon();
			
//			String id="super";
//			String pass="1111";
//			con=dbCon.getConnection(id,pass);
			
			StringBuilder insertDoc= new StringBuilder();
			
			insertDoc
			.append(" insert into BUSSINESS_LOG ")
			.append(" (DOC_NO, TITLE, EMP_NO, GRP_CODE, CODE, WORK_LOG, GRP_CODE2, CODE2, DOC_DATE, file_name, LOGIC)  ")
			.append(" values(?,?,?,'WORK',1,?,'APPR',1, sysdate, ? ,'N') ");
		
			pstmt=con.prepareStatement(insertDoc.toString());
			
			pstmt.setString(1, dVO.getDocNo());
			pstmt.setString(2, dVO.getTitle());
			pstmt.setInt(3, dVO.getEmpNo());
			pstmt.setString(4, dVO.getWorkLog());
			pstmt.setString(5, dVO.getFileName());
			
			pstmt.executeUpdate();
			
			
		}finally {
			DbConnection.dbClose(null, pstmt, con);
		}
		
		
	}
	
	//업무분류

	
}
