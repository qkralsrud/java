package com.human.dto;

public class BookDTO {
	
	private int no;
	private String title;
	
	public BookDTO() {}
	
	public BookDTO(String noStr, String title, String author) {
		super();
		if(noStr != null) {
			try {
				this.no = Integer.parseInt(noStr);
				this.title = title;
				this.author = author;				
			} catch (Exception e) {
				this.no= 0;
				this.title="";
				this.author="";
				// TODO: handle exception
			}
		}

	}

	private String author;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	
	@Override
	public String toString() {
		return no +"/"+ title +"/"+ author;
	}
}
