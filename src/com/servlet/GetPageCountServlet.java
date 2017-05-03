package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.biz.BookBiz;
import com.biz.MarkBiz;
import com.biz.ReaderBiz;
import com.biz.impl.BookBizImpl;
import com.biz.impl.MarkBizIpml;
import com.biz.impl.ReaderBizImpl;
import com.entity.Reader;

public class GetPageCountServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -425024495337896119L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String type=request.getParameter("type");
		MarkBiz mBiz = new MarkBizIpml();
		ReaderBiz rBiz = new ReaderBizImpl();
		BookBiz bookBiz = new BookBizImpl();
		int pCounts=1;
		if (type.equals("mark")) {
			int pageSize=Integer.parseInt(request.getParameter("pSize"));

			pCounts = mBiz.getMarkPages(pageSize);
		}else if (type.equals("reader")) {
			int pageSize=Integer.parseInt(request.getParameter("pSize2"));

			pCounts = rBiz.getReaderPages(pageSize);
		}else if (type.equals("book")) {
			int pageSize=Integer.parseInt(request.getParameter("pSize1"));

			pCounts= bookBiz.getBookPages(pageSize);
		}else if(type.equals("ͯ��")){
			int pageSize=Integer.parseInt(request.getParameter("pSize"));
			pCounts= bookBiz.getBookTypePages(type, pageSize);
		}else if(type.equals("��ѧ")){
			int pageSize=Integer.parseInt(request.getParameter("pSize"));
			pCounts= bookBiz.getBookTypePages(type, pageSize);
		}else if(type.equals("����")){
			int pageSize=Integer.parseInt(request.getParameter("pSize"));
			pCounts= bookBiz.getBookTypePages(type, pageSize);
		}else if(type.equals("reMark")){
			
			int pageSize=Integer.parseInt(request.getParameter("pSize"));
			Reader reader = (Reader)request.getSession().getAttribute("user");
			pCounts=mBiz.getMarkPages(reader.getreaId(), pageSize);
		}else if(type.equals("search")){
			int pageSize=Integer.parseInt(request.getParameter("pSize"));
			String str=request.getParameter("str");
			pCounts=bookBiz.getPagesByString(str, pageSize);
		}
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("pcount", pCounts);
		JSONObject jsonStr=JSONObject.fromObject(map);
		
		PrintWriter out = response.getWriter();
		out.write(jsonStr.toString());
		out.flush();
		out.close();
	}
}
