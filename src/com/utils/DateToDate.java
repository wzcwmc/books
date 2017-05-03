package com.utils;

public class DateToDate {
	//把java.sql.Date 转换成 java.util.Date格式
	public static java.util.Date toUtilDate(java.sql.Date sqlDate){
		java.util.Date date=new java.util.Date(sqlDate.getTime());
		return date;//java.util.date
	}

}
