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
		log.info("aa() 호출됨... type = {} // id = {}",type,id);
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
		log.info("요청 type ={} //  name = {}",type, name);
		log.info("no = {}",no);
		//return "result";
		
		// 컨트롤러->컨트롤러
		return "forward:/rem/a.do"; // url 주소 변경x
//		return "redirect:/rem/a.do"; // url 주소 변경
	}
}
