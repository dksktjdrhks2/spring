package advice;

import java.security.Signature;

import org.aspectj.lang.JoinPoint;

public class Advice {
	//감시객체 Advice
	//JoinPoint : pointcut이 걸린 위치의 정보를 받는 클래스
	public void before(JoinPoint jp){
		Signature s =  (Signature) jp.getSignature();
		
		System.out.println("----before:" + s);
	}
	
	public void after(JoinPoint jp){
		Signature s =  (Signature) jp.getSignature();
		
		System.out.println("----after:" + s.toString());
	}
}
