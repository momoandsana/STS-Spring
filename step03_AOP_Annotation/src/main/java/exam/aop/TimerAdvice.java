package exam.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

/*
 * 공통관심사항(사전, 사후처리- around 방식)
 * -사전 : 현재시간을 구한다
 * -사후 : 현재시간을 구해서 사전의 현재시간을 뺀다
 * 
 * @param: ProceedingJoinPoint - proceed() 메소드를 호출하기 위해 인수로 전달
 * (Proceed with the next advice or target method invocation)
 */

@Service("advice") // 기본 생성 id="timerAdvice" 근데 advice로 바꿈
@Aspect // 관심사항(공통관심사항) --> <aop:aspect ref="advice" 랑 같은 역할
public class TimerAdvice {
	
	/*
	 * (*) 별 정리
	 * 첫 번째 별 : 반환타입
	 * 두 번째 별 : 클래스 이름
	 * 세 번째 별 : 메소드 이름
	 * (..) : 인수가 있는 경우
	 * () : 인수가 없는 경우
	 * 
	 *  execution 은 함수가 호출될 때 포인트컷을 설정
	 */
	@Around("execution(* exam.service.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint)throws Throwable
	{
		// 사전 
		String methodName=joinPoint.getSignature().getName();
		
		Object[] params=joinPoint.getArgs();
		System.out.println("[LOG]"+methodName+"호출되기 전 사전 처리중입니다");
		System.out.println("[LOG]"+methodName+"의 인수의 개수"+params.length);
		
		for(Object param:params)
		{
			System.out.println(param);
		}
		
		StopWatch sw=new StopWatch();
		sw.start();
			
		Object obj=joinPoint.proceed(); 
		// 다음 target 대상 호출(다른 advice or joinPoint=핵심기능), 로그가 아닌 실제로 실행되는 기능
		
		// 사후
		sw.stop();
		System.out.println("[LOG] "+methodName+"의 리턴값 = "+obj);
		System.out.println("[LOG] "+methodName+"총 실행시간 ms "+sw.getTotalTimeMillis());
		System.out.println("[LOG] "+methodName+"사후처리 완료되었습니다");
		
		return obj;
	}
	

}
