package kr.co.sist.dao;

import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.CommuteVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc : 사원 메뉴 view에 표시될 Data<br>
 * 작성자 : 고한별<br>
 * 작성일 : 2024.03.15
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
     * Desc : view에 필요한 Data 호출
     * **********************Login Data에서 empno 받으면 수정******************
     *
     * @return : 관련 데이터 list
     * @throws SQLException
     */
    public List<CommuteVO> selectCommuteLog(int empNo) throws SQLException {
        List<CommuteVO> list = new ArrayList<>();
        CommuteVO commuteVO = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DbConnection.getCon();

            StringBuilder tempSelectQuery = new StringBuilder();
            tempSelectQuery.append("   select c.commute_date, to_char(c.attend_time,'HH24:MI:SS') as attend_time,  ")
                    .append("   to_char(c.quit_time,'HH24:MI:SS') as quit_time  ")
                    .append("   from EMP_INFO ei, COMMUTE c    ")
                    .append("   where (ei.emp_no = c.emp_no)   ")
                    .append("  and (ei.emp_no = ?)  ")
                    .append("  and (( to_char(c.commute_date,'mm')) ")
                    .append("  = ( to_char(sysdate,'mm'))) ");
            String selectInfo = tempSelectQuery.toString();

            preparedStatement = connection.prepareStatement(selectInfo);

            if (empNo != 0) {
                preparedStatement.setInt(1, empNo);
            }

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                commuteVO = new CommuteVO(resultSet.getDate("commute_date"),
                        resultSet.getString("attend_time"),
                        resultSet.getString("quit_time"));
                list.add(commuteVO);
            }

        } finally {
            DbConnection.dbClose(null, preparedStatement, connection);
        }
        return list;
    }

}
