package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.BookBiz;
import com.biz.impl.BookBizImpl;

public class DeleteServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 575186496479256146L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int bookId=Integer.parseInt(request.getParameter("bookId"));
		
		BookBiz bookBiz=new BookBizImpl();
		
		bookBiz.deleteBook(bookId);
		
	}

}
