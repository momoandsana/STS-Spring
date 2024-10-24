package web.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 생성->여기 파일 경로가 component scan 의 범위에 있다면
@RequestMapping("/rem")// 컨트롤러가 여러 개가 있다면 식별하기 위해 이런 namespace 부여
// http://localhost:9000/controller/rem/a.do
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
	
	/*
	 * 여러개의 요청(b.do, or c.do ... )이 하나의 메소드를 실행해야 할 때
	 * @return : String 은 리턴한 문자열이 뷰이름이 된다
	 */
	
	@RequestMapping({"/b.do","/c.do"})
	public String bb() {
		System.out.println("b.do c.do 요청");
		return "result"; // WEB-INF/views/result.jsp 로 이동
	}
	
	/*
	 * 요청방식(get,post,put,patch,delete) 에 따라
	 * 메소드가 실행되도록
	 * 
	 * @return : void 는 요청주소가 뷰의 이름이 된다
	 * ex) /rem/test.do --> /WEB-INF/views/rem/test.jsp 로 이동
	 */
	//@RequestMapping(value="/test.do")
	@PostMapping(value="/test.do")
	public void test1(HttpServletRequest request){
		// 한글이 깨지는 현상->필터 사용
		String name=request.getParameter("name");
		System.out.println("RequestMappingController 의 post test.do 가 요청됨...  name : "+name);
		
		
	}
	
	@GetMapping(value="/test.do")
	public void test2(String name) {
		// 폼에서 name="name" 인 경우임, String으로 바로 제출값을 받아서 사용
		//String name=request.getParameter("name");
		System.out.println("RequestMappingController 의 get test.do 가 요청됨... name : "+name);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
