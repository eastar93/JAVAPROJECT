package kr.sc.ictjsp.users.model;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;

public class usersDAO {
	
	private DataSource ds;
	
	private static final int JOIN_SUCCESS = 1;
	private static final int JOIN_FAIL = 0;
	
	private static final int LOGIN_SUCCESS = 1;
	private static final int LOGIN_FAIL = 0;
	
	private usersDAO() {
		
		try {
			ds.getConnection();
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
	
	private static usersDAO dao = new usersDAO();
	
	public static usersDAO getInstance() {
		return dao;
	}
	
	public int joinUsers(usersVO user) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "INSERT INTO users VALUES(?, ?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getBirth());
			pstmt.setString(6, user.getGender());
			
			pstmt.executeUpdate();
			
			result = JOIN_SUCCESS;
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try { 
				if(con != null && !con.isClosed()) {
					con.close();
				}
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			result = JOIN_FAIL;
		}
		return result;
	} // end joinUsers;
	
	public int usersLogin(usersVO user) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			
			String sql = "SELECT * FROM users WHERE id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String dbId = rs.getString("id");
				String dbPw = rs.getString("pw");
				
				if(user.getId().equals(dbId) &&
						user.getPw().equals(dbPw)) {
					return LOGIN_SUCCESS;
				} else {
					return LOGIN_FAIL;
				} 
				
			}else {
					return LOGIN_FAIL;
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return LOGIN_FAIL;
	} // end usersLogin
}
