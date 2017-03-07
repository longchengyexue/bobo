package com.dhee.vo;

/**
 * 最新公告表NOTICE的数据传输对象
 * @author dongjianmin
 */
public class NoticesVO {
	// 最新公告主键编号
	private String nid;
	// 最新公告标题
	private String ntitle;
	// 最新公告内容
	private String ncontent;
	// 最新公告创建日期
	private String ndate;
	public NoticesVO() {
		super();
	}
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public String getNdate() {
		return ndate;
	}
	public void setNdate(String ndate) {
		this.ndate = ndate;
	}
}