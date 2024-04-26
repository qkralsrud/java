package com.human.exam01;

public class Driver {
	//부모의 타입을 메개변수로 사용할 경우,
	//자식 객체를 매개변수로 받을수 있으므로 다양한 결과를 출력할 수 있다.
	public void drive(Vehicle vehicle) {
		//만약, 자식객체가 메서드를 재정의 한 경우 
		//자식객체의 메서드가 실행된다.
		vehicle.run();
		
	}
}
