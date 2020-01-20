package member.memberDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import member.memberDTO.MemberDTO;

public class MemberDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private static DataSource ds;
	
	static {
		
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");	
			//java:comp/env/ - tomcat 서버 사용시 설정을 불러올때는 적어야 한다....
		}catch(NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	
//	public MemberDAO() {
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		}catch(ClassNotFoundException e) {
//			e.printStackTrace();
//		}		
//	}
//
//	private void getConnection() {
//		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//		String user = "jsp";
//		String password = "jsp";
//		
//		try {
//			con = DriverManager.getConnection(url, user, password);
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	public String checkLogin(String id,String password) {
		String name = null;
		
		String sql = "select name from member where id = ? and password = ?";
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return name;
		
	}
	
	public String findID(MemberDTO dto) {
		String id = null;
		String sql = "select id from member where name = ? and tel1 = ? and tel2 = ? and tel3 = ?";
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getTel1());
			ps.setString(3, dto.getTel2());
			ps.setString(4, dto.getTel3());
			rs = ps.executeQuery();
			if(rs.next()) {
				id = rs.getString("id");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return id;
	}
	
	public boolean insert(MemberDTO dto) {
		boolean check = false;
		
		String sql = "insert into member values(member_seq.nextval,?,?,?,?,?,?,?)";
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPassword());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getEmail());
			ps.setString(5, dto.getTel1());
			ps.setString(6, dto.getTel2());
			ps.setString(7, dto.getTel3());
			if(ps.executeUpdate() != 0) {
				check = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return check;
	}
	
	public MemberDTO memberInfo(String id) {
		
		MemberDTO dto = null;
		
		String sql = "select * from Member where id = ?";
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO(rs.getInt("no"),rs.getString("id"),rs.getString("password"),
						rs.getString("name"),rs.getString("email"),rs.getString("tel1"),
						rs.getString("tel2"),rs.getString("tel3"));
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
		
	}
	
	public boolean deleteMember(int no) {
		String sql = "delete member where no = ?";
		boolean check = false;
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			if(ps.executeUpdate() != 0) {
				check = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return check;
		
	}
	
	
	public boolean updateMember(MemberDTO dto) {
		String sql = "update member set email = ?,tel1 = ?,tel2 = ?,tel3 = ? where no = ?";
		boolean check = false;
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getEmail());
			ps.setString(2, dto.getTel1());
			ps.setString(3, dto.getTel2());
			ps.setString(4, dto.getTel3());
			ps.setInt(5, dto.getNo());
			if(ps.executeUpdate() != 0) {
				check = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return check;
	}
	
public String getName(String id) {
		
		String name = null;
		
		String sql = "select name from Member where id = ?";
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return name;
		
	}


}


















