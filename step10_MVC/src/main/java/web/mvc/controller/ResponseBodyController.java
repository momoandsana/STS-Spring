package web.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.ProductDTO;

//@Controller
@RestController
/*
 * @Controller + @ResponseBody -> ajax�� �ϴ� ��Ʈ�ѷ�. 
 * ��ü�� �� ajax�� �ϰ� ���� ������ @Controller �� �����ϰ� @ResponseBody ���� ����
 */
@Slf4j
public class ResponseBodyController {
	@RequestMapping(value="/responseBody.do",produces= {"text/html;charset=UTF-8"})
	//@ResponseBody // ������ ��ü�� �״�� ���䰴ü�� �ȴ�
	public String aa() {
		log.info("responseBody.do ��û��");
		
		return"String �ѱ�"; // ȭ�鿡 �ٷ� ����. @ResponseBody ������ �並 ã�°� �ƴ϶� �ٷ� ȭ�鿡 ����	
	}
	
	/*
	 * ���� body�� list, map, dto ������ ��ü�� ������ ��
	 * json ���� ��ȯ�ؼ� �������ִ� jackson-databind ���̺귯���� �ʿ��ϴ�
	 * ���� ��ȯ���� �ʾƵ� �˾Ƽ� json���� �����ش�(@RestController �� ��������Ƿ�)
	 */
	@RequestMapping(value="/responseBody2.do")
	public ProductDTO bb() {
		log.info("responseBody2.do ��û��");
		return ProductDTO.builder().code("A01").detail("���ִ�").build();
		// dto �ڵ忡�� @Builder ��������Ƿ� ������ ���� �ٷ� ��ü �����ؼ� ���
	}
}
