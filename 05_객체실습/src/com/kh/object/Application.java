package com.kh.object;

import com.kh.object.practice.Product;

public class Application {
	public static void main(String[] args) {
		// 매개변수 생성자를 이용하여 3개의 객체 생성 (위의 사용데이터 참고)
		Product p = new Product("ssgnote9", "갤럭시노트9", "경기도 수원", 960000, 10.0);
		Product p1 = new Product("lgxnote5", "LG스마트폰5", "경기도 평택", 780000, 0.7);
		Product p2 = new Product("ktsnote3", "KT스마트폰3", "서울시 강남", 250000, 0.3);
		// 객체가 가진 필드 값 출력 확인
		System.out.println( p.information());
		System.out.println( p1.information());
		System.out.println( p2.information());
		System.out.println("======================================");
		// 각 객체의 가격을 모두 120만원으로 변경 / 부가세율도 모두 0.05로 변경
		p.setPrice(1200000);
		p.setTax(0.05);
		p1.setPrice(1200000);
		p1.setTax(0.05);
		p2.setPrice(1200000);
		p2.setTax(0.05);
		// 객체가 가진 필드 값 출력 확인
		System.out.println( p.information());
		System.out.println( p1.information());
		System.out.println( p2.information());
		System.out.println("======================================");
		// 각 객체의 가격에 부가세율을 적용한 실제 가격을 계산해서 출력함
		// 실제가격 = 가격 + (가격 * 부가세율)
		double price = p.getPrice() + (p.getPrice() * p.getTax());
		System.out.println("상품명 = "+ p.getName());
		System.out.println("부가세 포함가격 : "+(int)price);
		System.out.println("상품명 = "+ p1.getName());
		System.out.println("부가세 포함가격 : "+(int)price);
		System.out.println("상품명 = "+ p2.getName());
		System.out.println("부가세 포함가격 : "+(int)price);
		}
}
