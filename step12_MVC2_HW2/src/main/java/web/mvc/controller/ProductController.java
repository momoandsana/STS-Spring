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
    }

    @GetMapping("/read/{code}")
    public ResponseEntity<?> getProductDetail(@PathVariable("code") String code) {
        log.info("�󼼺��� ����");
        ProductDTO product = service.selectByCode(code);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/del/{code}")
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
        service.updateByCode(productDTO);
        return ResponseEntity.ok().build();
    }
    // sts���� put ��û�� �� ����
}
