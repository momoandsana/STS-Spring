package web.mvc.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller// ����, component scan ����� �Ǿ�� ����
@RequestMapping("/param")
@Slf4j // lombok ���� �����ϴ� logger�� �������ִ� ����
public class ParameterController {
	
	@RequestMapping("/a.do")
	public String aa(String name,Integer age) {
		// param/a.do?name=jang&age=20
		// ���࿡ Integer�� �ƴ϶� int��� null �� ���� ���ϹǷ� ������ ���� ���� �ִ�
		
		System.out.println();
		
		log.info("name = {} // age={} ",name,age);
		return "result";// prefix+result+suffix(.jsp)-> /WEB-INF/views/result.jsp
	}
	
	/*
	 * void �� ��û�ּҰ� ���̸��� �ȴ�.
	 * WEB-INF/param/b.jsp
	 */
	@RequestMapping("/b.do")
	public void bb(Model model,// Model �� ���������� �־���
			@RequestParam(defaultValue="guest",value="userId") String id,//Ŭ���̾�Ʈ���� id="name"�� �ƴ϶� userId="name" ���� ��������
			@RequestParam(defaultValue="0") int age) {
		// �μ� Model �� �������� ���޵� ������, age�� ���� �� ���´ٸ� �⺻���� 0���� ����
		
		log.info("id = {} // age={}",id,age);
		
		model.addAttribute("list",Arrays.asList("���","����","��","�ٳ���")); // �信�� ${list}
		
	}

}
