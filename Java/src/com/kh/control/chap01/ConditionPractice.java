package com.kh.control.chap01;

import java.util.Scanner;

public class ConditionPractice {
	public static void main(String[] args) {
		ConditionPractice v = new ConditionPractice();
		v.practice4();
	}
	
	public void practice4() {
		Scanner scanner = new Scanner(System.in);
		
		int num = 0;
		String season = null;
		
		System.out.println(num + "월은"+ season + "입니다.");
		System.out.print("%d월은 %s 입니다.",num,season);
		System.out.print("1~12 사이의 정수 입력 :" );
		num= scanner.nextInt();
		//12-2 겨울 , 3-5 봄 , 6-8, 여름 ,9-11 가을
//		switch(num) {
//		case 1:
//			System.out.printf("$d 월 달은 겨울입니다.",num);
//			break;
//			
//			default:
//			 System.out.print("해당 숫자는 잘못 입력되었습니다.");
//		}
	}
}
