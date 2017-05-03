package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.dao.AdminDao;
import com.entity.Mang;
import com.utils.DBUtils;

public class AdminDaoImpl implements AdminDao {
     Connection conn =null;
     PreparedStatement psmt=null;
     ResultSet rs=null;
     DBUtils dbu= new DBUtils();
	@Override
	public Mang getMangByName(String mangName) {
		String sql=" select mangid, mangname, mangpwd from mang  where mangname=? ";
		Mang admin= null;
		conn=dbu.getConn();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, mangName);
			rs=psmt.executeQuery();
			if(rs.next()){
				admin= new Mang();
				admin.setMangId(rs.getInt("mangid"));
				admin.setMangName(rs.getString("mangname"));
				admin.setMangPwd(rs.getString("mangpwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbu.closeAll(rs, psmt, conn);
		}
		return admin;
	}
}
