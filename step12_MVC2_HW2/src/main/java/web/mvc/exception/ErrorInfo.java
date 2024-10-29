package web.mvc.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter // status�� msg �� ���� getter
public enum ErrorInfo {
	
	DUPLICATE_CODE(601,"�ߺ��� �ڵ��Դϴ�"),
	
	INVALID_PRICE(602,"�������� ���� �����Դϴ�");
	
	private final int status;
	private final String msg;
	

}
