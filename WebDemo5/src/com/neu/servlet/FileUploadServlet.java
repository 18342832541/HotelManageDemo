package com.neu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
@MultipartConfig(maxFileSize=1024*1024*5,maxRequestSize=1024*1024*10)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("file");
		String fileName = part.getSubmittedFileName();
		
		ServletOutputStream outputStream = response.getOutputStream();
		
		if(fileName != null && !fileName.equals("")) {
			String path = request.getServletContext().getRealPath("/Files");
			
			String newFileName = path +"/"+ fileName;
			
			part.write(newFileName);
			
			response.setCharacterEncoding("text/html;charset=utf-8");
			response.getWriter().println("上传成功！");
		}
	}

}
