package web.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder // ������ ����� ��, �ؿ� 2�� ������̼� �ʼ��� ���� �߰�
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private String code;
	private String name;
	private int price;
	private String detail;
	// id �� ������ �ִ� �Ӽ��� �ƴ�

}
