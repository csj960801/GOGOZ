package com.myapp.Service;

import java.util.Map;

import com.myapp.VO.MemberVO;
import com.myapp.VO.UpdateVO;

public interface MemberCrudService {

	// 회원가입
	 boolean MemberRegister(MemberVO vo);
	//boolean MemberRegister(Map<String, Object> user);

	// 로그인
	boolean MemberLog(MemberVO vo);
	//boolean MemberLog(Map<String, Object> user);

	// 회원중복검사
	boolean MemberDuplicateCheck(MemberVO vo);

	// 회원탈퇴
	boolean MemberDelete(String email);

	// 회원수정
	boolean MemberUpdate(UpdateVO vo);

}// end of interface