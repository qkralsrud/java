package com.kh.object;

import com.kh.object.practice.Book;

public class Application {
	public static void main(String[] args) {
		// 기본생성자를 이용하여 첫 번째 Book 객체 생성
		Book b = new Book(null, 0, 0, null);
		// 매개변수 생성자를 이용하여 두 번째 Book 객체 생성 (사용 데이터 참고)
		Book b1 = new Book("자바의정석", 20000, 0.2 ,"윤상섭");
		// 객체가 가진 필드 값 출력 확인
	 	System.out.println(b.information());
	 	System.out.println(b1.information());
	 	System.out.println("======================================");
		// 첫 번째 객체가 가진 값을 setter를 이용하여 수정
	 	b.setTitle("C언어");
	 	b.setPrice(30000);
	 	b.setDiscountRate(0.1);
	 	b.setAuthor("홍길동");
		// 수정된 내용 출력 확인
	 	System.out.println(b.information());
	 	System.out.println(b1.information());
	 	System.out.println("======================================");
		// 각 객체의 할인율을 적용한 책 가격을 계산해서 출력
		// 할인된 가격 = 가격 – (가격 * 할인율)
	 	double dsprice = b.getPrice()-(b.getPrice()*b.getDiscountRate());
	 	double dsprice1 = b1.getPrice()-(b1.getPrice()*b1.getDiscountRate());
	 	System.out.println("도서명 ="+b.getTitle());
	 	System.out.println("할인된 가격 ="+(int)dsprice+"원");
	 	System.out.println("도서명 ="+b1.getTitle());
	 	System.out.println("할인된 가격 ="+(int)dsprice1+"원");
	}
}
