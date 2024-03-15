package dao;

import util.DbConnection;
import vo.EmpInfoVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminMenuDAO {
    private static AdminMenuDAO adminMenuDAO;

    private AdminMenuDAO() {
    }

    public static AdminMenuDAO getInstance(){
        if (adminMenuDAO == null){
            adminMenuDAO = new AdminMenuDAO();
        }
        return adminMenuDAO;
    }

    public List<EmpInfoVO> alertWork() throws SQLException{
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
