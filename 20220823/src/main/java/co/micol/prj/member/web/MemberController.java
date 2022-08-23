package co.micol.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.member.service.MemberService;

@Controller // member관리 컨트롤러
public class MemberController {
	@Autowired // 자동할당 데이터
	private MemberService dao;
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) { // 메소드가 command와 비슷
		model.addAttribute("members",dao.memberSelectList()); // 맴버목록 결과를 member에 담는다
		return "member/memberList";
	}
}
