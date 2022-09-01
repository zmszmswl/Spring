package co.micol.prj.member.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService service; 
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) { 
		// 목록조회
		model.addAttribute("members",service.memberSelectList()); 
		return "member/memberList";
	}
	
	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo, Model model) { 
		// 등록
		int n = service.memberInsert(vo);
		if(n != 0) {
			model.addAttribute("message", "정상적으로 추가되었습니다.");
		} else {
			model.addAttribute("message", "맴버 추가 실패했습니다.");
		}
		return "redirect:memberList.do";
	}
	
	@GetMapping("/memberForm.do")
	// 등록폼
	public String memberForm(){
		return "member/memberForm";
	}

}
