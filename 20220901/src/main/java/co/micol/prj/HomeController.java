package co.micol.prj;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
