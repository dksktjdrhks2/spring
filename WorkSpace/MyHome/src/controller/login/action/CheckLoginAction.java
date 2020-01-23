package controller.login.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.memberDAO.MemberDAO;
import util.Action;

public class CheckLoginAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		String name = null;
		String msg = null;
		boolean check = false;
		
		MemberDAO dao = new MemberDAO();
		name = dao.checkLogin(id, password);
		if(name != null){
			msg = name + "�� ȯ���մϴ�!!!";
			check = true;
			
			request.getSession().setAttribute("login", id);
			
			//��Ű����
			String ckid = request.getParameter("ckid");
			
			if(ckid != null){
				Cookie ck = new Cookie("ckid",id);
				ck.setMaxAge(60 * 60);
				response.addCookie(ck);//��Ű���� ����
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
			msg = "���̵� Ȥ�� ��й�ȣ�� �߸��Ǿ����ϴ�.";
		}
		
		request.setAttribute("name", name);
		request.setAttribute("msg", msg);
		request.setAttribute("check", check);
		/*
		 * 
		 * 
		 * //pageContext.forward("/Login/LoginResult.jsp"); RequestDispatcher rd =
		 * request.getRequestDispatcher("/Login/LoginResult.jsp");
		 * 
		 * rd.forward(request, response);
		 */
	}
	
}