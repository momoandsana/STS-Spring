package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public void login() {
		// 자동으로 login.jsp 가 반환되어 전달. 뷰쪽으로 전달할 데이터가 있으면 (Model model) 을 인수로 받아서 model.addAttribute()로 내용물 채우기
	}

}
