package a.b.c;

public class 강사 {
	String name;
	 int age;
 	String 과목;
 	
 	//접근 제한자 반환타입 메서드명 (매개변수 타입 매개변수명){}
 	public void 수업하다(int time) {
 		System.out.println(name + "강사님, " + time + "시간 수업을 진행");
 	}
 	
 	//생성자 - new 키워드를 만나서 객체를 생성 (메모리에 올린다
 	//반환타입이 없고 클래스명과 동일한 이름을 갖는다.
 	강사(String name, int age ,String 과목){
 		this.name = name;
 		this.age = age;
 		this.과목 = 과목;
 	}
 	

	public static void main(String[] args) {
// 	객체를 생성후 변수에 담아둔다.
// 		변수명으로 필드, 메서드에 접근할 수 있다.
//		강사 t = new 강사();
//		t.name = "park";
//		t.age = 20;
//		t.과목 = "java";
		
		강사 t = new 강사("park", 20 , "java");
		
		t.수업하다(4);
	}
	
}
