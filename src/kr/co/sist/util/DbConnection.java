package kr.co.sist.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

    public static void dbClose(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
