package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.VisitDAO;
import mycommons.MyCommons;
import vo.VisitVO;

@Controller
public class VisitController {
	private VisitDAO visit_dao;
	
	public VisitController(VisitDAO visit_dao) {
		// TODO Auto-generated constructor stub
		this.visit_dao = visit_dao;
	}
	
	@RequestMapping(value = {"/", "/list.do"}) // url중복 매핑 ( / , /list.do 라는 url이 들어오면 아래 메소드실행)
	public String list(Model model) {
		VisitVO vo = new VisitVO();
		
		List<VisitVO> list = visit_dao.selectList();
		
		model.addAttribute("list", list);
		
		return MyCommons.Visit.VIEW_PATH + "visit_list.jsp";
	}
	
	@RequestMapping("insert_form.do")
	public String insert_form() {
		return MyCommons.Visit.VIEW_PATH + "visit_insert_form.jsp";
	}
	
	@RequestMapping("/insert.do")
	public String insert(VisitVO vo, HttpServletRequest request) {
		
		String ip = request.getRemoteAddr();
		
		//Content 내용중에 \n
		String content = vo.getContent().replaceAll("\n", "<br>");
		vo.setContent(content);
		vo.setIp(ip);
		
		int res = visit_dao.insert(vo);
		
		return "redirect:list.do";
	}
	
}
