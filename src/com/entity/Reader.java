package com.entity;

import java.util.Date;



public class Reader {
	
	private int reaId;//���߱��
	private String loginId; //��¼��
	private String loginPwd; //��¼����
	private String reaName; //��������
	private String gender; //�Ա�
	private Date birthday; //����
	private String address; //��ַ
	private String phone;//�绰
	
	public int getreaId() {
		return reaId;
	}
	public void setReaId(int reaId) {
		this.reaId = reaId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getReaName() {
		return reaName;
	}
	public void setReaName(String reaName) {
		this.reaName = reaName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Reader( String loginId, String loginPwd, String reaName,
			String gender, Date birthday, String address, String phone) {
		super();
		this.loginId = loginId;
		this.loginPwd = loginPwd;
		this.reaName = reaName;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
	}
	public Reader() {
		super();
		// TODO Auto-generated constructor stub
	}
}