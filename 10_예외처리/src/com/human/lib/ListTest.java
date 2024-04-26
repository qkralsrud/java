package com.human.lib;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		/*
		 * ArrayList
		 * -ArrayList를 생성 하면 내부적으로 10개의 객체를 저장할 수 있는 공간이 생성
		 * -저장 순서는 유지 되고 인덱스를 통해서 관리된다.
		 * -객체, null저장이 가능 
		 * -중복되는 객체의 저장도 허용 <-> Set 중복을 허용하지 않음
		 */
		List<String> list = new ArrayList<String>(); 
		list.add("안녕하세여");
		
		System.out.println("list : "+ list);
		System.out.println("size : "+ list.size());
		System.out.println("list.get(0) : "+ list.get(0));
		
		List list1 = new ArrayList();
		list1.add("안녕하세요");
		list1.add(list1);
		list1.add(LocalDateTime.now());
		list1.add(3.14);
		System.out.println(list1);
		
		for(int i=0; i<list1.size();i++) {
			//인덱스에 해당 하는 값을 꺼내올때 get 메서드를 이용한다.
			System.out.println(list.get(0));
		}
		
		
		
			
		
	}
}
