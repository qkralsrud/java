package com.human.util;

import java.util.Scanner;

/*
 * 싱글톤 패턴 
 * 프로그램에서 공유의 목적으로 하나의 객체만 생성해서 사용하는 경우 
 *  -> 생성자를 private 으로 만들어서 객체를 생성할 수 없도록 
 *  -> 정적메서드를 구현 
 */
public class ScannerUtil {
	//static 은 정적메소드 static 에있는건 static 서만 사용가능 
	private static Scanner scan = new Scanner(System.in);
	
	private ScannerUtil() {
		
	}
	
	public static int getInt(String msg) {
		int res = 0;
		
		//숫자가 입력될때 까지 반복
		while(true) {
			try {
				System.out.println(msg);
				res = scan.nextInt();
				scan.nextLine();
				return res;
			} catch (Exception e) {
				System.out.println("숫자만 입력 가능합니다.");
				scan.nextLine();
			}
		}
	}
	
	public static String getString(String msg) {
		String res = "";
		System.out.print(msg);
		res = scan.nextLine();
		return res;
	}

	
	
}
