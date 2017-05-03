package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.ReaderBiz;
import com.biz.impl.ReaderBizImpl;
import com.entity.Reader;


public class RepwdServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String loginId=request.getParameter("loginId");
		String reaName=request.getParameter("reaName");
		String gender=request.getParameter("gender");
		Date birthday=java.sql.Date.valueOf(request.getParameter("birthday"));
		String loginpwd=request.getParameter("loginPwd");
		
		ReaderBiz readerBiz=new ReaderBizImpl();
		Reader reader=readerBiz.getReaderByLoginId(loginId);
		PrintWriter out=response.getWriter();
		
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		reader.setBirthday(java.sql.Date.valueOf(df.format(reader.getBirthday())));
		
		if(reader.getLoginId().equals(loginId)&&
				reader.getReaName().equals(reaName)&&
					reader.getGender().equals(gender)&&
						 reader.getBirthday().equals(birthday))
		{
			reader.setBirthday(birthday);
			reader.setLoginPwd(loginpwd);
			readerBiz.updateReader(reader, reader.getreaId());
			out.write("<script type='text/javascript'>alert('更新成功！');location.href='readerLogin.html';</script>");
			
			out.flush();
			out.close();
		}else{			

			
			out.write("<script type='text/javascript'>alert('更新失败！');location.href='repwd.jsp';</script>");
			
			out.flush();
			out.close();
		}
		
	}

}
