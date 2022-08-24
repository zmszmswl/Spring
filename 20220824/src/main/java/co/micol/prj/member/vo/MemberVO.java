package co.micol.prj.member.vo;

//import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private String member_id; // 현업에서는 memberId;
	private String member_password;
	private String member_name;
	private String member_author;

}
