package com.dhee.dto;
/**
 * TOWN�����ݴ������
 * @author wuzhihui
 */
public class TownDTO {
	//TOWN����������ر��
	private int tid;
	//TOWN������
	private String tname;
	//TOWN��״̬
	private int state;

	public TownDTO(){
		super();
	}
/**
 * �вι��췽��
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