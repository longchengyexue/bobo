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
	private String nid;//����
	//��ҳ
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
	 * Ĭ��ִ�еķ���
	 */
	public String index() {
		return SUCCESS;
	}
	/**
	 * ǰ̨indexҳ��ķ���
	 */
	public String selectindex() {
		//ͨ��service�����DAO���õ�װ�ж���ļ���
		NoticesService es = new NoticesService();
		list = es.selectindex();
		return SUCCESS;
	}
	/**
	 * ǰ̨2Notices���¹���
	 */
	public String select2Notices() {	
		//ͨ��service�����DAO���õ�װ��12������ļ���
		NoticesService es = new NoticesService();
		if(info==null){
			info = new PageInfo();
		}
		list = es.select2Notices(info);
		return SUCCESS;
	}
	/**
	 * ǰ̨���¹�����ϸ��ѯ������ǰ̨3Noticesҳ��
	 */
	public String select3Notices() {
		// ȡ������,Ȼ����Ե���service�еķ������в�ѯһ����ϸ����
		ev = new NoticesVO();
		ev.setNid(nid);
		NoticesService ns = new NoticesService();
		ev = ns.selectnoticedetail(Integer.parseInt(ev.getNid()));
		return SUCCESS;
	}
	/**
	 * �����̨2Noticesҳ��
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
	 * ��̨���¹����ѯ�������̨3Noticesҳ��
	 */
	public String manager3Notices() {
		// ȡ������,Ȼ����Ե���service�еķ������в�ѯһ����ϸ����
		ev = new NoticesVO();
		ev.setNid(nid);
		NoticesService ns = new NoticesService();
		ev = ns.manager3Notices(Integer.parseInt(ev.getNid()));
		return SUCCESS;
	}
	/**
	 *  �������¹�������ҳ��
	 */
	public String manager4Notices() {
		return SUCCESS;
	}
	/**
	 *  �����¹������ݿ��������
	 */
	public String manageradd() {
		NoticesService ns = new NoticesService();
		ns.manageradd(ev.getNtitle(),ev.getNdate(),ev.getNcontent());
		return SUCCESS;
	}
	/**
	 *  �����̨���¹����޸�
	 */
	public String update() {
		ev = new NoticesVO();
		ev.setNid(nid);
		NoticesService ns = new NoticesService();
		ev = ns.update(Integer.parseInt(ev.getNid()));
		
		return SUCCESS;
	}
	/**
	 * ���¹����޸�
	 */
	public String managerupdate(){
		NoticesService ns = new NoticesService();
		ns.managerupdate(ev);
		return SUCCESS;
	}
	/**
	 * ��̨ɾ�����ݷ���
	 */	
	public String date() {
		// ȡ������
		ev = new NoticesVO();
		ev.setNid(nid);
		// ��������,ɾ����ǰ����
		NoticesService ns = new NoticesService();
		ns.date(ev);
		return SUCCESS;
	}
}