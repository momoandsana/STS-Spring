package web.mvc.service;

import web.mvc.exception.BasicException;

public interface ExceptionTestService {
	/*
	 * 나이 체크
	 */
	void ageCheck(int age) throws BasicException;
	
	/*
	 * 중복 체크
	 */
	void idCheck(String id);
}
