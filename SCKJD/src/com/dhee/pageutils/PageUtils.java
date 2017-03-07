package com.dhee.pageutils;

import java.util.HashMap;
import java.util.Map;

public class PageUtils {
	public static PageUtils utils;
	static {
		utils = new PageUtils();
	}
	public PageUtils() {
	}
	public static PageUtils getInstance() {
		if (utils == null) {
			utils = new PageUtils();
		}
		return utils;
	}
/**
 *  
 * @param 页面实体对象
 * @param 查询到消息的长度
 * @return 装载有开始位置和结束位置的Map集合
 */
	public Map<String, Integer> getPageCutInfo(PageInfo info, int infolength) {
		Map<String, Integer> pageinfo = new HashMap<String, Integer>();
		int eachPage = info.getEachPage();
		if (eachPage == 0) {
			eachPage = EachPageInfoUtils.getEachPage("eachPage");
			info.setEachPage(eachPage);
		}
		int maxPage = info.getMaxPage();
		if (maxPage == 0) {
			if (infolength % eachPage == 0) {
				maxPage = infolength / eachPage;
			} else {
				maxPage = infolength / eachPage + 1;
			}
			info.setMaxPage(maxPage);
		}
		int currentPage = info.getCurrentPage();
		if (currentPage == 0) {
			currentPage++;
		}
		String pageTyoe = info.getPageType();
		if ("next".equalsIgnoreCase(pageTyoe)) {
			if(currentPage==maxPage){
				currentPage--;
			}
			currentPage++;
		} else if ("back".equalsIgnoreCase(pageTyoe)) {
			if (currentPage==1) { 
				currentPage++;
			}
			currentPage--;
		}
		info.setCurrentPage(currentPage);
		int startPosition = (currentPage-1)*eachPage;
		int endPosition = currentPage*eachPage;
		pageinfo.put("startPosition", startPosition);
		pageinfo.put("endPosition", endPosition);
		return pageinfo;
	}
}