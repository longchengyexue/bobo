package com.dhee.interfaces;

import java.util.ArrayList;

import com.dhee.dto.TownDTO;
/**
 * TownDAO����Ҫʵ�ֵ����нӿ�
 * @author wuzhihui
 */
public interface TownDAOInterface {
/**
 * ��ѯTown�����������ݵĳ��󷽷�
 * @return ����Town���ݶ����ArrayList����
 */
	public abstract ArrayList<TownDTO> selectTown();
/**
 * �޸�Town����ĳЩ���ݵĳ��󷽷�
 * @param TownDAO�Ķ���town
 * @return Ӱ�����ݿ���������жϲ����Ƿ�ɹ�
 */
	public abstract int updateTown(TownDTO town);	
/**
 * ��Base���в���ĳЩ���ݵĳ��󷽷�
 * @param TownDAO�Ķ���town
 * @return Ӱ�����ݿ���������жϲ����Ƿ�ɹ�
 */
	public abstract int insertTown(TownDTO town);
/**
 * ɾ��Base����ĳЩ���ݵĳ��󷽷�
 * @param TownDAO�Ķ���town
 * @return Ӱ�����ݿ���������жϲ����Ƿ�ɹ�
 */
	public abstract int deleteTown(TownDTO town);
}