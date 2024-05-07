package com.human.inhefit.override;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Application {
	public static void main(String[] args) {
//		SupersonicAirplane sa = new SupersonicAirplane();
//		sa.fly();
//		sa.flyMode = SupersonicAirplane.SUPERSONIC;
//		sa.fly();
//		sa.flyMode = SupersonicAirplane.NORMAL;
//		sa.fly();
		Book book = new Book("혼자공부하는", "신용권", 25000);
		Book book1 = new Book("혼자공부하는자바", "신용권", 30000);
		
		Book bookArr[] = new Book[5];
		bookArr[0] = book;
		bookArr[1] = book1;
		
		System.out.println("============");
		System.out.println(Arrays.toString(bookArr));
		System.out.println("============");
		System.out.println(bookArr);
		System.out.println(book);
		System.out.println(book1);
		
		if(book.equals(book1)) {
			System.out.println("동일한 책입니다.");
		} else {
			System.out.println("다른 책입니다.");
		}
	}
}
