package advice;

import java.security.Signature;

import org.aspectj.lang.JoinPoint;

public class Advice {
	//���ð�ü Advice
	//JoinPoint : pointcut�� �ɸ� ��ġ�� ������ �޴� Ŭ����
	public void before(JoinPoint jp){
		Signature s =  (Signature) jp.getSignature();
		
		System.out.println("----before:" + s);
	}
	
	public void after(JoinPoint jp){
		Signature s =  (Signature) jp.getSignature();
		
		System.out.println("----after:" + s.toString());
	}
}
