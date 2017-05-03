package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.biz.BookBiz;
import com.biz.MarkBiz;
import com.biz.ReaderBiz;
import com.biz.impl.BookBizImpl;
import com.biz.impl.MarkBizIpml;
import com.biz.impl.ReaderBizImpl;
import com.entity.Book;
import com.entity.Mark;
import com.entity.Reader;
import com.utils.JsonDateValueProcessor;

public class PageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7490407376401016901L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		String type = request.getParameter("type");
		int pageIndex=Integer.parseInt(request.getParameter("start"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		
		JsonConfig jsonConfig = new JsonConfig();
		MarkBiz mBiz = new MarkBizIpml();
		ReaderBiz rBiz = new ReaderBizImpl();
		BookBiz bBiz = new BookBizImpl();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor("yyyy-MM-dd"));
		if (type.equals("mark")) {
			List<Mark> mList = mBiz.getMarkAll(pageIndex, pageSize);
			if(mList.size()>0)
			{
				for (Mark mark : mList) {
					if(mark.getBack()==1)
					{
						mark.setStatus("已归还");
					}else if(mark.getBack()==0)
					{
						mark.setStatus("未归还");
					}
				}
			JSONArray jsonArr=JSONArray.fromObject(mList);
			out.write(jsonArr.toString());
			}
		}else if (type.equals("reader")) {
			List<Reader> rList = rBiz.getReaderAll(pageIndex, pageSize);
			JSONArray jsonArr=JSONArray.fromObject(rList);
			out.write(jsonArr.toString());
		}else if (type.equals("book")) {
			List<Book> bList = bBiz.getBookAll(pageIndex, pageSize);
			JSONArray jsonArr=JSONArray.fromObject(bList);
			out.write(jsonArr.toString());
		}else if (type.equals("童话")) {
			List<Book> bList = bBiz.getBookBytype(type, pageIndex, pageSize);
			JSONArray jsonArr=JSONArray.fromObject(bList);
			out.write(jsonArr.toString());
		}else if (type.equals("哲学")) {
			List<Book> bList = bBiz.getBookBytype(type, pageIndex, pageSize);
			JSONArray jsonArr=JSONArray.fromObject(bList);
			out.write(jsonArr.toString());
		}else if (type.equals("军事")) {
			List<Book> bList = bBiz.getBookBytype(type, pageIndex, pageSize);
			JSONArray jsonArr=JSONArray.fromObject(bList);
			out.write(jsonArr.toString());
		}else if (type.equals("reMark")) {
			Reader reader = (Reader)request.getSession().getAttribute("user");
			List<Mark> mList = mBiz.getMarkByReaId(pageIndex, pageSize, reader.getreaId());
			if(mList.size()>0){
			for (Mark mark : mList) {
				if(mark.getBack()==1)
				{
					mark.setStatus("已归还");
				}else if(mark.getBack()==0)
				{
					mark.setStatus("未归还");
				}
			}
			JSONArray jsonArr=JSONArray.fromObject(mList);
			out.write(jsonArr.toString());
			}
		}else if(type.equals("search")){
			String str=request.getParameter("str");
			List<Book> bList = bBiz.getBookByString(str, pageIndex, pageSize);
			if(bList.size()>0)
			{
				JSONArray jsonArr=JSONArray.fromObject(bList);
				out.write(jsonArr.toString());
			}
		}
		out.flush();
		out.close();
	}

}
