package web.mvc.dao;

import java.util.List;

import web.mvc.dto.ProductDTO;
import web.mvc.exception.MyErrorException;

public interface ProductDAO {
	List<ProductDTO> select();
	
	int insert(ProductDTO productDTO) throws MyErrorException;
	
	int delete(String code) throws MyErrorException;
	
	ProductDTO selectByCode(String code);
	
	int updateByCode(ProductDTO productDTO) throws MyErrorException;
}
