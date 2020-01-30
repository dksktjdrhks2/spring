package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
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
	public String list() {
		List<String> list = service.selectList();
		
		return "board_list";
	}
	
}
