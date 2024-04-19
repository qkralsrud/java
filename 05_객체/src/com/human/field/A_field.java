package com.human.field;
/*
 * 1.필드 (인스턴스 변수,멤버변수,전역변수,필드)
 * -클래스 영역 어디서든 사용이 가능하다.
 * -필드의 생성과 소멸 
 * 		생성 : new연산자를 통해서 객체 생성시 메모리 할당.
 * 		소멸 : 객체가 소멸될때 같이 소멸
 * 
 *  2.클래스 변수 (static 필드)
 *  -static 키워드가 붙은 필드를 클래스 변수 또는 static 필드라고 한다.
 *  -프로그램 실행과 동시에 메모리에 할당되고 객체들이 공유하면서 사용할 목적으로 선언!
 *  -클래스 변수의 생성과 소멸 
 *  	생성: 프로그램 실행시 생성
 *  	소멸: 프로그램 종료시 소멸 
 *  
 *  3.지역변수 
 *  -{}코드블럭 안에서 선언되는 변수 
 *  -메서드,제어문(if,for,while...)
 *  -접근제한자를 가질수 없음  오직 타입만 있다.
 *  -지역변수의 생성과 소멸 
 *  	생성: {}코드블럭 실행시 메모리 영역에 할당 
 *  	소멸: {}코드블럭 종료시 소멸 
 *  
 *  필드에서 사용가능한 접근 제한자 
 *  1. public - 모든 패키지에서 사용가능 
 *  2. protected - 같은 패키지 또는 상속관계
 *  3. default - 같은 패키지에 있는 경우 사용 가능 
 *  4. private - 해당클래스 내부에서만 사용이 가능
 *  		(캡슐화에 이용이 많이 됨 )
 *  
 *  * - 접근 제한자 : 외부에서 접근할 수 있는 범위를 제한할 수 있다.
 *       public(+) > protected(#) > default(~) > private(-)으로 갈수록 접근 제한이 강화된다. 
 *  
 * 
 * 
 */
public class A_field {
	public int field;
	public String publicField = "public";
	protected String protectedField = "protected";
	String defaultField = "default";
	private String privateField = "private";
	
		
	
	
	
	
	
	
	
}
