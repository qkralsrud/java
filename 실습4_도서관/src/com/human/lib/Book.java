package com.human.lib;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@AllArgsConstructor
@ToString


public class Book {
	
	private String title;
	private String author;
	private int price;
	private boolean rent; //true 대여중 ,false 대여가능 
	
	
	public String toString(Object obj) {
		String rentStr = rent ? "대여중" : "대여가능";
		return title + "/"+author +"/"+price+"/"+rentStr;
	}
}
