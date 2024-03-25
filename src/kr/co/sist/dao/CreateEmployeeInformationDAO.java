package kr.co.sist.dao;

import kr.co.sist.controller.event.CreateEmployeeInformationEvent;
import kr.co.sist.controller.event.LoginEvent;
import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.EmpInfoVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 */
public class CreateEmployeeInformationDAO {
	static private CreateEmployeeInformationDAO ceiDAO;

	private CreateEmployeeInformationDAO() {

	}

	public static CreateEmployeeInformationDAO getInstance() {
		if (ceiDAO == null) {
			ceiDAO = new CreateEmployeeInformationDAO();
		}
		return ceiDAO;
	}

	/**
	 * 현재 존재하는 사원의 최댓값을 찾아 리턴하는 매서드
	 * @return
	 * @throws SQLException
	 */
	public int selectMaxEmpnum() throws SQLException {
    	int empno =0;
    	
    	Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DbConnection.getCon();
            String selectMaxValue ="select nvl(max(emp_no),0)+1 emp_no from emp_info";
            pstmt=con.prepareStatement(selectMaxValue);
            rs = pstmt.executeQuery();
            if(rs.next()) {
            	empno = rs.getInt("emp_no");
            }
        }finally {
        	DbConnection.dbClose(rs, pstmt, con);
        }
		return empno;
    }

	/**
	 * TextField에서 입력받은 사원의 정보와 사원번호의 최댓값을 DB내에 추가하는 매서드.
	 *
	 * @param eVO
	 * @return 작성자: 김일신
	 * @throws SQLException
	 */
	public void insertEmpInfo(int empno,EmpInfoVO eVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DbConnection.getCon();
			String insertEmp = "	insert 	into 	EMP_INFO (EMP_NO,NAME,JOB,DEPT_CODE, CODE, TEL,GRP_CODE) "
					+ " 	values (?,?,?,?,?,?,'POS') 	";
			pstmt = con.prepareStatement(insertEmp);
//EMP_NO,NAME,JOB,DEPT_CODE, CODE, TEL,
			pstmt.setInt(1, empno);
			pstmt.setString(2, eVO.getName());
			pstmt.setString(3, eVO.getJob());
			CreateEmployeeInformationEvent ceie = new CreateEmployeeInformationEvent();
			pstmt.setInt(4, ceie.convertDept((eVO.getDept())));
			pstmt.setInt(5, ceie.convertposition(eVO.getPosition()));
			pstmt.setString(6, eVO.getTel());

			pstmt.executeUpdate();
		} finally {
			DbConnection.dbClose(null, pstmt, con);
		} // insertEmpInfo
	
	}// insertEmpInfo
	
	/**
	 * 사원번호의 최댓값으로 Account테이블에 해당 사원의 계정과 비밀번호를 입력하는 매서드
	 * @param empno
	 * @throws SQLException
	 */
	public void insertAccountEmp(int empno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con =DbConnection.getCon();
			String insertAuthEmp =
			"insert into account (emp_no , pass ,create_date,create_emp,logic)	"
			+ "values ( ?,?, sysdate, ?, 'N')";
			pstmt = con.prepareStatement(insertAuthEmp);
			
			pstmt.setInt(1, empno);
			pstmt.setString(2, String.valueOf(empno));
			pstmt.setInt(3, Integer.parseInt(LoginEvent.getEmpno()));
			
			pstmt.executeUpdate();
		}finally {
			DbConnection.dbClose(null, pstmt, con);
		}
		
	
	}
	public void insertUserAuthEmp(int empno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con =DbConnection.getCon();
			String insertAuthEmp =
					"insert into User_auth (emp_no , auth_code ,create_date,create_emp,logic)	"
							+ "values ( ?,'USER', sysdate, ?, 'N')";
			pstmt = con.prepareStatement(insertAuthEmp);
			
			pstmt.setInt(1, empno);
			pstmt.setInt(2, Integer.parseInt(LoginEvent.getEmpno()));
			
			pstmt.executeUpdate();
		}finally {
			DbConnection.dbClose(null, pstmt, con);
		}
		
		
	}
	
}
