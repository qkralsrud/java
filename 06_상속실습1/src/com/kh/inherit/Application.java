package com.kh.inherit;

import java.util.Scanner;

import com.kh.inherit.practice.Employee;
import com.kh.inherit.practice.Student;

public class Application {
	public static void main(String[] args) {
//		int intArr[] = new int[3];
//		intArr[0] = 1;
//		intArr[1] = 1;
//		intArr[2] = 1;
		
		Student sArr[]= new Student[3];
		sArr[0] = new Student("홍길동",20,178.2,70.0,1,"정보시스템공학과");
		sArr[1] = new Student("김말똥",21,187.3,80.0,2,"경영학과");
		sArr[2] = new Student("강개순",23,167.2,45.0,4,"정보통신공학과");
		
//		Student s1=new Student("기마ㅏ",21,187.9,80.2,2,"경영");
		
		for(Student s :sArr) {
			//NullpointException 의 발생을 막기 위해
			//예외사항이 발생 하면 오류 메세지를 출력후 프로그램 종료
			if(s !=null) {
				System.out.println(s.information());
			}
		}
		
//		for(int i=0 ; i<sArr.length;i++) {
//			if(sArr[i] != null) {
//			System.out.println(sArr[i].information());
//			}
//		}
		System.out.println("=================================");
		Employee eArr[]=new Employee[10];
		Scanner scan = new Scanner(System.in);
			
		int count = 0;
		while(count<eArr.length) {
			
            System.out.print("이름: ");
            String name = scan.nextLine();
            System.out.print("나이: ");
            int age = scan.nextInt();
            System.out.print("신장: ");
            double height = scan.nextDouble();
            System.out.print("몸무게: ");
            double weight =scan.nextDouble();
            System.out.print("급여: ");
            int salary = scan.nextInt();
            System.out.print("부서: ");
            String dept = scan.next();
          
            eArr[count] = new Employee(name,age,height, weight, salary , dept);
            count++;
            if(count ==10)break;
            System.out.print("계속해서 사원을 추가하시겠습니까? (Y/N): ");
            String input = scan.next().toUpperCase();
            if(count == 10 || input.equalsIgnoreCase("N")) {
            	break;
            	}
            for(Employee emp : eArr) {
            	if(emp !=null) {
            		System.out.println(emp.information());
            	}
            }
        }
	}
}
