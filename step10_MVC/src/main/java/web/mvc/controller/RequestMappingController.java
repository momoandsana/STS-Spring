package web.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // ����->���� ���� ��ΰ� component scan �� ������ �ִٸ�
@RequestMapping("/rem")// ��Ʈ�ѷ��� ���� ���� �ִٸ� �ĺ��ϱ� ���� �̷� namespace �ο�
// http://localhost:9000/controller/rem/a.do
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
	
	/*
	 * �������� ��û(b.do, or c.do ... )�� �ϳ��� �޼ҵ带 �����ؾ� �� ��
	 * @return : String �� ������ ���ڿ��� ���̸��� �ȴ�
	 */
	
	@RequestMapping({"/b.do","/c.do"})
	public String bb() {
		System.out.println("b.do c.do ��û");
		return "result"; // WEB-INF/views/result.jsp �� �̵�
	}
	
	/*
	 * ��û���(get,post,put,patch,delete) �� ����
	 * �޼ҵ尡 ����ǵ���
	 * 
	 * @return : void �� ��û�ּҰ� ���� �̸��� �ȴ�
	 * ex) /rem/test.do --> /WEB-INF/views/rem/test.jsp �� �̵�
	 */
	//@RequestMapping(value="/test.do")
	@PostMapping(value="/test.do")
	public void test1(HttpServletRequest request){
		// �ѱ��� ������ ����->���� ���
		String name=request.getParameter("name");
		System.out.println("RequestMappingController �� post test.do �� ��û��...  name : "+name);
		
		
	}
	
	@GetMapping(value="/test.do")
	public void test2(String name) {
		// ������ name="name" �� �����, String���� �ٷ� ���Ⱚ�� �޾Ƽ� ���
		//String name=request.getParameter("name");
		System.out.println("RequestMappingController �� get test.do �� ��û��... name : "+name);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
