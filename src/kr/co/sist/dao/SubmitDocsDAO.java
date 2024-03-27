package kr.co.sist.dao;

import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.DocumentVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubmitDocsDAO {

    private static SubmitDocsDAO smdDAO;

    private SubmitDocsDAO() {

    }

    public static SubmitDocsDAO getInstance() {
        if (smdDAO == null) {
            smdDAO = new SubmitDocsDAO();
        }
        return smdDAO;

    }

    /**
     * 비지니스 로그의 최댓값을 select하여 반환하는 매서드
     * @return docNum =현재 문서리스트중 가장 큰 수
     * @throws SQLException
     */
    public int searchMaxDocNum() throws SQLException {
    	int docNum = 0;
    	 Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs =null;
         try {
        	 con = DbConnection.getCon();
        	 
        	 String searchMaxNum =
        	"	select nvl(max(DOC_NO),240000)+1 DOC_NO from BUSINESS_LOG	";
        	 pstmt =con.prepareStatement(searchMaxNum);
        	 rs = pstmt.executeQuery();
        	 if(rs.next()) {
        		 docNum = rs.getInt("DOC_NO");
        	 }
        	 
         }finally {
        	 DbConnection.dbClose(rs, pstmt, con);
         }
    	
    	return docNum;
    }
    /**
     * 비지니스로그에 텍스트필드/텍스트에리아에서 입력받은 값으로 DB에 저장하는 매서드
     * @param docno : 문서의 최댓값
     * @param dVO : 입력받은 값들
     * @throws SQLException
     */
    public void insertBusinessLog(int docno,DocumentVO dVO) throws SQLException /*, ClassNotFoundException*/ {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DbConnection.getCon();

            StringBuilder insertDoc = new StringBuilder();

            insertDoc
                    .append(" insert into BUSINESS_LOG ")
                    .append(" (DOC_NO, TITLE, EMP_NO, GRP_CODE, CODE, WORK_LOG, GRP_CODE2, CODE2, DOC_DATE, file_name)  ")
                    .append(" values(?,?,?,'WORK',?,?,'APPR',1, sysdate, ? ) ");

            pstmt = con.prepareStatement(insertDoc.toString());

            pstmt.setInt(1,docno);
            pstmt.setString(2, dVO.getTitle());
            pstmt.setInt(3, dVO.getEmpNo());
            pstmt.setInt(4,dVO.getCode());
            pstmt.setString(5, dVO.getWorkLog());
            pstmt.setString(6, dVO.getFileName());

            pstmt.executeUpdate();

        } finally {
            DbConnection.dbClose(null, pstmt, con);
        }
    }

    public int translateCode(String description) throws SQLException{

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        int code = 0;

        try {
            con = DbConnection.getCon();

            String insertDoc = "select code from common where DESCRIPTION = ?";
            pstmt =con.prepareStatement(insertDoc);

            pstmt.setString(1,description);

            rs = pstmt.executeQuery();

            if(rs.next()) {
                code = rs.getInt("CODE");
            }

        }finally {
            DbConnection.dbClose(rs, pstmt, con);
        }

        return code;
    }




}
