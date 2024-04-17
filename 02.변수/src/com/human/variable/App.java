package com.human.variable;

import com.human.variable.practice.A_Variable;
import com.human.variable.practice.B_KeyBoardinput;
public class App {

	public static void main(String[] args) {
		//()매개변수를 넣을수 있다
		//객체의 설계도를 바탕으로 객체를 생성
		//객체가 가지고 있는 메서드를 사용하기 위해서 
		//변수를 선언하고 변수에 객체를 생성해서 저장합니다.
//		A_Variable a = new A_Variable();
//		A_Variable b = new A_Variable("Variable");
//	//	a.declear();
		B_KeyBoardinput b = new B_KeyBoardinput();
		b.inputByScanner();
	}

	//생성자의 특징 반환타입이 없고 클래스이름과 같은 메서드명 
	//기본 생성자 : 컴파일러에 의해서 자동으로 만들어지는 생성자로 매개변수가 없다
	public App() {
		
	}
}
