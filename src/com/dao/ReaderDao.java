package com.dao;

import java.util.List;

import com.entity.Reader;

public interface ReaderDao {

	
	/**
	 * ��ȡ���еĶ�����Ϣ�б�
	 * @return ������Ϣ����
	 */
	public List<Reader> getReaderAll(int pageIndex, int pageSize);
	
	/**
	 * ���ݵ�����ȡ������Ϣ
	 * @return ���߶���
	 */
	public Reader getReaderByLoginId(String LoginId);
	
	/**
	 * ���Ӷ����û�
	 * @param reader ���߶���
	 * @return ��Ӱ�������
	 */
	public  int addReader(Reader reader);
	/**
	 * ��ѯ�û�����
	 * @return �û�����
	 */
	public int getReaderCounts();
	
	/**
	 * �����û���Ϣ
	 * @param reader �û�����
	 * @param reaId �û�Id
	 * @return ��Ӱ������
	 */
	public int updateReader(Reader reader,int reaId);
	
	/**
	 * �����û�Idɾ���û�
	 * @param reaId �û�Id
	 * @return ��Ӱ������
	 */
	public int deleteReader(int reaId);
}