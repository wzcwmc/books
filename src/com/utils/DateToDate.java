package com.utils;

public class DateToDate {
	//��java.sql.Date ת���� java.util.Date��ʽ
	public static java.util.Date toUtilDate(java.sql.Date sqlDate){
		java.util.Date date=new java.util.Date(sqlDate.getTime());
		return date;//java.util.date
	}

}
