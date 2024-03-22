package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.controller.event.FindPasswordEvent;
import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.FindPasswordVO;

public class FindPasswordDAO {
    private static FindPasswordDAO fpDAO;

    public static FindPasswordDAO getInstance() {
        if (fpDAO == null) {
            fpDAO = new FindPasswordDAO();
        }
        return fpDAO;
    }

    public FindPasswordVO getPassword(String emp_no) {
    	FindPasswordVO fpVO = null;
    	int emp_no1=Integer.parseInt(emp_no);
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String password = null;

        try {
            con = DbConnection.getCon();

            // 쿼리 작성
            String query = "SELECT ei.emp_no, ei.tel, a.pass "
                    + "FROM emp_info ei, account a "
                    + "WHERE (ei.emp_no = a.emp_no) AND (ei.emp_no = ?)";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, emp_no1);

            // 쿼리 실행
            rs = pstmt.executeQuery();

            // 결과 확인
            if (rs.next()) {
            	fpVO = new FindPasswordVO (rs.getString("emp_no"), rs.getString("pass"), rs.getString("tel"));
            }
//            if(fpVO != null) {
//            }
//            JOptionPane.showMessageDialog(null, "아이디, 전화번호를 모두 입력해 주세요.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.dbClose(rs, pstmt, con);
        }

        return fpVO; // 찾아온 비밀번호 반환
    }
}
