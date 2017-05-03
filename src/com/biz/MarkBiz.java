package com.biz;

import java.util.List;

import com.entity.Mark;

public interface MarkBiz {
	/**
	 * ��ѯ���н����¼ ����ҳ��ѯ��
	 * 
	 * @return �����¼����
	 */
	public List<Mark> getMarkAll(int pageIndex, int pageSize);

	/**
	 * ����ReaId��ѯ�����¼ ����ҳ��ѯ��
	 * 
	 * @return �����¼����
	 */
	public List<Mark> getMarkByReaId(int pageIndex, int pageSize, int redId);

	/**
	 * ����BookId��ѯ�����¼ ����ҳ��ѯ��
	 * 
	 * @return �����¼����
	 */
	public List<Mark> getMarkByBookId(int pageIndex, int pageSize, int bookId);

	/**
	 * ��ȡ��ҳ��
	 * 
	 * @return ��ҳ��
	 */
	public int getMarkPages(int pageSize);

	/**
	 * ���ӽ����¼
	 * 
	 * @param mark
	 * @return Ӱ�������
	 */
	public int addMark(Mark mark);

	/**
	 * ����reaId��bookIdɾ�������¼
	 * 
	 * @param reaId
	 * @param bookId
	 * @return Ӱ�������
	 */
	public int deleteMark(int reaId, int bookId);

	/**
	 * ��ȡ��ͬ���߼�¼����ҳ��
	 * 
	 * @return ��ҳ��
	 */
	public int getMarkPages(int reaId, int pageSize);

	/**
	 * ����BookId��ѯ�����¼
	 * 
	 * @return �����¼����
	 */
	public List<Mark> getMarkByBookId(int bookId);

	/**
	 * ����ReaId��ѯ�����¼
	 * 
	 * @return �����¼����
	 */
	public List<Mark> getMarkByReaId(int reaId);
	/**
	 * ����BookId��reaId��ѯ�����¼ 
	 * @return  �����¼
	 */
	   public Mark getMarkByBookId(int bookId,int reaId);
	   /**
	    * ����reaId��bookId���½����¼
	    * @param reaId
	    * @param bookId
	    * @return  Ӱ�������
	    */
	   public int updateMark(Mark mark,int reaId,int bookId);
}