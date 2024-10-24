package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller// 생성, component scan 대상이 되어야 가능
@RequestMapping("/param")
@Slf4j // lombok 에서 제공하는 logger를 생성해주는 역할
public class ParameterController {
	
	@RequestMapping("/a.do")
	public String aa(String name,int age) {
		// param/a.do?name=jang&age=20
		System.out.println();
		
		log.info("name = {} // age={} ",name,age);
		return "result";// prefix+result+suffix(.jsp)-> /WEB-INF/views/result.jsp
	}

}
