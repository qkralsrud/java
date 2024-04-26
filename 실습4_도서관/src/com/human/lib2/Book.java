package com.human.lib2;

public class Book {
	private String title; //도서명 
	private boolean rent; //대여가능여부(true:대여중, false:대여가능)
	
	//파라메터 있는 생성자
	public Book(String title, boolean rent) {
		super();
		this.title = title;
		this.rent = rent;
	}
	
	@Override
	public String toString() {
		String rentStr = rent ? "대여중" : "대여가능"; 
		return title + "/"+ rentStr;
	}
	
	//setter, getter 메서드
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isRent() {
		return rent;
	}
	public void setRent(boolean rent) {
		this.rent = rent;
	}
	
	
}
