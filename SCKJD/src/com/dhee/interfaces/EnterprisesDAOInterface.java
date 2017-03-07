package com.dhee.interfaces;

import java.util.ArrayList;

import com.dhee.dto.EnterprisesDTO;
/**
 * EnterprisesDAO类需要实现的所有接口
 * @author wuzhihui
 */
public interface EnterprisesDAOInterface {
/**
 * 查询Enterprises表中所有数据的抽象方法
 * @return 载有数据对象enterprises的ArrayList集合
 */
	public abstract ArrayList<EnterprisesDTO> selectEnterprises();
/**
 * 修改enterprises表中某些数据的抽象方法
 * @param EnterprisesDTO的对象enterprises
 * @return 影响数据库的行数，判断操作是否成功
 */
	public abstract int updateEnterprises(EnterprisesDTO enterprises);	
/**
 * 往enterprises表中插入某些数据的抽象方法
 * @param EnterprisesDTO的对象enterprises
 * @return 影响数据库的行数，判断操作是否成功
 */
	public abstract int insertEnterprises(EnterprisesDTO enterprises);
/**
 * 删除enterprisesDTO表中某些数据的抽象方法
 * @param EnterprisesDTO的对象enterprises
 * @return 影响数据库的行数，判断操作是否成功
 */
	public abstract int deleteEnterprises(EnterprisesDTO enterprises);
}
