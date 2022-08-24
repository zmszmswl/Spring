package co.micol.prj.notice.map.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired  // 컨테이너에 등록된 것만 들고옴
	private NoticeService dao;
	
	@RequestMapping("/noticeList.do")
	public String noticeList(Model model) { // model 인터페이스객체
		model.addAttribute("notices",dao.noticeSelectList());
		return "notice/noticeList"; // 모델에 담고 스트링 타입으로 리턴하여 뷰페이지를 던짐 (1번) 돌려줄페이지가 스트링이라 스트링타입씀
	}
	
	@RequestMapping("/noticeSelectList.do")
	public ModelAndView noticeSelectList(ModelAndView mv) { // modelandview  전달할 객체를 담고 
		mv.addObject("notices", dao.noticeSelectList()); // 결과를 object에 담고
		mv.setViewName("notice/noticeList");	// 보여줄 view를 선택하고
		return mv; // 모델엔뷰를 리턴시켜야함 (2번)
	}
	
	@RequestMapping("/noticeForm.do") // 글쓰기 폼 호출
	public String noticeForm( ) {
		return "notice/noticeForm";
	}
	
	@PostMapping("/noticeInsert.do") // 글 등록
	public String noticeInsert(NoticeVO vo , MultipartFile mFile) { // vo 받고 []file 받는 매개변수 // 20220824는 첨부파일 안함
		System.out.println(vo.getNotice_writer());
		System.out.println(vo.getNotice_title());
		// **********************요부분에 첨부파일 처리 
		dao.noticeInsert(vo); //글 내용 등록
		return "redirect:noticeList.do"; // 글목록으로 돌아가기 @RequestMapping("/noticeList.do") 실행!
		// 컨트롤러-디스패쳐-뷰리절브 => 컨트롤러(redirect)-디스패쳐(redirect를 보고 요청이들어왔네?)-핸들러맵퍼(요청수행해야지)-noticeList.do를 실행함(.do를 실행)
	}
}
