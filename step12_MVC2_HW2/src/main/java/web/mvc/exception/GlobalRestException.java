package web.mvc.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import web.mvc.response.ResponseBodyDTO;

@RestControllerAdvice // rest(json) 을 사용하는 컨트롤러에서 생긴 exception 처리
@Slf4j
public class GlobalRestException {
	
	@ExceptionHandler(MyErrorException.class)
	public ResponseEntity<?> error(MyErrorException e)
	{
		log.error("ajax error....");
		
		log.error(e.getErrorInfo().getMsg());
		log.error("status : {}",e.getErrorInfo().getStatus());
		
		//뷰쪽에 전달할 응답데이터가 여러 개인 경우-객체를 만들어서 객체로 보낸다
		ResponseBodyDTO dto=new ResponseBodyDTO();
		dto.setMsg(e.getErrorInfo().getMsg());
		dto.setStatus(e.getErrorInfo().getStatus());
		
		return ResponseEntity
				.status(e.getErrorInfo().getStatus())
				//.body(e.getErrorInfo().getMsg());
				.body(dto); // dto로 보내니까 json으로 넘어간다
	}
}
