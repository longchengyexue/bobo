package com.dhee.dto;
/**
 * TOWN的数据传输对象
 * @author wuzhihui
 */
public class TownDTO {
	//TOWN表的主键基地编号
	private int tid;
	//TOWN的名称
	private String tname;
	//TOWN的状态
	private int state;

	public TownDTO(){
		super();
	}
/**
 * 有参构造方法
 */
	public TownDTO(int tid , String tname , int state){
		this.tid = tid;
		this.tname = tname;
		this.state = state;
	}

	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}