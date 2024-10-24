package exam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exam.service.AudioImpl;
import exam.service.Player;
import exam.service.TvImpl;
import exam.service.VedioImpl;


public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-aop.xml");
		
		System.out.println("-------------- 메소드 호출 ----------------");
		
		Player service1=context.getBean("audio",AudioImpl.class);
		Player service2=context.getBean("Tv",TvImpl.class);
		Player service3=context.getBean("video",VedioImpl.class);
		
		service1.start(1);
		service1.pause();
		service1.stop();
		
		service2.start(2);
		service2.pause();
		service2.stop();
		
		service3.start(3);
		service3.pause();
		service3.stop();
	
	}

}
