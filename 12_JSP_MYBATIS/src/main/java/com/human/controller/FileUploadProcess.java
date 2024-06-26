package com.human.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dto.MyFileDTO;
import com.human.service.FileUploadService;
import com.human.util.JSFunction;
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
		String sfileName = rename(fileName);
		
		// 다른 폼 값 입력받기
		String name = mr.getParameter("name");
		String title = mr.getParameter("title");
		String cate = mr.getParameter("cate");
		
		MyFileDTO dto = new MyFileDTO(name, title, cate, fileName, sfileName);
		System.out.println("============== 파일업로드 DTO");
		System.out.println(dto.getName());
		System.out.println(dto.getTitle());
		System.out.println(dto.getCate());
		FileUploadService service = new FileUploadService();
		// 사용자로 부터 입력받은 파일 정보를 데이터 베이스에 저장
		Map<String, String> map = service.insertMyfile(dto);
		
		// 메세지를 화면에 출력 하기위해 내장객체의 영역에 저장
		request.setAttribute("map", map);

		// 등록 성공
		// 메세지 출력 -> 리스트로 이동
		if("ok".equals( map.get("res") )) {
			JSFunction.alertLocation("등록 되었습니다.", "/fileList", response);
		// 등록 실패
		// 메세지 출력 -> 뒤로가기
		}else {
			JSFunction.alertBack("등록중 예외사항이 발생 하였습니다. 관리자에게 문의 해주세요", response);
		}
		
		// enctype을 multipart/form-data로 지정시 기존방식대로 파라메터를 전달 받을 수 없다
		//System.out.println( request.getParameter("name") );
		
		
		
		
	}
	
	
	/**
	 * 파일명이 중복될 경우, 파일이 소실될 위험이 있으므로 
	 * 파일이름에 업로드된시간을 추가하여 파일명을 변경
	 * 
	 * @param fileName
	 * @return
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
