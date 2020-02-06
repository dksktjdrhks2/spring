package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVO;

public class VisitDAO {
	private SqlSession sqlSession;
	//SqlSessionTemplate���� �ϴ� ��쵵 ����.
	//SqlSession�� ��ӹ������� SqlSessionTemplate�̴�.
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//���� ��� ��ȸ
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
