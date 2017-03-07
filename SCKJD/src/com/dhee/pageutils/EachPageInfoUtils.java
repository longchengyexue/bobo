package com.dhee.pageutils;

import java.util.Properties;

public class EachPageInfoUtils {

	public static int getEachPage(String keys){
		int eachPage = 0;
		Properties ps = new Properties();
		try {
			ps.load(EachPageInfoUtils.class.getClassLoader().getResourceAsStream("pageInfo.properties"));
			eachPage = Integer.parseInt(ps.getProperty(keys));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eachPage;
	}
}