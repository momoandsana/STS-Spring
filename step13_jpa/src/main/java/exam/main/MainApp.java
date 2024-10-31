package exam.main;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import exam.domain.Customer;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("** JPA 시작하기 **");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");// persistence.xml 에 unitname 있음

		EntityManager em = emf.createEntityManager();
		EntityTransaction ex = em.getTransaction();
		ex.begin();
		// 등록
//		em.persist(Customer.builder().userName("희정3").age(20).birthDay(new Date()).build()); // insert 쿼리 생성
//		em.persist(Customer.builder().userName("나영3").age(22).birthDay(new Date()).build()); 
//		em.persist(Customer.builder().userName("미미3").age(24).birthDay(new Date()).build()); 
//		
//		em.persist(Employee.builder().ename("ename11").job("job1").build());
//		em.persist(Employee.builder().ename("ename22").job("job2").build());

		// em.persist(Customer.builder().userName("하하2").age(21).birthDay(new
		// Date()).build());
		// 여기서 중복한 내용을 추가하면 위에 내용도 모두 롤백

		// em.persist(Employee.builder().ename("test").build());

		//em.persist(Employee.builder().ename("test2").build());
		// emp 에서 @DynamicInsert 어노테이션 넣으면 job에 대한 쿼리가 안 날라감
		/*
		 * insert into emp (ename, empno) values (?, ?)
		 */
		
		// 조회
		//Customer cu = em.find(Customer.class, 2L); // Long 타입이기 때문에 2L
		//
		// 찾은 객체를 수정, 만약에 변경할 내용이 없다면 update 문이 나가지 않는다
		// 만약에 customer 객체에 @DynamicUpdate 가 없다면 하나만 바꿔도 전체 업데이트지만, 있다면 수정 부분만 변경
		//cu.setAge(27);
		//cu.setUserName("효민");
		
		// 동일성 보장
//		Customer cu = em.find(Customer.class, 2L);
//		System.out.println("cu = "+cu);
//		
//		System.out.println("---------------");
//		Customer cu2 = em.find(Customer.class, 2L);
//		System.out.println("cu2 = "+cu2); 
		/*
		 * 이미 앞에서 찾은 객체는 1차 캐시에 저장이 되므로(같은 2L 이니까)
		 * 다시 select 문으로 디비에서 데이터를 가지고 오지 않고 캐시에서 값을 꺼내서 사용
		 */
		
		//삭제
//		Customer cu=em.find(Customer.class, 2L);
//		em.remove(cu);
		
		/*
		 * 다양한 조건의 쿼리를 작성하고 싶다. - 직접 쿼리를 작성해야한다
		 * JPQL 문법을 이용해서 엔티티 즉, 객체중심으로 쿼리를 작성할 수 있다
		 * 특정 디비에 종속적이지 않다는 장점이 있다
		 */
		
		/*
		 * 1. 나는 나이가 22살 이상인 정보를 검색하고 싶다
		 * jpql 쓰면 무조건 flush 가 일어남->커밋과 관계없이 디비에 들어간다
		 */
		//String sql="select c from Customer c where c.age>22";
//		String sql="select c from Customer c where c.userName like '%희%'";
//		List<Customer> list=em.createQuery(sql,Customer.class).getResultList();
//		for(Customer cu:list)
//		{
//			System.out.println(cu);
//		}
		
		
		// 파라미터로 전달된 값을 조건으로 사용하고 싶다
//		String sql="select c from Customer c where c.userName like ?1 or c.age>?2";
//		// ? 랑 인덱스 번호가 필요함
//		
//		List<Customer> list=em.createQuery(sql,Customer.class)
//				.setParameter(1, "%희%")
//				.setParameter(2,22)
//				.getResultList();
//		
//		for(Customer cu:list)
//		{
//			System.out.println(cu);
//		}
		
		
		String sql="select c from Customer c where c.userName like :name or c.age>:age";
		// :name, :age 변수 사용, 밑에서 바인딩
		
		List<Customer> list=em.createQuery(sql,Customer.class)
				.setParameter("name", "%희%")
				.setParameter("age",22)
				.getResultList();
		
		for(Customer cu:list)
		{
			System.out.println(cu);
		}
		/*
		 * 값을 변경한다면 커밋하는 순간에 
		 * 1차 캐시에서 스냅샷과 비교해서 쿼리를 날리지 말지 결정한다
		 * 알아서 변경감지를 하기 때문에 update 문장이 따로 없다
		 */
		
		
		

		ex.commit();

		em.close();
		emf.close();

		System.out.println("** JPA 끝 **");
	}

}
