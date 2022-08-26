package co.micol.prj.notice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeVO;

@RestController  //@Controller + @ResponseBody 호출한 페이지로 결과를 돌려준다.
public class NoticeAjaxController {
	@Autowired
	private NoticeService ns;
	
	@RequestMapping("/ajaxSearch.do")
	public List<NoticeVO> ajaxSearch(@RequestParam String key, @RequestParam String val) {	
		System.out.println("=======================박은지 바보");
		System.out.println("========================="+ key);
		return ns.noticeSearch(key, val);
	}
	
	

}
