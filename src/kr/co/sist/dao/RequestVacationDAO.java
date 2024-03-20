package kr.co.sist.dao;

import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.VacationVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<VacationVO> vacationData() throws SQLException {
        List<VacationVO> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DbConnection.getCon();
            String insertVacationLog = "insert into bussiness_log";

            preparedStatement = connection.prepareStatement(insertVacationLog);
            resultSet = preparedStatement.executeQuery();
        } finally {
            DbConnection.dbClose(resultSet, preparedStatement, connection);
        }
        return list;
    }
}
