package board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.boardDAO.BoardDAO;
import board.boardDTO.BoardDTO;
import util.Action;

public class ReadContentAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		BoardDAO dao = BoardDAO.getInstance();
		
		dao.readCount(seq);
		
		BoardDTO dto = dao.getContent(seq);
		
		request.setAttribute("dto", dto);
		request.getSession().setAttribute("seq", seq);
	}

}
