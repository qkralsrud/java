package com.human;

import java.util.Scanner;

import com.human.lib.Book;

public class Application {
	public static void main(String[] args) {
		Book bookArr[]=new Book[10];
		
		bookArr[0] = new Book("혼자공부하는자바","신용권",25000,false);
		bookArr[1] = new Book("웹표준의 정석","고경희",2000,false);
		bookArr[2] = new Book("sql","홍길동",25000,false);
		bookArr[3] = new Book("자바","김용권",27000,false);
		bookArr[4] = new Book("회색인간","저자",19000,false);
		bookArr[5] = new Book("소프트웨어 개발자","권용권",29000,false);
		bookArr[6] = new Book("하나부터","열까지",35000,false);
		bookArr[7] = new Book("머리부터","발끝까",34000,false);
		bookArr[8] = new Book("랑스러워","지다사",21000,false);
		bookArr[9] = new Book("살다가 살다가","워너비",23000,false);
		
		System.out.println("=======================");
		System.out.println("도서관에 오신걸 환영합니다.");
		System.out.println("=======================");
//		
//		for(Book book : bookArr) {
//			System.out.println(book);
//		}
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.도서대여");
			System.out.println("2.도서반납");
			System.out.println("3.종료");
			System.out.println("메뉴를 입력해주세요 : ");
			int menu = scanner.nextInt();
			
			if(menu ==1) {
				System.out.println("도서대여");
//				System.out.println(Arrays.toString(bookArr));
				System.out.println("도서목록 =========");
				for(Book book : bookArr) {
					System.out.println(book);
				}
				System.out.println("==============");
				System.out.println("도서번호를 선택해주세요");
				int num = scanner.nextInt();
				if(bookArr[num].isRent()) {
					System.out.println("이미 대여중인 책입니다.");
				}else {
					bookArr[num].setRent(true);
					System.out.println("대여 되었습니다.");
					break;
				}
				
			}else if(menu ==2) {
				System.out.println("도서반납");
			}else if (menu ==3) {
				System.out.println("프로그램을 종료 합니다.");
				System.exit(-1); //혹은 break;
			}else {
				System.out.println("1~3번까지 선택해주세요");
			}
			System.out.println("======================");
		}
	
	}
}
