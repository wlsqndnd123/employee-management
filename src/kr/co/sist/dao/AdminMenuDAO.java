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
     * @param isCodeFive true 연차신청서, false 업무문서
     * @return : 관련 데이터 list
     * @throws SQLException
     */
    public int alertWork(boolean isCodeFive) throws SQLException {
        int count = 0;

        try (Connection connection = DbConnection.getCon()) {
            String countDocsQuery = "SELECT COUNT(*) FROM business_log WHERE CODE2 = 1";

            if (isCodeFive) {
                countDocsQuery += " AND CODE = 5";
            } else {
                countDocsQuery += " AND CODE <> 5";
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(countDocsQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    count = resultSet.getInt(1);
                }
            }
        }

        return count;
    }
}
