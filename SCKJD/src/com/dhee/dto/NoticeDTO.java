package com.dhee.dto;
/**
 * ���¹����NOTICE�����ݴ������
 * @author wuzhihui
 */
public class NoticeDTO {
	//���¹����������
	private int nid;
	//���¹������
	private String ntitle;
	//���¹�������
	private String ncontent;
	//���¹��洴������
	private String ndate;

	public NoticeDTO(){
		super();
	}
/**
 * �вι��췽��
 */
	public NoticeDTO(int nid , String ntitle , String ncontent , String ndate){
		this.nid = nid;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.ndate = ndate;
	}

	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
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