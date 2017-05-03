package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.biz.BookBiz;
import com.biz.impl.BookBizImpl;
import com.entity.Book;

public class AddBookServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6437699434404205664L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//做新增
		    BookBiz bookBiz=new BookBizImpl();
		    
			DiskFileItemFactory factory=new DiskFileItemFactory();
			
			ServletFileUpload upload=new ServletFileUpload(factory);
			
			List items=null;
			try {
				items=upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			Iterator iter=items.iterator();
			Map<String,String> mapList=new HashMap<String,String>();
			while(iter.hasNext()){
				FileItem item=(FileItem) iter.next();
				if(item.isFormField()){
					//如果是表单域，就是非文件上传元素
					String name=item.getFieldName();//获取name属性的值
					
					String value=item.getString();//获取value属性的值
					
					value=new String(value.getBytes("ISO-8859-1"),"UTF-8");
					mapList.put(name, value);
					
				}else{
					//就是上传图片
					String fieldName=item.getFieldName();
					
					String fileName=item.getName();
					
					String contentType=item.getContentType();
					
					long size=item.getSize();
					
					String fix=fileName.substring(fileName.lastIndexOf(".")+1);
					
					Date nowDate=new Date();
					SimpleDateFormat sdf=new SimpleDateFormat("yyMMddhhmmss");
					fileName=sdf.format(nowDate);
					fileName +=System.currentTimeMillis();
					fileName +="."+fix;
					
					String savePath=request.getSession().getServletContext().getRealPath("/")+"bookface/";
					File file=new File(savePath+fileName);
					try {
						item.write(file);
					} catch (Exception e) {
						e.printStackTrace();
					}
					mapList.put(fieldName, "bookface/"+fileName);
				}
			}
			Book book=new Book();
			if(mapList.size()>0){
				for (String key : mapList.keySet()) {
					if(key.equals("isbn")){
						book.setIsbn(mapList.get(key));
					}else if(key.equals("bookName")){
						book.setBookName(mapList.get(key));
					}else if(key.equals("author")){
						book.setAuthor(mapList.get(key));
					}else if(key.equals("publisher")){
						book.setPublisher(mapList.get(key));
					}else if(key.equals("pubDate")){
						book.setPubDate(java.sql.Date.valueOf(mapList.get(key)));
					}else if(key.equals("bookType")){
						book.setBookType(mapList.get(key));
					}else if(key.equals("introduction")){
						book.setIntroduction(mapList.get(key));
					}else if(key.equals("price")){
						book.setPrice(mapList.get(key));
					}else if(key.equals("bookNum")){
						book.setBookNum(Integer.parseInt(mapList.get(key)));
						book.setNowNum(Integer.parseInt(mapList.get(key)));
						book.setLendNum(0);
					}else if(key.equals("bookImg")){
						book.setBookImg(mapList.get(key));
					}
				}
				DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				String now=df.format(new Date());
				book.setInnerDate(java.sql.Date.valueOf(now));
			}
			
			
			
			int res=bookBiz.addBook(book);
			
			if(res==1){
				response.sendRedirect("adminShow.html");
			}else if(res==2){
				PrintWriter out=response.getWriter();
				
				out.write("<script type='text/javascript'>alert('书已存在，请换书');location.href='addBook.html';</script>");
				
				out.flush();
				out.close();
			}else{
				//书不存在，但是新增失败
				PrintWriter out=response.getWriter();
				out.write("<script type='text/javascript'>alert('新增期间发生不可预知错误');location.href='addBook.html';</script>");
				//response.sendRedirect("addBook.html");
				out.flush();
				out.close();
			}
		}
	}
