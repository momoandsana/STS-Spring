package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 생성->여기 파일 경로가 component scan 의 범위에 있다면
@RequestMapping("/rem")// 컨트롤러가 여러 개가 있다면 식별하기 위해 이런 namespace 부여
public class RequestMappingController {
	
	@RequestMapping("/a.do")// 메소드 이름은 중요x, url 보고 찾아옴
	public ModelAndView aaa() {
		System.out.println("RequestMappingController의 aaa() 호출됨");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("result"); 
		// /WEB-INF/views/result.jsp -> prefix+뷰이름+suffix 로 이동한다
		mv.addObject("name","hee jung");// 뷰에서 ${name} or ${requestScope.name} 으로 조회 가능
		return mv;
	}
}
