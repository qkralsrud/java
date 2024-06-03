package com.human.dto;

public class MemberDTO {

	private String ID;
	private String PW;
	private String NAME;
	private String ADMIN_YN;
	private String REG_DATE;
	private String UDT_DATE;
	
	public MemberDTO() {}
	
	public MemberDTO(String iD, String pW, String nAME, String aDMIN_YN, String rEG_DATE, String uDT_DATE) {
		super();
		ID = iD;
		PW = pW;
		NAME = nAME;
		ADMIN_YN = aDMIN_YN;
		REG_DATE = rEG_DATE;
		UDT_DATE = uDT_DATE;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getADMIN_YN() {
		return ADMIN_YN;
	}
	public void setADMIN_YN(String aDMIN_YN) {
		ADMIN_YN = aDMIN_YN;
	}
	public String getREG_DATE() {
		return REG_DATE;
	}
	public void setREG_DATE(String rEG_DATE) {
		REG_DATE = rEG_DATE;
	}
	public String getUDT_DATE() {
		return UDT_DATE;
	}
	public void setUDT_DATE(String uDT_DATE) {
		UDT_DATE = uDT_DATE;
	}
	
	
}
