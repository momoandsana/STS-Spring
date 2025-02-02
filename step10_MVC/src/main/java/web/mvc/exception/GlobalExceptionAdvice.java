package web.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/*
 * 프로젝트 전체에서 발생하는 예외를
 * 모아서  처리하는 클래스(전역으로 처리하는 객체)
 */

@ControllerAdvice // 생성도 되면서 예외에 대한 처리를 담당, component-scan의 대상이 되어야 한다
@Slf4j
public class GlobalExceptionAdvice {
	/*
	 * 숫자로 변환 하려할 때 발생하는 예외처리
	 */
	@ExceptionHandler(value= {NumberFormatException.class})
	public ModelAndView error(NumberFormatException e) {
		log.error("숫자변환 오류...");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("error/numberError"); 
		// 미리 설정한 prefix & suffix 가 붙음. WEB-INF/VIEWS/error/numberError.jsp
		
		mv.addObject("msg","숫자변환 오류...");
		mv.addObject("errClass",e.getClass().getName());
		mv.addObject("statusCode",HttpStatus.EXPECTATION_FAILED);
		
		return mv;
	}
	
	
	
	/*
	 * 0으로 나눌 때 발생하는 에외처리
	 */
	@ExceptionHandler(value= {ArithmeticException.class})
	public ModelAndView error2(Exception e) {
		log.error("0으로 나누는 오류");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("error/numberError"); // WEB-INF/VIEWS/error/numberError.jsp
		
		mv.addObject("msg","0으로 나누는 오류");
		mv.addObject("errClass",e.getClass().getName());
		mv.addObject("statusCode",HttpStatus.EXPECTATION_FAILED);
		
		return mv;
	}
	
	/*
	 * 입력값이 충분하지 않을 때 발생하는 예외처리
	 */
//	@ExceptionHandler(value= {NumberFormatException.class})
//	public ModelAndView error3() {
//		
//		
//		return null;
//	}
	
	/*
	 * BasicException에 대한 처리
	 */
	@ExceptionHandler(value= {BasicException.class})
	public ModelAndView error3(BasicException e) {
		log.error("error3 : {}"+e.getErrorInfo().getMsg());
		// BasicException 안에 msg 랑 status 가 있음. 꺼내 쓰기
		// @ExcceptionHandler 쓰면 log.error 라고 해야지 에러 메시지가 콘솔에 나옴
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("error/basicError");
		mv.addObject("msg",e.getErrorInfo().getMsg());
		mv.addObject("status",e.getErrorInfo().getStatus());
		
		return mv;
	}
}














