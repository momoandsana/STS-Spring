package web.mvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import lombok.extern.slf4j.Slf4j;
import web.mvc.vo.UserVo;

@Controller// ����, component scan ����� �Ǿ�� ����
@RequestMapping("/param")
@Slf4j // lombok ���� �����ϴ� logger�� �������ִ� ����
public class ParameterController {
	/*
	 * ModelAndView �� ��ȯ���� �ʾƵ� ���������δ� ���������� ModelAndView �� ��ȯ�Ѵ�
	 * @ModelAttribute�� �μ��� ������ ���ٸ� addAttribute ���� return "jsp�̸�"���� jsp�� ���۰���������
	 * @RequestParam���� ���� �޾Ҵٸ� addAttribute�� ���� �߰��ؾ��� jsp �� ���� ����
	 */
	
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
		// userId�� ���ų� null �� ��� userId�� guest �� �ȴ�
		
		log.info("id = {} // age={}",id,age);
		
		model.addAttribute("list",Arrays.asList("���","����","��","�ٳ���")); // �信�� ${list}
		
	}
	
	/*
	 * �Ķ���ͷ� ���޵� ������ ��ü�� ���ε��ϸ�
	 * ���޵� ��ü�� �信�� ����� �� �ִ�
	 * ��� : ${��ü�̸�.�Ӽ�} - ��ü�̸��� ù���ڸ� �ҹ���
	 * 
	 * ex) ${userVo.id}
	 */
	@PostMapping(value="/user.do")
	public String user(@ModelAttribute("user") UserVo vo) {// jsp������ ${user.name} ���� ����� �Ѵ�
		//vo �� setter �� ����ؼ� ������ �Է� ���� ���� ���ε���
		/*
		 * ���� ���� vo�� ���񽺿� ����
		 * ���� name �� UserVo �� �ʵ��� ��ġ�ȴ�
		 * UserVo �� ���� �ʵ尡 �Ѿ���� ����
		 * userResult.jsp�� user�� �״�� ����
		 * jsp������ ${user.name}
		 * �ڹٿ����� vo.name ���� ���
		 * 
		 */
		log.info("vo = {}",vo);
		
		return "userResult";
		// WEB-INF/views/userResult.jsp �� �̵�"
	}
	
	@ModelAttribute("msg")// �信�� ${msg} �� ��� --> ���� ��Ʈ�ѷ� �ȿ����� ���� ����
	public String aaa() {
		return "���õ� �������̾��";
	}
	
	@ModelAttribute("menu") // �信�� ${menu} �� ���
	public List<String> bb(){
		return Arrays.asList("«��","¥��");
	}
	

}
