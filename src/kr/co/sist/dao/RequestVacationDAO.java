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

    /**
     * Desc : 현재 데이터베이스에 기록된 문서번호 최대값 확인하고 새 문서번호 반환
     * @return 문서번호 최대값 + 1
     * @throws SQLException
     */
    public int searchMaxDocNum() throws SQLException {
        int docNum = 0;
        try (Connection connection = DbConnection.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT NVL(MAX(DOC_NO), 0) + 1 AS DOC_NO FROM BUSINESS_LOG")) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    docNum = resultSet.getInt("DOC_NO");
                }
            }
        }
        return docNum;
    }

    /**
     * Desc : 연차신청서를 새로 작성하는 기능
     * @param docNo 자동생성된 문서 번호
     * @param vVO view에서 입력된 데이터를 저장한 VacationVO
     * @throws SQLException
     */
    public void insertBusinessLog(int docNo, VacationVO vVO) throws SQLException {
        try (Connection connection = DbConnection.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO BUSINESS_LOG (DOC_NO, TITLE, EMP_NO, GRP_CODE, CODE, WORK_LOG, GRP_CODE2, CODE2, start_date, end_date) " +
                             "VALUES (?, '연차신청서', ?, 'WORK', 5, ?, 'APPR', 1, ?, ?)")) {

            preparedStatement.setInt(1, docNo);
            preparedStatement.setInt(2, vVO.getEmpNo());
            preparedStatement.setString(3, vVO.getWorkLog());
            preparedStatement.setDate(4, vVO.getStartDate());
            preparedStatement.setDate(5, vVO.getEndDate());

            preparedStatement.executeUpdate();
        }
    }
}
