package web.mvc.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MyErrorException extends RuntimeException{
	private final ErrorInfo errorInfo;
}
