package com.myapp.VO;

import java.io.Serializable;

//데이터베이스의 user테이블의 컬럼과 클래스의 변수명을 일치시켜 맵핑.
//이렇게 DB와 접근하는 클래스를 도메인 클래스(VO객체)라고 불립니다.
public class MemberVO implements Serializable {

	private String name;
	private String email;
	
	public MemberVO() {
	}

	public MemberVO(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberVO [name= + " + name + ",email=" + email + "]";
	}// end of toString()

}// end of class