package com.spring.ex001.service;

import java.awt.print.Book;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.spring.ex001.dto.BookDTO;
import com.spring.ex001.dto.CriteriaDTO;
import com.spring.ex001.dto.FileDto;
import com.spring.ex001.dto.PageDto;
import com.spring.ex001.mapper.BookMapper;

@Service
public class BookService {
	@Autowired
	BookMapper mapper;
	
	@Autowired
	FileService fileservice;
	
	@Autowired
	PageDto pageDto;
	
	public Map<String, Object> getBookList(CriteriaDTO cri){
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 리스트 조회
		List<BookDTO> list = mapper.getBookList(cri);
		// 총건수 조회
		int totalCnt = mapper.getTotalCnt();
		// pageDto세팅
		pageDto.setPageDto(totalCnt, cri.getPageNo(), cri.getAmount());
		
		// map에 담아서 반환
		map.put("list", list);
		map.put("pageDto", pageDto);
		
		return map;
	}

	public Map<String, Object> bookReg(HttpServletRequest request) {
		String saveDir = "c:\\upload";
		int maxSize = 1024 * 1000; //1MB
		String encoding = "UTF-8";
		
		try {
			MultipartRequest mr= new MultipartRequest(request, saveDir, maxSize, encoding);
			// 도서 정보 취합
			BookDTO book = new BookDTO();
			book.setTitle(mr.getParameter("title"));
			book.setAuthor(mr.getParameter("author"));
			book.setPublisher(mr.getParameter("publisher"));
			book.setPrice(Integer.parseInt(mr.getParameter("price")));
			
			// 도서테이블에 입력 (selectKey에 의해서 no(시퀀스값)를 반환받아옴) 
			int res = mapper.regBook(book);
			
			FileDto file = new FileDto();
			file.setType("book"); // 파일 첨부가 발생한 테이블
			file.setSeq(book.getNo() + ""); // 시퀀스번호
			
			// 첨부파일 저장
			fileservice.attachFileSave(mr, file);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}

	/*
	 * 도서정보및 첨부파일정보를 조회
	 */
	public Map<String, Object> detailBook(int no) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 도서정보
		BookDTO book = mapper.detailBook(no);
		
		// 도서에 첨부된 파일정보
		List<FileDto> fileList = fileservice.getFileList("book", no+"");
		
		// map에 도서정보와 파일 정보를 저장
		map.put("book", book);
		map.put("fileList", fileList);
		
		return map;
	}

	public int delBook(int no) {
		int res = mapper.delBook(no);
		if(res > 0) {
			// 첨부파일 삭제
			fileservice.delFile("book", no+"");
		}
		return res;
	}
}









