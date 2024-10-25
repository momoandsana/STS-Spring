package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // lombok �� �ִ� ���̺귯��
public class HomeController {
	@RequestMapping("/")
	public String home(){
		log.info("/�� ��û�Ǿ����ϴ�"); 
		// log level �� info�� �����Ǿ� ���� �� info�� ���, src/main/resources�� log4j.xml ���Ͽ� ������ �Ѵ�
		System.out.println("HomeController ȣ��");
		return "index";
	}
}
