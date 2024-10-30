package exam.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity // jpa가 관리하는 객체
@Table(name="emp") //테이블이름. 원래는 클래스 이름으로 테이블이 만들어진다
@Setter
@Getter
@AllArgsConstructor
@Builder
@DynamicInsert
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="emp_empno_seq")
	@SequenceGenerator(name="emp_empno_seq",sequenceName="emp_empno_seq",allocationSize=1)
	//@GeneratedValue(strategy=GenerationType.AUTO) 
	// auto는 hibernation이 엔티티의 기본키를 생성함, 엔티티가 2개여도 기본키는 하나로 처리한다
	private Long empno;
	private String ename;
	private String job;
}
