package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller// ����, component scan ����� �Ǿ�� ����
@RequestMapping("/param")
@Slf4j // lombok ���� �����ϴ� logger�� �������ִ� ����
public class ParameterController {
	
	@RequestMapping("/a.do")
	public String aa(String name,int age) {
		// param/a.do?name=jang&age=20
		System.out.println();
		
		log.info("name = {} // age={} ",name,age);
		return "result";// prefix+result+suffix(.jsp)-> /WEB-INF/views/result.jsp
	}

}
