package web.mvc.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice // rest(json) �� ����ϴ� ��Ʈ�ѷ����� ���� exception ó��
@Slf4j
public class GlobalRestException {
	
	@ExceptionHandler(AjaxBasicException.class)
	public ResponseEntity<?> error(AjaxBasicException e)
	{
		log.error("ajax error....");
		
		log.error(e.getErrorInfo().getMsg());
		log.error("status : {}",e.getErrorInfo().getStatus());
		
		return ResponseEntity
				.status(e.getErrorInfo().getStatus())
				.body(e.getErrorInfo().getMsg());
	}
}
