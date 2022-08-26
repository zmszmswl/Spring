package co.micol.prj.notice.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeVO;

@Controller
public class NoticeController {
		@Autowired
		private NoticeService ns;
		
		@Autowired // 서블릿컨텍스트 안의 context-path를 찾는것 -> 즉, webapp을 찾음 ->  ★파일폴더를 찾기위해!
		private ServletContext servletContext;
		
		// 게시판 단건조회
		@PostMapping("/noticeSelect.do")
		public String noticeSelect(NoticeVO vo, Model model) { // 단건조회 1개의 값만 받을것임
			//vo.setNoticeId(22); // 강제로 하나의 레코드를 선택하기위해 만든것
			model.addAttribute("n",ns.noticeSelect(vo));
			ns.noticeHitUpdate(vo); // 조회수 증가
			return "notice/noticeSelect";
		}
		
		@GetMapping("/noticeSelectList.do")
		public String noticeSelectList(Model model) {
			model.addAttribute("notices", ns.noticeSelectList()); // 여러건
			return "notice/noticeSelectList";
		}
		
		@PostMapping("/noticeInsert.do")
		public String noticeInsert(NoticeVO vo, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException { // 실제로 file이라는 이름으로 올라오는것을  MultipartFile의 file로 쓰겠다. // 파일을 여러개받으려면 테이블을 분리하고 배열로 받아서 FOR문 돌린다.
								//vo.setNoticeWriter("관리자");
								//vo.setNoticeTitle("공지 알림 사항");
								//vo.setNoticeSubject("내용은 없어도 됩니다.");
			// file Upload 처리
			String saveFolder = servletContext.getRealPath("/fileUpload"); // 저장할 공간 폴더 명
			File sfile = new File(saveFolder); // sfile : 물리적으로 저장할 위치
			String oFileName = file.getOriginalFilename(); // 넘어온 파일의 파일이름
			
			if(!oFileName.isEmpty()) {
				// 자바 UUID 객체로 : 파일명 충돌방지를 위한 파일 별명만들기
				String sFileName = UUID.randomUUID().toString() + oFileName.substring(oFileName.lastIndexOf(".")); //고유한랜덤아이디 + (.jsp*)확장자명을 잘라서붙임
				file.transferTo(new File(sfile, sFileName)); // 파일을 물리적 위치에 저장한다.  sfile 공간에 sFileName(UUID)이름으로 저장하자
				vo.setNoticeAttech(oFileName);
				vo.setNoticeAttechDir(saveFolder + File.separator + sFileName); // fileUpload/234567.txt
			}
			
			ns.noticeInsert(vo); // 행위를 실행시켜야함
			return "redirect:noticeSelectList.do";
		}
		
		@RequestMapping("/noticeUpdate.do")
		public String noticeUpdate(NoticeVO vo) {
			vo.setNoticeWriter("관리자");
			vo.setNoticeId(23);
			ns.noticeUpdate(vo);
			return "redirect:noticeSelectList.do"; // 디스패쳐가 핸들러매퍼로 다시 돌려보낸다. 그래서 다시 컨트롤러에서 리턴을 찾음
		}
		
		@RequestMapping("/noticeSearch.do")
		public String noticeSearch(NoticeVO vo, String key, String val, Model model) { // vo 객체에 없는 애들은 form에서 넘어오는값을 @RequestParam으로 받는다 @RequestParam("key")@RequestParam("val")
			key = "1";
			val = "사항";
			model.addAttribute("notices", ns.noticeSearch(key, val));
			return "notice/noticeSearch";
		}
		
		@GetMapping("/noticeForm.do")
		public String noticeInsertForm(){
			return "notice/noticeForm";
		}
		
		@RequestMapping(value="/ajaxNoticeSelect.do", produces="application/text; charset=UTF-8")
		@ResponseBody // 호출한 페이지로 결과를 돌려보내준다.
		public String ajaxNoticeSelect(HttpServletResponse response) {
			//response.setContentType("text/html; charset=UTF-8"); // 호출한쪽에서 호출한쪽으로 던지는 테스트용임, json으로 던지면 처리안해도됌
			String message = "ajax Test를 한번 해봅니다.";
			return message;
		}
		
		@GetMapping("/ajaxTest.do")
		public String akaxTest() {
			return "notice/ajaxTest";
		}
}
