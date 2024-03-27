package kr.co.sist.dao;

import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.CommuteVO;
import kr.co.sist.vo.VacationVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc : 사원 메뉴 view에 표시될 Data<br>
 * 작성자 : 고한별<br>
 * 작성일 : 2024.03.15<br>
 * 수정자 : 고한별<br>
 * 수정일 : 2024.03.28
 */
public class UserMenuDAO {
    private static UserMenuDAO userMenuDAO;

    private UserMenuDAO() {
    }

    /**
     * Desc : 사원 메뉴 view에 사용되는 DAO 객체화
     *
     * @return DAO객체
     */
    public static UserMenuDAO getInstance() {
        if (userMenuDAO == null) {
            userMenuDAO = new UserMenuDAO();
        }
        return userMenuDAO;
    }

    /**
     * Desc : 사용자의 출퇴근 기록시간을 조회하여 List로 반환
     *
     * @param empNo 로그인 한 사원번호
     * @return 날짜와 출퇴근시간이 기록된 CommuteVO List
     * @throws SQLException
     */
    public List<CommuteVO> selectCommuteLog(int empNo) throws SQLException {
        List<CommuteVO> list = new ArrayList<>();
        CommuteVO commuteVO = null;

        try (Connection connection = DbConnection.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT c.commute_date, TO_CHAR(c.attend_time,'HH24:MI:SS') AS attend_time, " +
                             "TO_CHAR(c.quit_time,'HH24:MI:SS') AS quit_time " +
                             "FROM EMP_INFO ei, COMMUTE c " +
                             "WHERE (ei.emp_no = c.emp_no) " +
                             "AND (ei.emp_no = ?) " +
                             "AND ((TO_CHAR(c.commute_date,'mm')) = (TO_CHAR(sysdate,'mm')))")) {

            preparedStatement.setInt(1, empNo);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    commuteVO = new CommuteVO(resultSet.getDate("commute_date"),
                            resultSet.getString("attend_time"),
                            resultSet.getString("quit_time"));
                    list.add(commuteVO);
                }
            }
        }
        return list;
    }

    /**
     * Desc : 사용자의 휴가 정보를 조회하여 List로 반환
     *
     * @param empNo 로그인한 사원번호
     * @return 승인된 휴가의 시작일과 종료일이 기록된 VacationVO List
     * @throws SQLException
     */
    public List<VacationVO> selectVacationDate(int empNo) throws SQLException {
        List<VacationVO> list = new ArrayList<>();
        VacationVO vacationVO = null;

        try (Connection connection = DbConnection.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT START_DATE, END_DATE " +
                             "FROM BUSINESS_LOG " +
                             "WHERE EMP_NO = ? " +
                             "AND CODE = 5 " +
                             "AND CODE2 = 2 " +
                             "AND ((TO_CHAR(START_DATE, 'MM') = TO_CHAR(sysdate, 'mm')) " +
                             "OR (TO_CHAR(END_DATE, 'MM') = TO_CHAR(sysdate, 'mm')))")) {

            preparedStatement.setInt(1, empNo);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    vacationVO = new VacationVO(resultSet.getDate("start_date"),
                            resultSet.getDate("end_date"));
                    list.add(vacationVO);
                }
            }
        }
        return list;
    }

}
