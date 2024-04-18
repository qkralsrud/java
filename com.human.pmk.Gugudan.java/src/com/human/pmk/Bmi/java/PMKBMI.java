package com.human.pmk.Bmi.java;

import java.util.Scanner;

public class PMKBMI {
	public void BMi(){
		
		double height;
		double weight;
		double BMI;
		
		Scanner bmi = new Scanner(System.in);
		System.out.print("키(M) : ");
		height = bmi.nextDouble();
		System.out.print("몸무게(KG) : ");
		weight = bmi.nextDouble();
		BMI= weight / (height * height);
		
		if(BMI<18.5) {
			System.out.printf("당신의 BMI는 %.1f ,저체중입니다.",BMI);
		}else if(18.5 <= BMI && BMI <23) {
			System.out.printf("당신의 BMI는 %.1f ,정상입니다.",BMI);
		}else if(23<= BMI && BMI <25) {
			System.out.printf("당신의 BMI는 %.1f ,과체중입니다.",BMI);
		}else if(BMI >25) {
			System.out.printf("당신의 BMI는 %.1f ,비만입니다.",BMI);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		PMKBMI v = new PMKBMI();
		v.BMi();
	}
}
