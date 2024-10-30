package web.mvc.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter // status와 msg 에 대한 getter
public enum ErrorInfo {
	
	DUPLICATE_CODE(601,"중복된 코드입니다"),
	
	INVALID_PRICE(602,"적절하지 않은 가격입니다");
	
	// int status 가 먼저 선언되었으므로 메시지의 601 과 매치
	// 그 다음 msg 가 선언되었으므로 "msg" 와 매치
	
	private final int status;
	private final String msg;
	

}
