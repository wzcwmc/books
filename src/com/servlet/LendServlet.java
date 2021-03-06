package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

public class LendServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6956137594991246229L;

	
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
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date now = new java.util.Date();
		Date nowDate =Date.valueOf(df.format(now));
		Calendar cal = Calendar.getInstance();
		//下面的就是把当前日期加一个月
		cal.add(Calendar.MONTH, 1);
		Date backDate=Date.valueOf(df.format(cal.getTime()));
		String str="";
		Book book=bookBiz.getBookById(bookId);
		if(book!=null)
		{
		book.setLendNum(book.getLendNum()+1);
		book.setNowNum(book.getNowNum()-1);
		String pubDate=df.format(book.getPubDate());
		String innerDate=df.format(book.getInnerDate());
		book.setPubDate(Date.valueOf(pubDate));
		book.setInnerDate(Date.valueOf(innerDate));
		int rs=bookBiz.updateBook(book, bookId);
		Mark mark= new Mark(reader.getreaId(), reader.getLoginId(), bookId, book.getBookName(), nowDate, backDate, reader.getPhone(), 0);
		int res=markBiz.addMark(mark);
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
