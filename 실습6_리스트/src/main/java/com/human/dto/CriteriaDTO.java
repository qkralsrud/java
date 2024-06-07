package com.human.dto;

/**
 * 페이징 처리를 위한 필드와
 * 검색을 위한 필드의 정보를 담고 있는 객체
 */
public class CriteriaDTO {
	
	private int pageNo = 1; /*요청 페이지 번호*/
	private int amount = 10; /*페이지당 게시물의 수*/
	
	private String searchField = ""; /*검색필드*/
	private String searchWord = "";	/*검색어*/
	
	public CriteriaDTO(){}
	
	public CriteriaDTO(String parmPageNo) {
		
		try {
			if(parmPageNo != null && !"".equals(parmPageNo)) {
				this.pageNo = Integer.parseInt(parmPageNo);
			}
		} catch (Exception e) {
			System.out.println("parmPageNo를 숫자로 변경하던도중 예외가 발생 하였습니다.");
		}
	}

	
	
	public CriteriaDTO(String parmPageNo, String searchField, String searchWord) {
		// 생성자 호출 
		this(parmPageNo);
		
		this.searchField = searchField;
		this.searchWord = searchWord;
	}

	/**
	 * 초기화
	 * @param parmPageNo
	 * @param amount
	 */
	public CriteriaDTO(String parmPageNo, int amount) {
		
		try {
			if(parmPageNo != null && !"".equals(parmPageNo)) {
				this.pageNo = Integer.parseInt(parmPageNo);
			}
		} catch (Exception e) {
			System.out.println("parmPageNo를 숫자로 변경하던도중 예외가 발생 하였습니다.");
		}
		this.amount = amount;
	}

	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getSearchField() {
		return searchField;
	}
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	
	
}
