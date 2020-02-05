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
	
	//경로 설정
	public static final String VIEW_PATH = "/WEB-INF/views/dept/";
	
	public DeptController() {
		System.out.println("컨트롤러 실행");
	}
	
	public DeptController(DeptDAO dept_dao) {
		System.out.println("컨트롤러 실행");
		this.dept_dao = dept_dao;
	}
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		//dao에서 목록 요청...
		List<DeptVO> list = dept_dao.selectList();
		
		model.addAttribute("list", list);
		
		return VIEW_PATH + "dept_list.jsp";
		
	}
	
	
}
























