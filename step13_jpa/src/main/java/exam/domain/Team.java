package exam.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "memberList") // 지연로딩이지만 ToString 이랑 memberList 가 있으므로 join은 안 하지만 select 문이 2번 나감
public class Team {
	@Id // pk
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_pk_seq")
	@SequenceGenerator(name = "team_pk_seq", sequenceName = "team_pk_seq", allocationSize = 1) // 1씩 증가. 오라클에 시퀀스 이름
																								// team_pk_seq
	private Long teamId;

	@Column(nullable = false, length = 100) // not null;
	private String teamName;

	/*
	 * Member 가 Team 의 pk 를 fk 를 가지고 있고 Team은 Member에 대한 정보가 없으므로 fk 가 없으므로
	 * mappedBy가 필요-> Team 에서 Member를 조회하고 싶다면 조회할 일이 없다면 필요없음 밑에 코드는 양쪽으로 조회해야 하는
	 * 일이 있을 때만 사용한다
	 * 
	 * <Member 코드에서 team>
	 * 
	 * team 을 mappedBy 로 사용
	 * 
	 * @ManyToOne(fetch=FetchType.LAZY)
	 * @JoinColumn(name="tid") 
  	 * private Team team;
	 */

	/*
	 * 
	 * /** cascade는 Entity 의 상태변화가 생기면 연관관계 있는 Entity도 상태변화를 전이시키는 옵션
	 * CascadeType.ALL: 모든 CascadeType을 적용 
	 * CascadeType.PERSIST: 부모 엔티티를 저장할 때 연관된 자식 엔티티도 함께 저장 
	 * CascadeType.MERGE: 부모 엔티티를 병합할 때 연관된 자식 엔티티도 함께 병합
	 * CascadeType.REMOVE: 부모 엔티티를 삭제할 때 연관된 자식 엔티티도 함께 삭제 
	 * CascadeType.REFRESH: 부모 엔티티를 새로 고칠 때 연관된 자식 엔티티도 함께 새로 고침 
	 * CascadeType.DETACH: 부모 엔티티를 분리할 때 연관된 자식
	 * 엔티티도 함께 분리
	 * 
	 */
	
	// @OneToMany(mappedBy = "team")// 기본 fetch 타입 기본이 lazy, 미리 조인하지 않는다
	@OneToMany(mappedBy = "team", fetch = FetchType.EAGER,cascade=CascadeType.REMOVE)// 팀 삭제하면 자식(멤버)도 같이 삭제
	private List<Member> memberList;

}
