package com.human.obj;

/*
 * 전체 프로그램에서 단 하나의 객체만 만들도록 보장 하는 경우
 */
public class Singleton {
	//자신의 타입인 정적필드를 선언후 자신의 객체를 생성하여 초기화 한다
	private static Singleton singleton = new Singleton();
	
	/*
	 * 생성자의 접근제한자를 private으로 설정하면 
	 * 생성자를 통한 객체생성이 불가능하다
	 */
	private Singleton() {
		
	}
	static Singleton getInstance() {
		return singleton;
		
	}
}
