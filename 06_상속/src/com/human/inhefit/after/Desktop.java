package com.human.inhefit.after;

/*
 * [표현법]
 * 	접근제한자 class 클래스명 extends 부모클래스명 {...}
 * 
 * 자식클래스에서 부모클래스 선택 
 * 부모는 하나만 선택 가능 
 * 
 * 상속의 장점 
 * 		-적은 양의 코드로 새로운 클래스를 작성 
 * 		-코드를 공통적으로 관리 하므로 추가나 변경이 용이하다 
 * 		-코드의 중복을 제거하여 프로그램의 생산성과 유지보수에 크게 기여한다.
 */
public class Desktop extends Product {
	private boolean allInOne; // 일체 여부 

/*
 * 부모 필드를 초기화 하는 방법 
 * 	1. 부모의 생성자를 호출해서 초기화
 * 		super(매개값, ...)를 통해 자식의 생성자에서 부모의 생성자를 호출할수 있다
 * 	
 * 2. setter 메서드를 이용해서 초기화
 * 		부모필드(메서드의) 접근제한자가 private 인 경우 접근 불가능 
 * 
 * 3. super. 을 통해 필드에 직접 접근 
 * 		접근제한자가 우선됨 
 * 	
 */
	public Desktop(String brand, String pCode, String name, int price,boolean allInOne) {
		super(brand, pCode, name, price);
		super.setBrand(brand);
		setName(name);
		this.allInOne = allInOne;
	}
	
	@Override
	public String information() {
		return super.information()+allInOne;
		
	}
	
	//생성자
//	public Desktop(boolean allInOne) {
	//부모생성자 호출 
//		super(brand, pCode, name, price);
//		super.getBrand();
//		System.out.println(super.brand);//부모에 접근할때  사용되는 키워드
//		System.out.println(super.getName()); //접근제한자가 private 이면 부모여도 접근 불가
//		this.allInOne = allInOne;
//	}

	public boolean isAllInOne() {
		return allInOne;
	}

	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}

}
