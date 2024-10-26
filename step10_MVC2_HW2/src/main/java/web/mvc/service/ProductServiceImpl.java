package web.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import web.mvc.dao.ProductDAO;
import web.mvc.dto.ProductDTO;
import web.mvc.exception.ErrorInfo;
import web.mvc.exception.MyErrorException;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductDAO dao;
	
	@Override
	public List<ProductDTO> select() {
		// TODO Auto-generated method stub
		return dao.select();
	}

	@Override
	public ProductDTO selectByCode(String code) {
		// TODO Auto-generated method stub
		return dao.selectByCode(code);
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		// TODO Auto-generated method stub
		if(productDTO.getPrice()<1000 || productDTO.getPrice()>10000) throw new MyErrorException(ErrorInfo.INVALID_PRICE);
		return dao.insert(productDTO);
	}

	@Override
	public int delete(String code) throws MyErrorException {
		// TODO Auto-generated method stub
		return dao.delete(code);
	}

	@Override
	public int updateByCode(ProductDTO productDTO) throws MyErrorException {
		// TODO Auto-generated method stub
		return dao.updateByCode(productDTO);
	}

}
