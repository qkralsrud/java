package com.human.arr;

public class A_Array {
	/*
	 * 배열
	 * 
	 * [표현법]
	 *   1) 배열의 선언
	 *      자료형[] 배열명;
	 *      자료형 배열명[];
	 *      
	 *   2) 배열의 할당
	 *      배열명 = new 자료형[배열크기];
	 *      
	 *   3) 배열의 선언과 할당을 동시에 진행
	 *      자료형[] 배열명 = new 자료형[배열크기];
	 *      자료형 배열명[] = new 자료형[배열크기];
	 *      
	 *   4) 배열의 초기화
	 *      4-1) 인덱스를 이용한 초기화
	 *           배열명[0] = 값1;
	 *           배열명[1] = 값2;
	 *           ...
	 *           
	 *      4-2) 선언과 동시에 초기화
	 *           자료형[] 배열명 = {값1, 값2, 값3, ... };
	 *           자료형 배열명[] = {값1, 값2, 값3, ... };
	 *           자료형[] 배열명 = new 자료형[] {값1, 값2, 값3, ... };
	 *           자료형 배열명[] = new 자료형[] {값1, 값2, 값3, ... };
	 *           
	 *      4-3) 반복문을 이용한 초기화
	 *      
	 */ 
	
	public static void main(String[] args) {
		//같은 타입의 데이터를 여러개 저장하기 위해서 
		
		//배열 선언
		int[] numArr;
		int numArr1[];
		
		//배열에 값을 할당
		numArr = new int[5];
		
		System.out.println(numArr);
		
		for(int i=0 ; i < numArr.length; i++) {
			System.out.println(" numArr["+i+"] = "+  numArr[i]);
			
		}
		
		
	}
	
	
}
