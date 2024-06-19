package com.spring.ex001.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class BookDTO {
	private int no;
	private String title;      
	private String author;     
	private String publisher;  
	private int price;      
	private String pub_date;   
	private String rent_yn;
	private String rent_yn_str;
	private String rent_no;
	 
	
}
