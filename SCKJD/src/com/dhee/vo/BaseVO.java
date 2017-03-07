package com.dhee.vo;

public class BaseVO {
	//基地id
	private int bid;
	//基地名称
	private String bname;
	//基地日期
	private String bdate;
	//基地简介
	private String bintroduction;
	//城市表的主键，作为外键
	private int tid;
	//基地图片地址地址
	private String bimagepath;
	//基地图片1
	private String bimage1;
	//基地图片2
	private String bimage2;
	
	public BaseVO(String bdate, int bid, String bimage1, String bimage2,
			String bimagepath, String bintroduction, String bname, int tid) {
		super();
		this.bdate = bdate;
		this.bid = bid;
		this.bimage1 = bimage1;
		this.bimage2 = bimage2;
		this.bimagepath = bimagepath;
		this.bintroduction = bintroduction;
		this.bname = bname;
		this.tid = tid;
	}
	public BaseVO(int bid,String bname, int tid) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.tid = tid;
	}
	public BaseVO() {
		super();
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getBintroduction() {
		return bintroduction;
	}
	public void setBintroduction(String bintroduction) {
		this.bintroduction = bintroduction;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getBimagepath() {
		return bimagepath;
	}
	public void setBimagepath(String bimagepath) {
		this.bimagepath = bimagepath;
	}
	public String getBimage1() {
		return bimage1;
	}
	public void setBimage1(String bimage1) {
		this.bimage1 = bimage1;
	}
	public String getBimage2() {
		return bimage2;
	}
	public void setBimage2(String bimage2) {
		this.bimage2 = bimage2;
	}
	/**
	 * 参照其他类 复写toString
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.tid+"\t");
		sb.append(this.bid+"\t");
		sb.append(this.bname+"\t");
		sb.append(this.bintroduction+"\t");
		sb.append(this.bimagepath+"\t");
		sb.append(this.bimage1+"\t");
		sb.append(this.bimage2+"\t");
		sb.append(this.bdate+"\t");
		return sb.toString();
	}
}