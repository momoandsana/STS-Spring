package web.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.mvc.service.ExceptionTestService;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ExceptionController {
	
	private final ExceptionTestService service;// @RequiredArgsConstructor 로 생성자 주입
	
	@RequestMapping(value="/exception.do")
	public String aa(String no) {
		log.info("no = {}",no);
		
		int convertNo=Integer.parseInt(no);
		log.info("convertNo = {}",convertNo);
		
		int result=100/convertNo;
		log.info("result = {}",result);
		
		return "result";// WEB-INF/views/result.jsp
	}
	
	@RequestMapping("/ageCheck.do")
	public String ageCheck(int age) {
		// 서비스 호출
		service.ageCheck(age);
		
		return "error/basicError";
	}
	
	@RequestMapping("/idCheck.do")
	public String idCheck(String id) {
		// 서비스 호출
		service.idCheck(id);
		
		return "error/basicError";
	}
	
	
	
	
	
	
	
	
	
	/*
	 * 현재 컨트롤러에서 NumberFormantException 에서 예외가 발생했을 때 
	 * 실행될 메소드 작성
	 * @ExceptionHandler는 2개 이상의 exception 처리 가능
	 * @ExceptionHandler 로 설정했기 때문에 이 컨트롤러에서만 사용 가능하고, 다른 컨트롤러에서는 사용하지 못한다
	 *
	 */
	@ExceptionHandler(value={NumberFormatException.class})
//	@ExceptionHandler(value={NumberFormatException.class,ArithmeticException.class})
	public ModelAndView exception(Exception e) {
		log.error("메시지 : {} ",e.getMessage());
		
		// 예외에 대한 로직 처리
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("error/numberError"); // WEB-INF/VIEWS/error/numberError.jsp
		
		mv.addObject("msg",e.getMessage());
		mv.addObject("errClass",e.getClass().getName());
		mv.addObject("statusCode",HttpStatus.EXPECTATION_FAILED);
		
		return mv;
	}
	
//	 @ExceptionHandler(ArithmeticException.class)
//	    public ModelAndView handleArithmeticException(ArithmeticException e) {
//	        log.error("메시지 : {} ", e.getMessage());
//
//	        ModelAndView mv = new ModelAndView();
//	        mv.setViewName("error/arithmeticError"); // WEB-INF/views/error/arithmeticError.jsp
//	        
//	        mv.addObject("msg", e.getMessage());
//	        mv.addObject("errClass", e.getClass().getName());
//	        mv.addObject("statusCode", HttpStatus.EXPECTATION_FAILED);
//	        
//	        return mv;
//	    }
}
