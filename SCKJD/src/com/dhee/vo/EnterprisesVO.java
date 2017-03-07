package com.dhee.vo;
/**
 * 基地企业表ENTERPRISES的数据传输对象
 * @author wuzhihui
 */
public class EnterprisesVO {
	// 基地企业主键编号
	private String eid;
	// 基地企业用户的用户名
	private String username;
	// 基地企业用户的密码
	private String password;
	// 基地企业的企业名称
	private String ename;
	// 基地企业的用户电话
	private String mobile;
	// 基地企业的用户邮箱
	private String email;
	// 基地企业的logo路径
	private String elogopath;
	// 基地企业的企业logo名称
	private String elogoname;
	// 基地企业的所在基地的基地编号，作为外键，是base表的主键
	private String bid;
	// 基地企业的状态
	private int state;
	// 其他表的主键，没用到
	private int cid;
	private String web;
	/**
	 * 无参构造方法
	 */
	public EnterprisesVO() {
		super();
	}
	/**
	 * 有参构造方法
	 */
	public EnterprisesVO(String eid, String username, String password,
			String ename, String mobile, String email, String elogopath,
			String elogoname, String bid, int state, int cid, String web) {
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

	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
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
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
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