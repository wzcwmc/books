package com.biz.impl;

import java.util.List;

import com.biz.BookBiz;
import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;
import com.entity.Book;

public class BookBizImpl implements BookBiz {

	private BookDao bookDao = new BookDaoImpl();
		
	@Override
	public List<Book> getBookByName(String bookName) {
		return bookDao.getBookByName(bookName);
	}


	@Override
	public List<Book> getBookBytype(String bookType,int pageIndex, int pageSize) {
		return bookDao.getBookBytype(bookType,pageIndex,pageSize);
	}

	@Override
	public List<Book> getBookByLendNum() {
		return bookDao.getBookByLendNum();
	}

	@Override
	public List<Book> getBookByInnerDate() {
		return bookDao.getBookByInnerDate();
	}

	@Override
	public List<Book> getBookByString(String str,int pageIndex, int pageSize ) {
		return bookDao.getBookByString(str,pageIndex,pageSize );
	}

	@Override
	public Book getBookById(int bookId) {
		return bookDao.getBookById(bookId);
	}

	@Override
	public int getBookPages(int pageSize) {
		int count=bookDao.getBookCounts();
		int pages=0;
		if(count%pageSize==0)
		{
			pages=count/pageSize;
		}else{
			pages=count/pageSize+1;
		}
		return pages;
	}

	@Override
	public List<Book> getBookAll(int pageIndex, int pageSize) {
		return bookDao.getBookAll(pageIndex, pageSize);
	}

	@Override
	public int addBook(Book book) {
		Book bk=bookDao.getBookByIsbn(book.getIsbn());
		if(bk==null){
			//没有查到书，可以增书
			int res=bookDao.addBook(book);
			if(res>0){
				return 1;  //书不存在，新增成功
			}
			return 3;  //书不存在，新增失败
		}
		return 2;  //书存在
	}

	@Override
	public int deleteBook(int bookId) {
		return bookDao.deleteBook(bookId);
	}

	@Override
	public int updateBook(Book book, int bookId) {
		return bookDao.updateBook(book, bookId);
	}


	@Override
	public int getBookTypePages(String bookType,int pageSize) {
		int count=bookDao.getCountsBybookType(bookType);
		int pages=0;
		if(count%pageSize==0)
		{
			pages=count/pageSize;
		}else{
			pages=count/pageSize+1;
		}
		return pages;
	}


	@Override
	public int getPagesByString(String str,int pageSize) {
		int count=bookDao.getCountsByString(str);
		int pages=0;
		if(count%pageSize==0)
		{
			pages=count/pageSize;
		}else{
			pages=count/pageSize+1;
		}
		return pages;
	}


}
