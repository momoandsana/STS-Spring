package web.mvc.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //final을 기반으로 생성자 추가
@Getter // getErrorInfo();
public class BasicException extends RuntimeException{
	private final ErrorInfo errorInfo;
}
