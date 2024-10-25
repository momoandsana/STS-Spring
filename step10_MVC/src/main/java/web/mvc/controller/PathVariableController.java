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
		log.info("aa() »£√‚µ ... type = {} // id = {}",type,id);
	}
	
	@RequestMapping("/{id}")
	public String bb(@PathVariable String id) {
		log.info("id = {}",id);
		
		return "result";
	}
	
	@RequestMapping("/board/{type}/{id}")
	public String handleFaq(@PathVariable String type,
			@PathVariable String id) {
		log.info("ø‰√ª ={} //  id = {}",type, id);
		return "result";
	}
}
