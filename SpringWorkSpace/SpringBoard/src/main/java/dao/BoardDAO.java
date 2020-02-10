package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.BoardVO;

public class BoardDAO {
	private SqlSession sqlSession;
	//SqlSessionTemplate���� �ϴ� ��쵵 ����.
	//SqlSession�� ��ӹ������� SqlSessionTemplate�̴�.
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<BoardVO> getList(){
		List<BoardVO> list = null;
		
		list = sqlSession.selectList("board.board_list");
		
		return list;
	}
	
	public BoardVO selectOne(int seq) {
		BoardVO vo = null;
		
		vo = sqlSession.selectOne("board.board_one", seq);
		
		return vo;
	}
	
	public void readCount(int seq) {
		sqlSession.update("board.board_count", seq);
	}
}
