package co.micol.prj.notice.service;

import java.sql.Date;
import lombok.Data;

// 권장 : @Getter , @Setter
@Data
public class NoticeVO { // '구글 자바 명명규칙'대로 작성
	private int noticeId;
	private String noticeWriter;
	private String noticeTitle;
	private String noticeSubject;
	private Date noticeDate; // 시분초 : java.utll 아니면 : java.sql
	private int hit;
	private String noticeAttech;
	private String noticeAttechDir;
	
}
