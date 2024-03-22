package kr.co.sist.dao;

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
	
	
	
	public List<DocumentVO> selectAllDocument() throws SQLException{
		List<DocumentVO> list = new ArrayList<DocumentVO>();
		dVO= null;
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectAllDocument = null;
		try {
			con = DbConnection.getCon();
			
			selectAllDocument = "select bl.doc_no,bl.title, de.dept_name,bl.doc_date,c.grp_code,code2,bl.edit_date"
							+	"	from bussiness_log bl, dept de, common c	"
							+	"	where emp_no=?	";
			
			
			pstmt=con.prepareStatement(selectAllDocument);
			pstmt.setInt(1, 240004);
			rs =pstmt.executeQuery();
			
			
			while(rs.next()) {//String docNo, String title, String workDesc, String workLog, String apprDesc, String fileName,String dept, int empNo, Date docDate, Date modifiedDate
				DocumentVO dVO = new DocumentVO();
				dVO.setDocNo(rs.getString("doc_no"));
	            dVO.setTitle(rs.getString("title"));
	            dVO.setWorkDesc(rs.getString("dept_name"));
	            dVO.setDocDate(rs.getDate("doc_date"));
	            dVO.setApprDesc(rs.getString("grp_code"));
	            dVO.setCode2(rs.getInt("code2"));
	            dVO.setDocDate(rs.getDate("edit_date"));
				
			list.add(dVO);
			}
			
			
		}finally {
			DbConnection.dbClose(rs, pstmt, con);
		}
		return list;
	}//selectAllDocument
	
	public List<DocumentVO> selectDocinfo() throws SQLException {
	    List<DocumentVO> slList = new ArrayList<DocumentVO>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String selectAllDocument = null;
	    try {
	        con = DbConnection.getCon();
	        
	        selectAllDocument = "select bl.doc_no,bl.title, de.dept_name,bl.doc_date,c.grp_code,code2,bl.edit_date"
	                        + "	from bussiness_log bl, dept de, common c	"
	                        + "	where emp_no=?	";
	        
	        
	        pstmt = con.prepareStatement(selectAllDocument);
	        pstmt.setInt(1, 240004);
	        rs = pstmt.executeQuery();
	        
	        
	        while(rs.next()) {
	            DocumentVO dVO = new DocumentVO();
	            dVO.setDocNo(rs.getString("doc_no"));
	            dVO.setTitle(rs.getString("title"));
	            dVO.setWorkDesc(rs.getString("dept_name"));
	            dVO.setDocDate(rs.getDate("doc_date"));
	            dVO.setApprDesc(rs.getString("grp_code"));
	            dVO.setCode2(rs.getInt("code2"));
	            dVO.setDocDate(rs.getDate("edit_date"));
	            
	            slList.add(dVO);
	        }
	    } finally {
	        DbConnection.dbClose(rs, pstmt, con);
	    }
	    return slList;
	}
	
	
	
	
}
