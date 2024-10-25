package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TestController {
	
	@RequestMapping("/test2.do")
	public String test2(String no) {
		log.info("test2.do ø‰√ªµ ");
		int convertNo=Integer.parseInt(no);
		
		
		
		return "result";
	}
}
