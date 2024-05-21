package com.human;

import java.util.Scanner;

import com.human.vo.BookVO;

public class Application {
	/**
	 * 프로그램 실행을 담당
	 * @param args
	 */
	public static void main(String[] args) {
		// 생성자에 의해서 도서목록이 초기화		
		Library lib = new Library("영등포 도서관");
		
		// 사용자의 입력을 받기 위한 객체를 생성
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("===============================");
		System.out.println( lib.getTitle() + "에 오신걸 환영 합니다.");
		System.out.println("===============================");
		
		while(true){
			//로그인 해주세요
			//member -> 관리자(도서등록, 삭제, 수정, 관리자등록), 사용자(도서대여, 도서반납)
			System.out.println("메뉴를 선택 해주세요.");
			System.out.println("1. 도서등록 2. 도서삭제 3. 도서수정 4. 관리자등록 5. 종료");
			// 사용자의 입력을 대기 하고 있다가 입력된 값을 받아옴
			int menu = scanner.nextInt();
			scanner.nextLine();
			if(menu == 1) {
				System.out.print("도서명 : ");
				String title = scanner.next();
				System.out.print("작가명 : ");
				String author = scanner.next();
				System.out.print("출판사이름 : ");
				String publisher = scanner.next();
				System.out.print("가격 : ");
				String price = scanner.next();
				System.out.print("출판일 : ");
				String pub_date = scanner.next();
				
				// 사용자로 부터 입력 받은 데이터로 도서객체를 생성
				BookVO vo = new BookVO(0, title, author, publisher, price, pub_date);
				lib.insertBook(vo);
			} else if(menu == 2) {
				System.out.println(lib);
	
				System.out.println("도서번호를 입력 해주세요");
				int no = scanner.nextInt();
				lib.deleteBook(no);
			} else if(menu == 5) {
				break;
			} else if(menu == 3) {
				// 도서목록 출력
				System.out.println(lib);

				System.out.print("도서번호 : ");
				int no = scanner.nextInt();
				scanner.nextLine();
				System.out.print("도서명 : ");
				String title = scanner.next();
				System.out.print("작가명 : ");
				String author = scanner.next();
				System.out.print("출판사이름 : ");
				String publisher = scanner.next();
				System.out.print("가격 : ");
				String price = scanner.next();
				System.out.print("출판일 : ");
				String pub_date = scanner.next();
				
				// 사용자로 부터 입력 받은 데이터로 도서객체를 생성
				BookVO vo = new BookVO(no, title, author, publisher, price, pub_date);
				lib.updateBook(vo);
				// 도서목록 출력
				System.out.println(lib);

			}
		}
		System.out.println(lib);
		
		// 자원을 사용하는경우 반납 하는 메서드가 존재
		scanner.close();
	}
}
