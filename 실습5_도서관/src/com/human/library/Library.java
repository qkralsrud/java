package com.human.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
	List<BookVO> list =new ArrayList<BookVO>();
	
	public Library() {
		for(int i=0;i <10;i++) {
			list.add(null);
		}
	}
	
	//책을 추가
	public int insertBook(BookVO vo) {
		//(조건) ? 참일경우 : 거짓인경우
		int res =list.add(vo) ? 1:0;
		return res;
		
	}
	//책을 삭제
	public int removeBook(int no) {
		BookVO vo = list.remove(no);
		if(vo != null) {
			return 1;
		}else {
			return 0;
		}
		
	}
	
	
	@Override
	public String toString() {
		String str ="";
		for(BookVO vo :list) {
			str += vo.toString()+"\n";
		}
		return str;
	}
	
	
	public static void main(String[] args) {
		
		Library lib = new Library();
		lib.insertBook(new BookVO(1,"혼공자","신용권") );
		lib.insertBook(new BookVO(2,"웹표준의정석","고경희") );
		System.out.println(lib);
		
//		List<BookVO> list = new ArrayList<BookVO>();
//		BookVO book = new BookVO(1,"혼공자","신용권");
//		BookVO book1 = new BookVO(2,"웹표준의정석","고경희");
//		list.add(book);
//		list.add(book1);
//		System.out.println(list);
//		list.remove(book);
//		System.out.println(list);
//		
//		
//		for(int i=0;i<list.size();i++) {
//			BookVO vo = list.get(i);
//		}
//		
	}
	
	
	
	
} 
