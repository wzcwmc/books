package com.entity;

import java.util.Date;

/**
 * ͼ��ʵ����   ���ã����ݵ�����
 */


public class Book {
	private int bookId; //ͼ����
	private String isbn; //ͼ��汾��
	private String bookName;//ͼ����
	private String author;//ͼ������
	private String publisher; //ͼ�������
	private Date pubDate; //ͼ���������
	private String bookType;//ͼ������
	private String introduction; //ͼ�����
	private String price; //ͼ��۸�
	private int bookNum; //�鱾����
	private int lendNum; //���������
	private int nowNum; //���е�����
	private String bookImg;//�鱾ͼƬ
	private Date innerDate; //ͼ���������
	
	
	public Book() {
		super();
	}
	
	public Book(int bookId, String isbn, String bookName, String author,
			String publisher, Date pubDate, String bookType,
			String introduction, String price, int bookNum, int lendNum,
			int nowNum, String bookImg, Date innerDate) {
		super();
		this.bookId = bookId;
		this.isbn = isbn;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.pubDate = pubDate;
		this.bookType = bookType;
		this.introduction = introduction;
		this.price = price;
		this.bookNum = bookNum;
		this.lendNum = lendNum;
		this.nowNum = nowNum;
		this.bookImg = bookImg;
		this.innerDate = innerDate;
	}

	public Date getInnerDate() {
		return innerDate;
	}

	public void setInnerDate(Date innerDate) {
		this.innerDate = innerDate;
	}

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public int getLendNum() {
		return lendNum;
	}
	public void setLendNum(int lendNum) {
		this.lendNum = lendNum;
	}
	public int getNowNum() {
		return nowNum;
	}
	public void setNowNum(int nowNum) {
		this.nowNum = nowNum;
	}
	public String getBookImg() {
		return bookImg;
	}
	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}
}
