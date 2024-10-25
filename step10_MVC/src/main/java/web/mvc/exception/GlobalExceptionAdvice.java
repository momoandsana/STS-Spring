package web.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/*
 * ������Ʈ ��ü���� �߻��ϴ� ���ܸ�
 * ��Ƽ�  ó���ϴ� Ŭ����(�������� ó���ϴ� ��ü)
 */

@ControllerAdvice // ������ �Ǹ鼭 ���ܿ� ���� ó���� ���, component-scan�� ����� �Ǿ�� �Ѵ�
@Slf4j
public class GlobalExceptionAdvice {
	/*
	 * ���ڷ� ��ȯ �Ϸ��� �� �߻��ϴ� ����ó��
	 */
	@ExceptionHandler(value= {NumberFormatException.class})
	public ModelAndView error(NumberFormatException e) {
		log.error("���ں�ȯ ����...");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("error/numberError"); 
		// �̸� ������ prefix & suffix �� ����. WEB-INF/VIEWS/error/numberError.jsp
		
		mv.addObject("msg","���ں�ȯ ����...");
		mv.addObject("errClass",e.getClass().getName());
		mv.addObject("statusCode",HttpStatus.EXPECTATION_FAILED);
		
		return mv;
	}
	
	
	
	/*
	 * 0���� ���� �� �߻��ϴ� ����ó��
	 */
	@ExceptionHandler(value= {ArithmeticException.class})
	public ModelAndView error2(Exception e) {
		log.error("0���� ������ ����");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("error/numberError"); // WEB-INF/VIEWS/error/numberError.jsp
		
		mv.addObject("msg","0���� ������ ����");
		mv.addObject("errClass",e.getClass().getName());
		mv.addObject("statusCode",HttpStatus.EXPECTATION_FAILED);
		
		return mv;
	}
	
	/*
	 * �Է°��� ������� ���� �� �߻��ϴ� ����ó��
	 */
//	@ExceptionHandler(value= {NumberFormatException.class})
//	public ModelAndView error3() {
//		
//		
//		return null;
//	}
	
	/*
	 * BasicException�� ���� ó��
	 */
	@ExceptionHandler(value= {BasicException.class})
	public ModelAndView error3(BasicException e) {
		log.info("error3 : {}"+e.getErrorInfo().getMsg());
		// BasicException �ȿ� msg �� status �� ����. ���� ����
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("error/basicError");
		mv.addObject("msg",e.getErrorInfo().getMsg());
		mv.addObject("status",e.getErrorInfo().getStatus());
		
		return mv;
	}
}














