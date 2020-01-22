package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.ListAction;
import controller.login.action.CheckLoginAction;
import util.Action;
import util.ActionForward;


@WebServlet("*.brd")
public class Controller extends HttpServlet{
	
	Action action;
	ActionForward actionForward;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action = null;
		actionForward = null;
		
		String requestURL = request.getRequestURL().toString();
		
		System.out.println(requestURL);
		
		int lastIndex = requestURL.lastIndexOf("/");
		int lastIndex2 = requestURL.lastIndexOf(".brd");
		
		String path = requestURL.substring(lastIndex + 1, lastIndex2);
		
		System.out.println(path);
		
		switch(path) {
		case "BoardList":
			action = new ListAction();
			actionForward = new ActionForward("/Board/BoardList.jsp", false);
			break;
		}
		
		if(action != null) {
			action.execute(request, response);
		}
		
		if(actionForward.isRedirect()) {
			response.sendRedirect(actionForward.getNextPath());
		}else {
			request.getRequestDispatcher(actionForward.getNextPath()).forward(request, response);
		}
	}
}
