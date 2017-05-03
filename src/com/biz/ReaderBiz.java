package com.biz;

import java.util.List;

import com.entity.Reader;

public interface ReaderBiz {

	/**
	 * ��ȡ���еĶ�����Ϣ�б�
	 * @return ������Ϣ����
	 */
	public List<Reader> getReaderAll(int pageIndex, int pageSize);

	/**
	 * ���ݵ�����ȡ������Ϣ
	 * @return ���߶���
	 */
	public Reader getReaderByLoginId(String loginId, String loginPwd);
	
	/**
	 * ���ݵ�����ȡ������Ϣ
	 * @return ���߶���
	 */
	public Reader getReaderByLoginId(String loginId);
	/**
	 * ע���û�
	 * @param reader ���߶���
	 * @return
	 */
	public int register(Reader reader);
	/**
	 * ��ȡ��ҳ��
	 * @return ��ҳ��
	 */
	public int getReaderPages(int pageSize);
	
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