package com.biz.impl;

import java.util.List;

import com.biz.ReaderBiz;
import com.dao.ReaderDao;
import com.dao.impl.ReaderDaoImpl;
import com.entity.Reader;

public class ReaderBizImpl implements ReaderBiz {

	ReaderDao reaDao = new ReaderDaoImpl();
	
	@Override
	public List<Reader> getReaderAll(int pageIndex, int pageSize) {
		return reaDao.getReaderAll( pageIndex, pageSize);
	}

	@Override
	public Reader getReaderByLoginId(String loginId,  String loginPwd) {
		Reader reader = reaDao.getReaderByLoginId(loginId);
		if (reader!=null&&reader.getLoginPwd().equals(loginPwd)) {
			return reader;
		}
		return null;
	}

	@Override
	public int register(Reader reader) {
		Reader rea=reaDao.getReaderByLoginId(reader.getLoginId());
		//业务逻辑处理
		if(rea==null){
			//没有查到该用户，可以注册
			int result=reaDao.addReader(reader);
			if(result>0){
				return 1;//用户名不存在，新增成功
			}
			return 3;//用户名不存在，但是新增失败
		}
		return 2;//用户名已经存在
	}

	@Override
	public int getReaderPages(int pageSize) {
		int count=reaDao.getReaderCounts();
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
	public int updateReader(Reader reader, int reaId) {
		return reaDao.updateReader(reader, reaId);
	}

	@Override
	public Reader getReaderByLoginId(String loginId) {
		// TODO Auto-generated method stub
		return reaDao.getReaderByLoginId(loginId);
	}

	@Override
	public int deleteReader(int reaId) {
		// TODO Auto-generated method stub
		return reaDao.deleteReader(reaId);
	}

}
