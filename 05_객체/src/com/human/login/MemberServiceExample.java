package com.human.login;

public class MemberServiceExample {

	public static void main(String[] args) {
		//MemberService 객체를 생성
		
		MemberService service = new MemberService();
		boolean res = service.login("hong","1234");
		
		System.out.println("로그인 결과 : " + res);
		
		service.logout("hong");
	}
	
	

	
}
