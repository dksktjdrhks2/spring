package board.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.boardDAO.BoardDAO;
import board.boardDTO.BoardDTO;
import util.Action;

public class ListAction implements Action{

		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			BoardDAO dao = BoardDAO.getInstance();
			
			ArrayList<BoardDTO> list = dao.getList();
			
			request.setAttribute("list", list);
			
		}
}
