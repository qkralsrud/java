package com.human.library;

public class BookVO {

	//필드 선언
	private int No;
	private String TITLE;
	private String AUTHOR;
	private String PUBLISHER;
	private int PRICE;
	private String PUB_DAY;
	
	public BookVO() {
		
	}
	//생성자
	//no,title,author
	public BookVO(int No,String TITLE,String AUTHOR ) {
		this.No = No;
		this.TITLE = TITLE;
		this.AUTHOR = AUTHOR;
		
	}
	//toString 메서드 재정의
	@Override
	public String toString() {
		String str ="BookVO [No=" + No + ", 제목=" + TITLE + 
				", 작가=" + AUTHOR + ", 출판사=" + PUBLISHER + 
				", 가격=" + PRICE + ", 출판일=" + PUB_DAY + "]";
		String strGet = getNo()+"/"+ getTITLE()+"/"+  getAUTHOR() 
						+"/"+getPUBLISHER()+"/"+getPRICE()+"/"+getPUB_DAY();
		
		return strGet;
	}
	
	public static void main(String[] args) {
		BookVO book = new BookVO(1,"혼공자","신용권");
		System.out.println("book : "+ book);
		System.out.println("book.toString :"+ book.toString());
		
		book.setPUBLISHER("한빛미디어");
		book.setPRICE(25000);
		book.setPUB_DAY("2024-01-10");
		
		System.out.println(book);
		
	}
	//패키지 명과 클래스명 @ 주소 16진수 코드값으로 출력
	
	public int getNo() {
		return No;
	}


	public void setNo(int no) {
		No = no;
	}


	public String getTITLE() {
		return TITLE;
	}


	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}


	public String getAUTHOR() {
		return AUTHOR;
	}


	public void setAUTHOR(String aUTHOR) {
		AUTHOR = aUTHOR;
	}


	public String getPUBLISHER() {
		return PUBLISHER;
	}


	public void setPUBLISHER(String pUBLISHER) {
		PUBLISHER = pUBLISHER;
	}


	public int getPRICE() {
		return PRICE;
	}


	public void setPRICE(int pRICE) {
		PRICE = pRICE;
	}


	public String getPUB_DAY() {
		return PUB_DAY;
	}


	public void setPUB_DAY(String pUB_DAY) {
		PUB_DAY = pUB_DAY;
	}
	
	

	
	
}
