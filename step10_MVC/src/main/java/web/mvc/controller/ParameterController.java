package web.mvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import lombok.extern.slf4j.Slf4j;
import web.mvc.vo.UserVo;

@Controller// 생성, component scan 대상이 되어야 가능
@RequestMapping("/param")
@Slf4j // lombok 에서 제공하는 logger를 생성해주는 역할
public class ParameterController {
	/*
	 * ModelAndView 로 반환하지 않아도 내부적으로는 내부적으로 ModelAndView 로 반환한다
	 * @ModelAttribute를 인수로 받으면 별다른 addAttribute 없이 return "jsp이름"으로 jsp로 전송가능하지만
	 * @RequestParam으로 값을 받았다면 addAttribute로 따로 추가해야지 jsp 로 전송 가능
	 */
	
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
		// userId가 없거나 null 인 경우 userId는 guest 가 된다
		
		log.info("id = {} // age={}",id,age);
		
		model.addAttribute("list",Arrays.asList("사과","딸기","배","바나나")); // 뷰에서 ${list}
		
	}
	
	/*
	 * 파라미터로 전달된 정보를 객체로 바인딩하면
	 * 전달된 객체를 뷰에서 사용할 수 있다
	 * 방법 : ${객체이름.속성} - 객체이름은 첫글자를 소문자
	 * 
	 * ex) ${userVo.id}
	 */
	@PostMapping(value="/user.do")
	public String user(@ModelAttribute("user") UserVo vo) {// jsp에서도 ${user.name} 으로 열어야 한다
		//vo 의 setter 를 사용해서 폼에서 입력 받은 값이 바인딩됨
		/*
		 * 전달 받은 vo를 서비스에 전달
		 * 폼의 name 과 UserVo 의 필드들과 매치된다
		 * UserVo 에 없는 필드가 넘어오면 무시
		 * userResult.jsp에 user가 그대로 전달
		 * jsp에서는 ${user.name}
		 * 자바에서는 vo.name 으로 사용
		 * 
		 */
		log.info("vo = {}",vo);
		
		return "userResult";
		// WEB-INF/views/userResult.jsp 로 이동"
	}
	
	@ModelAttribute("msg")// 뷰에서 ${msg} 로 사용 --> 같은 컨트롤러 안에서만 공유 가능
	public String aaa() {
		return "오늘도 수고많으셨어요";
	}
	
	@ModelAttribute("menu") // 뷰에서 ${menu} 로 사용
	public List<String> bb(){
		return Arrays.asList("짬뽕","짜장");
	}
	

}
