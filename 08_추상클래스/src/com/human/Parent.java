package com.human;

public class Parent {
	public void a() {
		System.out.println("Parent.a()");
	}
	public void b() {
		System.out.println("Parent.b()");
	}
	
	public void method(Parent p) {
		//부모타입의 객체를 받아서 자식 객체로 강제 형변환 
		/*강제형변환시 발생하는 오류를 막기위해
		 * 형변환이 가능한지 확인 후 강제 형변환을 진행 
		 */
		//객체 뒤는 내가 확인하고싶은 타입 이 객체가 이 타입으로 변환 가능한지
		if(p instanceof Child) {
			Child child = (Child) p;
			child.c();
			System.out.println("형변환 성공");
		}else {
			System.out.println("타입변환 안됨");
		}
	}
}
