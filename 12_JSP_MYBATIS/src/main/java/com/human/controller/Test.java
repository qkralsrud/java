package com.human.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dir = "c:\\upload";
		String sFileName = "jstl-1.2_20240610_10528255.jar";
		String oFileName = URLEncoder.encode("jstl-1.2.jar", "UTF-8");;
		File file = new File("c:\\upload" + File.separator + sFileName);
		if(file.exists()) {
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", 
					"attachment; filename=\"" + oFileName + "\"");
			response.setHeader("Content-Length", "" + file.length() );

			ServletOutputStream ostream = response.getOutputStream();
			FileInputStream istream = new FileInputStream(file);
			
			int bytesRead = -1;
			byte[] buffer = new byte[4096];
			while((bytesRead = istream.read(buffer) )> -1) {
				 ostream.write(buffer, 0, bytesRead);
			}
			
		    istream.close();
		    ostream.close();
		    
		} else {
			request.setAttribute("msg", "파일이 존재 하지 않습니다.");
			request.getRequestDispatcher("/msgBox.jsp").forward(request, response);
		}
		
		
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
