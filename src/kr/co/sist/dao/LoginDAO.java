package kr.co.sist.dao;

import kr.co.sist.controller.event.LoginEvent;
import kr.co.sist.util.DbConnection;
import kr.co.sist.vo.LoginVO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO {
    private String emp_no, password;
    private static LoginEvent loginEvent;
    private static LoginDAO lDAO;

    public static LoginDAO getInstance() {
        if (lDAO == null) {
            lDAO = new LoginDAO();
        }//end if
        return lDAO;
    }//end LoginDAO

    /**
     * 사번과 비번을 입력받은 정보로 저장
     */

    public class Validation {
        /**
         * Desc. : 인자로 넘어온 str에 값이 없으면 true return
         *
         * @param str
         * @return
         */
        public boolean isEmpty(String str) {
            return str == null || str.isEmpty();
        }
    }//Validation


    /**
     * 유효성 검사 1)
     * 사번, 비번이 모두 입력되었는지 확인
     */
    public void checkEmpty() {
        Validation validator = new Validation();

        boolean idEmpty = validator.isEmpty(emp_no);
        boolean passwordEmpty = validator.isEmpty(password);

        if (idEmpty || passwordEmpty) {
            JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 모두 입력해주세요.");
        }
    }

//	public static LoginDAO getInstance() {
//		if(lDAO == null) {
//			lDAO = new LoginDAO();
//		}//end if
//		return lDAO;
//	}//end LoginDAO

    public LoginVO confirmUser(String emp_no) {
        LoginVO lVO = null;


        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DbConnection.getCon();


            String query = "	select a.emp_no, a.pass, ua.auth_code "
                    + "	from  account a, USER_AUTH ua "
                    + "	where    (a.emp_no= ua.emp_no) AND (a.emp_no = ?) ";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, emp_no);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                lVO = new LoginVO(rs.getString("emp_no"),
                        rs.getString("pass"),
                        rs.getString("auth_code"));
                // 다른 필드도 필요하다면 추가로 설정
            }
//            if(lVO != null) {
//            }
//            JOptionPane.showMessageDialog(null, "아이디, 비밀번호를 모두 입력해 주세요.");
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DbConnection.dbClose(rs, pstmt, con);
        }
        return lVO;

    }//confirmUser

    public static void main(String[] args) {
    }
}
//	
//	public void loginClik() {
//		setInputInfo(); // 입력 받은 아이디와 비밀번호를 설정합니다.
//	    if (confirmUser() != null) { // confirmUser() 메서드를 통해 사용자 정보가 확인되면
//	        LoginVO lVO = confirmUser(); // 사용자 정보를 가져옵니다.
//	        String authCode = lVO.getAuthCode(); // 사용자의 권한 코드를 가져옵니다. (예시)
//	        
//	        // 권한 코드에 따라 다른 메뉴를 띄웁니다.
//	        if (authCode.equals("ADMIN")) { // 관리자인 경우
//	            SwingUtilities.invokeLater(AdminMenu::new);
//	        } else if (authCode.equals("USER")) { // 사용자인 경우
//	            SwingUtilities.invokeLater(UserMenu::new);
//	        } else { // 권한 코드가 잘못된 경우
//	            JOptionPane.showMessageDialog(null, "권한이 없는 사용자입니다.");
//	        }
//	    } else { // 사용자 정보가 확인되지 않은 경우
//	        JOptionPane.showMessageDialog(null, "사용자 정보를 확인할 수 없습니다.");
//	    }
//	}//loginClik
//
//	
//	
//	
//	public String getLogInfo() throws SQLException{
//		String authCode = "";
//
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//            con = DbConnection.getCon();
//
//            // 아이디와 비밀번호로 인증코드를 가져오는 쿼리 실행
//            String query = "SELECT auth_code FROM user_auth WHERE emp_no = ? AND pass = ?";
//            pstmt = con.prepareStatement(query);
//            
//            String emp_no = null;
//            String password = null;
//			pstmt.setString(1, emp_no);
//			pstmt.setString(2, password);
//			
//            rs = pstmt.executeQuery();
//
//            if (rs.next()) {
//                authCode = rs.getString("auth_code");
//            }
//        } finally {
//            DbConnection.dbClose(rs, pstmt, con);
//        }
//
//        return authCode;
//    }
	

