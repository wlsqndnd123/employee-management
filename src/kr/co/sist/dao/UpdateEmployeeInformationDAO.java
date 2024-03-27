package kr.co.sist.dao;

import kr.co.sist.controller.event.CreateEmployeeInformationEvent;
import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.EmpInfoVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpdateEmployeeInformationDAO {
    private static UpdateEmployeeInformationDAO upEmpDAO;

    private UpdateEmployeeInformationDAO() {

    }// UpdateEmployeeInformationDAO

    public static UpdateEmployeeInformationDAO getInstance() {
        if (upEmpDAO == null) {
            upEmpDAO = new UpdateEmployeeInformationDAO();
        } // end if

        return upEmpDAO;
    }// getInstance

    /**
     * 텍스트필드로 입력받은 사원의 정보로 DB내의 사원의 정보를 변경하는 매서드.
     *
     * @param eVO
     * @return 작성자: 김일신
     * 24.03.18
     * @throws SQLException
     */
    public int updateEmpInfo(EmpInfoVO eVO) throws SQLException {

        int cnt = 0;

        Connection con = DbConnection.getCon();
        PreparedStatement pstmt = null;
        try {

            String updateEmpInfo =
                    "	update EMP_INFO	"
                            + "	set    CODE = ? ,DEPT_CODE = ? , JOB = ? ,EDIT_DATE =sysdate	"
                            + "	where emp_no =    ? ";

            pstmt = con.prepareStatement(updateEmpInfo);
            CreateEmployeeInformationDAO cDAO= CreateEmployeeInformationDAO.getInstance(); 
            pstmt.setInt(1, cDAO.convertPos(eVO.getPosition()));
            pstmt.setInt(2, cDAO.convertDept(eVO.getDept()));
            pstmt.setString(3, eVO.getJob());
            pstmt.setInt(4, eVO.getEmpno());

            cnt = pstmt.executeUpdate();
        } finally {
            DbConnection.dbClose(null, pstmt, con);
        }

        return cnt;

    }// updateEmpInfo

    /**
     * 선택된 사원의 사원번호로 emp_info 테이블 내
     * 해당 사원의 논리삭제 상태를 변경하는 매서드
     *
     * @param empno
     * @return 작성자: 김일신
     * @throws SQLException
     */
    public int deleteEmpInfo(int empno) throws SQLException {
        int cnt = 0;
        Connection con = DbConnection.getCon();
        PreparedStatement pstmt = null;
        StringBuilder deleteEmp = new StringBuilder();
        try {
            deleteEmp.append("	update EMP_INFO	")
            .append("	set    logic =	'Y'	, EDIT_DATE =sysdate	")
            .append("	where emp_no = ? ");
              
            pstmt = con.prepareStatement(deleteEmp.toString());
            pstmt.setInt(1, empno);
            cnt = pstmt.executeUpdate();


        } finally {
            DbConnection.dbClose(null, pstmt, con);
            ;
        }
        return cnt;
    }
    /**
     * 선택된 사원의 사원번호로 Account 테이블 내
     * 해당 사원의 논리삭제 상태를 변경하는 매서드
     * @param empno
     * @return
     * @throws SQLException
     */
    public int deleteAccountEMP(int empno) throws SQLException {
    	int cnt = 0;
    	Connection con = DbConnection.getCon();
    	PreparedStatement pstmt = null;
    	StringBuilder deleteEmp = new StringBuilder();
    	try {
    		deleteEmp.append("	update account	")
    		.append("	set    logic =	'Y'	, EDIT_DATE =sysdate	")
    		.append("	where emp_no = ? ");
    		
    		pstmt = con.prepareStatement(deleteEmp.toString());
    		pstmt.setInt(1, empno);
    		cnt = pstmt.executeUpdate();
    		
    		
    	} finally {
    		DbConnection.dbClose(null, pstmt, con);
    		;
    	}
    	return cnt;
    }
    	/**
    	 * 선택된 사원의 사원번호로 User_auth 테이블 내
    	 * 해당 사원의 논리삭제 상태를 변경하는 매서드
    	 * @param empno
    	 * @return
    	 * @throws SQLException
    	 */
    	public int deleteUserAuthEmp(int empno) throws SQLException {
    		int cnt = 0;
    		Connection con = DbConnection.getCon();
    		PreparedStatement pstmt = null;
    		StringBuilder deleteEmp = new StringBuilder();
    		try {
    			deleteEmp.append("	update User_auth	")
    			.append("	set    logic =	'Y'	, EDIT_DATE =sysdate	")
    			.append("	where emp_no = ? ");
    			
    			pstmt = con.prepareStatement(deleteEmp.toString());
    			pstmt.setInt(1, empno);
    			cnt = pstmt.executeUpdate();
    			
    			
    		} finally {
    			DbConnection.dbClose(null, pstmt, con);
    			;
    		}
    		return cnt;
    }
    	
}