package com.dhee.pageutils;

import java.util.ArrayList;
import java.util.List;

public class PageInfo {
	//当前页码
	private int currentPage;
	//类型
	private String pageType;
	//最大页码
	private int maxPage;
	//每一页显示的条数
	private int eachPage;
	//装载下拉列表中的页数集合
	private List<Integer> listpage;
	//Getters和Setters方法
	public List<Integer> getListpage() {
		return listpage;
	}
	public void setListpage(List<Integer> listpage) {
		this.listpage = listpage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getPageType() {
		return pageType;
	}
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		listpage = new ArrayList<Integer>();
		for (int i = 0; i < maxPage; i++) {
			listpage.add(1+i);
		}
		this.maxPage = maxPage;
	}
	public int getEachPage() {
		return eachPage;
	}
	public void setEachPage(int eachPage) {
		this.eachPage = eachPage;
	}
}