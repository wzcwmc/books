package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.MarkDao;
import com.entity.Mark;
import com.utils.DBUtils;
import com.utils.DateToDate;

public class MarkDaoImpl implements MarkDao {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	DBUtils dbu = new DBUtils();

	@Override
	public List<Mark> getMarkAll(int pageIndex, int pageSize) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * ");
		sb.append(" from (select tt.*  ");
		sb.append(" from (select r.loginid,r.phone,b.bookname,m.*,rownum AS rowno ");
		sb.append(" from  mark m,reader r,book b ");
		sb.append(" where m.reaid=r.reaid and m.bookid=b.bookid order by lendDate ) tt  ");
		sb.append(" where rownum <= ");
		sb.append(pageIndex * pageSize);
		sb.append(" ) table_alias ");
		sb.append(" where table_alias.rowno >= ");
		sb.append((pageIndex - 1) * pageSize + 1);
		return getMarkBySQL(sb.toString());
	}

	@Override
	public List<Mark> getMarkByReaId(int pageIndex, int pageSize,int redId) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * ");
		sb.append(" from (select tt.*  ");
		sb.append(" from (select r.loginid,r.phone,b.bookname,m.*,rownum as rowno ");
		sb.append(" from  mark m,reader r,book b ");
		sb.append(" where m.reaid=? and m.reaid=r.reaid and m.bookid=b.bookid order by lendDate ) tt  ");
		sb.append(" where rownum <= ");
		sb.append(pageIndex * pageSize);
		sb.append(" ) table_alias ");
		sb.append(" where table_alias.rowno >= ");
		sb.append((pageIndex - 1) * pageSize + 1);
		return getMarkBySQL(sb.toString(),redId);
	}

	@Override
	public List<Mark> getMarkByBookId(int pageIndex, int pageSize,int bookId) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * ");
		sb.append(" from (select tt.*  ");
		sb.append(" from (SELECT m.*, ROWNUM AS rowno ");
		sb.append(" from mark m  ");
		sb.append(" where bookid= ? ");
		sb.append(" ORDER BY lendDate) tt  ");
		sb.append(" WHERE ROWNUM <= ");
		sb.append(pageIndex * pageSize);
		sb.append(" ) table_alias ");
		sb.append(" WHERE table_alias.rowno >= ");
		sb.append((pageIndex - 1) * pageSize + 1);
		return getMarkBySQL(sb.toString(),bookId);
	}

	private List<Mark> getMarkBySQL(String sql, Object... obj) {
		List<Mark> list = new ArrayList<Mark>();
		conn = dbu.getConn();
		try {
			psmt = conn.prepareStatement(sql);
			if (obj.length > 0) {
				for (int i = 0; i < obj.length; i++) {
					psmt.setObject(i + 1, obj[i]);
				}
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
			Mark mark= new Mark();
			mark.setBookId(rs.getInt("bookId"));
			mark.setReaId(rs.getInt("reaId"));
			mark.setLendDate(DateToDate.toUtilDate(rs.getDate("lendDate")));
			mark.setBackDate(DateToDate.toUtilDate(rs.getDate("backDate")));
			mark.setBack(rs.getInt("isback"));
			if(sql.contains("bookname"))
			{
				mark.setBookName(rs.getString("bookname"));
			}
			if(sql.contains("loginid"))
			{
				mark.setLoginId(rs.getString("loginid"));
			}
			if(sql.contains("phone"))
			{
				mark.setPhone(rs.getString("phone"));
			}
			list.add(mark);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, psmt, conn);
		}
		return list;
	}

	@Override
	public int getMarkCounts() {
		int count=0;
		String sql=" select count(0) as rowno from mark ";
		conn=dbu.getConn();
		try {
			psmt= conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			if(rs.next())
			{
				count=rs.getInt("rowno");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbu.closeAll(rs, psmt, conn);
		}
		return count;
	}

	@Override
	public int addMark(Mark mark) {
		StringBuffer sb = new StringBuffer();
		sb.append(" insert into mark ");
		sb.append(" (reaid, bookid, lenddate, backdate,isback) ");
		sb.append(" values (?, ?, ?, ?, ? ) ");
		Object [] obj={mark.getReaId(),mark.getBookId(),mark.getLendDate(),mark.getBackDate(),mark.getBack()};
		return dbu.executeUpdate(sb.toString(), obj);
	}

	@Override
	public int deleteMark(int reaId, int bookId) {
		String sql =" delete mark where reaid=? and bookid=? ";
		Object [] obj={reaId,bookId};
		return dbu.executeUpdate(sql, obj);
	}

	@Override
	public int getCountByreaId(int reaId) {
		String sql = "select count(0) as rowno from mark where reaid = ? ";
		int count=0;
		conn=dbu.getConn();
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setInt(1, reaId);
			rs=psmt.executeQuery();
			if(rs.next())
			{
				count=rs.getInt("rowno");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbu.closeAll(rs, psmt, conn);
		}
		return count;
	}

	@Override
	public List<Mark> getMarkByReaId(int reaId) {
		String sql = " select * from mark where reaid = ? ";
		return getMarkBySQL(sql, reaId);
	}

	@Override
	public List<Mark> getMarkByBookId(int bookId) {
		
		String sql = " select * from mark where bookid = ? ";
		
		return getMarkBySQL(sql, bookId);
	}

	@Override
	public Mark getMarkByBookId(int bookId, int reaId) {
		String sql = " select * from mark where bookid = ? and reaId = ? ";
		Object [] obj={ bookId,reaId};
		List<Mark> list=getMarkBySQL(sql,obj);
		if(list.size()>0)
		{
			return list.get(0);
		}
		return null;
	}

	@Override
	public int updateMark(Mark mark,int reaId, int bookId) {
		String sql=" update mark set reaid = ?, bookid = ?, "
				+ " lenddate = ?,backdate = ?, isback = ? "
				+ " where reaid = ? and bookid = ? ";
		Object [] obj={mark.getReaId(),mark.getBookId(),mark.getLendDate(),
				mark.getBackDate(),mark.getBack(),reaId,bookId};
		return dbu.executeUpdate(sql, obj);
	}
}
