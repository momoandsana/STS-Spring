package web.mvc.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
 * enum�� ���� ���õ� �������
 * �����Ͽ� ���ϰ� ����ϱ� ���� �ڷ���
 * �����ڵ�� ���ܸ޽����� �����ü�� ��������
 */
@RequiredArgsConstructor
@Getter // status�� msg �� ���� getter
public enum ErrorInfo {
	/*
	 * ���̰� 15���� �̸��� ��
	 */
	INVALID_AGE(600,"�̼����ڴ� �ȵ˴ϴ�"),// INVALID_AGE �̸��� ���� ���빰�� ������ ����
	
	/*
	 * ���̵� �ߺ��� ��
	 */
	DUPLICATE_ID(601,"�ߺ��� ���̵��Դϴ�");
	
	private final int status;
	private final String msg;
	
//	ErrorInfo(int status,String msg) {
//		this.status=status;
//		this.msg=msg;
//	};// @RequiredArgsConstructor �� ��ü ����
}
