package com.spring.com;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/test2.do")
	public ModelAndView test2(HttpServletRequest request) {
		
		//ModelAndView
		// - �����Ϳ� �� ������ �ϳ��� ��ü�� �����ؼ� �����Ҽ� �ִ� ��ü,...
		ModelAndView mv = new ModelAndView();
		
		String[] msg = new String[] {
			"�ȳ�",
			"Hello",
			"Sawubona",
		};
		
		String ip = request.getRemoteAddr();
		
		mv.addObject("msg", msg);
		mv.addObject("ip", ip);
		
		
		//mv�� �� ������ ��´�...
		mv.setViewName(VIEW_PATH + "test2.jsp");
		
		return mv;
	}
}
