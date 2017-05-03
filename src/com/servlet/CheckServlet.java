package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.MarkBiz;
import com.biz.impl.MarkBizIpml;
import com.entity.Mark;

public class CheckServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6020573833301164517L;

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
			MarkBiz mBiz = new MarkBizIpml();
			List<Mark> mList = mBiz.getMarkByBookId(bookId);
			String isOk="ok";
			if (mList.size()>0) {
				for (Mark mark : mList) {
					if (mark.getBack()==1) {
						continue;
					}else {
						isOk="no";
						break;
					}
				}
			} else {
				isOk="ok";
			}
			out.write(isOk);
		}
	
		if (type.equals("reader")) {
			int reaId = Integer.parseInt(request.getParameter("reaId"));
			MarkBiz mBiz = new MarkBizIpml();
			List<Mark> mList = mBiz.getMarkByReaId(reaId);
			String isOk="ok";
			if (mList.size()>0) {
				for (Mark mark : mList) {
					if (mark.getBack()==1) {
						continue;
					}else {
						isOk="no";
						break;
					}
				}
			} else {
				isOk="ok";
			}
			out.write(isOk);
		}
		out.flush();
		out.close();
	}
}
