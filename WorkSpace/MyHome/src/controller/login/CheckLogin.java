package controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.memberDAO.MemberDAO;

@WebServlet("/Login/CheckLogin")
public class CheckLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		String name = null;
		String msg = null;
		boolean check = false;
		
		MemberDAO dao = new MemberDAO();
		name = dao.checkLogin(id, password);
		if(name != null){
			msg = name + "님 환영합니다!!!";
			check = true;
			
			request.getSession().setAttribute("login", id);
			
			//쿠키생성
			String ckid = request.getParameter("ckid");
			
			if(ckid != null){
				Cookie ck = new Cookie("ckid",id);
				ck.setMaxAge(60 * 60);
				response.addCookie(ck);//쿠키파일 생성
			}else{
				Cookie[] cks = request.getCookies();
				if(cks != null){
					for(Cookie ck : cks){
						if(ck.getName().equals("ckid")){
							if(ck.getValue().equals(id)){
								ck.setMaxAge(0);
								response.addCookie(ck);
							}
							break;
						}
					}
				}
			}
		}else{
			msg = "아이디 혹은 비밀번호가 잘못되었습니다.";
		}
		
		request.setAttribute("name", name);
		request.setAttribute("msg", msg);
		request.setAttribute("check", check);
		
		
		
		//pageContext.forward("/Login/LoginResult.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/Login/LoginResult.jsp");
		
		rd.forward(request, response);
	}
}
