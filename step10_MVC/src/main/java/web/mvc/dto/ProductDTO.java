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
@Builder // 생성자 만들어 줌, 밑에 2개 어노테이션 필수로 같이 추가
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private String code;
	private String name;
	private int price;
	private String detail;
	// id 는 가지고 있는 속성이 아님

}
