package com.human.obj;

public class ConstantApplication {
	public static void main(String[] args) {
		Constant c = new Constant("123456-1234567","홍길동");
		
//		c.nation = "usa"; final 키워드가 붙어있기 때문에 변경 불가능 
//		c.ssn = "2222222-2222222"
		c.name="홍길석";
	}
}
