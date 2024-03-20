package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.sist.controller.event.CreateEmployeeInformationEvent;
import kr.co.sist.util.DbConnection;
import kr.co.sist.view.admin.ShareDept;
import kr.co.sist.vo.DocumentVO;

public class ShareDeptDAO {
	private static ShareDeptDAO sdDAO;
	private ShareDept sd;
	private DocumentVO dVO;

	private ShareDeptDAO() {

	}

	public static ShareDeptDAO getInstance() {
		if (sdDAO == null) {
			sdDAO = new ShareDeptDAO();
		}

		return sdDAO;

	}// getInstance

	public int shareDoc(DocumentVO dVO) throws SQLException {
		int cnt =0;
		Connection con =null;
		PreparedStatement pstmt = null;
		try {
			
		con = DbConnection.getCon();
		String insertDoc =
		"insert into SHARE_DOCS (DOC_NO,DEPT_CODE) values (?,?)";
		pstmt =con.prepareStatement(insertDoc);
		pstmt.setString(1, dVO.getDocNo());
		CreateEmployeeInformationEvent ce = new CreateEmployeeInformationEvent();
		pstmt.setInt(2, ce.convertDept(dVO.getDept()));
		
		pstmt.executeQuery();
		
		}finally {
			DbConnection.dbClose(null, pstmt, con);
		}
		
		return cnt;
	}

}
