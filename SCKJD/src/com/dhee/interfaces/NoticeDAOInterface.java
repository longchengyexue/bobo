package com.dhee.interfaces;

import java.util.ArrayList;

import com.dhee.dto.NoticeDTO;
/**
 * NoticeDAO����Ҫʵ�ֵ����нӿ�
 * @author wuzhihui
 */
public interface NoticeDAOInterface {
/**
 * ��ѯnotice�����������ݵĳ��󷽷�
 * @return �������ݶ���notice��ArrayList����
 */
	public abstract ArrayList<NoticeDTO> selectNotice();
/**
 * �޸�notice����ĳЩ���ݵĳ��󷽷�
 * @param NoticeDTO�Ķ���notice
 * @return Ӱ�����ݿ���������жϲ����Ƿ�ɹ�
 */
	public abstract int updateNotice(NoticeDTO notice);
/**
 * ��notice���в���ĳЩ���ݵĳ��󷽷�
 * @param NoticeDTO�Ķ���notice
 * @return Ӱ�����ݿ���������жϲ����Ƿ�ɹ�
 */
	public abstract int insertNotice(NoticeDTO notice);
/**
 * ɾ��notice����ĳЩ���ݵĳ��󷽷�
 * @param NoticeDTO�Ķ���notice
 * @return Ӱ�����ݿ���������жϲ����Ƿ�ɹ�
 */
	public abstract int deleteNotice(NoticeDTO notice);
}