package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.BoardDAO;
import mycommons.MyCommons;
import vo.BoardVO;

@Controller
public class BoardController {

	private BoardDAO board_dao;
	
	public BoardController(BoardDAO board_dao) {
		// TODO Auto-generated constructor stub
		this.board_dao = board_dao;
	}
	
	@RequestMapping(value = {"/", "/list.do"})
	public String list(Model model) {
		List<BoardVO> list = board_dao.getList();
		
		model.addAttribute("list", list);
		
		return MyCommons.Board.VIEW_PATH + "board_list.jsp";
	}
	
	@RequestMapping("/board_content.do")
	public String content(Model model, int seq) {
		BoardVO vo = null;
		
		board_dao.readCount(seq);
		vo = board_dao.selectOne(seq);
		
		model.addAttribute("vo", vo);
		
		return MyCommons.Board.VIEW_PATH + "board_content.jsp";
	}
}
