package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public void login() {
		// �ڵ����� login.jsp �� ��ȯ�Ǿ� ����. �������� ������ �����Ͱ� ������ (Model model) �� �μ��� �޾Ƽ� model.addAttribute()�� ���빰 ä���
	}

}
