package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.DocumentVO;
import kr.co.sist.vo.EmpInfoVO;

public class DocsManagementDAO {
	private static DocsManagementDAO dmmDAO;
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
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String searchDocument = null;
		try {
			con = DbConnection.getCon();
			
			searchDocument = "		select bl.doc_no ,bl.title, c.description, d.dept_name, bl.doc_date, bl.grp_code, bl.code2, bl.edit_date	"
					+ "			from dept d, emp_info ei, bussiness_log bl, common c	"
					+ "			where (d.dept_code = ei.dept_code)and (ei.emp_no = bl.emp_no)and (bl.grp_code = c.grp_code) and (c.code = bl.code)	";
			
			
			pstmt=con.prepareStatement(searchDocument);
			
			rs =pstmt.executeQuery();
			
			
			while(rs.next()) {//String docNo, String title, String workDesc, String workLog, String apprDesc, String fileName,String dept, int empNo, Date docDate, Date modifiedDate
				DocumentVO dVO = new DocumentVO();
				dVO.setDocNo(rs.getString("doc_no"));
	            dVO.setTitle(rs.getString("title"));
	            dVO.setFileName(rs.getString("description"));
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
	
	public List<DocumentVO> selectDocInfo(String dept, String fileType, String appr) {
	    List<DocumentVO> dlist = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	        con = DbConnection.getCon();
	        
	        String selectDoc = "select bl.doc_no ,bl.title, c.description, d.dept_name, bl.doc_date, bl.grp_code, bl.code2, bl.edit_date "
	                + "from dept d, emp_info ei, bussiness_log bl, common c "
	                + "where (d.dept_code = ei.dept_code) and (ei.emp_no = bl.emp_no) and (bl.grp_code = c.grp_code) and (c.code = bl.code) "
	                + "and (d.dept_name = ?) and (c.description = ?) and (bl.code2 = ?)";
	        
	        pstmt = con.prepareStatement(selectDoc);
	        pstmt.setString(1, dept);
	        pstmt.setString(2, fileType);
	        pstmt.setString(3, appr);
	        rs = pstmt.executeQuery();
	        
	        while(rs.next()) {
	            DocumentVO dVO = new DocumentVO();
	            dVO.setDocNo(rs.getString("doc_no"));
	            dVO.setTitle(rs.getString("title"));
	            dVO.setFileName(rs.getString("description"));
	            dVO.setWorkDesc(rs.getString("dept_name"));
	            dVO.setDocDate(rs.getDate("doc_date"));
	            dVO.setApprDesc(rs.getString("grp_code"));
	            dVO.setEmpNo(rs.getInt("code2"));
	            dVO.setDocDate(rs.getDate("edit_date"));
	            dlist.add(dVO);
	        }
	    } catch (SQLException e) {
	        // 예외 처리
	    } finally {
	        DbConnection.dbClose(rs, pstmt, con);
	    }
	    return dlist;
	}
	public List<DocumentVO> selectInfo(String col) throws SQLException {
		List<DocumentVO> list = new ArrayList<DocumentVO>();
		DocumentVO dVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getCon();
			if (col.equals("CODE2")) {//승인상태

				String selectCODE2 = "	select CODE2 from BUSSINESS_LOG ";
				pstmt = con.prepareStatement(selectCODE2);
			}else if (col.equals("CODE"))  {//문서종류

				String selectCODE = "	select CODE from BUSSINESS_LOG ";
				pstmt = con.prepareStatement(selectCODE);
			} else {//신청부서

				String selectdeptInfo = "	select DEPT_NAME from DEPT where DEPT_NAME not like '시스템관리자' ";
				pstmt = con.prepareStatement(selectdeptInfo);
			
			}

			rs = pstmt.executeQuery();

			if (col.equals("CODE2")) {
				while (rs.next()) {
					dVO = new DocumentVO(col, null, 0);
				} // end while
			} else if (col.equals("CODE")) {
				while (rs.next()) {
					dVO = new DocumentVO(null, col, 0);

				} // endwhile

			}else {
				dVO = new DocumentVO(null, null, Integer.parseInt(col));
				
			}
		} finally {
			DbConnection.dbClose(rs, pstmt, con);

		} // end finally

		return list;

	}
	
	
	
}
