package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.sist.controller.event.CreateEmployeeInformationEvent;
import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.EmpInfoVO;

public class CreateEmployeeInformationDAO {
	static private CreateEmployeeInformationDAO ceiDAO ;
	private CreateEmployeeInformationDAO() {
		
	}
	public static CreateEmployeeInformationDAO getInstance() {
		if(ceiDAO==null) {
			ceiDAO = new CreateEmployeeInformationDAO();
		}
		return ceiDAO;
}
	/**
	 * TextField에서 입력받은 사원의 정보들을 DB내에 추가하는 매서드.
	 * @param eVO
	 * @return
	 * 작성자: 김일신
	 * @throws SQLException 
	 */
	public void insertEmpInfo(EmpInfoVO eVO) throws SQLException {
		Connection con = DbConnection.getCon();
		PreparedStatement pstmt = null;
		try {
			
		String insertEmp =
		"	insert 	into 	EMP_INFO (EMP_NO,NAME,JOB,DEPT_CODE, CODE, TEL,GRP_CODE) "
		+ " 	values (?,?,?,?,?,?,'POS') 	";
		pstmt =con.prepareStatement(insertEmp);
//EMP_NO,NAME,JOB,DEPT_CODE, CODE, TEL,
		pstmt.setInt(1,eVO.getEmpno());
		pstmt.setString(2, eVO.getName());
		pstmt.setString(3, eVO.getJob());
		 CreateEmployeeInformationEvent ceie = new CreateEmployeeInformationEvent();
		pstmt.setInt(4, ceie.convertDept((eVO.getDept())));
		pstmt.setInt(5, ceie.convertposition(eVO.getPosition()));
		pstmt.setString(6, eVO.getTel());
		
		pstmt.executeUpdate();
		}finally {
			DbConnection.dbClose(null, pstmt, con);
		}//insertEmpInfo
		
		
		
	}
}
