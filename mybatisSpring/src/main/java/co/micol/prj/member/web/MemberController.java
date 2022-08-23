package co.micol.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService service; // service ? 실제 Repository에서 dao를 요청하여 결과를 가져온다.
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) { //스프링프레임워크에서 제공하는 model 인터페이스 왠만하면 model 담음 //vo객체에서 값을 자바에서는? model에 담아옴
		// service 객체를 호출해서 값을 가져오게 처리
		model.addAttribute("members",service.memberSelectList()); // jsp 페이지에서 쓰는 변수명,  값이 넘어온 덩어리
		return "member/memberList";
	}
	@RequestMapping("/memberSelect,do")
	public String memberSelect(MemberVO vo, Model model) { //결과를 담아오고 페이지에 보여줄거면 vo와 model 둘 다 사용ㅇ
		// 한명 데이터 조회
		model.addAttribute("member",service.memberSelect(vo));
		return "member/memberSelect";
	}
	
	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo, Model model) { // pom의 name 속성이 vo객체와 일치하면 request객체를 사용하지않아도 알아서 MemberVO에 값이 들어와있음
		// 추가처리
		int n = service.memberInsert(vo);
		if(n != 0) {
			model.addAttribute("message", "정상적으로 추가되었습니다.");
		} else {
			model.addAttribute("message", "맴버 추가 실패했습니다.");
		}
		return "member/memberInsert";
	}
	
	@RequestMapping("/memberDelete.do")
	public String memberDelete(MemberVO vo, Model model) { // pom의 name 속성이 vo객체와 일치하면 request객체를 사용하지않아도 알아서 MemberVO에 값이 들어와있음
		// 추가처리
		int n = service.memberDelete(vo);
		if(n != 0) {
			model.addAttribute("message", "정상적으로 삭제되었습니다.");
		} else {
			model.addAttribute("message", "맴버 삭제 실패했습니다.");
		}
		return "member/memberDelete";
	}
	
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberVO vo, Model model) { // pom의 name 속성이 vo객체와 일치하면 request객체를 사용하지않아도 알아서 MemberVO에 값이 들어와있음
		// 추가처리
		int n = service.memberUpdate(vo);
		if(n != 0) {
			model.addAttribute("message", "정상적으로 수정되었습니다.");
		} else {
			model.addAttribute("message", "맴버 수정 실패했습니다.");
		}
		return "member/memberUpdate";
	}
	
	
	
	
	
}
