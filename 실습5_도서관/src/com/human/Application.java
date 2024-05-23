package com.human;

import java.util.Scanner;

import com.human.service.BookService;
import com.human.service.MemberService;
import com.human.vo.BookVO;
import com.human.vo.MemberVO;

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
		
		String id, pw;
		MemberService service = new MemberService();
		BookService bookService = new BookService();
				
		while(true){
			MemberVO loginMember = null;
			// 로그인 처리
			do{
				//로그인 해주세요
				System.out.println("로그인");// 세션(서버에 저장), 쿠키(웹브라우져)
				System.out.print("아이디 : ");
				id = scanner.next();
				System.out.print("비밀번호 : ");
				pw = scanner.next();
				
				loginMember = service.login(id, pw);
			// do{실행로직}while(조건)
			// 최초 한번은 무조건 실행후 조건문이 참인 경우 반속 실행
			} while(loginMember == null);
			
			// 로그인한 사용자의 정보를 바탕으로 관리자인지 사용자인지 판단
			if(loginMember.isAdmin()) {// 관리자 메뉴 시작============
				// 로그인 처리가 성공이고, isAdmin이 true이면 관리자 메뉴를 보여줍니다.
				// 사용자 메뉴
				
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
	
				} else if(menu == 4) {
					System.out.println("아이디를 입력 해주세요");
					id = scanner.next();
					
					// 아이디 중복 체크
					// 사용가능 : true, 사용불가능 : false
					boolean checkId = service.checkId(id);
					// 아이디가 중복된 경우 - 메세지처리
					if(!checkId) {
						while(true) {
							// 아이디를 다시 입력 받아야 함
							System.out.println("아이디를 입력 해주세요");
							id = scanner.next();
							checkId = service.checkId(id);
							// 사용가능한 아이디이면 반복문 탈출
							if(checkId) {
								break;
							}
						}
						
					}
					// 아이디가 중복되지 않은경우
					System.out.println("비밀번호를 입력 해주세요");
					pw = scanner.next();
					System.out.println("이름을 입력 해주세요");
					String name = scanner.next();
					
					MemberVO vo = new MemberVO(id, pw, name, "Y", null , null);
	
					service.insertMember(vo);
					
				}
			}// 관리자 메뉴 끝 ====================
			else {// 사용자 메뉴 시작
				System.out.println("1. 도서대여 2. 도서반납 3. 대여현황");
				System.out.print("메뉴를 선택 해주세요.");
				int menu = scanner.nextInt();
				scanner.nextLine();
				if(menu == 1) {
					System.out.println("도서번호를 입력 해주세요");
					int no = scanner.nextInt();
					scanner.nextLine();
					
					boolean rent = bookService.rent(no, loginMember.getId());
					System.out.println("rent");
				} else if (menu ==2) {
					System.out.println("도서번호를 입력 해주세요");
					int no = scanner.nextInt();
					scanner.nextLine();
					boolean resReturn = bookService.returnBook(no);

					
				}
				
				
			}// 사용자 메뉴 끝
		}
		System.out.println(lib);
		
		// 자원을 사용하는경우 반납 하는 메서드가 존재
		scanner.close();
	}
}
