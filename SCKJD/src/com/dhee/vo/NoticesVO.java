package com.dhee.vo;

/**
 * ���¹����NOTICE�����ݴ������
 * @author dongjianmin
 */
public class NoticesVO {
	// ���¹����������
	private String nid;
	// ���¹������
	private String ntitle;
	// ���¹�������
	private String ncontent;
	// ���¹��洴������
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