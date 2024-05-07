package com.human.inhefit.override;

/**
 * 모든 클래스는 Object 클래스의 후손이다. 
 * Object 클래스에 있는 모든 메서드를 다 사용 할 수 있다
 */
public class Book /*extends Object*/{
	
	private String title;
	private String author;
	private int price;
	
	Book(){}
	
	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
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

	public String information() {
		return title +"/"+ author +"/"+ price;
	}
	
	/**
	 * 오버라이딩
	 * 	- 자식 클래스가 상속받은 부모 클래스의 메소드를 재정의 하는 것
	 * 	- 메서드의 선언부가 같은 경우
	 *  - 자식 객체를 통해서 실행시 재정의된 메서드가 우선권을 가진다
	 *  	(부모클래스에서 정의된 메소드가 사라지는것은 아니다.)
	 *  
	 *  오버라이딩 성립 조건
	 *  - 부모 클래스의 메서드와 동일한 선언부
	 *  	(매개변수의 갯수, 자료형, 순서가 동일!!)
	 *  - 반환형 동일
	 *  - 부모 메서드의 접근 제한자의 범위와 동일 하거나 더 큰 범위
	 *  	public > protected > default > private
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		Book book = new Book("혼자공부하는자바", "신용권", 25000 );
		System.out.println( book.information() );
		// 패키지명을 포함한 풀 경로@주소
		System.out.println( book );
		
		String str = "str"; 
		System.out.println( str );
	}
	
	/**
	 * 부모 메서드의 선언부 == 자식 메서드의 선언부
	 * 부모가 가진 메서드를 자식이 재 정의
	 * 
	 * @Override 어노테이션
	 * 	- 명시를 안해줘도 오버라이딩 된다
	 * 	- 어노테이션을 붙이는 이유
	 * 		해당 메소드가 오버라이딩된 메소드라는것을 컴파일러에게 알려주는 역할
	 * 		자식 메소드에서 재정의를 잘못하고 있는 경우 컴파일 에러로 표시
	 */
	
	/**
	 * Object 클래스의 toString 메소드 오버라이딩(재정의)
	 * 	- 클래스명@16진수해시코드를 반환
	 *  - 출력메서드(print)의 경우 기본적으로 객체의 참조값을 매개값으로 냄겨주면 내부적으로 참조값.toString()메서드를 호출해서 리턴되는 값을 출력 
	 */
	@Override
	public String toString() {
		return super.toString() 
				+ "\nBook [title = " + title + ", author = "+ author +"]";
	}
	
	/**
	 * Object 클래스의 equals 메소드 오버라이딩(재정의)
	 * 	- 매개 값으로 전달받은 객체와 동일한 객체라면 true를 리턴하고 그렇지 않으면 false
	 * 		주소값 으로 비교
	 * 	- 주소값 비교가 아닌 객체가 가지고 있는 필드값을 비교 하여 반환
	 * 
	 * << 부모타입으로 자동 형 변환 되므로 모든 객체는 Object타입이 될 수 있다 >>
	 */
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		
		// 강제 형변환
		Book target = (Book) obj;
		
		// 파라메터로 넘어온 객체와 제목이 같다면 같다고 판단
		if(this.title.equals(target.title)){
			res = true;
		}
		return res;
	}
	
	
}












