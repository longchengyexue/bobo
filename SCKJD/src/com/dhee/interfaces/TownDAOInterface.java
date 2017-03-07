package com.dhee.interfaces;

import java.util.ArrayList;

import com.dhee.dto.TownDTO;
/**
 * TownDAO类需要实现的所有接口
 * @author wuzhihui
 */
public interface TownDAOInterface {
/**
 * 查询Town表中所有数据的抽象方法
 * @return 载有Town数据对象的ArrayList集合
 */
	public abstract ArrayList<TownDTO> selectTown();
/**
 * 修改Town表中某些数据的抽象方法
 * @param TownDAO的对象town
 * @return 影响数据库的行数，判断操作是否成功
 */
	public abstract int updateTown(TownDTO town);	
/**
 * 往Base表中插入某些数据的抽象方法
 * @param TownDAO的对象town
 * @return 影响数据库的行数，判断操作是否成功
 */
	public abstract int insertTown(TownDTO town);
/**
 * 删除Base表中某些数据的抽象方法
 * @param TownDAO的对象town
 * @return 影响数据库的行数，判断操作是否成功
 */
	public abstract int deleteTown(TownDTO town);
}