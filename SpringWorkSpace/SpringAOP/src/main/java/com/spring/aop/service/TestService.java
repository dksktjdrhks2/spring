package com.spring.aop.service;

import com.spring.aop.dao.TestDAO;

public class TestService {
	TestDAO test_dao;
	
	//������������ ���� �غ�
	public void setTest_dao(TestDAO test_dao) {
		this.test_dao = test_dao;
	}
	
	//������ ���� �̸� ��������
	public void test(){
		System.out.println("-- call TestService.test() --");
	}
	
}
