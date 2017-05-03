package com.biz;

import java.util.List;

import com.entity.Book;

public interface BookBiz {

	/**
	 * 根据书名查询书籍信息
	 * @param bookName
	 * @return 书籍集合
	 */
	public List<Book> getBookByName(String bookName);

	/**
	 * 根据书籍类型查询书籍信息
	 * @param bookType
	 * @return 书籍集合
	 */
	public List<Book> getBookBytype(String bookType,int pageIndex, int pageSize);
	
    /**
     * 查询借出数量多的书
     * @return 图书集合
     */
    public List<Book> getBookByLendNum();
    
    /**
     * 查询近期入库的书籍
     * @return 图书集合
     */
    public List<Book> getBookByInnerDate();
    
    /**
     * 根据输入的关键字查询图书
     * @param str 输入的关键字
     * @return 图书集合
     */
    public List<Book> getBookByString(String str,int pageIndex, int pageSize);
    
    /**
     * 分页查询 获得所有图书信息
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<Book> getBookAll(int pageIndex, int pageSize);
    /**
     * 根据编号查询图书
     * @param bookId 编号
     * @return 图书集合（只含一本）
     */
    public Book  getBookById(int bookId);
    /**
	 * 获取总页数
	 * @return 总页数
	 */
	public int getBookPages(int pageSize);
	/**
	 * 获取不同类型图书总页数
	 * @return 总页数
	 */
	public int getBookTypePages(String bookType,int pageSize);
	
	 /**
     * 添加图书
     * @return  影响的行数
     */
    public int addBook(Book book);
    /**
     * 根据bookId删除图书
     * @param bookId
     * @return  影响的行数
     */
    public int deleteBook(int bookId);
    /**
     * 图书更新
     * @param book
     * @return  影响的行数
     */
    public int updateBook(Book book,int bookId);
    /**
     * 根据关键词搜索查询相同条件的图书总页数
     * @return 图书总页数
     */
    public int getPagesByString(String str,int pageSize);

}
