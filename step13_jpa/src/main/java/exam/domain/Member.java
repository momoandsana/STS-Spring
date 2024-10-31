package exam.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * member 대 team 은 1대 다
 */

@Entity
@Getter
@Setter
@Builder
@ToString(exclude="team") // @ToString 무의식적으로 추가하면 team 같이 연관된 데이터 모두 불러옴
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="member_pk_seq")// 시퀀스 전략 생성
	@SequenceGenerator(name="member_pk_seq",sequenceName="member_pk_seq",allocationSize=1)// 위에서 만든 시퀀스 전략 사용
	private Long memberId;
	
	private String name;
	private int age;
	
	/*
	 * 연관관계가 있을 때 fetch 전략을 통해
	 * 지연로딩 or 즉시로딩할 수 있다
	 * lazy vs eager
	 * 
	 * @ManyToOne : 기본 즉시로딩 (미리 조인을 해서 가지고 옴)
	 * @OneToMany : 기본 지연로딩->가지고 올 내용이 많으니까
	 */
	
	// 한 명의 Member 의 하나의 팀에 소속될 수 있다
	@ManyToOne(fetch=FetchType.LAZY) // 연관관계 세팅(fk 설정 기본컬러명-entity이름_참조pk)->TEAM_TEAMID
	@JoinColumn(name="tid")// TEAM_TEAMID->tid 컬럼이름 변경하고 싶을 때 사용(fk 이름 변경하고 싶을 때), 디비에 들어가는 컬럼이름
	private Team team;
}
