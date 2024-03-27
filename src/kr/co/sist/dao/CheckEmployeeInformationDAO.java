package kr.co.sist.dao;

import kr.co.sist.util.DbConnection;
import kr.co.sist.view.admin.CheckEmployeeInformation;
import kr.co.sist.vo.EmpInfoVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckEmployeeInformationDAO {
    private static CheckEmployeeInformationDAO checkEmpDAO;
    private CheckEmployeeInformation checkEmp;
    private EmpInfoVO eVO;

    private CheckEmployeeInformationDAO() {

    }

    public static CheckEmployeeInformationDAO getInstance() {
        if (checkEmpDAO == null) {
            checkEmpDAO = new CheckEmployeeInformationDAO();
        }

        return checkEmpDAO;
    }

    /**
     * 선택 창(TextFiled)에서 입력받은 사원번호로 DB 내의 사원정보를 찾아 list에 출력하는 method.
     *
     * @param empno : textFiled로 입력받은 값
     * @return
     * 작성자: 김일신 24.03.18
     */
    public EmpInfoVO selectEmpInfo(int empno) throws SQLException {
        eVO = null;
        Connection con = null;

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DbConnection.getCon();
            
            String SelectEmp = "	select	ei.EMP_NO, ei.name , ei.JOB , d.DEPT_NAME, c.DESCRIPTION, to_char(ei.CREATE_DATE,'yyyy-mm-dd') CREATE_DATE, ei.TEL, to_char(ei.EDIT_DATE,'yyyy-mm-dd')EDIT_DATE\r\n"
                    + "		from EMP_INFO ei, DEPT d  ,	COMMON c	"
                    + "		where (ei.DEPT_CODE = d.DEPT_CODE  ) and ( Ei.code = C.CODE ) and (c.GRP_CODE = 'POS') and ( ei.LOGIC ='N')	"
                    + "		and    (ei.emp_no = ?) 	";
            pstmt = con.prepareStatement(SelectEmp);
            pstmt.setInt(1, empno);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                eVO = new EmpInfoVO(rs.getInt("EMP_NO"), rs.getString("name"), rs.getString("JOB"),
                        rs.getString("DESCRIPTION"), rs.getString("DEPT_NAME"), rs.getDate("CREATE_DATE"),
                        rs.getString("TEL"), rs.getDate("EDIT_DATE"));
            }
        } finally {
            DbConnection.dbClose(rs, pstmt, con);
        }
        return eVO;

    }// selectEmpInfo

    /**
     * 콤보박스/데이트추져로 설정한 값으로 EmpInfoVo를 검색해 List로 출력하는 method
     *
     * @return 작성자 :김일신 24.03.18
     * @throws SQLException
     */
    public EmpInfoVO selectEmpInfo(String dept, String position, int year) throws SQLException {
        eVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DbConnection.getCon();

//		dept = (String)checkEmp.getCbDept().getSelectedItem();
//		position = (String)checkEmp.getCbPosition().getSelectedItem();
//		year = checkEmp.getJycHiredateYear().getYear();

            String SelectEmp = "	select	ei.EMP_NO, ei.name , ei.JOB , d.DEPT_NAME, c.DESCRIPTION, to_char(ei.CREATE_DATE,'yyyy-mm-dd') CREATE_DATE, ei.TEL, to_char(ei.EDIT_DATE,'yyyy-mm-dd')EDIT_DATE "
                    + "		from EMP_INFO ei, DEPT d  ,	COMMON c	"
                    + "		where (ei.DEPT_CODE = d.DEPT_CODE  ) and ( Ei.code = C.CODE ) and (c.GRP_CODE = 'POS') and  ( ei.LOGIC ='N')	"
                    + "		and    (d.DEPT_NAME =	?	) and (c.DESCRIPTION =  ?	) and   (	to_char(ei.CREATE_DATE, 'yyyy') = ?	) 	";

            pstmt = con.prepareStatement(SelectEmp);
            pstmt.setString(1, dept);
            pstmt.setString(2, position);
            pstmt.setInt(3, year);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                eVO = new EmpInfoVO(rs.getInt("EMP_NO"), rs.getString("name"), rs.getString("JOB"),
                        rs.getString("DESCRIPTION"), rs.getString("DEPT_NAME"), rs.getDate("CREATE_DATE"),
                        rs.getString("TEL"), rs.getDate("EDIT_DATE"));
            }
        } finally {
            DbConnection.dbClose(rs, pstmt, con);
        }
        return eVO;
    }// selectEmpInfo

    /**
     * 모든 검색조건이 선택되지 않은 상태에서 모든 사원의 정보를 JTable에 출력하는 method.
     *
     * @return
     * @throws SQLException
     */
    public List<EmpInfoVO> selectAllEmpInfo() throws SQLException {
        List<EmpInfoVO> list = new ArrayList<EmpInfoVO>();
        EmpInfoVO eVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuilder selectAllEnpInfo = new StringBuilder();
        try {
            con = DbConnection.getCon();
            selectAllEnpInfo.append(" 	select	 ei.EMP_NO, ei.name , ei.JOB , d.DEPT_NAME, c.DESCRIPTION, to_char(ei.CREATE_DATE,'yyyy-mm-dd') CREATE_DATE, ei.TEL, to_char(ei.EDIT_DATE,'yyyy-mm-dd')EDIT_DATE	 ")
            .append("	from EMP_INFO ei, DEPT d  ,	COMMON c	")
            .append("	where (ei.DEPT_CODE = d.DEPT_CODE  ) and ( Ei.code = C.CODE ) and c.GRP_CODE = 'POS' and  ( ei.LOGIC ='N') and (ei.emp_no not like 240000)	");
            pstmt = con.prepareStatement(selectAllEnpInfo.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                eVO = new EmpInfoVO(rs.getInt("EMP_NO"), rs.getString("name"), rs.getString("JOB"),
                        rs.getString("DESCRIPTION"), rs.getString("DEPT_NAME"), rs.getDate("CREATE_DATE"),
                        rs.getString("TEL"), rs.getDate("EDIT_DATE"));
                list.add(eVO);

            }
        } finally {
            DbConnection.dbClose(rs, pstmt, con);
        }
        return list;

    }// selectAllEmpInfo

    public List<EmpInfoVO> selectInfo(String col) throws SQLException {
        List<EmpInfoVO> list = new ArrayList<EmpInfoVO>();
        eVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DbConnection.getCon();
            if (col == "dept") {

                String selectdeptInfo = "	select DEPT_NAME from DEPT where DEPT_NAME not like '시스템관리자' ";
                pstmt = con.prepareStatement(selectdeptInfo);
            } else {

                String selectposInfo = "	select DESCRIPTION from COMMON where GRP_CODE ='POS' and DESCRIPTION not like '시스템관리자' ";
                pstmt = con.prepareStatement(selectposInfo);
            } // end if

            rs = pstmt.executeQuery();

            if (col == "dept") {
                while (rs.next()) {
                    // int empno, String name, String job, String position, String dept, Date
                    // hiredate, String tel, Date modifiedDate
                    eVO = new EmpInfoVO(0, null, null, null, rs.getString("DEPT_NAME"), null, null, null);
                    list.add(eVO);
                } // end while
            } else {
                while (rs.next()) {
                    eVO = new EmpInfoVO(0, null, null, rs.getString("DESCRIPTION"), null, null, null, null);
                    list.add(eVO);

                } // endwhile

            }
        } finally {
            DbConnection.dbClose(rs, pstmt, con);

        } // end finally

        return list;

    }// selectInfo
}// end class