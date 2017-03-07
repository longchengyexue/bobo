package com.dhee.interfaces;

import java.util.ArrayList;

import com.dhee.dto.EnterprisesDTO;
/**
 * EnterprisesDAO����Ҫʵ�ֵ����нӿ�
 * @author wuzhihui
 */
public interface EnterprisesDAOInterface {
/**
 * ��ѯEnterprises�����������ݵĳ��󷽷�
 * @return �������ݶ���enterprises��ArrayList����
 */
	public abstract ArrayList<EnterprisesDTO> selectEnterprises();
/**
 * �޸�enterprises����ĳЩ���ݵĳ��󷽷�
 * @param EnterprisesDTO�Ķ���enterprises
 * @return Ӱ�����ݿ���������жϲ����Ƿ�ɹ�
 */
	public abstract int updateEnterprises(EnterprisesDTO enterprises);	
/**
 * ��enterprises���в���ĳЩ���ݵĳ��󷽷�
 * @param EnterprisesDTO�Ķ���enterprises
 * @return Ӱ�����ݿ���������жϲ����Ƿ�ɹ�
 */
	public abstract int insertEnterprises(EnterprisesDTO enterprises);
/**
 * ɾ��enterprisesDTO����ĳЩ���ݵĳ��󷽷�
 * @param EnterprisesDTO�Ķ���enterprises
 * @return Ӱ�����ݿ���������жϲ����Ƿ�ɹ�
 */
	public abstract int deleteEnterprises(EnterprisesDTO enterprises);
}
