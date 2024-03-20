package kr.co.sist.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Singleton pattern을 사용한 DBMS connection 관리 클래스
 */
public class DbConnection2 {
	//
	private static DbConnection2 dbCon;
	
	private DbConnection2() {
		
	}//Dbconnection
	
	public static DbConnection2 getInstance() {
		if(dbCon == null) { // 최초 호출이거나, 사용중에 객체가 죽었다면 if를 탄다.
			dbCon = new DbConnection2();
		}//end if
		return dbCon;
	}//getInstance
	
	/**
	 * Connection을 반환하는 method
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection(String id,String pass) throws SQLException {
		Connection con = null;
		
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		String url= "jdbc:oracle:thin:@localhost:1521:orcl";
//		String pass= "";
//		String id= "";
		
		//2.커넥션 얻기
		con = DriverManager.getConnection(url,id,pass);
		
		
		return con;
	}//getConnection
	
	public Connection getConnection(String url,String id,String pass) throws SQLException {
		Connection con = null;
		
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
//		String url= "jdbc:oracle:thin:@localhost:1521:orcl";
//		String pass= "";
//		String id= "";
		
		//2.커넥션 얻기
		con = DriverManager.getConnection(url,id,pass);
		
		
		return con;
	}
	
	/**
	 * 연결을 종료하는 일
	 * @param rs
	 * @param stmt
	 * @param con
	 * @throws SQLException
	 */
	public void dbClose(ResultSet rs, Statement stmt, Connection con) throws SQLException {
		try {
			if(rs != null) {rs.close();}
			if(stmt != null) {stmt.close();}
		}finally {
			if(con != null) {con.close();}
		}//end finally
	}//dbClose

	
}//class
