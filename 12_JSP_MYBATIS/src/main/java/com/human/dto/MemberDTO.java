package com.human.dto;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String adminYn;
	private String regDate;
	private String udtDate;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id +"/"+ pw +"/"+ name +"/"+ adminYn +"/" + regDate +"/"+ udtDate;
	}
	public MemberDTO() {}
	public MemberDTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public MemberDTO(String id, String pw, String name, String adminYn, String regDate, String udtDate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.adminYn = adminYn;
		this.regDate = regDate;
		this.udtDate = udtDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdminYn() {
		return adminYn;
	}

	public void setAdminYn(String adminYn) {
		this.adminYn = adminYn;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getUdtDate() {
		return udtDate;
	}

	public void setUdtDate(String udtDate) {
		this.udtDate = udtDate;
	}
	
	
}
