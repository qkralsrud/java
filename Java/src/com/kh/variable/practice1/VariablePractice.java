package com.kh.variable.practice1;

import java.util.Scanner;

public class VariablePractice {
	public static void main(String[] args) {
		  VariablePractice v = new VariablePractice(); 
		v.method5();
	}
	public void method1() {
		String name;
		String gender;
		int age;
		double height;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요 : ");
		name=scanner.next();
		
		scanner.nextLine();
//		System.out.println(scanner.next());
		
		System.out.println("나이를 입력하세요 : " );
		age=scanner.nextInt();
		
		System.out.println("성별을 입력하세요(남/여) : " );
		gender=scanner.next();
		
		System.out.println("키를 입력하세요(cm) : ");
		height =scanner.nextDouble();
		
		System.out.println("키" + height + "인" + age + "살" + gender+" "+name + "님 반갑습니다.^^");
		//print (출력), println(출력후 줄바꿈), printf(출력형식을 지정
		//출력 형식 (%s - 문자열 , %d- 정수 , %f - 실수 , %c - char ) 
		System.out.printf("당신의 이름 은 %s 이고 나이는 %d 키는%f cm 성별은 %s 입니다.",name , age, height,gender);
	}
	
	public void method2() {

		Scanner scanner = new Scanner(System.in);
		int num1, num2;
		System.out.println("첫번째 정수를 입력하세요 : ");
		num1 = scanner.nextInt();
		System.out.println("두번째 정수를 입력하세요 : ");
		num2 = scanner.nextInt();
		
		System.out.println(num1 + num2);
		System.out.println(num1 - num2);
		System.out.println(num1 * num2);
		System.out.println(num1 / num2);
	}
	
	public void method4() {
		
	}
	public static void method5() {
		double num1,num2,num3;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("국어 : ");
		 num1 = scanner.nextDouble();
		 System.out.print("영어 : ");
		 num2 = scanner.nextDouble();
		 System.out.print("수학 : ");
		 num3 = scanner.nextDouble();
		 
		 double sum = num1 + num2+ num3;
		 double avg = sum/3;
		 
		 System.out.printf("총점 : %.1f ",sum );
		 System.out.printf("평균 : %d ",(int)avg);
		
		 if(num1 >= 40 && num2 >= 40 && num3 >=40 && avg >= 60){
			 System.out.println("합격");
		 }else {
			 System.out.println("불합격");
		 }
		
	}
	
}
