package com.human;

public class Application {
	public static void main(String[] args) {
		//인터페이스는 생성이 불가능 하다 - 생성자가 없음 ! 
		//생성 할 수 없지만 타입으로 이용 가능 
		//RemoteControl rc = new RemoteControl();
		
		RemoteControl rc_tv = new RemoteControlImpl();
		RemoteControl rc_audio = new RemotecontrolImpl_Audio();
		
		rc_tv.turnOn();
		rc_tv.setVolume(5);
		rc_tv.setVolume(15);
		rc_tv.setVolume(-111);
		rc_tv.turnoff();
		System.out.println("=====================");
		rc_audio.turnOn();
		rc_audio.setVolume(100);
		rc_audio.turnoff();
		
		
		
	}
}
