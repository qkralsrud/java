package com.human.lib;

public class Book {
	//필드
	private String title;
	private String author;
	private int price;
	private boolean rent; //true 대여중 , false 대여가능
	
	//생성자
	public Book(){
		
	}
	
	public Book(String title, String author, int price, boolean rent) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.rent = rent;
	}
	
	public String info() {
		String rentStr = rent ? "대여중": "대여가능";
		return title +"/"+ author +"/" +price +"/" +rentStr;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isRent() {
		return rent;
	}

	public void setRent(boolean rent) {
		this.rent = rent;
	}
	
	
	
}
