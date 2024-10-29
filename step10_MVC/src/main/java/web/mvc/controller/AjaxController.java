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
		// 여기서 객체로 넘기기 때문에 json으로 전달된다
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
	public ResponseEntity<?> ajax3(@RequestBody UserDTO userDTO)// 프론트에서 json으로 데이터를 전송한 상태
	{
		log.info("ajax3 의 userDTO = {}",userDTO);
		
		// 나이가 18보다 작으면 BasiccException 발생시켜보자
		if(userDTO.getAge()<18)
		{
			throw new AjaxBasicException(ErrorInfo.INVALID_AGE);
		}
		
		//return ResponseEntity.status(HttpStatus.OK).body("ok2");
		// ok2는 String 이기 때문에 ResponseEntity<?> 의 ? 에는 String 이 들어감
		// 여기서는 그냥 단어로 나갔기 때문에 받을 때도 json 이 아니라 text로 받아야 함
		// json 으로 보내기 위해서는 객체를 보내야 함
		
		// 객체로 보내기,ResponseEntity<?> 사용하므로 위에처럼 String 으로 보내도 되고 지금 처럼 객체로 보내도 된다
		// 이렇게 보내면 프론트 ajax 코드에서도 dataType : "json" 으로 수정해야 한다
		List<ProductDTO> list=new ArrayList<>();
		list.add(ProductDTO.builder().code("A01").detail("맛있다").name("새우깡").price(2500).build());
		list.add(ProductDTO.builder().code("A02").detail("고구마맛").name("고구마깡").price(3000).build());
		list.add(ProductDTO.builder().code("A03").detail("감자맛").name("감자깡").price(3500).build());
		
		return ResponseEntity.status(HttpStatus.OK).body(list); // jackson-bind lib에 의해 json 변환 응답
		
	}
	/*
	 * ajax2.do 는 텍스트로 브라우저로 넘어가고(form data 형식)
	 * postman 에서 params 로 key value 입력하기(dto 필드에 맞게)
	 * 
	 * ajax3.do 는 json 형식으로 받는다->@RequestBody 로 받으니까
	 * postman에서 보낼때도 params 가 아니라 body-raw-json 으로 직접{}로 작성하기
	 * 
	 * ResponseEntity 로 보내는게 좋다(형식 통일), 상태코드&헤더 같은 값도 설정해줄 수 있음
	 * ResponseEntity 는 내용물에 맞춰서 나감. 객체이든 String 이든
	 * @ResponseBody를 사용하는 것보다 더 세세한 설정을 해줄 수 있음
	 */

	@RequestMapping("/ajax4.do")
	public ResponseEntity<?> ajax4(@RequestBody UserDTO userDTO)
	{
		log.info("ajax3 의 userDTO = {}",userDTO);
		
		HttpHeaders resHeaders=new HttpHeaders();
		resHeaders.add("Content-Type", "text/plain");
		
		return new ResponseEntity<>("OK",resHeaders,HttpStatus.CREATED);
		
	}
	
}





















