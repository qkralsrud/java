package com.human.vo;

// 데이터를 담는 역할
public class BookVO {
	
	// 필드 - 값을 할당 하지 않으면 타입의 기본값으로 생성됨
	private int no;
	private String title;
	private String author;
	private String publisher;
	private String price;
	private String pub_date;
	
	// 생성자 - 클래스명과 동일한이름, 반환타입 없음
	// 기본생성자
	public BookVO() {}
	
	public BookVO(int no, String title, String author) {
		// 필드에 매개변수로 넘어온 값을 저장
		this.no = no;
		this.title = title;
		this.author = author;		
	}
	
	public BookVO(int no, String title, String author, String publisher, String price, String pub_date) {
		super();
		this.no = no;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.pub_date = pub_date;
	}

	// 메서드
	@Override
	public String toString() {
		String str = no +"/"+ title +"/"+ author +"/"+ publisher +"/"+ price +"/"+ pub_date;
		// 클래스 내부에 있는 메서드를 실행 하기 위해서 메서드 이름을 불러줍니다
		String strGet = getNo() +"/"+ getTitle() +"/"+ getAuthor() +"/"+ getPublisher() +"/"+ getPrice() +"/"+ getPub_date();
		return strGet;
	}
	
	
	public static void main(String[] args) {
		BookVO book = new BookVO(1, "혼공자", "신용권");
		System.out.println("book : " + book);
		System.out.println("book.toString : " + book.toString());
		
		// setter, getter 메서드 활용 
		book.setPublisher("한빛미디어");
		book.setPrice("25,000");
		book.setPub_date("2024-01-10");
		
		System.out.println(book);
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPub_date() {
		return pub_date;
	}

	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}
	
	
	
}
