package co.micol.prj.member.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/memberLogin.do") // 로그인처리
	public String memberLogin(MemberVO vo, HttpSession session, Model model) { // vo (id, password)담김 /  로그인할때는 HttpSession 객체에 담아야함 / 결과는 모델에 담아줌
		vo = service.memberSelect(vo); // 수행해서 vo에 담기
		if(vo == null) { // 수행된 결과가 없을때 (db에 vo에 담아간 id와 password가 일치하는게 없을때)
			model.addAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다.");
		} else {
			session.setAttribute("id", vo.getMember_id());
			session.setAttribute("name", vo.getMember_name());
			session.setAttribute("author", vo.getMember_author());
			model.addAttribute("message", vo.getMember_name() + "님 환영합니다.");
			System.out.println("123");
		}
		return "member/memberMessage";
	}
	
	@GetMapping("/memberLoginForm.do") // 로그인폼 값 전달이 아닌 단순한 폼 호출 맵핑은 get방식 활용
	public String memberLoginForm() {
		return "member/memberLoginForm";
	}
}
