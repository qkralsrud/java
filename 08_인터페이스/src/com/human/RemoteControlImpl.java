package com.human;
/*
 * 구현객체 
 * -클래스의 선언부에 implements 키워드를 추가하고 인터페이스이름을 명시
 * -인터페이스가 가지고 잇는 모든 추상 메서드를 구현 해야한다
 */
public class RemoteControlImpl implements RemoteControl {

	int volume = 0;
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("tv를 켭니다");
	}

	@Override
	public void turnoff() {
		// TODO Auto-generated method stub
		System.out.println("tv를 끕니다");
		
	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		
		System.out.println("볼륨 : "+this.volume);
	}
	
}
