package testJava;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// spring 컨테이너 구동
		// 추상클래스나 인터페이스는 자기자신을 초기화 할 수 없음 
		// 컨테이너를 구축하면 bean이 올라감!
		AbstractApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml"); // resources에 만들어놓은 xml 파일명 넣기
		
		/*
		 * TV tv = (TV) context.getBean("samsungTV"); // context안에서 getBean(id)
		 * tv.powerOn(); tv.powerOff(); tv.volumeUp(); tv.volumeDown();
		 */
		
		/* 생성자에 의한 의존성 주입방법(DI)
		 * LgTV tv = (LgTV) context.getBean("lgTV"); // context안에서 getBean(id)
		 * tv.getTv().powerOn();
		 * 
		 * LgTV tv1 = new LgTV((TV) context.getBean("samsungTV"));
		 */
		
		//setter에 의한 의존성 주입방법(DI)
		LgTV tv = (LgTV) context.getBean("lgTV");
		tv.getTv().powerOff();
	}
}
