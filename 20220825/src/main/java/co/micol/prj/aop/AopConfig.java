package co.micol.prj.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//자바기반 AOP 설정
@Configuration // java 환경설정 파일을 나타낸다.
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfig {
	@Bean
	public AopAdvice beforAdvice() { // 클래스를 빈으로 등록하겠다. [xml]
		return new AopAdvice(); // 클래스는 생성자를 만들어줘야함 //<aop:aspectj-autoproxy proxy-target-class="true" />
														   //<bean class="co.micol.prj.aop.AopAdvice" id="aopAdvice"> </bean> <!-- 풀 패키지명을 포함하여 정확한 클래스명 작성함 -->
	}
}
