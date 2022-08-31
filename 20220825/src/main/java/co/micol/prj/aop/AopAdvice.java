package co.micol.prj.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // 부품설정
@Aspect // 수행할 클래스 자체를 정의 (역할)
public class AopAdvice {
	@Pointcut("execution(* co.micol.prj..*Impl.*(..))") // pointcut 설정
	public void allPoint() {}
	
	@Before("allPoint()") // weaving = 포인트컷이 동작할 시점
	public void beforlog(JoinPoint jp) { // advice = 수행하는 메소드 
		Date date = new Date(); //java 8 부터 LocalDat객체를 권장함
		String runMethod = jp.getSignature().getName();
		System.out.println(runMethod + " : 시작시간 =" + date); //권한
	}
	
	@After("allPoint()") // weaving 설정
	public void log(JoinPoint jp) {
		Date date = new Date(); //java 8 부터 LocalDat객체를 권장함
		String runMethod = jp.getSignature().getName();
		System.out.println(runMethod + " : 종료시간 =" + date); //권한
	}
	

	
	/*
	 * public void endlog() { System.out.println("메소드가 종료되었다."); }
	 */
}
