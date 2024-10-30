package web.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.ProductDTO;
import web.mvc.exception.MyErrorException;
import web.mvc.service.ProductService;

@RestController
@RequiredArgsConstructor
@Slf4j
/*
 * postman에서 http:localhost:9000/controller 에서 나머지 요소들 추가해서 요청하기
 * rest api 에서는 자원만 api로 나타내고 삭제 수정에 대한 것은 delete,put 처럼 요청을 통해서 나타내기
 * web.xml 에서 /controller 로 contextpath 를 설정했음
 */
public class ProductController {

	private final ProductService service;

	@GetMapping("/")
	public ResponseEntity<?> listProducts() {
		List<ProductDTO> list = service.select();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/insertForm")
	public ResponseEntity<?> insertForm() {
		return ResponseEntity.ok("insertForm");
	}

	@PostMapping("/products")
	public ResponseEntity<?> insertProduct(@RequestBody ProductDTO productDTO) throws MyErrorException {
		int result = service.insert(productDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
		// RestControllerAdvice 가 있어야지 예외사항에 대한 응답이 포스트맨으로 감
		//그냥 @ControllerAdvice 랑 같이 쓰면 안 먹힘
	}

	@GetMapping("/products/{code}")
	public ResponseEntity<?> getProductDetail(@PathVariable("code") String code) {
		log.info("상세보기 도착");
		ProductDTO product = service.selectByCode(code);
		return ResponseEntity.ok(product);
	}

	@DeleteMapping("/products/{code}")
	public ResponseEntity<?> deleteProduct(@PathVariable("code") String code) {
		log.info("삭제 도착");
		service.delete(code);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/updateForm/{code}")
	public ResponseEntity<?> updateForm(@PathVariable("code") String code) {
		ProductDTO product = service.selectByCode(code);
		return ResponseEntity.ok("updateForm");
	}

	@PutMapping("/products/{code}")
	public ResponseEntity<?> updateProduct(@PathVariable("code") String code, @RequestBody ProductDTO productDTO) {
		productDTO.setCode(code);
		service.updateByCode(productDTO); // 여기서 exception 이
		return ResponseEntity.ok().build();
	}
	/*
	 * 요청 -> http://localhost:9000/controller/products/A07
	 * 
	 * { "code": "A07", 
	 * "name": "수정수정", 
	 * "price": 4000,
	 *  "detail":"Sample product description." }
	 * 
	 */
}
