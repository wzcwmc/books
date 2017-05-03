package com.dao;

import java.util.List;

import com.entity.Book;

public interface BookDao {

	 /**
     * ���÷�����ִ��sql���
     * @param sql  sql���
     * @param obj  
     * @return  ��ѯ����ļ���
     */
    public List<Book> getBookBySQL(String sql,Object...obj);
    
    /**
     * ��������ģ����ѯ
     * @param bookName  �����ֶ�
     * @return  ͼ�鼯��
     */
    public List<Book> getBookByName(String bookName);
    /**
     * ���ݰ汾�ž�ȷ��ѯ
     * @param Isbn  �����ֶ�
     * @return  ͼ��
     */
    public Book getBookByIsbn(String Isbn);
    
    /**
     * �����������ģ����ѯ
     * @param bookType  ͼ������
     * @return  ͼ�鼯��
     */
    public List<Book> getBookBytype(String bookType,int pageIndex, int pageSize);
    
    /**
     * ��������Ĺؼ��ֲ�ѯͼ��
     * @param str ����Ĺؼ���
     * @return ͼ�鼯��
     */
    public List<Book> getBookByString(String str, int pageIndex, int pageSize);
    
    /**
     * ���ݱ�Ų�ѯͼ��
     * @param bookId ���
     * @return ͼ�鼯�ϣ�ֻ��һ����
     */
    public Book  getBookById(int bookId);
    
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
     * ��ҳ��ѯ �������ͼ����Ϣ
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<Book> getBookAll(int pageIndex, int pageSize);
    /**
     * ��ѯͼ������
     * @return ͼ������
     */
    public int getBookCounts();
    /**
     * ��ѯ��ͬ����ͼ������
     * @return ͼ������
     */
    public int getCountsBybookType(String bookType);
    /**
     * ���ݹؼ���������ѯ��ͬ������ͼ������
     * @return ͼ������
     */
    public int getCountsByString(String str);
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
    
}