package board.boardDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.boardDTO.BoardDTO;
import member.memberDAO.MemberDAO;

public class BoardDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static DataSource ds;
	
	private static BoardDAO instance;
	
	private BoardDAO() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDAO getInstance() { // singleton
		if(instance == null) {
			instance = new BoardDAO();
		}
		
		return instance;
	}
	
	public ArrayList<BoardDTO> makeList(ResultSet rs){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String id = idCut(rs.getString("id"));
				String name = rs.getString("name");
				String title = titleCut(rs.getString("title"));
				String content = rs.getString("content");
				String filename = rs.getString("filename");
				int hit = rs.getInt("hit");
				Date logtime = rs.getDate("logtime");
				BoardDTO dto = new BoardDTO(seq, id, name, title, content, filename, hit, logtime);
				
				list.add(dto);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if(list.isEmpty()) {
			list = null;
		}else {
			list.trimToSize();
		}
		
		return list;
	}
	
	private String titleCut(String title) {
		if(title.length() >= 10) {
			return title.substring(0,10) + "...";
		}else {
			return title;
		}
	}
	
	private String idCut(String id) {
		if(id.length() >= 4) {
			return id.substring(0,4) + "...";
		}else {
			return id;
		}
	}
	
	public ArrayList<BoardDTO> getList(int start) {
		ArrayList<BoardDTO> list = null;
		//String sql = "select * from board order by seq desc";
		String sql = "SELECT" + 
				"*" + 
				"FROM (select rownum rn, tt.* from (SELECT" + 
				"*" + 
				"FROM board order by seq desc) tt) where rn >= ? and rn <= ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql); // sql문으로 변환해준다
			ps.setInt(1, start);
			ps.setInt(2, start + 4);
			rs = ps.executeQuery();
			list = makeList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public boolean write(BoardDTO dto) {
		boolean check = false;
		
		String sql = "insert into board values(board_seq.nextval,?,?,?,?,?,0,sysdate)";
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, new MemberDAO().getName(dto.getId()));
			ps.setString(3, dto.getTitle());
			ps.setString(4, dto.getContent());
			ps.setString(5, dto.getFilename());
			if(ps.executeUpdate() != 0) {
				check = true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return check;
	}
	
	public void readCount(int seq) {
		String sql = "update board set hit = hit + 1 where seq = ?";
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, seq);
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public BoardDTO makeDTO(ResultSet rs){
		BoardDTO dto = null;
		
		try {
			if(rs.next()) {
				int seq = rs.getInt("seq");
				String id = rs.getString("id");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String filename = rs.getString("filename");
				int hit = rs.getInt("hit");
				Date logtime = rs.getDate("logtime");
				dto = new BoardDTO(seq, id, name, title, content, filename, hit, logtime);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public BoardDTO getContent(int seq) {
		String sql = "select * from board where seq = ?";
		
		BoardDTO dto = null;
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, seq);
			rs = ps.executeQuery();
			dto = makeDTO(rs);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return dto;
	}
	
	public int getTotal() {
		String sql = "select count(*) from board";
		
		int su = 0;
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				su = rs.getInt("count(*)");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return su;
	}
}
