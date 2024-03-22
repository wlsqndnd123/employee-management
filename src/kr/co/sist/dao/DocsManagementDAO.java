package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.DocumentVO;

public class DocsManagementDAO {
	private static DocsManagementDAO dmmDAO;
	private DocumentVO dVO;
	
	public DocsManagementDAO() {
		
	}
	
	public static DocsManagementDAO getInstance() {
		if(dmmDAO == null) {
			dmmDAO = new DocsManagementDAO();
		}
		return dmmDAO;
	}
	
	public List<DocumentVO> searchDocument()throws SQLException{
		List<DocumentVO>list = new ArrayList<DocumentVO>();
		dVO=null;
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String searchDocument = null;
		try {
			con = DbConnection.getCon();
			
			searchDocument = "		select bl.doc_no ,bl.title, dept_name, bl.doc_date, bl.grp_code, bl.code2, bl.edit_date	"
					+ "		from dept d, emp_info ei, bussiness_log bl	"
					+ "		where (d.dept_code = ei.dept_code)and (ei.emp_no = bl.emp_no)	";
			
			
			pstmt=con.prepareStatement(searchDocument);
			
			rs =pstmt.executeQuery();
			
			
			while(rs.next()) {//String docNo, String title, String workDesc, String workLog, String apprDesc, String fileName,String dept, int empNo, Date docDate, Date modifiedDate
				DocumentVO dVO = new DocumentVO();
				dVO.setDocNo(rs.getString("doc_no"));
	            dVO.setTitle(rs.getString("title"));
	            dVO.setWorkDesc(rs.getString("dept_name"));
	            dVO.setDocDate(rs.getDate("doc_date"));
	            dVO.setApprDesc(rs.getString("grp_code"));
	            dVO.setEmpNo(rs.getInt("code2"));
	            dVO.setDocDate(rs.getDate("edit_date"));
				
			list.add(dVO);
			}
			
			
		}finally {
			DbConnection.dbClose(rs, pstmt, con);
		}
		return list;
		
	}
	
	
	
	
	
	
	
}
