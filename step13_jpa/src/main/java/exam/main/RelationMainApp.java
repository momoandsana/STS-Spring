package exam.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import exam.domain.Member;
import exam.domain.Team;

public class RelationMainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("** JPA 시작하기 **");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");// persistence.xml 에 unitname 있음

		EntityManager em = emf.createEntityManager();
		EntityTransaction ex = em.getTransaction();
		ex.begin();

		// Team 등록
//		Team t1=Team.builder().teamName("team01").build();
//		Team t2=Team.builder().teamName("team02").build();
//		Team t3=Team.builder().teamName("team03").build();
//		
//		em.persist(t1);
//		em.persist(t2);
//		em.persist(t3);
//		
//		//Member 등록
//		em.persist(Member.builder().name("희정").age(25).team(t1).build());
//		em.persist(Member.builder().name("나영").age(26).team(t1).build());
//		em.persist(Member.builder().name("효리").age(27).team(t1).build());
//		
//		em.persist(Member.builder().name("미미").age(17).team(t2).build());
//		em.persist(Member.builder().name("하하").age(47).team(t2).build());
//		
//		em.persist(Member.builder().name("삼순").age(56).team(t3).build());
//		em.persist(Member.builder().name("삼식").age(24).team(t3).build());

		// 회원검색
		//Member member = em.find(Member.class, 2L);
		/*
		 * pk가 2인 Long이기 때문에 2L, 멤버 꺼내 올려면 constructor가 필요->롬복 어노테이션 필요 Member에
		 * 
		 * Member 안에 Team 도 있기 때문에 알아서 Team 을 조인해서 Team 에 대한 정보도 가지고 옴 Member : Team
		 * 은 @ManyToOne 관계이기 때문에 FetchType을 LAZY 로 하면 조인해서 팀 정보를 가지고 오는 것이 아니라 select 문이
		 * team에 대해서 한 번 더 돌아 Member 의 ToString에서 team에 대한 정보를 요구하기 때문이다 즉시로딩은 무조건 조인해서
		 * 가지고 옴
		 * 
		 * 지연로딩을 하면 프록시(가짜)를 만들어 미리 데이터를 채워두고 진자 필요한 순간에 쿼리한다
		 */

//		System.out.println(member);// Member 에 ToString 필요. 주소가 아니라 내용물 보고 싶다면
//
//		System.out.println("***********************");
//		Team t = member.getTeam();
//		System.out.println("t = " + t);

		/*
		 * select * from member join team on member.tid=team.teamid and memberid=2;
		 * 
		 * select * from team join member on member.tid=team.teamid and memberid=2;
		 * 
		 * 이거 2개는 결과적으로 같은 쿼리임(디비에서는)
		 */
		
		// 팀 검색 하면서 팀에 소속된 회원도 검색하고 싶다
//		Team t=em.find(Team.class, 1L);
//		System.out.println(t);
//		
//		System.out.println("------------------------------------------");
//		System.out.println(t.getMemberList());
		
		// 삭제
//		Member m=em.find(Member.class, 2L); // 멤버 삭제는 그냥도 가능
//		em.remove(m);
		
		//참조되고 있는 부모키를 삭제
		Team team=em.find(Team.class, 1L);// 자식 레코드(참조하고 있는 레코드) 가 있으므로 삭제 불가능
		em.remove(team);
		
		

		ex.commit();// 자동 flush 포함

		em.close();
		emf.close();

		System.out.println("** JPA 끝 **");
	}

}
