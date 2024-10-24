package exam.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

public class LogAdvice {
	
	
	public Object around(ProceedingJoinPoint joinPoint)throws Throwable
	{
		// 사전
		System.out.println(joinPoint.getTarget().getClass().getSimpleName()+" start(int volumn) 호출\n");
		
		
		Object obj=joinPoint.proceed();
		
		
		// 사후
		System.out.println(joinPoint.getTarget().getClass().getSimpleName()+" stop(int volumn) 호출\n");
		
		return obj;
	}
}
