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

// - 상속관계에서 객체를 좀더 정확하게 영역을 구별할수 있도록 Controller를 적어준다...

//@Component
@Controller
public class TestController {
	
	// 실행 경로를 참조할 상수를 지정한다....
	public static final String VIEW_PATH = "/WEB-INF/views/test/";
	
	public TestController() {
		System.out.println("--- TestController 생성자 ---");
	}
	
	@RequestMapping("/test.do")
	public String test(Model model, HttpServletRequest request) {
		
		String[] msg = new String[] {
			"안녕",
			"Hello",
			"Sawubona",
		};
		
		String ip = request.getRemoteAddr();
		request.setAttribute("ip", ip);
		//Model은 requset영역을 잠시 빌려서 바인딩 해놓은 구조이므로 온전한 request객체는 아니다...
		//메소드의 매개변수로 request객체를 적어주면 자동으로 받아 온다....
		
		model.addAttribute("msg", msg);
		
		return VIEW_PATH + "test.jsp"; // /WEB-INF/views/test/test.jsp
	}
}
