package com.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.BookBiz;
import com.biz.ReaderBiz;
import com.biz.impl.BookBizImpl;
import com.biz.impl.ReaderBizImpl;
import com.entity.Book;
import com.entity.Reader;

public class UpdateServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5173846545005594014L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		int bookId=0;
		String type=request.getParameter("type");
		if(type.equals("book"))
		{
			bookId=Integer.parseInt(request.getParameter("bookId"));
			
			BookBiz bookBiz= new BookBizImpl();
			Book book=bookBiz.getBookById(bookId);
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			book.setPubDate(Date.valueOf(df.format(book.getPubDate())));
			book.setInnerDate(Date.valueOf(df.format(book.getInnerDate())));
			if(book!=null)
			{
				request.setAttribute("book", book);
				request.getRequestDispatcher("bookDetails.jsp").forward(request, response);
			}
		}else if(type.equals("reader"))
		{
			String loginId=request.getParameter("loginId");
			ReaderBiz readerBiz=new ReaderBizImpl();
			Reader reader=readerBiz.getReaderByLoginId(loginId);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			reader.setBirthday(Date.valueOf(df.format(reader.getBirthday())));
			if(reader!=null)
			{
				request.setAttribute("reader", reader);
				request.getRequestDispatcher("readerDetails.jsp").forward(request, response);
			}
		}
		
	}

}
