package web.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.ProductDTO;

//@Controller
@RestController
/*
 * @Controller + @ResponseBody -> ajax만 하는 컨트롤러. 
 * 전체를 다 ajax로 하고 싶지 않으면 @Controller 로 설정하고 @ResponseBody 같이 쓰기
 */
@Slf4j
public class ResponseBodyController {
	@RequestMapping(value="/responseBody.do",produces= {"text/html;charset=UTF-8"})
	//@ResponseBody // 리턴한 객체가 그대로 응답객체가 된다
	public String aa() {
		log.info("responseBody.do 요청됨");
		
		return"String 한글"; // 화면에 바로 나옴. @ResponseBody 때문에 뷰를 찾는게 아니라 바로 화면에 나옴	
	}
	
	/*
	 * 응답 body에 list, map, dto 형태의 객체를 리턴할 때
	 * json 으로 변환해서 리턴해주는 jackson-databind 라이브러리가 필요하다
	 * 따로 변환하지 않아도 알아서 json으로 보내준다(@RestController 도 사용했으므로)
	 */
	@RequestMapping(value="/responseBody2.do")
	public ProductDTO bb() {
		log.info("responseBody2.do 요청됨");
		return ProductDTO.builder().code("A01").detail("맛있다").build();
		// dto 코드에서 @Builder 사용했으므로 생성자 없이 바로 객체 생성해서 사용
	}
}
