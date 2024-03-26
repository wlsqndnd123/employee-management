package kr.co.sist.dao;

import kr.co.sist.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Desc : 관리자 메뉴 view에 표시될 Data<br>
 * 작성자 : 고한별<br>
 * 작성일 : 2024.03.15
 */
public class AdminMenuDAO {
    private static AdminMenuDAO adminMenuDAO;

    private AdminMenuDAO() {
    }

    /**
     * Desc : 관리자 메뉴 view에 사용되는 DAO 객체화
     *
     * @return DAO객체
     */
    public static AdminMenuDAO getInstance() {
        if (adminMenuDAO == null) {
            adminMenuDAO = new AdminMenuDAO();
        }
        return adminMenuDAO;
    }

    /**
     * Desc : 업무 알람에 필요한 Data 호출
     *
     * @return : 관련 데이터 list
     * @throws SQLException
     */
    public int alertWork(boolean isCodeFive) throws SQLException {
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DbConnection.getCon();
            String countDocs = "select count(*) from business_log where CODE2 = 1";
            if (isCodeFive) {
                countDocs += " and CODE = 5";
            } else {
                countDocs += " and CODE <> 5";
            }
            preparedStatement = connection.prepareStatement(countDocs);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } finally {
            DbConnection.dbClose(resultSet, preparedStatement, connection);
        }

        return count;
    }
}
