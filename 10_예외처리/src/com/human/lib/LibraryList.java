package com.human.lib;

import java.util.ArrayList;
import java.util.List;

public class LibraryList {
	public static void main(String[] args) {
		
		LibraryList lib = new LibraryList();
		System.out.println(lib);
		lib.rentBook(0);
		System.out.println(lib);
		lib.returnBook(0);
		System.out.println(lib);
		
		Book book = new Book("도서3","작가3",3000,false);
		lib.insertBook(book);
		System.out.println(lib);
		
		lib.removeBook(0);
		System.out.println(lib);
	}
	List<Book> list = new ArrayList<Book>();
	
	public LibraryList() {
		list.add(new Book("도서0","작가0",1000,false));
		list.add(new Book("도서1","작가1",1000,false));
		list.add(new Book("도서2","작가2",1000,false));
	}
	
	public void rentBook(int no) {
		Book book = list.get(no);
		if(book.isRent())System.out.println("대여불가");
		else {
			book.setRent(true);
			System.out.println("대여성공");
		}
	}
	
	public void returnBook(int no) {
		Book book = list.get(no);
		if(book.isRent()) {
			book.setRent(false);
			System.out.println("반납 성공");
		}else {
			System.out.println("반납 실패");
		}
	}
	public void insertBook(Book book) {
		list.add(book);		
		System.out.println("도서추가");
		
	}
	public void removeBook(int no) {
		list.remove(no);
		System.out.println(no + "도서삭제");
		
	}
	@Override
	public String toString() {
		String str = "";
		//리스트도 인덱스로 참조 하므로 인덱스값도 함께 출력 합니다.
		for(int i=0;i<list.size();i++) {
			str += i +" "+ list.get(i).info()+"\n";
		}
		return str;
	}
	
}
