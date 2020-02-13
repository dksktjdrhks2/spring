package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.TotalService;
import vo.DeptVO;

@Controller
public class TestController {
	
	public static final String VIEW_PATH = "/WEB-INF/views/dept/";
	
	@Autowired
	TotalService service;
	
	public TestController() {
		// TODO Auto-generated constructor stub
		System.out.println("--- TestController ������ ---");
	}
	
	@RequestMapping(value = {"/", "/list.do"})
	public String list(Model model) {
		//dao���� ��� ��û...
		List<DeptVO> dept_list = service.selectList_dept();
		
		model.addAttribute("list", dept_list);
		
		return VIEW_PATH + "dept_list.jsp";
	}
	
}
