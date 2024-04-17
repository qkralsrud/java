package com.human.variable.practice;

import java.util.Scanner;

public class B_KeyBoardinput {
	//inputByScanner(){}
	
	public class B_KeyBoardInput {
		// inputByScanner(){}
		// 접.제 반환타입 메서드명(매개변수타입 매개변수이름){}
		public void inputByScanner() {
			// 스캐너 객체를 이용해서 사용자의 입력값을 받아 올 수 있다!
			// 객체 생성후 이용 가능
			Scanner scanner = new Scanner(System.in);
			System.out.println("BMI 구하기 =============");
			System.out.println("키를 입력해주세요 : ");
			String input = scanner.next();
			System.out.println("입력값 : " + input);
			
			
			/*
			 * scanner.nextLine() : 사용자가 입력한 값을 모두 읽어온다. (문자열)
			 * scanner.next() : 사용자가 입력한 값 중에 공백이 있을 경우 공백 이전까지의 값만 읽어온다.
			 * scanner.nextInt() : 정수를 입력받을 때 사용한다.
			 * scanner.nextDouble() : 실수를 입력받을 때 사용한다.
			 * ... 그 밖에 byte, boolean 등의 기본 자료형을 입력받을 때도 마찬가지로 nextXXX()로 입력받으면 된다. 
			 */
		}
	}