package kr.co.sist.dao;

import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.DocumentVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocsListDAO {
    private static DocsListDAO docslistDAO;


    public DocsListDAO() {

    }

    public static DocsListDAO getInstance() {
        if (docslistDAO == null) {
            docslistDAO = new DocsListDAO();
        }
        return docslistDAO;
    }

  
    public int searchDept(String dept) {
    	int dept_code =0;
    	
    	
    	
    	return dept_code;
    	
    }
    public List<DocumentVO> selectAllDocument() throws SQLException {
        List<DocumentVO> list = new ArrayList<DocumentVO>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DbConnection.getCon();
            String selectAllDocument = "	select   doc_no,bl.title, d.dept_name, bl.doc_date, bl.code2, bl.edit_date"
                    + "	from   dept d,emp_info ei, business_log bl	"
                    + "	where (d.dept_code = ei.dept_code)and (ei.emp_no = bl.emp_no) and bl.logic ='N'	";


            pstmt = con.prepareStatement(selectAllDocument);
            rs = pstmt.executeQuery();

            //String docNo, String title, int code2, String dept, Date docDate, Date modifiedDate
            while (rs.next()) {
                DocumentVO dVO = new DocumentVO();
                dVO.setDocNo(rs.getString("doc_no"));
                dVO.setTitle(rs.getString("title"));
                dVO.setDept(rs.getString("dept_name"));
                dVO.setDocDate(rs.getDate("doc_date"));
                dVO.setCode2(rs.getInt("code2"));
                dVO.setModifiedDate(rs.getDate("edit_date"));

                list.add(dVO);
            }


        } finally {
            DbConnection.dbClose(rs, pstmt, con);
        }
        return list;
    }//selectAllDocument


    public List<DocumentVO> selectMyDocinfo(String empno) throws SQLException {
        List<DocumentVO> list = new ArrayList<DocumentVO>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DbConnection.getCon();
            String selectAllDocument = "	SELECT DISTINCT  bl.doc_no, bl.title, d.dept_name, bl.doc_date,bl.grp_code,bl.code2, bl.edit_date"
                    + "	FROM 	dept d, emp_info ei, business_log bl	"
                    + "	LEFT JOIN share_docs sd ON bl.doc_no = sd.doc_no	"
                    + "	WHERE (d.dept_code = ei.dept_code) AND (ei.emp_no = bl.emp_no) AND (ei.emp_no = ?) and bl.logic ='N' "
                    + "	order by  DOC_NO desc	";


            pstmt = con.prepareStatement(selectAllDocument);
            pstmt.setString(1, empno);
            rs = pstmt.executeQuery();


            while (rs.next()) {
                DocumentVO dVO = new DocumentVO();
                dVO.setDocNo(rs.getString("doc_no"));
                dVO.setTitle(rs.getString("title"));
                dVO.setDept(rs.getString("dept_name"));
                dVO.setDocDate(rs.getDate("doc_date"));
                dVO.setApprDesc(rs.getString("grp_code"));
                dVO.setCode2(rs.getInt("code2"));
                dVO.setDocDate(rs.getDate("edit_date"));
                list.add(dVO);

            }
        } finally {
            DbConnection.dbClose(rs, pstmt, con);
        }
        return list;
    }

    public DocumentVO selectDocinfo(String doc_no) throws SQLException {
        DocumentVO dVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DbConnection.getCon();

            String selectAllDocument = "select	bl.doc_no, bl.title, d.dept_name, bl.doc_date,bl.WORK_LOG,bl.edit_date , ei. name, ei.emp_no, bl.code2  "
                    + "	FROM 	dept d, emp_info ei, business_log bl	"
                    + "	WHERE (d.dept_code = ei.dept_code) AND (ei.emp_no = bl.emp_no) AND (bl.doc_no =? )	";


            pstmt = con.prepareStatement(selectAllDocument);
            pstmt.setString(1, doc_no);
            rs = pstmt.executeQuery();


            while (rs.next()) {
//String docNo, String title, String workLog, String dept, Date docDate, Date modifiedDate
                dVO = new DocumentVO();
                dVO.setDocNo(rs.getString("Doc_no")); 
                dVO.setName(rs.getString("name"));
                dVO.setTitle(rs.getString("title"));
                dVO.setWorkLog(rs.getString("WORK_LOG"));
                dVO.setDept(rs.getString("dept_name"));
                dVO.setDocDate(rs.getDate("doc_date"));
                dVO.setModifiedDate(rs.getDate("edit_date"));
                dVO.setEmpNo(rs.getInt("emp_no"));
                dVO.setCode2(rs.getInt("code2"));
                

//                        rs.getDate("edit_date"), rs.getInt("emp_no"));

            }
        } finally {
            DbConnection.dbClose(rs, pstmt, con);
        }
        return dVO;
    }


    public String selectRejectDetail(String doc_no) throws SQLException {
        String rejectDetail = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String selectrejectDetail = null;
        try {
            con = DbConnection.getCon();
            selectrejectDetail = "select reason "
                    + "		from REJECT"
                    + "		where doc_no = ?";

            pstmt = con.prepareStatement(selectrejectDetail);
            pstmt.setString(1, doc_no);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                rejectDetail = rs.getString("reason");
            }
        } finally {
            DbConnection.dbClose(null, pstmt, con);
        }
        return rejectDetail;
    }

}
