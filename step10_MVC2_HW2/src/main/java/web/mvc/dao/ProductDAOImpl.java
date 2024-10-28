package web.mvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.mvc.dto.ProductDTO;
import web.mvc.exception.ErrorInfo;
import web.mvc.exception.MyErrorException;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private List<ProductDTO> list;

	

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		// TODO Auto-generated method stub
		for(ProductDTO product : list) { //selectByCode() 사용하기
			if((product.getCode()).equals(productDTO.getCode()))throw new MyErrorException(ErrorInfo.DUPLICATE_CODE);
		}
		list.add(productDTO);
		
		return 1; // 성공적으로 insert
	}

//	@Override
//	public int delete(String code) throws MyErrorException {
//		// TODO Auto-generated method stub
//		for(ProductDTO product:list)
//		{
//			if(product.getCode().equals(code)) {
//				list.remove(product);
//				return 1;
//			}
//		}
//		
//		return 0; 
//	}
	@Override
	public int delete(String code) throws MyErrorException {
	    boolean removed = list.removeIf(product -> product.getCode().equals(code));
	    
//	    ProductDTO product=selectByCode(code);
//	    list.remove(product);
	    
	    return removed ? 1 : 0;
	}


	@Override
	public int updateByCode(ProductDTO productDTO) throws MyErrorException {
		// TODO Auto-generated method stub
		for(ProductDTO product:list)
		{
			if(product.getCode().equals(productDTO.getCode())) //selectByCode() 사용
			{
				product.setName(productDTO.getName());
				product.setPrice(productDTO.getPrice());
				product.setDetail(productDTO.getDetail());
				return 1;
			}
		}
		
		return 0;
	}

	@Override
	public List<ProductDTO> select() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public ProductDTO selectByCode(String code) {
		// TODO Auto-generated method stub
		for(ProductDTO product:list)
		{
			if(product.getCode().equals(code))
			{
				return product;
			}
		}
		return null;
	}
	
//	@Override
//	public void ageCheck(int age) throws BasicException {
//		// TODO Auto-generated method stub
//		log.info("age = {}",age);
//		if(age < 15) throw new BasicException(ErrorInfo.INVALID_AGE);
//
//	}

}
