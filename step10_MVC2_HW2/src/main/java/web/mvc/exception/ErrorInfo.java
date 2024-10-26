package web.mvc.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter // status와 msg 에 대한 getter
public enum ErrorInfo {
	
	DUPLICATE_CODE(601,"중복된 코드입니다"),
	
	INVALID_PRICE(602,"적절하지 않은 가격입니다");
	
	private final int status;
	private final String msg;
	

}
