package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.sist.util.DbConnection;

public class ConfirmDocsDAO {
	private static ConfirmDocsDAO cfDAO;

	private ConfirmDocsDAO() {

	}

	public static ConfirmDocsDAO getInstance() {
		if (cfDAO == null) {
			cfDAO = new ConfirmDocsDAO();
		}
		return cfDAO;
	}

	public int updateConfirmDoc(String docNum) throws SQLException {
		int cnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DbConnection.getCon();
			String approve = "update business_log set code2 = 2 	where doc_no = ?";

			pstmt = con.prepareStatement(approve);
			pstmt.setString(1, docNum);

			pstmt.executeUpdate();

		} finally {
			DbConnection.dbClose(null, pstmt, con);

		}

		return cnt;

	}
}
