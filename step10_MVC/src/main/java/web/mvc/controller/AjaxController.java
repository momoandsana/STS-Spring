package web.mvc.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.ProductDTO;
import web.mvc.dto.UserDTO;
import web.mvc.exception.AjaxBasicException;
import web.mvc.exception.ErrorInfo;

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
		// ���⼭ ��ü�� �ѱ�� ������ json���� ���޵ȴ�
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
	public ResponseEntity<?> ajax3(@RequestBody UserDTO userDTO)// ����Ʈ���� json���� �����͸� ������ ����
	{
		log.info("ajax3 �� userDTO = {}",userDTO);
		
		// ���̰� 18���� ������ BasiccException �߻����Ѻ���
		if(userDTO.getAge()<18)
		{
			throw new AjaxBasicException(ErrorInfo.INVALID_AGE);
		}
		
		//return ResponseEntity.status(HttpStatus.OK).body("ok2");
		// ok2�� String �̱� ������ ResponseEntity<?> �� ? ���� String �� ��
		// ���⼭�� �׳� �ܾ�� ������ ������ ���� ���� json �� �ƴ϶� text�� �޾ƾ� ��
		// json ���� ������ ���ؼ��� ��ü�� ������ ��
		
		// ��ü�� ������,ResponseEntity<?> ����ϹǷ� ����ó�� String ���� ������ �ǰ� ���� ó�� ��ü�� ������ �ȴ�
		// �̷��� ������ ����Ʈ ajax �ڵ忡���� dataType : "json" ���� �����ؾ� �Ѵ�
		List<ProductDTO> list=new ArrayList<>();
		list.add(ProductDTO.builder().code("A01").detail("���ִ�").name("�����").price(2500).build());
		list.add(ProductDTO.builder().code("A02").detail("������").name("������").price(3000).build());
		list.add(ProductDTO.builder().code("A03").detail("���ڸ�").name("���ڱ�").price(3500).build());
		
		return ResponseEntity.status(HttpStatus.OK).body(list); // jackson-bind lib�� ���� json ��ȯ ����
		
	}
	/*
	 * ajax2.do �� �ؽ�Ʈ�� �������� �Ѿ��(form data ����)
	 * postman ���� params �� key value �Է��ϱ�(dto �ʵ忡 �°�)
	 * 
	 * ajax3.do �� json �������� �޴´�->@RequestBody �� �����ϱ�
	 * postman���� �������� params �� �ƴ϶� body-raw-json ���� ����{}�� �ۼ��ϱ�
	 * 
	 * ResponseEntity �� �����°� ����(���� ����), �����ڵ�&��� ���� ���� �������� �� ����
	 * ResponseEntity �� ���빰�� ���缭 ����. ��ü�̵� String �̵�
	 * @ResponseBody�� ����ϴ� �ͺ��� �� ������ ������ ���� �� ����
	 */

	@RequestMapping("/ajax4.do")
	public ResponseEntity<?> ajax4(@RequestBody UserDTO userDTO)
	{
		log.info("ajax3 �� userDTO = {}",userDTO);
		
		HttpHeaders resHeaders=new HttpHeaders();
		resHeaders.add("Content-Type", "text/plain");
		
		return new ResponseEntity<>("OK",resHeaders,HttpStatus.CREATED);
		
	}
	
}





















