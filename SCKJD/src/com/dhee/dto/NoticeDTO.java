package com.dhee.dto;
/**
 * 最新公告表NOTICE的数据传输对象
 * @author wuzhihui
 */
public class NoticeDTO {
	//最新公告主键编号
	private int nid;
	//最新公告标题
	private String ntitle;
	//最新公告内容
	private String ncontent;
	//最新公告创建日期
	private String ndate;

	public NoticeDTO(){
		super();
	}
/**
 * 有参构造方法
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