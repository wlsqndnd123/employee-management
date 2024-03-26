package kr.co.sist.dao;

import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.VacationVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    /**
     * Desc : view에 필요한 Data 호출
     *
     * @return : 관련 데이터 list
     * @throws SQLException
     */
    public void vacationData(VacationVO vVO) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = DbConnection.getCon();
            String insertVacationLog = "insert into BUSINESS_LOG(doc_no, title, emp_no, grp_code, code, work_log, grp_code2, code2, start_date, end_date) " +
                    " values ('000002110','연차신청서',240004,'WORK',5,'ㅅㅂ','APPR',1,?,?) ";

            preparedStatement = connection.prepareStatement(insertVacationLog);
//            resultSet = preparedStatement.executeQuery();

//            preparedStatement.setString(1,vacationVO.getDocNo());
//            preparedStatement.setString(2, vacationVO.getWorkLog());
            preparedStatement.setDate(1, vVO.getStartDate());
            preparedStatement.setDate(2, vVO.getEndDate());

            preparedStatement.executeUpdate();
        } finally {
            DbConnection.dbClose(null, preparedStatement, connection);
        }
    }

    public static void main(String[] args) {

    }
}
