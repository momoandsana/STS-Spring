package web.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;


@ControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {
	
	
	@ExceptionHandler(value= {MyErrorException.class})
	public ModelAndView error4(MyErrorException e)
	{
		log.info("error3 : {}"+e.getErrorInfo().getMsg());
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("error");
		mv.addObject("errMsg",e.getErrorInfo().getMsg());
		mv.addObject("errStatus",e.getErrorInfo().getStatus());
		
		return mv;
	}
}














