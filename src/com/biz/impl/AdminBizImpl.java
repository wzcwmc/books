package com.biz.impl;

import com.biz.AdminBiz;
import com.dao.AdminDao;
import com.dao.impl.AdminDaoImpl;
import com.entity.Mang;

public class AdminBizImpl implements AdminBiz {
	AdminDao adDao = new AdminDaoImpl();

	@Override
	public Mang Register(String mangName, String mangPwd) {
		Mang manger = adDao.getMangByName(mangName);
		if (manger != null && manger.getMangPwd().equals(mangPwd)) {
			return manger;
		}
		return null;
	}
}
