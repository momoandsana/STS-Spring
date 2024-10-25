package web.mvc.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import web.mvc.exception.BasicException;
import web.mvc.exception.ErrorInfo;

@Service // 빈 생성->component-scan 에 잡히는지 확인
@Slf4j
public class ExceptionTestServiceImpl implements ExceptionTestService {
	ExceptionTestServiceImpl() {
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
