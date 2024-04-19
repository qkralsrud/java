package com.human.obj;

public class MemberPrivate {
	
	//캡슐화를 적용 시키기 위해 접근 제한자를 private로 지정 
	//같은 패키지에 있더라도 직접 접근할수 없도록 접근을 막는다.
	private String name;
	private String id;
	private String password;
	private int age;
	
	//생성자 
	//반환타입이 없고 ,클래스명과 동일한 이름
	//필드를 초기화 하고 객체를 사용할 준비를 한다
	//생성자를 만들지 않으면 컴파일러에 의해서 자동으로 기본생성자(매개변수가 없는 생성자)가 만들어 지지만
	//생성자를 하나라도 만들면 기본생성자를 만들어 주지 않는다.
	public MemberPrivate(){
		System.out.println("기본생성자 호출!");
	}
	
	public MemberPrivate(String name, String id, String password, int age) {
//		super();
//		this.name = name;
//		this.id = id;
		this(name,id);
		this.password = password;
		this.age = age;
	}
	
	public void information() {
		System.out.printf("이름 : %s ,아이디 : %s, 나이 : %d, 비밀번호 : %s \n",name,id,age,password);
	}
	
	public String getInfo() {
		return "이름 :"+ name +",아이디 :"+ id +", 나이 :"+ age +", 비밀번호 : " + password;
	}
	
	public static void main(String[] args) {
		MemberPrivate mb = new MemberPrivate("kim", "homg", "123",30);
		//반환타입이 없는 경우 변수에 담을수 없다.
		mb.information();
		String info = mb.getInfo();
		System.out.println("info : "+ info);
		System.out.println("mb : "+ mb);
		System.out.println("mb : "+ mb.toString());
	}
	
	
	public MemberPrivate(String name, String id) {
		this.name = name;
		this.id = id;
	}
	/*
	 * 1) getter 메소드
	 *   - 외부에서 접근이 가능해야 하기 때문에 접근 제한자를 public으로 사용해야 한다.
	 *   - 하나의 필드의 값을 반환해 주는 기능을 하는 메소드이다.
	 *   - 메소드명은 getXXX와 같이 붙여주게 된다. (낙타 표기법으로 작성해야 한다.)
	 *   - getter 메소드는 필드에 담겨있는 값을 반환만 시켜주기 때문에 전달되는 매개 값이 없다.
	 *   - getter 메소드는 값을 반환해야 하기 때문에 반환하고자 하는 값의 자료형을 반환형에 써주어야 한다.
	 *   
	 * 2) setter 메소드
	 *   - 외부에서 접근이 가능해야 하기 때문에 접근 제한자를 public으로 사용해야 한다.
	 *   - 하나의 필드의 값을 수정하는 기능을 하는 메소드이다.
	 *   - 메소드명은 setXXX와 같이 붙여주게 된다. (낙타 표기법으로 작성해야 한다.)
	 *   - setter 메소드는 해당 필드의 값을 수정하기 때문에 전달되는 매개 값이 필요하다.
	 *     (단, 매개 값은 수정하려는 필드의 자료형과 동일해야 한다.)
	 *   - 필드에 대해서 값을 수정하는 메소드이므로 반환값이 없다.
	 */ 
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

}
