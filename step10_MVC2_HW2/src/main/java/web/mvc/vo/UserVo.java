package web.mvc.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter// 값들이 set으로 들어감
@ToString
public class UserVo {
	private String id;
	private String name;
	private int age;
	private String addr;
}
