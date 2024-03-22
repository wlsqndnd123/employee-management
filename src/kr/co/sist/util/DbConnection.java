package kr.co.sist.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.Properties;

public class DbConnection {

    private static Properties properties;

    static {
        properties = new Properties();
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon() throws SQLException {
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("password");

        return DriverManager.getConnection(url, user, pwd);
    }

    public static void dbClose(ResultSet rs, Statement stmt, Connection con) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	public static DbConnection getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	public Connection getConnection(String id, String pass) {
		// TODO Auto-generated method stub
		return null;
	}
}
