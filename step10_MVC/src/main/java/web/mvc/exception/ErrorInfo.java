package web.mvc.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
 * enum은 서로 관련된 상수들을
 * 정의하여 편리하게 사용하기 위한 자료형
 * 예외코드와 예외메시지를 상수객체로 관리하자
 */
@RequiredArgsConstructor
@Getter // status와 msg 에 대한 getter
public enum ErrorInfo {
	/*
	 * 나이가 15보다 미만일 때
	 */
	INVALID_AGE(600,"미성년자는 안됩니다"),// INVALID_AGE 이름을 통해 내용물을 꺼내서 쓴다
	
	/*
	 * 아이디가 중복일 때
	 */
	DUPLICATE_ID(601,"중복된 아이디입니다");
	
	private final int status;
	private final String msg;
	
//	ErrorInfo(int status,String msg) {
//		this.status=status;
//		this.msg=msg;
//	};// @RequiredArgsConstructor 로 대체 가능
}
