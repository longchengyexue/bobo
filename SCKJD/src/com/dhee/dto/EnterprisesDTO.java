package com.dhee.dto;
/**
 * ������ҵ��ENTERPRISES�����ݴ������
 * @author wuzhihui
 */
public class EnterprisesDTO {
	//������ҵ�������
	private int eid;
	//������ҵ�û����û���
	private String username;
	//������ҵ�û�������
	private String password;
	//������ҵ����ҵ����
	private String ename;
	//������ҵ���û��绰
	private String mobile;
	//������ҵ���û�����
	private String email;
	//������ҵ��logo·��
	private String elogopath;
	//������ҵ����ҵlogo����
	private String elogoname;
	//������ҵ�����ڻ��صĻ��ر�ţ���Ϊ�������base�������
	private int bid;
	//������ҵ��״̬
	private int state;
	
	private int cid;
	private String web;
	
	public EnterprisesDTO(){
		super();
	}
/**
 * �вι��췽��
 */
	public EnterprisesDTO(int eid , String username , String password , String ename , String mobile ,
			String email , String elogopath , String elogoname , int bid , int state , int cid , String web){
		this.eid = eid;
		this.username = username;
		this.password = password;
		this.ename = ename;
		this.mobile = mobile;
		this.email = email;
		this.elogopath = elogopath;
		this.elogoname = elogoname;
		this.bid = bid;
		this.state = state;
		this.cid = cid;
		this.web = web;
	}
/**
 * ���е�Setters��Getters����
 */
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getElogopath() {
		return elogopath;
	}
	public void setElogopath(String elogopath) {
		this.elogopath = elogopath;
	}
	public String getElogoname() {
		return elogoname;
	}
	public void setElogoname(String elogoname) {
		this.elogoname = elogoname;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
}