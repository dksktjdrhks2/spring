package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.DeptVO;

@Repository("dept_dao") // 같은 프로젝트의 다른 패키지에 DeptDAO라는 이름의 클래스가 있을 경우르 대비해 별명을 붙인부분...
public class DeptDAO {
	
	//Auto-Detecting기능을 사용할때는 인젝션을 사용할수 없으므로...
	//SqlSession객체는 Autowired기능을 이용하여 인젝션을 해주면 된다...
	@Autowired
	private SqlSession sqlSession;
	
	public DeptDAO() {
		// TODO Auto-generated constructor stub
		System.out.println("--- DeptDAO 생성자 ---");
	}
	
	public List<DeptVO> selectList(){
		List<DeptVO> list = null;
		
		list = sqlSession.selectList("dept.dept_list");
		
		return list;
	}
}
