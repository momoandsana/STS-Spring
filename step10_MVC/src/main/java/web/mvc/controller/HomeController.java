package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//	
//	/**
//	 * Simply selects the home view to render by returning its name.
//	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}
	
	@RequestMapping("/") // url 주소에서 / 라고 요청이 되면 이 메소드를 실행해줘
	public ModelAndView test() {
		System.out.println("test 호출!!");
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("message","Don't sleep");// request scope 영역에 저장->request.setAttribute("message","Don't sleep")
		return mv; // WEB-INF/views/home.jsp 이동
	}
	//controller는 modelandview return
	
}
