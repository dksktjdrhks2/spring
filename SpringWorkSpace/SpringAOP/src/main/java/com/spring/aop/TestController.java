package com.spring.aop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.aop.service.TestService;

@Controller
public class TestController {

	public static final String VIEW_PATH = "/WEB-INF/views/";
	
	TestService testService;
	
	//������������ ���� �غ�
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	
	@RequestMapping(value ={ "/", "/test.do"} )
	public String test(){
		
		testService.test();
		
		return VIEW_PATH + "test.jsp";
	}
}
