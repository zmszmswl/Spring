package co.micol.prj.notice.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NoticeService {
	
	// 조인 또는 vo 객체를 만들지 않고 사용할 때 
	List<Map<String,Object>> noticeSelectList(); // key: 컬럼명 객체타입에 상관없이 value를 받아오려고 object객체로 받음 key를 불러야 value가 나와서 key를 jsp에서 부름
	// 리스트구조와 맵객체를 이용해서 vo객체와 테이블객체가 다르거나 전달할때 vo와 받을때 vo가 조인해서 다를 경우
	// VO는 1:1로 맵핑되어야하는데 해결할 방법이 없을때 마이바티스 메뉴얼을 보면 1.MAP을 만들어서하거나 2.VO의 VO를 상속받아서 하거나 MAP을 사용하는게 더 쉬움

	NoticeVO noticeSelect(NoticeVO vo); // NoticeVO타입
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	List<NoticeVO> noticeSearch(@Param("key")String key, @Param("val")String val); //값이 여러개일경우! mapper일경우에만 이렇게쓰자.  key( 제목,내용, 작성자 등등)에 어떤 val(단어)가 포함되어있으면 다 불러와라

}
