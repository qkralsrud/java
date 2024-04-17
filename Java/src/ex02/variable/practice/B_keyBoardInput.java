package ex02.variable.practice;

import java.util.Scanner;

public class B_keyBoardInput {
	public void inputByScanner() {
		Scanner scanner = new Scanner(System.in);
		
		/*
		 * scanner.nextLine() : 사용자가 입력한 값을 모두 읽어온다. (문자열)
		 * scanner.next() : 사용자가 입력한 값 중에 공백이 있을 경우 공백 이전까지의 값만 읽어온다.
		 * scanner.nextInt() : 정수를 입력받을 때 사용한다.
		 * scanner.nextDouble() : 실수를 입력받을 때 사용한다.
		 * ... 그 밖에 byte, boolean 등의 기본 자료형을 입력받을 때도 마찬가지로 nextXXX()로 입력받으면 된다. 
		 */ 
		String input;
		int age;
		System.out.println("이름을 입력 해주세요");
		input = scanner.next(); //공백을 기준으로 끊어서 반환
		System.out.println(input);
		
		System.out.println("주소를 입력 해주세요");
		input = scanner.next(); //모두 반환
		System.out.println( input );
		
		System.out.println("나이를 입력해주세요");
		age = scanner.nextInt(); //입력값을 숫자로 반환  
		System.out.println(age);
		
	}

	public static void main(String[] args) {
		System.out.println("스캐너 객체를 이용해서 입력을 받아 봅시다.");
		
		//inputByScanner 실행
		//1.객체생성
		 B_keyBoardInput b   = new B_keyBoardInput();
		 b.inputByScanner();
	}
}
