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
	
	
	
	public List<DocumentVO> selectAllDocument(int empno) throws SQLException{
		List<DocumentVO> list = new ArrayList<DocumentVO>();
//		DocumentVO dVO =null;
//		Connection con = DbConnection.getCon();
//		PreparedStatement pstmt =null;
//		ResultSet rs=null;
//		try {
//			String selectAllDocument
//			="   select sd.doc_no, bl.title, c.grp_code, d.dept_name,bl.doc_date, c.code, grp_code2,sd.edit_date"
//			+"  	from bussiness_log bl, share_docs sd ,dept d, common c  "
//					+"where (bl.doc_no=sd.doc_no)and(sd.dept_code=d.dept_code)and(bl.grp_code=c.grp_code) and(bl.code=c.code)";
//			pstmt = con.prepareStatement(selectAllDocument);
//			rs=pstmt.executeQuery();
//			while(rs.next()) {//String docNo, String title, String workDesc, String workLog, String apprDesc, String fileName,
////				String dept, int empNo, Date docDate
//				dVO = new DocumentVO(rs.getString("DOC_NO"),
//						rs.getString("TITLE"), rs.getString("GRP_CODE"),
//						rs.getString("DEPT_CODE"), rs.getString("deptname"), rs.getString("GRP_CODE2"),empno,rs.getDate("DOC_DATE"));
//
//				dVO = new DocumentVO(selectAllDocument, selectAllDocument, selectAllDocument, selectAllDocument, selectAllDocument, selectAllDocument, 0, null);
//
//				list.add(dVO);
//			}
//		System.out.println(list);
//		}finally {
//			DbConnection.dbClose(rs, pstmt, con);
//		}
		
		return list;
	}//selectAllDocument
	
	public DocumentVO selectDocinfo(int empno)throws SQLException{
		dVO=null;
//		Connection con = DbConnection.getCon();
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			String SelectDoc="     select sd.doc_no, bl.title, c.grp_code, sd.dept_code,bl.doc_date, c.code, grp_code2,sd.edit_date "
//					+"     from bussiness_log bl, share_docs sd ,dept d, common c    "
//					+("where (bl.doc_no=sd.doc_no)and(sd.dept_code=d.dept_code)and(bl.grp_code=c.grp_code) and(bl.code=c.code)");
//			pstmt = con.prepareStatement(SelectDoc);
//			pstmt.setString(1, SelectDoc);
//			rs=pstmt.executeQuery();
//
//		}finally {
//			DbConnection.dbClose(rs, pstmt, con);
//		}
		return dVO;
	}//selectDocinfo
	
	
	
	
}
