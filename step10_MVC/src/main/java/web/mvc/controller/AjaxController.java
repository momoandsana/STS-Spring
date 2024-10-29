package web.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.ProductDTO;
import web.mvc.dto.UserDTO;

/*
 * 비동기통신 전용 Controller
 * 
 */

@RestController // @Controller + @ResponseBody 의 조합\
@Slf4j
public class AjaxController {
	
	// 원하는 데이터타입으로 리턴
	@PostMapping("/ajax.do") // jsp에서 data : {email:"jang" , pwd="1234"}
	public ProductDTO ajax(String email,String pwd) {
		log.info("email = {} , pwd = {}",email,pwd);
		
		
		
		return ProductDTO.builder()
				.code("A05")
				.price(4000)
				.name("새우깡")
				.detail("짜고 맛나다")
				.build();
	}
	
	@RequestMapping("/ajax2.do")
	public ResponseEntity<?> ajax2(UserDTO userDTO) {
		log.info("userDTO = {}",userDTO);
		
		
		return ResponseEntity.status(HttpStatus.OK).body("ok");
	}
	
	/*
	 * 프론트에서 전달되는 데이터를 제이슨 객체로 바인딩할 때는
	 * @RequestBody 가 필요(인수로 받는다)
	 */
	@RequestMapping("/ajax3.do")
	public ResponseEntity<?> ajax3(@RequestBody UserDTO userDTO)
	{
		log.info("ajax3 의 userDTO = {}",userDTO);
		return ResponseEntity.status(HttpStatus.OK).body("ok2");
	}
	/*
	 * ajax2.do 는 텍스트로 브라우저로 넘어가고(form data 형식)
	 * ajax3.do 는 json 형식으로 받는다
	 * ResponseEntity 로 보내는게 좋다(형식 통일)
	 */

	
	
}





















