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
	
	private final ExceptionTestService service;// @RequiredArgsConstructor �� ������ ����
	
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
		// ���� ȣ��
		service.ageCheck(age);
		
		return "error/basicError";
	}
	
	@RequestMapping("/idCheck.do")
	public String idCheck(String id) {
		// ���� ȣ��
		service.idCheck(id);
		
		return "error/basicError";
	}
	
	
	
	
	
	
	
	
	
	/*
	 * ���� ��Ʈ�ѷ����� NumberFormantException ���� ���ܰ� �߻����� �� 
	 * ����� �޼ҵ� �ۼ�
	 * @ExceptionHandler�� 2�� �̻��� exception ó�� ����
	 * @ExceptionHandler �� �����߱� ������ �� ��Ʈ�ѷ������� ��� �����ϰ�, �ٸ� ��Ʈ�ѷ������� ������� ���Ѵ�
	 *
	 */
	@ExceptionHandler(value={NumberFormatException.class})
//	@ExceptionHandler(value={NumberFormatException.class,ArithmeticException.class})
	public ModelAndView exception(Exception e) {
		log.error("�޽��� : {} ",e.getMessage());
		
		// ���ܿ� ���� ���� ó��
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("error/numberError"); // WEB-INF/VIEWS/error/numberError.jsp
		
		mv.addObject("msg",e.getMessage());
		mv.addObject("errClass",e.getClass().getName());
		mv.addObject("statusCode",HttpStatus.EXPECTATION_FAILED);
		
		return mv;
	}
	
//	 @ExceptionHandler(ArithmeticException.class)
//	    public ModelAndView handleArithmeticException(ArithmeticException e) {
//	        log.error("�޽��� : {} ", e.getMessage());
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