package com.biz;

import java.util.List;

import com.entity.Book;

public interface BookBiz {

	/**
	 * ����������ѯ�鼮��Ϣ
	 * @param bookName
	 * @return �鼮����
	 */
	public List<Book> getBookByName(String bookName);

	/**
	 * �����鼮���Ͳ�ѯ�鼮��Ϣ
	 * @param bookType
	 * @return �鼮����
	 */
	public List<Book> getBookBytype(String bookType,int pageIndex, int pageSize);
	
    /**
     * ��ѯ������������
     * @return ͼ�鼯��
     */
    public List<Book> getBookByLendNum();
    
    /**
     * ��ѯ���������鼮
     * @return ͼ�鼯��
     */
    public List<Book> getBookByInnerDate();
    
    /**
     * ��������Ĺؼ��ֲ�ѯͼ��
     * @param str ����Ĺؼ���
     * @return ͼ�鼯��
     */
    public List<Book> getBookByString(String str,int pageIndex, int pageSize);
    
    /**
     * ��ҳ��ѯ �������ͼ����Ϣ
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<Book> getBookAll(int pageIndex, int pageSize);
    /**
     * ���ݱ�Ų�ѯͼ��
     * @param bookId ���
     * @return ͼ�鼯�ϣ�ֻ��һ����
     */
    public Book  getBookById(int bookId);
    /**
	 * ��ȡ��ҳ��
	 * @return ��ҳ��
	 */
	public int getBookPages(int pageSize);
	/**
	 * ��ȡ��ͬ����ͼ����ҳ��
	 * @return ��ҳ��
	 */
	public int getBookTypePages(String bookType,int pageSize);
	
	 /**
     * ����ͼ��
     * @return  Ӱ�������
     */
    public int addBook(Book book);
    /**
     * ����bookIdɾ��ͼ��
     * @param bookId
     * @return  Ӱ�������
     */
    public int deleteBook(int bookId);
    /**
     * ͼ�����
     * @param book
     * @return  Ӱ�������
     */
    public int updateBook(Book book,int bookId);
    /**
     * ���ݹؼ���������ѯ��ͬ������ͼ����ҳ��
     * @return ͼ����ҳ��
     */
    public int getPagesByString(String str,int pageSize);

}