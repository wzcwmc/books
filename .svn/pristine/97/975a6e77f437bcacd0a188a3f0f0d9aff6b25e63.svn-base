package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.biz.BookBiz;
import com.biz.impl.BookBizImpl;
import com.entity.Book;

public class ToAdminShowServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3652291813529740993L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		BookBiz bookBiz=new BookBizImpl();
		//ReaderBiz readerBiz = new ReaderBizImpl();
		String type = request.getParameter("type");
		
		int pageIndex=Integer.parseInt(request.getParameter("start"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		
		if (type.equals("id")) {
			
			
		}else if (type.equals("word")) {
			
			
		}else if (type.equals("all")) {
			List<Book> bList=bookBiz.getBookAll(pageIndex, pageSize);
			JSONArray mJsonArray= JSONArray.fromObject(bList);
			out.write(mJsonArray.toString());
		}
		
		out.flush();
		out.close();
	}

}
