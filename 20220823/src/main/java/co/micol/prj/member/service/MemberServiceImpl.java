package co.micol.prj.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.micol.prj.member.map.MemberMapper;
import co.micol.prj.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper map;	//IoC 컨테이너에서 자동으로(@Autowired) mybatis mapper를 주입해주는 것.
	
	@Override
	public List<MemberVO> memberSelectList() {
		// 전체 맴버 목록 가져오는것
		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// 한명의 맴버 정보 가져오기
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// 맴버추가
		return map.memberInsert(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// 맴버정보변경
		return map.memberUpdate(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// 맴버삭제
		return map.memberDelete(vo);
	}

}
