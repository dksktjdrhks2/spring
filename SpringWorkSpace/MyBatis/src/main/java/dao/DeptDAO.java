package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVO;

public class DeptDAO {

	private SqlSession sqlSession;
	//SqlSessionTemplate
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//select�޼ҵ�
	public List<DeptVO> selectList(){
		List<DeptVO> list = null;
		
		list = sqlSession.selectList("dept.dept_list");
		
		return list;
	}
	
}























