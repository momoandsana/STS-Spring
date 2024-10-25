package web.mvc.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //final�� ������� ������ �߰�
@Getter // getErrorInfo();
public class BasicException extends RuntimeException{
	private final ErrorInfo errorInfo;
}
