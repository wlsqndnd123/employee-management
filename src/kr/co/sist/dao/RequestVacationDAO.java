package kr.co.sist.dao;

import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.DocumentVO;
import kr.co.sist.vo.VacationVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Desc : 사원 휴가 신청 메뉴 view에 표시될 Data<br>
 * 작성자 : 고한별<br>
 * 작성일 : 2024.03.15
 */
public class RequestVacationDAO {
    private static RequestVacationDAO requestVacationDAO;

    private RequestVacationDAO() {
    }

    /**
     * Desc : 사원 휴가 신청 메뉴 view에 사용되는 DAO 객체화
     *
     * @return DAO객체
     */
    public static RequestVacationDAO getInstance() {
        if (requestVacationDAO == null) {
            requestVacationDAO = new RequestVacationDAO();
        }
        return requestVacationDAO;
    }

    public int searchMaxDocNum() throws SQLException {
        int docNum = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        try {
            connection = DbConnection.getCon();

            String searchMaxNum =
                    "	select nvl(max(DOC_NO),0)+1 DOC_NO from BUSINESS_LOG	";
            preparedStatement =connection.prepareStatement(searchMaxNum);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                docNum = resultSet.getInt("DOC_NO");
            }

        }finally {
            DbConnection.dbClose(resultSet, preparedStatement, connection);
        }
        return docNum;
    }

    public void insertBusinessLog(int docno, VacationVO vVO) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DbConnection.getCon();

            String insertDoc = " insert into BUSINESS_LOG " +
                    " (DOC_NO, TITLE, EMP_NO, GRP_CODE, CODE, WORK_LOG, GRP_CODE2, CODE2, start_date, end_date)  " +
                    " values(?,'연차신청서',?,'WORK',5,?,'APPR',1,?,?) ";

            preparedStatement = connection.prepareStatement(insertDoc);

            preparedStatement.setInt(1,docno);
            preparedStatement.setInt(2, vVO.getEmpNo());
            preparedStatement.setString(3, vVO.getWorkLog());
            preparedStatement.setDate(4, vVO.getStartDate());
            preparedStatement.setDate(5, vVO.getEndDate());

            preparedStatement.executeUpdate();

        } finally {
            DbConnection.dbClose(null, preparedStatement, connection);
        }
    }
}
