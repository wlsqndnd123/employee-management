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
		String selectVOInfo = null;
		try {
			con = DbConnection.getCon();
			
			selectVOInfo = "select bl.doc_no, bl.emp_no, bl.title, bl.create_date,  d.dept_name,  bl.code2 ,ei.name, vc.assign_count ,vc.use_count"
					+	"		from   BUSSINESS_LOG bl , EMP_INFO ei , DEPT d, vacation_count vc"
					+	"		where  (ei.emp_no = bl.emp_no) and (bl.code = 5) and (d.dept_code = ei.dept_code) and (ei.emp_no = vc.emp_no )";
			
			
			
			
			pstmt=con.prepareStatement(selectVOInfo);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				vVO = new VacationVO(rs.getInt("emp_no"), rs.getInt("assign_count"), rs.getInt("use_count"),rs.getInt("code2"), rs.getString("doc_no"), null,
						null, rs.getString("name"), null,
						null, null,rs.getString("title"),rs.getString("dept_name") ,null, null, rs.getDate("create_date"));
				
				
				list.add(vVO);
			}
		
		}finally {
		DbConnection.dbClose(null, pstmt, con);
		
			}
		return list;
	}
	
	
	public String selectRejetDetail(String doc_no) throws SQLException {
		String rejetDetail = null;
		vVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String selectrejetDetail = null;
		try {
			con = DbConnection.getCon();
			selectrejetDetail = "select reason "
					+	"		from REJECT"
					+	"		where doc_no = ?" ;
			
			pstmt=con.prepareStatement(selectrejetDetail);
			pstmt.setString(1, doc_no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rejetDetail = rs.getString("reason");
			}

		}finally {
		DbConnection.dbClose(null, pstmt, con);
		
			}
		return rejetDetail;
	}
	
	
	public int approveVS(int docNum) throws SQLException {
		int cnt=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DbConnection.getCon();
			String approve = "update bussiness_log set code2 = 2 where doc_no = ?" ;
			
			pstmt=con.prepareStatement(approve);
			pstmt.setInt(1, docNum);
			pstmt.executeUpdate();
			
			

		}finally {
		DbConnection.dbClose(null, pstmt, con);

			}
	
		return cnt;
	}
	
	
	
	
	
	
	public List<VacationVO> selectedDoc_numInfo(String doc_num)  throws SQLException {

		List<VacationVO> list = new ArrayList<VacationVO>();
		vVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectedDoc_numInfo = null;
		try {
			con = DbConnection.getCon();
			
			selectedDoc_numInfo = "select bl.doc_no, bl.emp_no, bl.title, bl.create_date,  d.dept_name,  bl.code2 ,ei.name, vc.assign_count ,vc.use_count"
					+	"		from   BUSSINESS_LOG bl , EMP_INFO ei , DEPT d, vacation_count vc"
					+	"		where  (ei.emp_no = bl.emp_no) and (bl.code = 5) and (d.dept_code = ei.dept_code) and (ei.emp_no = vc.emp_no ) and (bl.doc_no = ?)";
			
			pstmt=con.prepareStatement(selectedDoc_numInfo);
			pstmt.setString(1, doc_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vVO = new VacationVO(rs.getInt("emp_no"), rs.getInt("assign_count"), rs.getInt("use_count"),rs.getInt("code2"), rs.getString("doc_no"), null,
						null, rs.getString("name"), null,null, null,rs.getString("title"),rs.getString("dept_name") ,null, null, rs.getDate("create_date"));

				list.add(vVO);
			}
			
		
		}finally {
		DbConnection.dbClose(null, pstmt, con);
		
			}
		
		
		return list;
		
		
	}
	

	
	public void returnVS() {
		
	}
	
	public void InsertReturnReason () {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}