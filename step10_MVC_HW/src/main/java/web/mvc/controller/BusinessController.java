package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BusinessController {

    @RequestMapping("/business")
    public String Business() {
    	log.info("BuisnessController »£√‚");
        return "business";
    }
}
