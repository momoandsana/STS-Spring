package web.mvc.response;

import lombok.Getter;
import lombok.Setter;

//response�� �̸� scan�ϰ� ��ü�� ���� �ʿ䰡 �����Ƿ� component-scan �� ��� ���Ե��� �ʾƾ� �Ѵ�
//response �� ���� ����� �����
@Setter
@Getter
public class ResponseBodyDTO {
	private String msg;
	private int status;
	
	//�Ǵٸ� �Ӽ���
	
}
