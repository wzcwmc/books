package com.dao;

import com.entity.Mang;

public interface AdminDao {
	/**
	 * 根据登录名获取管理员信息
	 * @param mangName  登录名
	 * @return  管理员实体
	 */
    public Mang getMangByName(String mangName);
    
    
}
