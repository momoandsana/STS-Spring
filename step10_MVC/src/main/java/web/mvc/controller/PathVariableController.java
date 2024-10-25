package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PathVariableController {
	
	@RequestMapping("/{type}/{id}.do")
	public void aa(@PathVariable String type,
				   @PathVariable String id) 
	{
		log.info("aa() ȣ���... type = {} // id = {}",type,id);
	}
	
	@RequestMapping("/{id}")
	public String bb(@PathVariable String id) {
		log.info("id = {}",id);
		
		return "result";
	}
	
	@RequestMapping("/{type}/{name}/{no}")
	public String cc(@PathVariable String type,
			@PathVariable String name,
			@PathVariable int no)
		
	{
		log.info("��û type ={} //  name = {}",type, name);
		log.info("no = {}",no);
		//return "result";
		
		// ��Ʈ�ѷ�->��Ʈ�ѷ�
		return "forward:/rem/a.do"; // url �ּ� ����x
//		return "redirect:/rem/a.do"; // url �ּ� ����
	}
}
