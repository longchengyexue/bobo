package com.dhee.interfaces;

import java.util.ArrayList;

import com.dhee.dto.NoticeDTO;
import com.dhee.dto.studentDto;

public interface studentInterface {
	/**
	 * ��ѯnotice�����������ݵĳ��󷽷�
	 * @return �������ݶ���notice��ArrayList����
	 */
		public abstract ArrayList<studentDto> select();
	/**
	 * �޸�notice����ĳЩ���ݵĳ��󷽷�
	 * @param NoticeDTO�Ķ���notice
	 * @return Ӱ�����ݿ���������жϲ����Ƿ�ɹ�
	 */
		public abstract int update(studentDto student);
	/**
	 * ��notice���в���ĳЩ���ݵĳ��󷽷�
	 * @param NoticeDTO�Ķ���notice
	 * @return Ӱ�����ݿ���������жϲ����Ƿ�ɹ�
	 */
		public abstract int insert(studentDto student);
	/**
	 * ɾ��notice����ĳЩ���ݵĳ��󷽷�
	 * @param NoticeDTO�Ķ���notice
	 * @return Ӱ�����ݿ���������жϲ����Ƿ�ɹ�
	 */
		public abstract int delete(studentDto student);
}
