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
 * postman���� http:localhost:9000/controller ���� ������ ��ҵ� �߰��ؼ� ��û�ϱ�
 * rest api ������ �ڿ��� api�� ��Ÿ���� ���� ������ ���� ���� delete,put ó�� ��û�� ���ؼ� ��Ÿ����
 * web.xml ���� /controller �� contextpath �� ��������
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
		// RestControllerAdvice �� �־���� ���ܻ��׿� ���� ������ ����Ʈ������ ��
		//�׳� @ControllerAdvice �� ���� ���� �� ����
	}

	@GetMapping("/products/{code}")
	public ResponseEntity<?> getProductDetail(@PathVariable("code") String code) {
		log.info("�󼼺��� ����");
		ProductDTO product = service.selectByCode(code);
		return ResponseEntity.ok(product);
	}

	@DeleteMapping("/products/{code}")
	public ResponseEntity<?> deleteProduct(@PathVariable("code") String code) {
		log.info("���� ����");
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
		service.updateByCode(productDTO); // ���⼭ exception ��
		return ResponseEntity.ok().build();
	}
	/*
	 * ��û -> http://localhost:9000/controller/products/A07
	 * 
	 * { "code": "A07", 
	 * "name": "��������", 
	 * "price": 4000,
	 *  "detail":"Sample product description." }
	 * 
	 */
}
