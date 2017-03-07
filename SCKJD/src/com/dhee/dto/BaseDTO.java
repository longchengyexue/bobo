package com.dhee.dto;
/**
 * 基地表BASE的数据传输对象
 * @author wuzhihui
 */
public class BaseDTO {
	//基地表的主键基地编号
	private int bid;
	//基地名称
	private String bname;
	//基地成立日期
	private String bdate;
	//基地简介
	private String bintroduction;
	//其他表的主键
	private int tid;
	//基地图片路径
	private String bimagepath;
	//基地图片1
	private String bimage1;
	//基地图片2
	private String bimage2;
/**
 * 无参构造方法
 */
	public BaseDTO(){
		super();
	}
/**
 * 有参构造方法
 */
	public BaseDTO(int bid , String bname , String bdate , String bintroduction , int tid , 
			String bimagepath , String bimage1 , String bimage2){
		this.bid = bid;
		this.bname = bname;
		this.bdate = bdate;
		this.bintroduction = bintroduction;
		this.tid = tid;
		this.bimagepath = bimagepath;
		this.bimage1 = bimage1;
		this.bimage2 = bimage2;
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
}