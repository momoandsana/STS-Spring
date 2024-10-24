package web.mvc.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller// 생성, component scan 대상이 되어야 가능
@RequestMapping("/param")
@Slf4j // lombok 에서 제공하는 logger를 생성해주는 역할
public class ParameterController {
	
	@RequestMapping("/a.do")
	public String aa(String name,Integer age) {
		// param/a.do?name=jang&age=20
		// 만약에 Integer가 아니라 int라면 null 이 들어가지 못하므로 에러가 생길 수도 있다
		
		System.out.println();
		
		log.info("name = {} // age={} ",name,age);
		return "result";// prefix+result+suffix(.jsp)-> /WEB-INF/views/result.jsp
	}
	
	/*
	 * void 는 요청주소가 뷰이름이 된다.
	 * WEB-INF/param/b.jsp
	 */
	@RequestMapping("/b.do")
	public void bb(Model model,// Model 은 스프링에서 넣어줌
			@RequestParam(defaultValue="guest",value="userId") String id,//클라이언트에서 id="name"이 아니라 userId="name" 으로 보낼거임
			@RequestParam(defaultValue="0") int age) {
		// 인수 Model 은 뷰쪽으로 전달될 데이터, age에 값이 안 들어온다면 기본값을 0으로 설정
		
		log.info("id = {} // age={}",id,age);
		
		model.addAttribute("list",Arrays.asList("사과","딸기","배","바나나")); // 뷰에서 ${list}
		
	}

}
