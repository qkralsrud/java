package ex03.제어문;

import java.util.Scanner;

public class A_If {
	/*
	 * if 문
	 * 
	 * [표현법]
	 *   if(조건식) {
	 *     .. 실행할 코드 ..;
	 *   }
	 * - 보통 조건식에는 비교 연산자(>,<,>=, <=), 논리 연산자(|| or , && and , == equal )를 사용한다.
	 * - 조건식의 결과가 참(true)이면 중괄호 안의 코드를 실행한다.
	 * - 조건식의 결과가 거짓(false)이면 중괄호 안의 코드를 무시하고 넘어간다.
	 */ 
	public void method2() {
		// 주민번호를 입력 받아서  
				// 뒷 자리의 첫 번째 값이 1 또는 3이면 "남자입니다." 출력
				// 뒷 자리의 첫 번째 값이 2 또는 4이면 "여자입니다." 출력
				// 뒷 자리의 첫 번째 값이 1, 3 또는 2, 4가 아니면 "잘못 입력하셨습니다." 출력
				// 예시)
				//   주민번호를 입력하세요. (- 포함) : 000525-33333333 
		Scanner scanner = new Scanner(System.in);
		String ssn = "000525-4444444";
		//문자열의 인덱스에 해당하는 문자를 반환
		char gendercode= ssn.charAt(7);
		if(gendercode == '1' || gendercode == '3') {
			System.out.println("남자입니다.");
		}else if(gendercode == '2' || gendercode == '4') {
			System.out.println("여자입니다.");
		}else {
			System.out.println("잘못 입력 되었습니다.");
		}
		//substring : 문자열중 원하는 위치의 문자열을 반환
		//시작 인덱스 부터 끝까지
		String gendercode1= ssn.substring(7,8);
	
		
	}
	
	
	public void method1() {
		
		boolean result = false;
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
//		if(input <= 100 && input >= 1 ) {
//			result = true;
//		}
//		
//		//코드가 한줄인 경우 코드블럭 없이 사용 가능
//		//첫번째
//		//if(input <= 100 && input >= 1) result = true;
//		//두번쨰
//		//result = (input <=100) && (input >=1);
//		
//		
//		System.out.println("사용자가 입력한 값이 1이상 100이하의 값인가요? : " + result);
		
		System.out.println("입력값 :" + input);
		if(input%2 == 0) {
			System.out.println("짝수입니다.");
		}else {
			System.out.println("홀수입니다.");
		}
	}
	
	public static void main(String[] args) {
		A_If a = new A_If();
//		a.method1();
		
		while(true) {
			
			a.method2();
		}
	}
	
}
