package com.human.obj;

public class Constant {
	/*
	 * final 키워드 
	 * 초기값이 저장되면 최종값이 되어 프로그램 실행도중 수정 불가
	 * 초기화 이후 값을 변경할 수 없다.
	 * 
	 * final 필드의 초기화
	 * -선언과 동시에 초기화
	 * -생성자를 이용해서 초기화
	 */
	
	/*
	 * 상수 - 불변값을 저장하는 필드 
	 * -final키워드만 붙어있는 경우 생성자를 통해 인스턴스마다 다른값을 가질수 있다
	 */
	final String nation = "korea";
	final String ssn;
	String name;
	
	Constant(String ssn, String name){
		this.ssn = ssn;
		this.name = name;
//		nation = "eng"; 이미 값이 final로 설정되어있는 값을 변경하려 하면 오류남 
	}
}
