package com.dhee.interfaces;

import java.util.ArrayList;

import com.dhee.dto.BaseDTO;
/**
 * BaseDAO����Ҫʵ�ֵ����нӿ�
 * @author wuzhihui
 */
public interface BaseDAOInterface {
/**
 * ��ѯBase�����������ݵĳ��󷽷�
 * @return ���л������ݶ����ArrayList����
 */
	public abstract ArrayList<BaseDTO> selectBase();
/**
 * �޸�Base����ĳЩ���ݵĳ��󷽷�
 * @param BaseDAO�Ķ���base
 * @return Ӱ�����ݿ���������жϲ����Ƿ�ɹ�
 */
	public abstract int updateBase(BaseDTO base);
/**
 * ��Base���в���ĳЩ���ݵĳ��󷽷�
 * @param BaseDAO�Ķ���base
 * @return Ӱ�����ݿ���������жϲ����Ƿ�ɹ�
 */
	public abstract int insertBase(BaseDTO base);
/**
 * ɾ��Base����ĳЩ���ݵĳ��󷽷�
 * @param BaseDAO�Ķ���base
 * @return Ӱ�����ݿ���������жϲ����Ƿ�ɹ�
 */
	public abstract int deleteBase(int bid);
}