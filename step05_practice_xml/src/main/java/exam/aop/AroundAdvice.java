package exam.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

/*
 * 사전,사후 처리
 */
@Service("aroundAdvice") // 기본 생성 id="timerAdvice" 근데 advice로 바꿈
@Aspect // 관심사항(공통관심사항) --> <aop:aspect ref="advice" 랑 같은 역할
public class AroundAdvice {
	@Around("execution(* exam.service.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint)throws Throwable
	{
		// 사전
		System.out.println("AroundAdvice의 around 방식의 사전처리입니다\n");
		
		
		Object obj=joinPoint.proceed();
		
		// 사후
		System.out.println("AroundAdvice의 around 방식의 사후처리입니다\n");
		
		return obj;
	}
	
	
}
