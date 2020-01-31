package com.spring.com;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// Component
// - Controller
// - Service
// - Repository

// - ��Ӱ��迡�� ��ü�� ���� ��Ȯ�ϰ� ������ �����Ҽ� �ֵ��� Controller�� �����ش�...

//@Component
@Controller
public class TestController {
	
	// ���� ��θ� ������ ����� �����Ѵ�....
	public static final String VIEW_PATH = "/WEB-INF/views/test/";
	
	public TestController() {
		System.out.println("--- TestController ������ ---");
	}
	
	@RequestMapping("/test.do")
	public String test(Model model, HttpServletRequest request) {
		
		String[] msg = new String[] {
			"�ȳ�",
			"Hello",
			"Sawubona",
		};
		
		String ip = request.getRemoteAddr();
		request.setAttribute("ip", ip);
		//Model�� requset������ ��� ������ ���ε� �س��� �����̹Ƿ� ������ request��ü�� �ƴϴ�...
		//�޼ҵ��� �Ű������� request��ü�� �����ָ� �ڵ����� �޾� �´�....
		
		model.addAttribute("msg", msg);
		
		return VIEW_PATH + "test.jsp"; // /WEB-INF/views/test/test.jsp
	}
}
