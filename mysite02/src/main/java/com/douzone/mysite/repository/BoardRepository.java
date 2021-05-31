package com.douzone.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.mysite.vo.BoardVo;


public class BoardRepository {
           public List<BoardVo> findAll() {
			List<BoardVo> list = new ArrayList<>();
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
					
			try {
				conn = getConnection();
				
				String sql =
					"   select a.no, a.title,a.depth a.hit, b.no,b.name" +
					"     from board a,user b" +
				    "where a.user_no=b.no"+
					" order by a.group_no desc a.order_no asc";
				
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Long no = rs.getLong(1);
					String title = rs.getString(2);
					String regDate = rs.getString(3);
				    String userName=rs.getString(4);
					
					BoardVo vo = new BoardVo();
					vo.setNo(no);
					vo.setTitle(title);
					vo.setRegDate(regDate);
					vo.setUserName(userName);
					list.add(vo);
				}
				
			} catch (SQLException e) {
				System.out.println("error:" + e);
			} finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return list;
		}
		
		public boolean delete(BoardVo vo) {
			boolean result = false;

			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = getConnection();
				
				String sql =
						" delete" +
						"   from board" +
						"  where no=?" +
						"    and password=?";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setLong(1, vo.getNo());
				
				
				int count = pstmt.executeUpdate();
				result = count == 1;
				
			} catch (SQLException e) {
				System.out.println("error:" + e);
			} finally {
				try {
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}		
			
			return result;		
		}
		
		public boolean insert(BoardVo vo) {
			boolean result = false;

			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = getConnection();
				
				String sql =
						" insert" +
						"   into board" +
						" values (?,?)";
				pstmt = conn.prepareStatement(sql);
				
			
				pstmt.setString(1,vo.getTitle());
				pstmt.setString(2 ,vo.getContents());
		
			
				
			
				
				int count = pstmt.executeUpdate();
				result = count == 1;
				
			} catch (SQLException e) {
				System.out.println("error:" + e);
			} finally {
				try {
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}		
			
			return result;
		}
		
		private Connection getConnection() throws SQLException {
			Connection conn = null;
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				String url = "jdbc:mysql://192.168.80.102:3307/webdb?characterEncoding=utf8";
				conn = DriverManager.getConnection(url, "webdb", "webdb");
			} catch (ClassNotFoundException e) {
				System.out.println("드라이버 로딩 실패:" + e);
			} 
			
			return conn;
		}	
	}
