package com.entity;

import java.util.Date;

/**
 * 记录实体类  作用：数据的载体
 */


public class Mark {

	private int reaId; // 读者编号
	private String loginId; //登录名    辅助列
	private int bookId; // 图书编号
	private String bookName;//图书名    辅助列
	private Date lendDate; // 借出日期
	private Date backDate;// 返还日期
	private String phone;//电话    辅助列
	private int isBack;//是否归还
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
