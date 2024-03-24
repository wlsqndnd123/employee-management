package kr.co.sist.dao;

import kr.co.sist.controller.event.CreateEmployeeInformationEvent;
import kr.co.sist.util.DbConnection;
import kr.co.sist.view.admin.ShareDept;
import kr.co.sist.vo.DocumentVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
//            pstmt.setDate(4, dDAO.selectDocinfo(dVO.getDocNo()).getDocDate());

            pstmt.executeQuery();

        } finally {
            DbConnection.dbClose(null, pstmt, con);
        }

    }

}
