package exam.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;



@Service("sampleAdvice")// 기본 생성 id="sampleAdvice"
@Aspect // 관심사항(공통관심사항)
@Order(1)
public class SampleAdvice {
	/*
	 * 사전처리
	 * joinpoint 는 target 대상, 즉 advice 적용하는 메소드의 정보를 조회할 수 있는 메소드 제공
	 */
	@Before("PointCutDefinition.aa()")
	public void before(JoinPoint joinPoint) {
		String methodName=joinPoint.getSignature().getName();
		System.out.println(methodName+"호출되기 전 before 의 사전처리입니다\n");
		
	}
	
	/*
	 * 사후처리 : 예외발생여부 상관없이 무조건
	 */
	@After("PointCutDefinition.aa()")
	public void afterFinally() {
		System.out.println("예외발생 여부 상관없이 무조건 사후처리입니다\n");
	}
	
	/*
	 * 사후처리 : 예외발생없이 정상동작했을 때
	 */
	@AfterReturning(pointcut="PointCutDefinition.aa()",returning="returnObj")
	public void afterReturning(JoinPoint joinPoint,Object returnObj) {
		// return 값을 받아와서 사용하고 싶으면, returnObj 로 받아오기, xml 파일에도 returning 설정해주기
		
		String methodName=joinPoint.getSignature().getName();
		
		System.out.println("afterReturning() 정상작동했을 때 사후처리입니다");
		System.out.println(methodName+"의 리턴값은 "+returnObj+"\n");
	}
	
	/*
	 * 사후처리 : 예외발생했을 때
	 */
	@AfterThrowing(pointcut="PointCutDefinition.aa()",throwing = "e")
	public void afterThrowing(Throwable e) {
		// object-throwable-exception-runtime,check 상속 순서
		System.out.println("afterThrowing() 예외가 발생했을 때 사후처리입니다");
		System.out.println("예외정보 : "+e+"\n");//e.toString 이 호출된다
	}
}












