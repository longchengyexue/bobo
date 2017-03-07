package com.dhee.interfaces;

import java.util.ArrayList;

import com.dhee.dto.NoticeDTO;
/**
 * NoticeDAO类需要实现的所有接口
 * @author wuzhihui
 */
public interface NoticeDAOInterface {
/**
 * 查询notice表中所有数据的抽象方法
 * @return 载有数据对象notice的ArrayList集合
 */
	public abstract ArrayList<NoticeDTO> selectNotice();
/**
 * 修改notice表中某些数据的抽象方法
 * @param NoticeDTO的对象notice
 * @return 影响数据库的行数，判断操作是否成功
 */
	public abstract int updateNotice(NoticeDTO notice);
/**
 * 往notice表中插入某些数据的抽象方法
 * @param NoticeDTO的对象notice
 * @return 影响数据库的行数，判断操作是否成功
 */
	public abstract int insertNotice(NoticeDTO notice);
/**
 * 删除notice表中某些数据的抽象方法
 * @param NoticeDTO的对象notice
 * @return 影响数据库的行数，判断操作是否成功
 */
	public abstract int deleteNotice(NoticeDTO notice);
}