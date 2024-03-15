package dao;

import util.DbConnection;
import vo.EmpInfoVO;

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
     * @return DAO객체
     */
    public static UserMenuDAO getInstance(){
        if (userMenuDAO == null){
            userMenuDAO = new UserMenuDAO();
        }
        return userMenuDAO;
    }

    /**
     * Desc : view에 필요한 Data 호출
     * @return : 관련 데이터 list
     * @throws SQLException
     */
    public List<EmpInfoVO> userData() throws SQLException{
        List<EmpInfoVO> list = new ArrayList<>();

        DbConnection dbConnection = DbConnection.getInstance();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            String id = "scott";
            String pass = "tiger";

            connection = dbConnection.getConnection(id,pass);

        }finally {
            dbConnection.dbClose(resultSet, preparedStatement, connection);
        }
        return list;
    }
}
