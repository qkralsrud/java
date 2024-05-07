package com.human.inhefit.after;

public class Product/*extends Object 생략되어있음*/ {
	public String brand; // 브랜드
	private String pCode; // 상품코드
	private String name; // 상품명
	private int price; // 가격
	
	public String information() {
		return brand + ","+pCode +","+name+","+price;
	}
	public Product() {
		
	}
	
	public Product(String brand, String pCode, String name, int price) {
		super();
		this.brand = brand;
		this.pCode = pCode;
		this.name = name;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
