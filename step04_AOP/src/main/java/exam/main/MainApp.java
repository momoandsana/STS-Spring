package exam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exam.service.CustomerService;


public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-aop.xml");
		
		System.out.println("-------------- 메소드 호출 ----------------");
		
		CustomerService service=context.getBean("target",CustomerService.class);
		
		service.select();
		System.out.println("-------------------------------------------------");
		service.selectById("id");
		System.out.println("-------------------------------------------------");
		service.update("id","name");
	
	}

}
