package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardService;

@Controller
public class BoardController {
	
	private BoardService service;
	
	public BoardController() {
		System.out.println("--- BoardController 생성자 ---");
	}
	
	public void setService(BoardService service) {
		this.service = service;
	}
	
	// 사용자가 board/list.do를 요청하면 해당 메소드가 실행될수 있도록 하려면
	// @requestMapping을 통해 지정하면 된다...
	
	@RequestMapping("/board/list.do")
	public String list(Model model) {
		//Model
		// - Servlet과 Controller의 중간 매개체 역할을 하는 인터페이서
		// - request객체와 binding(연결)처리가 되어 서로간의 호환이 가능해 진다...
		
		List<String> list = service.selectList();
		
		// request.setAttribute
		model.addAttribute("list", list);
		
		return "board_list";
	}
	
}
