package com.dhee.db;

import java.io.IOException;
import java.util.Properties;
/**
 * �����ļ�Properties��
 * @author wuzhihui
 */
public class MyProperties {
	private MyProperties(){}
	/**
	 * ���ݴ����keyֵ�����ض�Ӧ��valueֵ
	 * @param key
	 * @return key��Ӧ��ֵvalue
	 */
	public static String getPropertices(String key){
		Properties ps = new Properties();
		try {
			ps.load(MyProperties.class.getClassLoader().getResourceAsStream("sql.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = ps.getProperty(key);
		return value;
	}
}