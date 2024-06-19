package com.spring.ex001.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FileDto {
	public String type;
	public int idx;
	public String seq;
	public String ofilename;
	public String sfilename;
	public String reg_date;
	
//	@Override
//	public String toString() {
//		return "";
//	}
	
}