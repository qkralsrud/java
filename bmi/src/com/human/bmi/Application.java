package com.human.bmi;

import java.util.Scanner;

public class Application {
	
	private void bmi() {
		//몸무게를 키의 제곱으로 나눈 값
		//18.5 이하 저체중
		//23 정상
		//25 과체중
		//25이상 비만 
		System.out.println("BMI - 체질량지수 ===========");
		
		while(true) {
				
			Scanner s = new Scanner(System.in);
			System.out.print("키(m) :");
			double height = s.nextDouble();
			System.out.print("몸무게(kg) :");
			double wight = s.nextDouble();
			double BMI;
			BMI = wight / (height*height);
			String bmimsg = "";
			
			
			if(BMI <= 18.5) {
				bmimsg="저체중";
			}else if(18.5 < BMI && BMI <= 23) {
				bmimsg="정상";
			}else if(23 <BMI && BMI <=25) {
				bmimsg="과체중";
			}else if(BMI>25) {
				bmimsg="비만";
			}
			
	//		System.out.println("당신의 BMI 지수는" + BMI + "이고"+bmimsg +"입니다.");
			System.out.printf("당신의 BMI 지수는 %.1f 이고 %s입니다.\n",BMI,bmimsg);
			
			System.out.println("그만하시겠습니까?(Y/N)");
			String next = s.next();
//			if(next.equals("Y") || next.equals("y")) {
			if(next.equalsIgnoreCase("Y")) {
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Application v = new Application();
		v.bmi();
	}
	
}
