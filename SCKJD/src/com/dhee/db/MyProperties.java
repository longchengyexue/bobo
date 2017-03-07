package com.dhee.db;

import java.io.IOException;
import java.util.Properties;
/**
 * 配置文件Properties类
 * @author wuzhihui
 */
public class MyProperties {
	private MyProperties(){}
	/**
	 * 根据传入的key值，返回对应的value值
	 * @param key
	 * @return key对应的值value
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