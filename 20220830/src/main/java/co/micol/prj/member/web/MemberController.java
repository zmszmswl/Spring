package co.micol.prj.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	// 타일즈 태우기 싫을때
	@GetMapping("/memberLoginForm.do")
	public String memberLoginForm() {
		return "notiles/member/memberLoginForm"; 
	}
	
	// 타일즈 태우기 싫을때
	@GetMapping("/memberJoinForm.do")
	public String memberJoinForm() {
		return "notiles/member/memberJoinForm";
	}
	
}
