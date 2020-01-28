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
			
			int start = 1;
			if(request.getParameter("start") != null){
				start = Integer.parseInt(request.getParameter("start"));
			}
			
			BoardDAO dao = BoardDAO.getInstance();
			
			ArrayList<BoardDTO> list = dao.getList(start);
			
			int total = dao.getTotal();
			int nowPage = (start - 1) / 5 + 1; // 5 = 한페이지에서 뽑아올 글의 갯수 (현재페이지)
			
			request.setAttribute("list", list);
			request.setAttribute("total", total);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("start", start);
		}
}
