package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1152385603102668848L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		request.removeAttribute("user");
		if (type.equals("reader")) {
			response.sendRedirect("readerLogin.html");
		} else if (type.equals("manger")) {
			response.sendRedirect("mangLogin.html");
		}
	}

}
