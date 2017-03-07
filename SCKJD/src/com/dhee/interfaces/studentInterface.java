package com.dhee.interfaces;

import java.util.ArrayList;

import com.dhee.dto.NoticeDTO;
import com.dhee.dto.studentDto;

public interface studentInterface {
	/**
	 * 查询notice表中所有数据的抽象方法
	 * @return 载有数据对象notice的ArrayList集合
	 */
		public abstract ArrayList<studentDto> select();
	/**
	 * 修改notice表中某些数据的抽象方法
	 * @param NoticeDTO的对象notice
	 * @return 影响数据库的行数，判断操作是否成功
	 */
		public abstract int update(studentDto student);
	/**
	 * 往notice表中插入某些数据的抽象方法
	 * @param NoticeDTO的对象notice
	 * @return 影响数据库的行数，判断操作是否成功
	 */
		public abstract int insert(studentDto student);
	/**
	 * 删除notice表中某些数据的抽象方法
	 * @param NoticeDTO的对象notice
	 * @return 影响数据库的行数，判断操作是否成功
	 */
		public abstract int delete(studentDto student);
}
