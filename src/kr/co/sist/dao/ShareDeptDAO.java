package kr.co.sist.dao;

import kr.co.sist.controller.event.CreateEmployeeInformationEvent;
import kr.co.sist.util.DbConnection;
import kr.co.sist.view.admin.ShareDept;
import kr.co.sist.vo.DocumentVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShareDeptDAO {
    private static ShareDeptDAO sdDAO;

    private ShareDeptDAO() {

    }

    public static ShareDeptDAO getInstance() {
        if (sdDAO == null) {
            sdDAO = new ShareDeptDAO();
        }

        return sdDAO;

    }// getInstance

    public void shareDoc(DocumentVO dVO) throws SQLException {
        int cnt = 0;
        Connection con = null;
        PreparedStatement pstmt = null;
        try {

            con = DbConnection.getCon();
            String insertDoc =
                    "insert into SHARE_DOCS (DOC_NO,DEPT_CODE,EDIT_DATE,CREATE_EMP) values (?,?,sysdate,?)";
            pstmt = con.prepareStatement(insertDoc);
            pstmt.setString(1, dVO.getDocNo());
            CreateEmployeeInformationEvent ce = new CreateEmployeeInformationEvent();
            DocsListDAO dDAO =DocsListDAO.getInstance();
            pstmt.setInt(2, ce.convertDept(dVO.getDept()));
            pstmt.setInt(3, dDAO.selectDocinfo(dVO.getDocNo()).getEmpNo());

            pstmt.executeQuery();

        } finally {
            DbConnection.dbClose(null, pstmt, con);
        }

    }
    public List<DocumentVO> getSharedDepts(int deptno) throws SQLException {
    	List<DocumentVO> deptArr = new ArrayList<DocumentVO>();
    	DocumentVO dVO =null;
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs =null;
    	StringBuilder searchDept = new StringBuilder();
    	DocsManagementDAO dDAO = DocsManagementDAO.getInstance();
    	try {
    		con = DbConnection.getCon(); 
    		searchDept
    		.append("select d.dept_name, d.DEPT_CODE from dept d ")
    		.append(" where d.DEPT_CODE not in (select s.dept_code	from share_docs s, business_log b")
    		.append("  where s.doc_no = b.doc_no and s.doc_no = ?) and d.DEPT_CODE <> 99");	
    		pstmt = con.prepareStatement(searchDept.toString());
    		pstmt.setInt(1, deptno);
    		 rs=pstmt.executeQuery();
        	 while(rs.next()) {
        		 dVO= new DocumentVO();
        		 dVO.setDept(rs.getString("dept_name"));
        		 deptArr.add(dVO);
        	 }
    	}finally {
    		
    	}
		return deptArr;
    }
//    public List<DocumentVO> getSharedDepts(int deptno) throws SQLException {
//    	List<DocumentVO> deptArr = new ArrayList<DocumentVO>();
//    	DocumentVO dVO =null;
//    	Connection con = null;
//    	PreparedStatement pstmt = null;
//    	ResultSet rs =null;
//    	StringBuilder searchDept = new StringBuilder();
//    	String[] dept = null;
//    	try {
//    		con = DbConnection.getCon(); 
//        	 searchDept
//        	 .append("	SELECT	CASE DEPT_CODE	")
//        	 .append("	WHEN 1 THEN '정비본부'	WHEN 2 THEN '정비기획부문'	")
//        	 .append("  WHEN 3 THEN '안전정비부문'	WHEN 4 THEN '정비지원팀'	")
//        	 .append("  WHEN 5 THEN '정비통제팀'  WHEN 6 THEN '예방정비팀'	")
//        	 .append("  WHEN 7 THEN '중정비팀'	WHEN 8 THEN '인천운항정비팀'	")
//        	 .append("  WHEN 9 THEN '김포운항정비팀'	WHEN 10 THEN '부품정비팀'	")
//        	 .append("    END AS dept_name	FROM SHARE_DOCS	where DOC_NO = ?");
//       
//        	 pstmt = con.prepareStatement(searchDept.toString());
//        	 pstmt.setInt(1, deptno);
//        	 rs=pstmt.executeQuery();
//        	 while(rs.next()) {
//        		 dVO= new DocumentVO();
//        		 dVO.setDept(rs.getString("dept_name"));
//        		 deptArr.add(dVO);
//        		 dVO.toString();
//        	 }
//        	 
//         }finally {
//        	 
//         }
//		return deptArr;
//    }
    
    public List<DocumentVO> varifiyDepts(int docno) throws SQLException{
    	List<DocumentVO> list = new ArrayList<DocumentVO>();
    	DocumentVO dVO= null;
    	Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuilder selectDept = new StringBuilder();
        try {
            con = DbConnection.getCon();
            selectDept
            .append("select DEPT_NAME from  DEPT")
            .append(" where  DEPT_CODE not like( select DEPT_CODE from SHARE_DOCS ")
            .append(" where DOC_NO = ? )");
            pstmt = con.prepareStatement(selectDept.toString());
            pstmt.setInt(1, docno);
            
           rs= pstmt.executeQuery();
           while(rs.next()) {
        	   dVO = new DocumentVO();
        	   dVO.setDept(rs.getString("DEPT_NAME"));
        	   list.add(dVO);
           }
        	   
        
            
        }finally {
        	
        }
        
    	
		return list;
    	
    }

}
