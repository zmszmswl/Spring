package co.micol.prj.notice.map;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import co.micol.prj.notice.service.NoticeVO;

public interface NoticeMapper {
	@Select("select * from notice") // ibatis 속성이라 권장하지v않지만 간단한걸 사용할땐 괜찮음
	List<Map<String,Object>> noticeSelectList(); // 조인 또는 vo 객체를 만들지 않고 사용할 때 : 리스트구조와 맵객체를 이용해서 vo객체와 테이블객체가 다르거나 전달할때 vo와 받을때 vo가 조인해서 다를 경우 

	NoticeVO noticeSelect(NoticeVO vo); // NoticeVO타입
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	// 꼭기억하기 ★★★ @Param :  Mapper 인터페이스에서 매개변수를 2개 이상 사용하려고 한다면 파라매터로 넘어오는 변수를 스트링값으로 사용하겠다고 선언해줘야 맵퍼에서 인식가능
	List<NoticeVO> noticeSearch(@Param("key") String key, @Param("val") String val); // @Parem("속성명") 타입 "속성명" //
}
