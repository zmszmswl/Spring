package co.micol.prj.member.vo;

//import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private String memberId; // 현업에서는 memberId;
	private String memberPassword;
	private String memberName;
	private String memberAuthor;

}
