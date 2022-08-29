package co.micol.prj;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Locale loclae, Model model) {
		return "home/home";
	}
	@RequestMapping("/home.do")
	public String home() {
		return "home/home";
	}
	@GetMapping("/charts.do")
	public String chart() {
		return "home/chart";
	}
	
	
/*	@GetMapping("/admin.do")
	public String admin() {
		return "admin/admin";
	}
	
	@GetMapping("/") // 처음 들어오는 페이지 호출 // 루트로 로그인페이지 먼저 뜨도록
	public String Login() {
		return "memberLoginForm";
	}
*/	
}
