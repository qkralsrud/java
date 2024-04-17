package a.b.c;

public class Student {
	
	//필드 - 속성을 정의해둔건 
	//변수를 선언후 값을 대입
	//직접 값을 대입할수도 있고 생성자를 이용할 수도 있다
	String name ;
	int age;
	
	//생성자를 만드는 방법 
	//반환 타입이 없고 클래스와 동일한 이름을 사용한다
	public Student(String name, int age){
		//필드명과 매개변수명이 같은경우 매개변수가 우선된다
		this.name = name;
		this.age = age;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//학생 개체를 생성하고 학생 객체가 가지고 있는 필드값을 출력 해보자
		
	 Student student1 =	new Student();
	 student1.name = "gom";
	 student1.age = 25;
	 
	 System.out.println("기본생성자를 이용하여 객체를 생성");
	 System.out.println("기본생성자 : " + student1.age);
	 System.out.println("기본생성자 : " + student1.name);
	 
	 Student 미선 = new Student("미선",24);
	 System.out.println("매개변수가 있는 생성자를 이용하여 객체를 생성");
	 System.out.println("생성자를 이용하여 필드를 초기화");
	 System.out.println(미선.name);
	 System.out.println(미선.age);
	}

}
