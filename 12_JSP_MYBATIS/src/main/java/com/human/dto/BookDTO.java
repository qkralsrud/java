package com.human.dto;

public class BookDTO {
	
	private int no;
	private String title;
	private String author;
	
	public BookDTO() {}
			
	public BookDTO(int no, String title, String author) {
		super();
		this.no = no;
		this.title = title;
		this.author = author;
	}


	@Override
	public String toString() {
		
		return "BookDTO [no=" + no + ", title=" + title + ", author=" + author + "]";
	}



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
	
	
	
}
