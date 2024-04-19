package com.human.login;

public class MemberService {


//	private String id;
//	private String pw;

	public boolean login(String id, String pw) {
		//id = hong , pw =1234
		//로그인 되었습니다. 메세지 출력 후 true 값 반환
		//아니면 > 로그인 아이디가 올바르지 않습니다.메세지 출력후 false 반환
//		id = "hong";
//		pw = "1234";
		if(id.equals("hong") && pw.equals("1234")) {
			System.out.println("로그인 성공!");
			return true;
		}else {
			System.out.println("로그인 실패");
			return false;
			
		}
	}

	public void logout(String id) {
		System.out.println(id+"님 로그아웃 되었습니다.");
	}
	

}
