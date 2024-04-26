package com.human.lib;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@AllArgsConstructor



public class Book {
	
	private String title;
	private String author;
	private int price;
	private boolean rent; //true 대여중 ,false 대여가능 
	
	
	@Override
	public String toString() {
		String rentStr = rent ? "대여중" : "대여가능";
		return title + "/"+author +"/"+price+"/"+rentStr;
	}
}
