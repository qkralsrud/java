package com.human.inhefit.override;

public class SupersonicAirplane extends Airplane{
	// 상수(변하지 않음) 비행모드
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;
	
	public int flyMode = NORMAL;
	//flyMode = 1;
	
	@Override
	public void fly() {
		
		if(flyMode == NORMAL) {
			super.fly();
		} else if(flyMode == SUPERSONIC){
			System.out.println("초음속 비행 입니다.");
		} else {
			System.out.println("비행모드를 확인해주세요.");
		}
	}
		
	
}
