package kr.co.sist.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.Properties;

public class DbConnection {

    private static Connection con;
    private static DbConnection dbCon;

    static {
        Properties properties = new Properties();
        Reader reader;
        try {
            reader = new FileReader("src/kr/co/sist/util/jdbc.properties");
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String driverName = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("password");

        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    

    public static Connection getCon() {
        return con;
    }

    public static void dbClose(ResultSet rs, Statement stmt, Connection con) throws SQLException {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}
