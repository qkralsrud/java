package com.human.lib2;

import java.util.Scanner;

public class Application {
	
	public static void main(String[] args) {
		Library lib = new Library();
		
		Scanner scan = new Scanner(System.in);
		int menu=0, no=0;
		//도서 목록 출력 - toString메서드를 재정의 해놨음 
		System.out.println(lib);
		
		while(true) {
			System.out.println("=========================");
			System.out.println("도서관에 오신걸 환영합니다.");
			System.out.println("=========================");
			System.out.println("1.대여");
			System.out.println("2.반납");
			System.out.println("3.도서추가");
			System.out.println("4.종료");
			System.out.println("=========================");
			System.out.println("메뉴를 추가해주세요");
			System.out.println("=========================");
			menu =scan.nextInt();
			
			if(menu == 1) {
				System.out.println("=====대여=====");
				System.out.println(lib);
				System.out.println("도서번호 : ");
				no = scan.nextInt();
				//도서대여
				lib.rentBook(no);
			}else if (menu==2) {
				System.out.println("=====반납=====");
				System.out.println(lib);
				System.out.println("도서번호 : ");
				no = scan.nextInt();
				
				lib.returnBook(no);
				
			}else if (menu ==3) {
				System.out.println("====도서추가====");
				
			}else if (menu == 4) {
				System.out.println("종료");
				break;
			}else {
				System.out.println(menu + "는 없는 메뉴 입니다.");
			}
		
		}
	}
}
