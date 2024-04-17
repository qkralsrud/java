package a.b.c;

public class 클래스 {
	String 반이름;
	강사 t;
	Student s;
	
	클래스(){
		반이름 = "휴면교육센터";
		t = new 강사("kim",20,"java");
		s = new Student();
		System.out.println();
	}
	
	public void info() {
		System.out.println("클래스명 : " + 반이름);
		System.out.println("강사명 : " + t.name);
		System.out.println("나이 : " + t.age);
	}
	
	public static void main(String[] args) {
		//1.객체 생성
		클래스 c = new 클래스();
		c.info();
	}
	
	
	
	
}
