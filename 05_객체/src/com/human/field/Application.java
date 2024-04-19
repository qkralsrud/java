package com.human.field;

public class Application {
//이공간에는 필드선언 , 생성자. 메서드 올수 있음
	
	public static void main(String[] args) {
		A_field a = new A_field(); //객체
		System.out.println( a.publicField);
		System.out.println( a.protectedField);
		System.out.println( a.defaultField);
//		System.out.println( a.privateField); //같은 패키지에 있어도 사용할수 없음
		
		
		
	}
}
