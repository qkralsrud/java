package com.human.obj;

public class SingledtionApplication {
	public static void main(String[] args) {
		Singleton s= Singleton.getInstance();
		Singleton s1= Singleton.getInstance();
		
//		생성자의 접근제한자가 외부에서 private 인경우 접근 불가 
//		Singleton s2 =new Singleton();
		System.out.println(s);
		System.out.println(s1);
		
		if(s==s1) {
			System.out.println("같은 Singleton 객체 입니다.");
		}else {
			System.out.println("다른 Singleton 객체 입니다.");
			
		}
		
	}
}
