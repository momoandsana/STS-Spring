package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	
	@RequestMapping("/register")
	String registerForm() {
		return "register";
	}
	
	@RequestMapping("/personal")
	String personal() {
		return "personal/personal";
	}
}
