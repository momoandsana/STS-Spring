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
 * �񵿱���� ���� Controller
 * 
 */

@RestController // @Controller + @ResponseBody �� ����\
@Slf4j
public class AjaxController {
	
	// ���ϴ� ������Ÿ������ ����
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
	
	@RequestMapping("/ajax2.do")
	public ResponseEntity<?> ajax2(UserDTO userDTO) {
		log.info("userDTO = {}",userDTO);
		
		
		return ResponseEntity.status(HttpStatus.OK).body("ok");
	}
	
	/*
	 * ����Ʈ���� ���޵Ǵ� �����͸� ���̽� ��ü�� ���ε��� ����
	 * @RequestBody �� �ʿ�(�μ��� �޴´�)
	 */
	@RequestMapping("/ajax3.do")
	public ResponseEntity<?> ajax3(@RequestBody UserDTO userDTO)
	{
		log.info("ajax3 �� userDTO = {}",userDTO);
		return ResponseEntity.status(HttpStatus.OK).body("ok2");
	}
	/*
	 * ajax2.do �� �ؽ�Ʈ�� �������� �Ѿ��(form data ����)
	 * ajax3.do �� json �������� �޴´�
	 * ResponseEntity �� �����°� ����(���� ����)
	 */

	
	
}





















