package com.human;

public class App {
	public static void main(String[] args) {
//		Parent p = new Child();
		Parent p = new Parent();
		//부모타입으로 형변환시 부모가 가진 필드, 메서드만 사용이 가능
		p.method(p);
	}
}	
