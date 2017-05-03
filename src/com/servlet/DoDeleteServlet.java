package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.BookBiz;
import com.biz.MarkBiz;
import com.biz.ReaderBiz;
import com.biz.impl.BookBizImpl;
import com.biz.impl.MarkBizIpml;
import com.biz.impl.ReaderBizImpl;

public class DoDeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4692323493322554256L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		String type = request.getParameter("type");
		if (type.equals("book")) {
			int bookId = Integer.parseInt(request.getParameter("bookId"));
			BookBiz biz= new BookBizImpl();
			int rs = biz.deleteBook(bookId);
			if (rs>0) {
				out.write("ok");
			}else {
				out.write("no");
			}
		}
		if (type.equals("reader")) {
			int reaId = Integer.parseInt(request.getParameter("reaId"));
			ReaderBiz rBiz = new ReaderBizImpl();
			int rs = rBiz.deleteReader(reaId);
			if (rs>0) {
				out.write("ok");
			}else {
				out.write("no");
			}
		}
		if (type.equals("mark")) {
			int reaId = Integer.parseInt(request.getParameter("reaId"));
			int bookId = Integer.parseInt(request.getParameter("bookId"));
			MarkBiz mBiz = new MarkBizIpml();
			int rs = mBiz.deleteMark(reaId, bookId);
			if (rs>0) {
				out.write("ok");
			}else {
				out.write("no");
			}
		}
			
		out.flush();
		out.close();
	}

}
