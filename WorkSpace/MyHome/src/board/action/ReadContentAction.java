package board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.boardDAO.BoardDAO;
import board.boardDTO.BoardDTO;
import util.Action;

public class ReadContentAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardDTO dto = new BoardDTO();
		
		dto.setTitle(request.getParameter("title"));
		
		BoardDTO dto2 = BoardDAO.getInstance().getContent(dto);
		
		request.setAttribute("dto", dto2);
	}
}
