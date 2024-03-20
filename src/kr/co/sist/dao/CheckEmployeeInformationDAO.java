package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.util.DbConnection2;
import kr.co.sist.view.admin.CheckEmployeeInformation;
import kr.co.sist.vo.EmpInfoVO;

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
     * @return 작성자: 김일신 24.03.18
     */
    public EmpInfoVO selectEmpInfo(int empno) throws SQLException {
        eVO = null;
        DbConnection2 dbCon = DbConnection2.getInstance();
        Connection con =null;

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String id = "super";
            String pass = "1111";
            con = dbCon.getConnection(id, pass);
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
            dbCon.dbClose(rs, pstmt, con);
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
        DbConnection2 dbCon = DbConnection2.getInstance();
        Connection con =null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String id = "super";
            String pass = "1111";
            con = dbCon.getConnection(id, pass);

//		dept = (String)checkEmp.getCbDept().getSelectedItem();
//		position = (String)checkEmp.getCbPosition().getSelectedItem();
//		year = checkEmp.getJycHiredateYear().getYear();

            String SelectEmp =
                    "	select	ei.EMP_NO, ei.name , ei.JOB , d.DEPT_NAME, c.DESCRIPTION, to_char(ei.CREATE_DATE,'yyyy-mm-dd') CREATE_DATE, ei.TEL, to_char(ei.EDIT_DATE,'yyyy-mm-dd')EDIT_DATE\r\n"
                            + "		from EMP_INFO ei, DEPT d  ,	COMMON c	"
                            + "		where (ei.DEPT_CODE = d.DEPT_CODE  ) and ( Ei.code = C.CODE ) and (c.GRP_CODE = 'POS')	"
                            + "		and    (d.DEPT_NAME =	?	) and (c.DESCRIPTION =  ?	) and   (	to_char(ei.CREATE_DATE, 'yyyy') = ?	) 	";

            pstmt = con.prepareStatement(SelectEmp);
            pstmt.setString(1, dept);
            pstmt.setString(2, position);
            pstmt.setInt(3, year);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                eVO = new EmpInfoVO(rs.getInt("EMP_NO"),rs.getString("name"), rs.getString("JOB"),
                        rs.getString("DESCRIPTION"), rs.getString("DEPT_NAME"), rs.getDate("CREATE_DATE"),rs.getString("TEL") , rs.getDate("EDIT_DATE"));
            }
        }finally {
            dbCon.dbClose(rs, pstmt, con);
        }
        return eVO;
    }// selectEmpInfo

    /**
     * 모든 검색조건이 선택되지 않은 상태에서 검색을 눌렀을 때, 모든 사원의 정보를 JTable에 출력하는 method.
     *
     * @return
     * @throws SQLException
     */
    public List<EmpInfoVO> selectAllEmpInfo() throws SQLException {
        List<EmpInfoVO> list = new ArrayList<EmpInfoVO>();
        EmpInfoVO eVO = null;
        DbConnection2 dbCon = DbConnection2.getInstance();
        Connection con =null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        try {
            String id = "super";
            String pass = "1111";
            con = dbCon.getConnection(id, pass);
            String selectAllEnpInfo
                    =" 	select	 ei.EMP_NO, ei.name , ei.JOB , d.DEPT_NAME, c.DESCRIPTION, to_char(ei.CREATE_DATE,'yyyy-mm-dd') CREATE_DATE, ei.TEL, to_char(ei.EDIT_DATE,'yyyy-mm-dd')EDIT_DATE	 "
                    + "	from EMP_INFO ei, DEPT d  ,	COMMON c	"
                    + "	where (ei.DEPT_CODE = d.DEPT_CODE  ) and ( Ei.code = C.CODE ) and c.GRP_CODE = 'POS' and  ( ei.LOGIC ='N') and (ei.emp_no not like 240000)	";
            pstmt = con.prepareStatement(selectAllEnpInfo);
            rs = pstmt.executeQuery();
            while(rs.next()) {//int empno, String name, String job,String position ,String dept,Date hiredate, String tel ,Date modifiedDate
                eVO = new EmpInfoVO(rs.getInt("EMP_NO"),
                        rs.getString("name"), rs.getString("JOB"),
                        rs.getString("DESCRIPTION"), rs.getString("DEPT_NAME"), rs.getDate("CREATE_DATE"),rs.getString("TEL") , rs.getDate("EDIT_DATE"));
                list.add(eVO);

            }
            System.out.println(list);
        }finally {
            dbCon.dbClose(rs, pstmt, con);
        }
        return list;
    }//selectAllEmpInfo
}