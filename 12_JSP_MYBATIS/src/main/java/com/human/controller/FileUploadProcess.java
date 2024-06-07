package com.human.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

/**
 * 파일업로드
 */
@WebServlet("/fileUpload")
public class FileUploadProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 파일이 저장될 경로
	String filePath = "c:\\upload";
	// 최대크기 (1MB)
	int maxSize = 1024*1000; 
	// 인코딩정보
	String encoding = "utf-8";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("파일업로드 요청===============");
		
		
		// 첨부파일을 저장 하기 위해서 MultipartRequest 객체를 생성 합니다.
		// 객체 생성과 동시에 파일이 저장
		MultipartRequest mr = new MultipartRequest(request, filePath, maxSize, encoding);
		
		// 파일 이름 변경
		// 파일이름이 중복된 경우, 기존파일이 소실될 위험이 있어 파일의 이름을 변경 합니다.
		String fileName =  mr.getFilesystemName("file");
		rename(fileName);
		
		// 다른 폼 값 입력받기
		String name = mr.getParameter("name");
		String id = mr.getParameter("id");
		
		System.out.println("name : " + name);
		System.out.println("id : " + id);
		
		
		
		System.out.println( request.getParameter("name") );
		
		
	}
	
	
	
	public void rename(String fileName) {
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
	}
	
	
	

	

}
