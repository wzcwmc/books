package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.AdminBiz;
import com.biz.impl.AdminBizImpl;
import com.entity.Mang;

public class AdminLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6401746003262880946L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}


	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String LoginId=request.getParameter("username");
		String LoginPwd=request.getParameter("userpass");
		String str="";
		AdminBiz ab= new AdminBizImpl();
		Mang admin=ab.Register(LoginId, LoginPwd);
		if(admin!=null)
		{
			request.getSession().setAttribute("user", admin);
			str="true";
		}else{
			str="false";
		}
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(str);
		out.flush();
		out.close();
	}

}
