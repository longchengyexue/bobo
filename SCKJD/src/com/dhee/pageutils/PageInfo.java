package com.dhee.pageutils;

import java.util.ArrayList;
import java.util.List;

public class PageInfo {
	//��ǰҳ��
	private int currentPage;
	//����
	private String pageType;
	//���ҳ��
	private int maxPage;
	//ÿһҳ��ʾ������
	private int eachPage;
	//װ�������б��е�ҳ������
	private List<Integer> listpage;
	//Getters��Setters����
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