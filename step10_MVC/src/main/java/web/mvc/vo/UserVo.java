package web.mvc.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter// ������ set���� ��
@ToString
public class UserVo {
	private String id;
	private String name;
	private int age;
	private String addr;
}
