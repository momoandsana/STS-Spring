package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // ����->���� ���� ��ΰ� component scan �� ������ �ִٸ�
@RequestMapping("/rem")// ��Ʈ�ѷ��� ���� ���� �ִٸ� �ĺ��ϱ� ���� �̷� namespace �ο�
public class RequestMappingController {
	
	@RequestMapping("/a.do")// �޼ҵ� �̸��� �߿�x, url ���� ã�ƿ�
	public ModelAndView aaa() {
		System.out.println("RequestMappingController�� aaa() ȣ���");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("result"); 
		// /WEB-INF/views/result.jsp -> prefix+���̸�+suffix �� �̵��Ѵ�
		mv.addObject("name","hee jung");// �信�� ${name} or ${requestScope.name} ���� ��ȸ ����
		return mv;
	}
}
