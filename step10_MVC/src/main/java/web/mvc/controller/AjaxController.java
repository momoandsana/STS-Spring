package web.mvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<String> ajax2(UserDTO userDTO) {
		log.info("userDTO = {}",userDTO);
		
		return ResponseEntity.status(200).body("ok");
	}

	
	
}





















