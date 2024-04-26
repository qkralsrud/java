package com.human.lib2;

public class Library {
	Book bookArr[] = new Book[10];
	
	//생성자를 이용해서 도서를 추가 
	public Library() {
		bookArr[0] = new Book("밤하늘 기차", false);
		bookArr[1] = new Book("하늘 열차", false);

	}
	
	@Override
	public String toString() {
		String str = "<< 도서 목록 >> \n";
		int i = 0;
		for(Book book : bookArr) { //bookArr 배열을 book에 저장해 
			if(book != null) {
				str += i +" "+ book.toString() + "\n";
				i++;
			}
	}
		return str;
	}
	
	//도서대여
	public void rentBook(int no) {
		Book book = bookArr[no]; //배열의 몇번째 방에있는 책을 꺼내서 book에 저장할꺼야 
		if(book ==null) {
			System.out.println("도서번호를 잘못입력하셨습니다.");
			return;
		}
		if(book.isRent()) { //그리고 그 꺼내온 책을 rent값에 저장해서 가져올꺼야
			System.err.println("대여중 입니다."); //err 빨간 글씨로 나옴 
			return; //void 이지만 return을 쓰는 이유는 여기서 종료하겠다는 의미 
		}
//		bookArr[no].setRent(true);
		book.setRent(true);
		System.out.println("대여 되었습니다.");
	}
	//도서 반납
	public void returnBook(int no) {
		Book book = bookArr[no];
		if(book ==null) {
			System.out.println("도서번호를 잘못입력하셨습니다.");
			return;
		}
		if(book.isRent()) {
			book.setRent(false);//반납을 했으니까 false로 바꿔줌 
			System.out.println("반납 되었습니다.");
		}else {
			System.out.println("반납 가능한 상태가 아닙니다. 관리자에게 문의해주세요");
		}
//		bookArr[no].setRent(false);
//		System.out.println("반납 되었습니다.");
	}
	
	
//	//메서드를 이용해서 도서를 추가 
//	public boolean insertBook(Book book) {
//		return false;
//		
//	}
	
//	public static void main(String[] args) {
//		Library lib = new Library();
//		
//		System.out.println(lib);
//		lib.rentBook(0);
//		System.out.println(lib);
//		lib.returnBook(0);
//		System.out.println(lib);
//		
//		lib.bookArr[0] = new Book("밤하늘 기차", false);
//		
//		for(Book b : lib.bookArr) {//lib(library)에 있는 배열을 꺼내서 변수 b에 저장해 
//			System.out.println(b);
//		}
	//}
}
