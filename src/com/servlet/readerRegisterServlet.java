package com.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.ReaderBiz;
import com.biz.impl.ReaderBizImpl;
import com.entity.Reader;

public class readerRegisterServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 559513957504296988L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		String userId=request.getParameter("loginId");
		String userPwd=request.getParameter("loginPwd");
		String username=request.getParameter("reaName");
		String userGender=request.getParameter("gender");
		Date userBirthday=Date.valueOf(request.getParameter("birthday"));
		String userAddress=request.getParameter("address");
		String userPhone=request.getParameter("phone");
		
		
		
		Reader rea=new Reader(userId, userPwd, username, userGender, userBirthday, userAddress, userPhone);
		
		
		ReaderBiz readerBiz=new ReaderBizImpl();
		int result=readerBiz.register(rea);
		if(result==1){
			response.sendRedirect("readerLogin.html");
		}else if(result==2){
			response.sendRedirect("readerRegister.jsp");
		}else if(result==3){
			System.out.println("系统发生不可预知的错误，请联系管理员!");
			
		}
	}
}
