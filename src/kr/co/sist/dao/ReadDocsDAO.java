package kr.co.sist.dao;

import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.DocumentVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadDocsDAO {

    private static ReadDocsDAO rdDAO;

    private ReadDocsDAO() {

    }

    public static ReadDocsDAO getInstance() {
        if (rdDAO == null) {
            rdDAO = new ReadDocsDAO();
        }
        return rdDAO;
    }

    public void updateDoc(DocumentVO dVO) throws SQLException {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DbConnection.getCon();

            StringBuilder updateDoc = new StringBuilder();

            updateDoc
                    .append(" update  BUSINESS_LOG ")
                    .append(" set edit_emp = ?, edit_date = sysdate, WORK_LOG = ? ")
                    .append(" where doc_no=? ");

            pstmt = con.prepareStatement(updateDoc.toString());

            pstmt.setInt(1, dVO.getEmpNo());
            pstmt.setString(2, dVO.getWorkLog());
            pstmt.setString(3, dVO.getDocNo());

            pstmt.executeUpdate();
        } finally {
            DbConnection.dbClose(null, pstmt, con);
        }
    }

    public void deleteDoc(int docnum) throws SQLException {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DbConnection.getCon();

            StringBuilder updateDoc = new StringBuilder();

            updateDoc
                    .append(" update  BUSINESS_LOG ")
                    .append(" set  logic = 'y' ")
                    .append(" where doc_no=? ");

            pstmt = con.prepareStatement(updateDoc.toString());

            pstmt.setInt(1, docnum);

            pstmt.executeUpdate();
        } finally {
            DbConnection.dbClose(null, pstmt, con);
        }
    }


}