package web.mvc.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import web.mvc.response.ResponseBodyDTO;

@RestControllerAdvice // rest(json) �� ����ϴ� ��Ʈ�ѷ����� ���� exception ó��
@Slf4j
public class GlobalRestException {
	
	@ExceptionHandler(MyErrorException.class)
	public ResponseEntity<?> error(MyErrorException e)
	{
		log.error("ajax error....");
		
		log.error(e.getErrorInfo().getMsg());
		log.error("status : {}",e.getErrorInfo().getStatus());
		
		//���ʿ� ������ ���䵥���Ͱ� ���� ���� ���-��ü�� ���� ��ü�� ������
		ResponseBodyDTO dto=new ResponseBodyDTO();
		dto.setMsg(e.getErrorInfo().getMsg());
		dto.setStatus(e.getErrorInfo().getStatus());
		
		return ResponseEntity
				.status(e.getErrorInfo().getStatus())
				//.body(e.getErrorInfo().getMsg());
				.body(dto); // dto�� �����ϱ� json���� �Ѿ��
	}
}
