package com.human;

import java.util.Scanner;

import com.human.lib.Book;
import com.human.lib.Library;
import com.human.util.ScannerUtil;

public class Application {
	 public static void main(String[] args) {
		 Library lib = new Library();
		 int no =0;
		 System.out.println("[도서관]");
		int menu = ScannerUtil.getInt("1.대여 2.반납 3.등록 4.삭제 5.종료 \n메뉴 :");
		if(menu == 1) {
			System.out.println("[대여]");
			System.out.println(lib);
			
			no = ScannerUtil.getInt("책번호 : ");
			lib.rentBook(no);
			
		}else if(menu ==2) {
			System.out.println("[반납]");
			System.out.println(lib);
			no = ScannerUtil.getInt("책번호 : ");
			try {
				lib.returnBook(no);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("msg : "+ e.getMessage());
				System.out.println("반납불가");
			}
			
		}else if(menu ==3) {
			System.out.println("[등록]");
			String title = ScannerUtil.getString("제목 : ");
			String author =ScannerUtil.getString("작가: ");
			int price =ScannerUtil.getInt("가격: ");

			Book book = new Book(title, title, menu, false);
			System.out.println(lib);
			no = ScannerUtil.getInt("책번호 : ");
			lib.intsertBook(book, no);
			
		}else if(menu==4) {
			System.out.println("[삭제]");
			System.out.println(lib);
			no = ScannerUtil.getInt("책 번호 : ");
			lib.removeBook(no);
			
		}else if(menu ==5) {
			System.out.println("[종료]");
			System.exit(-1);
		}else {
			System.out.println(menu +"는 없는 메뉴 입니다.");
			
		}
	}
}
