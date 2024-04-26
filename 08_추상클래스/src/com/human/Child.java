package com.human;

public class Child extends Parent{
	@Override
	public void b() {//b는 재정의 함 
		System.out.println("Child.b");
	}
	
	public void c() {
		System.out.println("Child.c");
	}
}
