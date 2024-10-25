package web.mvc.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.ProductDTO;
import web.mvc.exception.BasicException;
import web.mvc.exception.ErrorInfo;

@Service // �� ����->component-scan �� �������� Ȯ��
@Slf4j
public class ExceptionTestServiceImpl implements ExceptionTestService {
	
	@Autowired
	private List<ProductDTO> list;
	
	@PostConstruct //���� list�� �����Ǵ��� Ȯ���ϱ� ����
	public void aaa() {
		System.out.println(list);
	}
	
	public ExceptionTestServiceImpl() {
		System.out.println("ExceptionTestServiceImpl....");
	}
	
	@Override
	public void ageCheck(int age) throws BasicException {
		// TODO Auto-generated method stub
		log.info("age = {}",age);
		if(age < 15) throw new BasicException(ErrorInfo.INVALID_AGE);

	}

	@Override
	public void idCheck(String id) {
		// TODO Auto-generated method stub
		log.info("id = {}",id);
		if(!"jang".equals(id)) {
			throw new BasicException(ErrorInfo.DUPLICATE_ID);
		}
	}

}
