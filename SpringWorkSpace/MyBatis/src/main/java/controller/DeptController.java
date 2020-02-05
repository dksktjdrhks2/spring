package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDAO;
import vo.DeptVO;

@Controller
public class DeptController {
	private DeptDAO dept_dao;
	
	//��� ����
	public static final String VIEW_PATH = "/WEB-INF/views/dept/";
	
	public DeptController() {
		System.out.println("��Ʈ�ѷ� ����");
	}
	
	public DeptController(DeptDAO dept_dao) {
		System.out.println("��Ʈ�ѷ� ����");
		this.dept_dao = dept_dao;
	}
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		//dao���� ��� ��û...
		List<DeptVO> list = dept_dao.selectList();
		
		model.addAttribute("list", list);
		
		return VIEW_PATH + "dept_list.jsp";
		
	}
	
	
}
























