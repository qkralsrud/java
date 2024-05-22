package com.human.vo;

public class MemberVO {
	
	private String id;
	private String pw;
	private String name;
	private boolean admin;
	private String admin_yn;
	private String reg_date;
	private String udt_date;
	
	public MemberVO(String id, String pw, String name, String admin_yn, String reg_date, String udt_date) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.admin = admin_yn.equalsIgnoreCase("Y") ? true : false;
		this.admin_yn = admin_yn;
		this.reg_date = reg_date;
		this.udt_date = udt_date;
	}

	public MemberVO(String id, String pw, String name, String reg_date, String udt_date) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.reg_date = reg_date;
		this.udt_date = udt_date;
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
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getUdt_date() {
		return udt_date;
	}
	public void setUdt_date(String udt_date) {
		this.udt_date = udt_date;
	}

	public String getAdmin_yn() {
		return admin_yn;
	}

	public void setAdmin_yn(String admin_yn) {
		this.admin_yn = admin_yn;
	}
	
	
}
