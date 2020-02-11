package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.BoardVO;

public class BoardDAO {
	private SqlSession sqlSession;
	//SqlSessionTemplate으로 하는 경우도 있음.
	//SqlSession을 상속받은것이 SqlSessionTemplate이다.
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<BoardVO> getList(){
		List<BoardVO> list = null;
		
		list = sqlSession.selectList("board.board_list");
		
		return list;
	}
	
	public BoardVO getContent(int seq) {
		BoardVO vo = null;
		
		sqlSession.update("board.board_count", seq);
		
		vo = sqlSession.selectOne("board.board_one", seq);
		
		return vo;
	}
}
