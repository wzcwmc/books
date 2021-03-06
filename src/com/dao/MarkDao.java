package com.dao;

import java.util.List;

import com.entity.Mark;

public interface MarkDao {
 /**
  * 查询所有借书记录  （分页查询）
  * @return  借书记录集合
  */
   public List<Mark> getMarkAll(int pageIndex,int pageSize);
   /**
    * 根据ReaId查询借书记录  （分页查询）
    * @return  借书记录集合
    */
   public List<Mark> getMarkByReaId(int pageIndex,int pageSize,int redId);
   /**
    * 根据ReaId查询借书记录
    * @return  借书记录集合
    */
   public List<Mark> getMarkByReaId(int reaId);
   /**
    * 根据BookId查询借书记录  （分页查询）
    * @return  借书记录集合
    */
   public List<Mark> getMarkByBookId(int pageIndex,int pageSize,int bookId);
   /**
    * 根据BookId查询借书记录 
    * @return  借书记录集合
    */
   public List<Mark> getMarkByBookId(int bookId);
   /**
    * 根据BookId和reaId查询借书记录 
    * @return  借书记录
    */
   public Mark getMarkByBookId(int bookId,int reaId);
   /**
    * 查询借书记录总数
    * @return 借书记录总数
    */
   public int getMarkCounts();
   /**
    * 添加借书记录
    * @param mark
    * @return   影响的行数
    */
   public int addMark(Mark mark);
   /**
    * 根据reaId和bookId删除借书记录
    * @param reaId
    * @param bookId
    * @return  影响的行数
    */
   public int deleteMark(int reaId,int bookId );
   
   /**
    * 根据读者ID 获取该读者记录数
    * @param reaId 读者id
    * @return 记录条数
    */
   public int getCountByreaId(int reaId);
   /**
    * 根据reaId和bookId更新借书记录
    * @param reaId
    * @param bookId
    * @return  影响的行数
    */
   public int updateMark(Mark mark,int reaId,int bookId);
}
