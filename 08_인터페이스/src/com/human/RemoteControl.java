package com.human;
//인터페이스는 객체로 생성 할 수 없으므로 생성자를 가질수 없음
public interface RemoteControl {
	//상수 선언
	//인스턴스필드, 정적필드 선언이 불가능 
	public int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	//추상메서드
	public void turnOn();
	public void turnoff();
	public void setVolume(int volume);
	
	
}
