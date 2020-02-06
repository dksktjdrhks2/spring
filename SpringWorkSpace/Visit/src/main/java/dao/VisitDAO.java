package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVO;

public class VisitDAO {
	private SqlSession sqlSession;
	//SqlSessionTemplate으로 하는 경우도 있음.
	//SqlSession을 상속받은것이 SqlSessionTemplate이다.
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//방명록 목록 조회
	public List<VisitVO> selectList(){
		List<VisitVO> list = null;
		
		list = sqlSession.selectList("visit.visit_list");
		
		return list;
	}
	
	public int insert(VisitVO vo) {
		int res = 0;
		
		res = sqlSession.insert("visit.visit_insert", vo);
		
		return res;
	}
}
