package com.entity;

import java.util.Date;

/**
 * ��¼ʵ����  ���ã����ݵ�����
 */


public class Mark {

	private int reaId; // ���߱��
	private String loginId; //��¼��    ������
	private int bookId; // ͼ����
	private String bookName;//ͼ����    ������
	private Date lendDate; // �������
	private Date backDate;// ��������
	private String phone;//�绰    ������
	private int isBack;//�Ƿ�黹
    private String status;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getReaId() {
		return reaId;
	}

	public void setReaId(int reaId) {
		this.reaId = reaId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Date getLendDate() {
		return lendDate;
	}

	public void setLendDate(Date lendDate) {
		this.lendDate = lendDate;
	}

	public Date getBackDate() {
		return backDate;
	}

	public void setBackDate(Date backDate) {
		this.backDate = backDate;
	}

	public int getBack() {
		return isBack;
	}

	public void setBack(int isBack) {
		this.isBack = isBack;
	}

	

	public Mark(int reaId, String loginId, int bookId, String bookName,
			Date lendDate, Date backDate, String phone, int isBack) 
	{
		super();
		this.reaId = reaId;
		this.loginId = loginId;
		this.bookId = bookId;
		this.bookName = bookName;
		this.lendDate = lendDate;
		this.backDate = backDate;
		this.phone = phone;
		this.isBack = isBack;
	}

	public Mark() {
		super();
	}

}
