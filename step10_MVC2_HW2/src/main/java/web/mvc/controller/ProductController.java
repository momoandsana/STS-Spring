package web.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.ProductDTO;
import web.mvc.exception.MyErrorException;
import web.mvc.service.ProductService;

@Controller
@RequiredArgsConstructor
@Slf4j
//@RequestMapping("/controller/")
public class ProductController {
	private final ProductService service;
	
	/*
	 * 전체 조회
	 */
	@GetMapping("/")
	public String listProducts(Model model) {
		List<ProductDTO> list=service.select();
		model.addAttribute("productList",list);
		System.out.println(list);
		return "productList";
	}
	
	/*
	 * 상품 등록 폼 열기
	 */
	@GetMapping("/insertForm")
	public String insertForm() {
		return "insertForm";
	}
	
	/*
	 * 실제 상품 등록
	 */
	@PostMapping("/products")
	public String insertProduct(@ModelAttribute ProductDTO productDTO)throws MyErrorException{
		service.insert(productDTO);
		return "redirect:/";
	}
	
	/*
	 * 상세보기
	 */
	@GetMapping("/read/{code}")
	public String getProductDetail(@PathVariable("code") String code,Model model)
	{	log.info("상세보기 도착");
		ProductDTO product=service.selectByCode(code);
		model.addAttribute("product",product);
		return "read";// ??
	}
	
	/*
	 * 삭제
	 */
	@GetMapping("/del/{code}")
	public String deleteProduct(@PathVariable("code") String code,Model model)
	{	
		log.info("삭제 도착");
		int result=service.delete(code);
		return "redirect:/";
		//return null;
	}
	
	/*
	 * updateForm 열기
	 */
	@GetMapping("/updateForm")
	public String updateForm(@RequestParam("code") String code,Model model)
	{
		ProductDTO product=service.selectByCode(code);
		model.addAttribute("product",product);
		return "updateForm";
	}
	
	/*
	 * 실제 업데이트
	 */
	@PostMapping("/update")
	public String updateProduct(@ModelAttribute ProductDTO productDTO)
	{
		int result=service.updateByCode(productDTO);
		if(result==1)return "redirect:/read/" + productDTO.getCode(); 
		return null;
	}
	
}



































