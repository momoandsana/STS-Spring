package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BusinessController {

    @RequestMapping("/business")
    public String showBusinessPage() {

        return "business";
    }
}
