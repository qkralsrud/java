package com.human;

public class Application {
	public static void main(String[] args) {
		Child child = new Child(); 
		//자동 형변환(자식객체는 부모타입에 대입 할 수 있다)
		//1. 객체를 생성후 대입
		Parent parent = child; //타입이 다른데 들어감 >> 자동형변환
		//2. 선언과 동시에 생성
		Parent parent1 = new Child();
		
		parent.a();
		parent.b(); // 자식이 재정의해놨기때문에 자식메서드 호출됨 
		//부모타입으로 변환되면 
		//부모가 가지고 있는 필드와 메서드만 사용가능 
		//parent.c(); c는 자식이 가지고 있는 메서드 이기때문에 안됨 
		
		//강제형변환 (자식타입 > 부모타입으로 변환시 명시적으로 타입을 적어줌) 
//		Child c = (Child)parent; //parent의 타입은 Parent인데 Child로 강제로 형변환 함
//		c.c();
		
		//생성된 타입으로 변환이 가능 
		//타입변환이 가능한지 객체의 타입을 확인후 형 변환을 진행 
		//객체 instanceof 타입  parent가 Child타입으로 변환이 가능한지 확인 하는거 
		if(parent instanceof Child) { //instanceof는 변환 가능한지 체크하는거
			Child c = (Child)parent; //parent의 타입은 Parent인데 Child로 강제로 형변환 함
			c.c();
		}else {
			System.out.println("형변환이 불가능 합니다.");
		}
		
		
	}
}
