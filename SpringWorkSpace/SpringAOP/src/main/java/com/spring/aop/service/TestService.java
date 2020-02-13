package com.spring.aop.service;

import com.spring.aop.dao.TestDAO;

public class TestService {
	TestDAO test_dao;
	
	//세터인젝션을 위한 준비
	public void setTest_dao(TestDAO test_dao) {
		this.test_dao = test_dao;
	}
	
	//나중을 위해 미리 만들어뒀음
	public void test(){
		System.out.println("-- call TestService.test() --");
	}
	
}
