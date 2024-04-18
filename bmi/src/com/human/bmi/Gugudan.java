package com.human.bmi;

public class Gugudan {

	public static void main(String[] args) {
//1-9출력 
		int i;
		int k;
		int num;
//		for (i=2 ;i<10; i++) {
//			System.out.println(i+"단");
//			for(k=1 ;k<10 ;k++) {
//				num = i * k;
//				System.out.println(i+"X"+k +"="+num);
//			}
//		}
		
		for(k=1 ,i=2;i<10;k++) {
			num = i * k;
			System.out.print(i+" X " + k +" = "+num +"\n");
			
			if(k>8){
				i++;
				k=0;
			}
				
		}
		
	}

}
