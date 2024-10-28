package web.mvc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.ProductDTO;

/*
 * �񵿱���� ���� Controller
 * 
 */

@RestController // @Controller + @ResponseBody �� ����\
@Slf4j
public class AjaxController {
	
	@PostMapping("/ajax.do") // jsp���� data : {email:"jang" , pwd="1234"}
	public ProductDTO ajax(String email,String pwd) {
		log.info("email = {} , pwd = {}",email,pwd);
		
		
		
		return ProductDTO.builder()
				.code("A05")
				.price(4000)
				.name("�����")
				.detail("¥�� ������")
				.build();
	}
}
