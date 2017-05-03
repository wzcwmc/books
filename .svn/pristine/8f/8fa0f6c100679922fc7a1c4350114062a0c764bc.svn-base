package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.BookBiz;
import com.biz.MarkBiz;
import com.biz.impl.BookBizImpl;
import com.biz.impl.MarkBizIpml;
import com.entity.Book;
import com.entity.Mark;
import com.entity.Reader;

public class BackServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8515574147464828391L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookBiz bookBiz= new BookBizImpl();
		MarkBiz markBiz= new MarkBizIpml();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int bookId=Integer.parseInt(request.getParameter("bookId"));
		Reader reader=(Reader)request.getSession().getAttribute("user");
		Mark mark=markBiz.getMarkByBookId(bookId, reader.getreaId());
		String str="";
		Book book=bookBiz.getBookById(bookId);
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date now = new java.util.Date();
		Date nowDate =Date.valueOf(df.format(now));
		if(book!=null)
		{
		book.setLendNum(book.getLendNum()-1);
		book.setNowNum(book.getNowNum()+1);
		String pubDate=df.format(book.getPubDate());
		String innerDate=df.format(book.getInnerDate());
		book.setPubDate(Date.valueOf(pubDate));
		book.setInnerDate(Date.valueOf(innerDate));
		int rs=bookBiz.updateBook(book, bookId);
		mark.setBack(1);
		mark.setBackDate(nowDate);
		String lendDate=df.format(mark.getLendDate());
		mark.setLendDate(Date.valueOf(lendDate));
		int res=markBiz.updateMark(mark, mark.getReaId(), bookId);
		if(rs>0&&res>0)
		{
		str="ok";
		out.write(str);
		out.flush();
		out.close();
		}
		}
		
	}

}
