package com.human.exam01;

public class Application {
	public static void main(String[] args) {
//		Vehicle vehicle= new Vehicle();
		 Driver driver= new Driver();
		driver.drive(new Vehicle()); 
		driver.drive(new Bus()); 
		driver.drive(new Taxi()); 
	}
}	
