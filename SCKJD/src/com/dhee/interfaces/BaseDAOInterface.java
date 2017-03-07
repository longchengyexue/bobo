package com.dhee.interfaces;

import java.util.ArrayList;

import com.dhee.dto.BaseDTO;
/**
 * BaseDAO类需要实现的所有接口
 * @author wuzhihui
 */
public interface BaseDAOInterface {
/**
 * 查询Base表中所有数据的抽象方法
 * @return 载有基地数据对象的ArrayList集合
 */
	public abstract ArrayList<BaseDTO> selectBase();
/**
 * 修改Base表中某些数据的抽象方法
 * @param BaseDAO的对象base
 * @return 影响数据库的行数，判断操作是否成功
 */
	public abstract int updateBase(BaseDTO base);
/**
 * 往Base表中插入某些数据的抽象方法
 * @param BaseDAO的对象base
 * @return 影响数据库的行数，判断操作是否成功
 */
	public abstract int insertBase(BaseDTO base);
/**
 * 删除Base表中某些数据的抽象方法
 * @param BaseDAO的对象base
 * @return 影响数据库的行数，判断操作是否成功
 */
	public abstract int deleteBase(int bid);
}