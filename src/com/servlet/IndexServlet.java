package com.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.BookBiz;
import com.biz.impl.BookBizImpl;
import com.entity.Book;

public class IndexServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6418830650105091230L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		List<Book> listOne = new ArrayList<Book>();
		List<Book> listTwo = new ArrayList<Book>();
		
		BookBiz bookBiz = new BookBizImpl();
		
		listOne = bookBiz.getBookByLendNum();
		listTwo = bookBiz.getBookByInnerDate();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		for (Book book : listTwo) {
			String date = df.format(book.getInnerDate());
			book.setInnerDate(java.sql.Date.valueOf(date));
		}
		
		
		request.setAttribute("listOne", listOne);
		request.setAttribute("listTwo", listTwo);
		
		String user=request.getParameter("user");
		if (user.equals("mang")) {
			request.getRequestDispatcher("adminIndex.jsp").forward(request, response);
		}else if(user.equals("reader")){
			request.getRequestDispatcher("readerIndex.jsp").forward(request, response);
		}
	}

}
