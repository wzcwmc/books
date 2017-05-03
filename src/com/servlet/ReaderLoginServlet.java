package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.ReaderBiz;
import com.biz.impl.ReaderBizImpl;
import com.entity.Reader;

public class ReaderLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1463752545387247806L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String loginPwd= request.getParameter("loginPwd");
		
		ReaderBiz reaBiz = new ReaderBizImpl();
		Reader reader = reaBiz.getReaderByLoginId(loginId,loginPwd);
		String isOk;
		if (reader!=null) {
			isOk="OK";
			request.getSession().setAttribute("user", reader);
		}else {
			isOk="NO";
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write(isOk);
		out.flush();
		out.close();
	}

}
