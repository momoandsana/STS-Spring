package exam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exam.service.BoardService;
import exam.service.MemberService;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-aop.xml");
		
		System.out.println("-------------- 메소드 호출 ----------------");
		MemberService service=context.getBean("target",MemberService.class);
		BoardService service2=context.getBean("target2",BoardService.class);
		// 여기서는 빈의 id 이름과 인터페이스 이름이 들어간다
		
		service.memberInsert("희정");
		System.out.println("------------------------------------------");
		
		service.memberUpdate();
		System.out.println("------------------------------------------");
		
		int re=service.memberDelete(5);
		System.out.println("리턴 결과 : "+re);
		System.out.println("------------------------------------------");
		
		String s=service.select("name","효리");
		System.out.println("리턴 결과 : "+s);
		System.out.println("------------------------------------------");
		
		service2.insert("name");
	}

}
