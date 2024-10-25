package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // lombok 에 있는 라이브러리
public class HomeController {
	@RequestMapping("/")
	public String home(){
		log.info("/가 요청되었습니다"); 
		// log level 이 info로 설정되어 있을 때 info가 출력, src/main/resources의 log4j.xml 파일에 설정을 한다
		System.out.println("HomeController 호출");
		return "index";
	}
}
