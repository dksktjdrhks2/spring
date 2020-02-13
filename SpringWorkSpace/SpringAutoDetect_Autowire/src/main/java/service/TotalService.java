package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import dao.DeptDAO;
import vo.DeptVO;

@Service
public class TotalService {
	
	@Autowired
	private DeptDAO dept_dao;//@Repository("dept_dao") ���⿡ ���� �̸��� �׻� �����ϰ� ����� �Ѵ�...
	
	public TotalService() {
		// TODO Auto-generated constructor stub
		System.out.println("--- TotalService ������ ---");
	}
	
	public List<DeptVO> selectList_dept(){
		List<DeptVO> list = null;
		
		list = dept_dao.selectList();
		
		return list;
	}
}
