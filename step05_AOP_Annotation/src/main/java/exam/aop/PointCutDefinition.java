package exam.aop;

import org.aspectj.lang.annotation.Pointcut;

/*
 * pointcut 정의를 담당하는 클래스
 */
public class PointCutDefinition {
	@Pointcut("execution(public * exam.service.*.*(..))")
	public void aa() {}
	
	/*
	 * 로그기록하는 포인트컷
	 */
	@Pointcut("execution(public * exam.service.*Impl.read(..))")
	public void bb() {}
	
	/*
	 * 타이머 체크하는 포인트컷
	 */
	@Pointcut("execution(public void exam.service.*.write())")
	public void cc() {}
	
	
}
