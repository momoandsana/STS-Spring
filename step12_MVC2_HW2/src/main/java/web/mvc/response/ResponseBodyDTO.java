package web.mvc.response;

import lombok.Getter;
import lombok.Setter;

//response는 미리 scan하고 객체를 만들 필요가 없으므로 component-scan 의 대상에 포함되지 않아야 한다
//response 할 일이 생기면 만들기
@Setter
@Getter
public class ResponseBodyDTO {
	private String msg;
	private int status;
	
	//또다른 속성들
	
}
