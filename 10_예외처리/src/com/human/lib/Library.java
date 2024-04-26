package com.human.lib;


public class Library {
	Book[] bookArr = new Book[10];
	Object[] objArr = {};
	public Library() {
		Book book = new Book("책0", "저자",1000,false);
		bookArr[0] = new Book("회색인간","홍길동",18900,false);
		bookArr[1] = new Book("백색의마법사","동길홍",22300,false);
	}
	
	public void  rentBook(int no) {
		try {
			Book book =bookArr[no];
			if(book.isRent()) {
				System.out.println("대여불가");
			}else {
				book.setRent(true);
			}
		}catch(Exception e){
			System.out.println("배열의 범위를 초과 하였습니다.");
		}
	}
	
	public  void  returnBook(int no) throws Exception {
		Book book = bookArr[no];//배열로 부터 해당 인덱스의 요소를 꺼내서 변수에 저장
		if(book.isRent()) {
			book.setRent(false);
		}else {
			System.err.println("반납불가");
		}
	}
	
	public void  intsertBook(Book book, int no) {
		if(bookArr[no] ==null) {
			bookArr[no] = book;
		}else {
			System.out.println("등록불가");
		}
	}
	
	public  void removeBook(int no) {
		if(bookArr[no] != null) {
			bookArr[no] = null;
		}else { //이미 비어있는 칸 
			System.out.println("삭제불가");
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		//배열에 들어있는 요소들을 차례대로 출력
		for(int i=0; i<bookArr.length; i++) {
			if(bookArr[i]==null) {
				str += i +"\n";
			}else {
				
			str += i +" "+bookArr[i].info()+"\n";
			}
		}
		return str;
	}
	
}
