package kr.co.sist;

import kr.co.sist.view.common.Login;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {
        try {
            new Login();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
