package kr.co.sist.controller.event;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.util.DbConnection;
import kr.co.sist.view.user.DocsList;
import kr.co.sist.vo.DocumentVO;

public class DocsListDAO {
	private static DocsListDAO docslistDAO;
	private DocsList docslist;
	private DocumentVO dVO;
	
	
	public DocsListDAO() {
		
	}
	
	public static DocsListDAO getInstance() {
		if(docslistDAO == null) {
			docslistDAO=new DocsListDAO();
		}
		return docslistDAO;
	}
	
	
	public DocumentVO selectDocinfo(String docNo)throws SQLException{
		dVO=null;
		Connection con = DbConnection.getCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String SelectDoc="     select bl.DOC_NO,bl.TITLE,bl.GRP_CODE, sd.DEPT_CODE, sd.CREATE_DATE,bl.GRP_CODE2, c.CODE,c.CREATE_DATE "
					+"     from BUSSINESS_LOG, bl, SHARE_DOCS sd, COMMON c     ";
			pstmt = con.prepareStatement(SelectDoc);
			pstmt.setString(1, SelectDoc);
			rs=pstmt.executeQuery();
			
		}finally {
			DbConnection.dbClose(rs, pstmt, con);
		}
		return dVO;
	}//selectDocinfo
	
	public List<DocumentVO> selectAllDocument() throws SQLException{
		List<DocumentVO> list = new ArrayList<DocumentVO>();
		DocumentVO dVO =null;
		Connection con = DbConnection.getCon();
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		try {
			String selectAllDocument
			="select bl.DOC_NO,bl.TITLE,bl.GRP_CODE, sd.DEPT_CODE, sd.CREATE_DATE,bl.GRP_CODE2, c.CODE,c.CREATE_DATE"
			+"  	from BUSSINESS_LOG, bl, SHARE_DOCS sd, COMMON c  "
					+" where bl.DOC_NO=SD.DOC_NO";
			pstmt = con.prepareStatement(selectAllDocument);
			rs=pstmt.executeQuery();
			while(rs.next()) {//String docNo,String title,String workDes,String workLog,String appDesc, String fileName,int empNo, Date docdate
				dVO = new DocumentVO(rs.getString("DOC_NO"),
						rs.getString("TITLE"), rs.getString("WORK"),
						rs.getString("workLog"), rs.getString("apprDesc"), rs.getString("fileName"), rs.getInt("empNo"),rs.getDate("CREATE_DATE"));
				list.add(dVO);
			}
		System.out.println(list);
		}finally {
			DbConnection.dbClose(rs, pstmt, con);
		}
		
		return list;
	}
	
	
	
}
