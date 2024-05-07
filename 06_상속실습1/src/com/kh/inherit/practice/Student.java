package com.kh.inherit.practice;

public class Student extends Person{
	private int grade; //학년 
	private String major;
	
	public Student() {
		
	}
	
	public Student(String name,int age, double height, double weight, 
			int grade,String major){
		//생성자 통해서 필드를 초기화
		super(age, height, weight);
		System.out.println("Student 생성자 호출 ");
		//필드에 직접 접근해서 필드를 초기화
		super.name = name;
		this.grade = grade;
		this.major = major;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String information() {
		return super.information()+ grade+"/"+major;
		
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	

	
}
