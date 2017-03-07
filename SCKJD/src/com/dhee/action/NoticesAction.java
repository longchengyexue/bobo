package com.dhee.action;

import java.util.ArrayList;

import com.dhee.pageutils.PageInfo;
import com.dhee.service.NoticesService;
import com.dhee.vo.NoticesVO;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class NoticesAction extends ActionSupport {
	private ArrayList<NoticesVO> list;
	private NoticesVO ev;
	private String nid;//主键
	//分页
	private PageInfo info;
	public PageInfo getInfo() {
		return info;
	}
	public void setInfo(PageInfo info) {
		this.info = info;
	}
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public ArrayList<NoticesVO> getList() {
		return list;
	}
	public void setList(ArrayList<NoticesVO> list) {
		this.list = list;
	}
	public NoticesVO getEv() {
		return ev;
	}
	public void setEv(NoticesVO ev) {
		this.ev = ev;
	}
	/**
	 * 默认执行的方法
	 */
	public String index() {
		return SUCCESS;
	}
	/**
	 * 前台index页面的方法
	 */
	public String selectindex() {
		//通过service层调用DAO层拿到装有对象的集合
		NoticesService es = new NoticesService();
		list = es.selectindex();
		return SUCCESS;
	}
	/**
	 * 前台2Notices最新公告
	 */
	public String select2Notices() {	
		//通过service层调用DAO层拿到装有12个对象的集合
		NoticesService es = new NoticesService();
		if(info==null){
			info = new PageInfo();
		}
		list = es.select2Notices(info);
		return SUCCESS;
	}
	/**
	 * 前台最新公告详细查询，进入前台3Notices页面
	 */
	public String select3Notices() {
		// 取到主键,然后可以调用service中的方法进行查询一条详细数据
		ev = new NoticesVO();
		ev.setNid(nid);
		NoticesService ns = new NoticesService();
		ev = ns.selectnoticedetail(Integer.parseInt(ev.getNid()));
		return SUCCESS;
	}
	/**
	 * 进入后台2Notices页面
	 */
	public String managerNotices() {
		NoticesService es = new NoticesService();
		if(info==null){
			info = new PageInfo();
		}
		list = es.managerNotices(info);
		return SUCCESS;
	}
	/**
	 * 后台最新公告查询，进入后台3Notices页面
	 */
	public String manager3Notices() {
		// 取到主键,然后可以调用service中的方法进行查询一条详细数据
		ev = new NoticesVO();
		ev.setNid(nid);
		NoticesService ns = new NoticesService();
		ev = ns.manager3Notices(Integer.parseInt(ev.getNid()));
		return SUCCESS;
	}
	/**
	 *  进入最新公告增加页面
	 */
	public String manager4Notices() {
		return SUCCESS;
	}
	/**
	 *  对最新公告数据库进行增加
	 */
	public String manageradd() {
		NoticesService ns = new NoticesService();
		ns.manageradd(ev.getNtitle(),ev.getNdate(),ev.getNcontent());
		return SUCCESS;
	}
	/**
	 *  进入后台最新公告修改
	 */
	public String update() {
		ev = new NoticesVO();
		ev.setNid(nid);
		NoticesService ns = new NoticesService();
		ev = ns.update(Integer.parseInt(ev.getNid()));
		
		return SUCCESS;
	}
	/**
	 * 最新公告修改
	 */
	public String managerupdate(){
		NoticesService ns = new NoticesService();
		ns.managerupdate(ev);
		return SUCCESS;
	}
	/**
	 * 后台删除数据方法
	 */	
	public String date() {
		// 取到主键
		ev = new NoticesVO();
		ev.setNid(nid);
		// 根据主键,删除当前数据
		NoticesService ns = new NoticesService();
		ns.date(ev);
		return SUCCESS;
	}
}