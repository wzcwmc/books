package com.biz.impl;

import java.util.List;

import com.biz.MarkBiz;
import com.dao.MarkDao;
import com.dao.impl.MarkDaoImpl;
import com.entity.Mark;

public class MarkBizIpml implements MarkBiz {
	
    MarkDao markDao = new MarkDaoImpl();
	@Override
	public List<Mark> getMarkAll(int pageIndex, int pageSize) {
		return markDao.getMarkAll(pageIndex, pageSize);
	}

	@Override
	public List<Mark> getMarkByReaId(int pageIndex, int pageSize, int redId) {
		return markDao.getMarkByReaId(pageIndex, pageSize, redId);
	}

	@Override
	public List<Mark> getMarkByBookId(int pageIndex, int pageSize, int bookId) {
		return markDao.getMarkByBookId(pageIndex, pageSize, bookId);
	}

	@Override
	public int getMarkPages(int pageSize) {
		int count=markDao.getMarkCounts();
		int pages=0;
		if(count%pageSize==0)
		{
			pages=count/pageSize;
		}else{
			pages=count/pageSize+1;
		}
		return pages;
	}

	@Override
	public int addMark(Mark mark) {
		return markDao.addMark(mark);
	}

	@Override
	public int deleteMark(int reaId, int bookId) {
		return markDao.deleteMark(reaId, bookId);
	}

	@Override
	public int getMarkPages(int reaId, int pageSize) {
		int count=markDao.getCountByreaId(reaId);
		int pages=0;
		if(count%pageSize==0)
		{
			pages=count/pageSize;
		}else{
			pages=count/pageSize+1;
		}
		return pages;
	}

	@Override
	public List<Mark> getMarkByBookId(int bookId) {
		return markDao.getMarkByBookId(bookId);
	}

	@Override
	public List<Mark> getMarkByReaId(int reaId) {
		return markDao.getMarkByReaId(reaId);
	}

	@Override
	public Mark getMarkByBookId(int bookId, int reaId) {
		return markDao.getMarkByBookId(bookId, reaId);
	}

	@Override
	public int updateMark(Mark mark, int reaId, int bookId) {
		return markDao.updateMark(mark, reaId, bookId);
	}

}
