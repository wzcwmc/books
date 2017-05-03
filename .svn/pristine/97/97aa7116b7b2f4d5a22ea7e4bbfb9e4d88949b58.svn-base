package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Mang;
import com.entity.Reader;

public class WelcomeServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 293967437724026534L;

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
		if (type.equals("manger")) {
			Mang manger = (Mang)request.getSession().getAttribute("user");
			out.write(manger.getMangName());
		}
		if (type.equals("reader")) {
			Reader reader = (Reader)request.getSession().getAttribute("user");
			out.write(reader.getLoginId());
		}

		out.flush();
		out.close();
	}

}
