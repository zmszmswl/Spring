package co.micol.prj;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); // 로그를 관리. log4j에서 가져와서 console에 남김
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) // 홈페이지 출력
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale); // 동작할때 이걸 동작시킴
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping("/home.do")
	public String home() {
		logger.info("home.do가 실행되었습니다.");
		return "home";
	}
	
	@RequestMapping("/test.do")
	public String test() {
		logger.info("test.do가 실행되었습니다.");
		return "test";
	}
}
