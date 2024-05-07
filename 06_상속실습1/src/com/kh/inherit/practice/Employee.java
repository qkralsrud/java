package com.kh.inherit.practice;

public class Employee extends Person{
	private int salary; //급여
	private String dept; //부서
	
	public Employee() {}

	public Employee(String name, int age, double height, double weight,
			int salary, String dept) {
		super(age, height, weight);
		System.out.println("Employee 생성자 호출");
		super.name = name;
		this.salary = salary;
		this.dept = dept;
	}
	
	@Override
	public String information() {
		return super.information()+salary+"/"+dept;
		
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
}
