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
	
	public ArrayList<BoardDTO> getList() {
		ArrayList<BoardDTO> list = null;
		String sql = "select * from board order by seq desc";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql); // sql문으로 변환해준다
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
	
	public BoardDTO getContent(BoardDTO dto) {
		String sql = "select * from board where title = ?";
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setTitle(rs.getString(4));
				dto.setContent(rs.getString(5));
				dto.setFilename(rs.getString(6));
				dto.setHit(rs.getInt(7));
				dto.setLogtime(rs.getDate(8));
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
		
		return dto;
	}
}
