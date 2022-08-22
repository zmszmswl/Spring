package co.micol.prj.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //member 관리 controller
public class MemberController {

	
	@GetMapping("memberList.do") 
	public String memberList() { // 메소드가 command와 비슷
		return "member/memberList";  
	}
	
	@RequestMapping("memberSearch.do")
	public String memberSearch() {
		return "member/memberSearch";
	}
	
	@RequestMapping("memberInsert.do")
	public String memberInsert() {
		return "member/memberInsert";
	}
}
