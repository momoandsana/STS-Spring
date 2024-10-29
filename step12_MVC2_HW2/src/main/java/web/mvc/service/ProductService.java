package web.mvc.service;

import java.util.List;

import web.mvc.dto.ProductDTO;
import web.mvc.exception.MyErrorException;

public interface ProductService {
	List<ProductDTO> select();
	
	int insert(ProductDTO productDTO)throws MyErrorException;
	
	ProductDTO selectByCode(String code)throws MyErrorException;
	
	int delete(String code)throws MyErrorException;
	
	int updateByCode(ProductDTO productDTO) throws MyErrorException;
}
