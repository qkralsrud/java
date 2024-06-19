package com.spring.ex001.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.spring.ex001.dto.FileDto;
import com.spring.ex001.mapper.FileMapper;

@Service
public class FileService {
	
	String filePath = "c:\\upload";
	
	@Autowired
	FileMapper mapper;
	/**
	 * 외부로 부터
	 * 파일객체에 입력할 테이블정보와 seq정보를 받아 옵니다.
	 * @param mr
	 * @param dto
	 */
	public void attachFileSave(MultipartRequest mr, FileDto dto) {
		
		// 화면의 파일태그의 이름을 가지고 오는 메서드
		Enumeration<String> e = mr.getFileNames();
		int idx = 0;
		// 다음 요소가 있는지 확인
		// 첨부된 파일의 정보를 데이터 베이스에 저장 
		while (e.hasMoreElements()) {
			// 다음 요소를 가지고 오는 메서드
			String elName = (String) e.nextElement();
			// 첨부된 원본 파일명
			String oname = mr.getFilesystemName(elName);
			
			// 첨부된 파일이 없는경우
			if(oname == null) {
				continue;
			}
			
			// 저장된 이름
			String sname = rename(oname);
			
			dto.setIdx(idx);
			dto.setOfilename(oname);
			dto.setSfilename(sname);
			
			System.out.println("=====================");
			System.out.println(dto);
			System.out.println(dto.getIdx());
			System.out.println(dto.getOfilename());
			System.out.println(dto.getSfilename());
			System.out.println("=====================");
			// 데이터베이스 저장 하기전에 데이터 확인
			int res = mapper.regFile(dto);
			idx++ ;
		}
	}
	
	
	
	/**
	 * 파일명이 중복될 경우, 파일이 소실될 위험이 있으므로 
	 * 파일이름에 업로드된시간을 추가하여 파일명을 변경
	 * 
	 * 원본파일명 -> 저장 파일명으로 변경및 파일 이름 변경
	 * @param fileName : 원본 파일 명
	 * @return 저장 파일 명
	 */
	public String rename(String fileName) {
		//String fileName="jstl-1.2 (1).jar";
		
		// 파일 이름
		String oldFileName = fileName.substring(0, fileName.lastIndexOf("."));
		// 파일 확장자
		String ext = fileName.substring( fileName.lastIndexOf(".") );
		// 현재시간을 형식에 맞게 문자열로 반환
		String now = new SimpleDateFormat("_yyyyMMdd_HmsS").format(new Date());

		String newFileName = oldFileName+now+ext; 
		
		File oldFile = new File(filePath + File.separator + fileName);
		File newFile = new File(filePath + File.separator + newFileName);
		
		// 파일의 이름을 변경 합니다.
		oldFile.renameTo(newFile);
		
		// 새로운 파일명을 반환
		return newFileName;
	}
	
	
	
}
