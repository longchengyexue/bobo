package com.dhee.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.dhee.dto.BaseDTO;
import com.dhee.pageutils.PageInfo;
import com.dhee.service.EnterprisesService;
import com.dhee.service.RegistrationService;
import com.dhee.vo.EnterprisesVO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * EnterprisesAction��Enterprises���Ӧ��Action�࣬���������ҵ����ķ���
 * @author wuzhihui
 */
@SuppressWarnings("serial")
public class EnterprisesAction extends ActionSupport {
	//װ�����ݶ���ļ���
	private ArrayList<EnterprisesVO> list ;
	//EnterprisesVO�Ķ���
	private EnterprisesVO ev;
	private String eid;
	//��ҳ
	private PageInfo info;
	private Map<Integer , String> bnamemap;
	//�ϴ���������Ҫ������
	private File myfile;
	private String myfileFileName;
	private String myfileContentType;
	//���ݿ��еĴ��ͼƬ��·��
	private String databasePath = "http://192.168.1.65:8083/SCKJD/images/";
	
	public PageInfo getInfo() {
		return info;
	}
	public void setInfo(PageInfo info) {
		this.info = info;
	}
	public ArrayList<EnterprisesVO> getList() {
		return list;
	}
	public void setList(ArrayList<EnterprisesVO> list) {
		this.list = list;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public EnterprisesVO getEv() {
		return ev;
	}
	public void setEv(EnterprisesVO ev) {
		this.ev = ev;
	}
	public Map<Integer, String> getBnamemap() {
		return bnamemap;
	}
	public void setBnamemap(Map<Integer, String> bnamemap) {
		this.bnamemap = bnamemap;
	}
	
	public File getMyfile() {
		return myfile;
	}
	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}
	public String getMyfileFileName() {
		return myfileFileName;
	}
	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}
	public String getMyfileContentType() {
		return myfileContentType;
	}
	public void setMyfileContentType(String myfileContentType) {
		this.myfileContentType = myfileContentType;
	}
	
	public String execute(){
		RegistrationService rs = new RegistrationService();
		ArrayList<BaseDTO> list = rs.regist();
		bnamemap = new HashMap<Integer , String>();
		for(int i = 0; i < list.size(); i++){
			BaseDTO bdto = new BaseDTO();
			bdto = list.get(i);
			if(bdto.getBname().length() > 12){
				bnamemap.put(bdto.getBid(), bdto.getBname().substring(0, 12));
			}else{
				bnamemap.put(bdto.getBid(), bdto.getBname());
			}
		}
		return SUCCESS;
	}
/**
 * ǰ̨2Company_REҳ��ķ���,ͨ��service�����DAO���õ�װ��12������ļ���
 * @return
 */
	public String selectCompanyRE(){
		EnterprisesService es = new EnterprisesService();
		if(info==null){
			info = new PageInfo();
		}
		list = es.selectCompanyRE(info);
		return SUCCESS;
	}
/**
 * ǰ̨����������ѯ��ϸ��Ϣ����
 * @return ����
 */
	public String selectcompanydetail(){
		EnterprisesService es = new EnterprisesService();
		ev = new EnterprisesVO();
		ev = es.selectcompanydetail(eid);
		return SUCCESS;
	}
/**
 * ��̨2Company_REҳ��ķ���
 * @return
 */
	public String managerCompanyRE(){
		EnterprisesService es = new EnterprisesService();
		if(info==null){
			info = new PageInfo();
		}
		list = es.managerCompanyRE(info);
		return SUCCESS;
	}
/**
 * ��̨����������ѯ��ϸ��Ϣ����
 * @return ����
 */
	public String managercompanydetail(){
		//ȡ������,Ȼ����Ե���DAO�еķ������в�ѯһ����ϸ����
		EnterprisesService es = new EnterprisesService();
		ev = new EnterprisesVO();
		ev = es.selectcompanydetail(eid);
		return SUCCESS;
	}
/**
 * ��̨����������ʾ�޸���Ϣ����
 * @return ����
 */
	public String updateEnterprises(){
		EnterprisesService es = new EnterprisesService();
		ev = new EnterprisesVO();
		ev = es.selectcompanydetail(eid);

		RegistrationService rs = new RegistrationService();
		ArrayList<BaseDTO> list = rs.regist();
		bnamemap = new HashMap<Integer , String>();
		for(int i = 0; i < list.size(); i++){
			BaseDTO bdto = new BaseDTO();
			bdto = list.get(i);
			if(bdto.getBname().length() > 12){
				bnamemap.put(bdto.getBid(), bdto.getBname().substring(0, 12));
			}else{
				bnamemap.put(bdto.getBid(), bdto.getBname()); 
			}
		}
		return SUCCESS;
	}
/**
 * ��̨���������޸���Ϣ����
 * @return ����
 */
	public String resetEnterprises(){
		//�õ���������ֵ��Ȼ����Ե���DAO�еķ��������޸�����
		EnterprisesService es = new EnterprisesService();
		es.resetEnterprises(ev);
		return SUCCESS;
	}
/**
 * ��̨������ݵķ���
 * @return
 */
	public String addEnterprises(){
		EnterprisesService es = new EnterprisesService();
		//�ϴ�ͼƬ����Ը�·��
		String path = ServletActionContext.getServletContext().getRealPath("/")+"images\\";
		//����UUID����������ļ�����,����ļ�����ͻ����
		String fileName = UUID.randomUUID().toString();
		
		if(myfile == null){
			//���û���ϴ�ͼƬ
			ev.setElogopath(databasePath + "blank.jpg");
		}else{
			//�� ���������ļ����ƽ��в�֣�Ȼ��ȡ���ļ���׺��
			String [] fileNames = myfileFileName.split("\\.");
			//������·��+ͼƬ����+ͼƬ��ʽ
			File destFile = new File(path+fileName+"."+fileNames[fileNames.length-1]);
			if(!myfile.exists()){
				File newFile = new File(path , fileName+"."+fileNames[fileNames.length-1]);
				try {
					newFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				try {
					FileUtils.copyFile(myfile, destFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			ev.setElogopath(databasePath + fileName+"."+fileNames[fileNames.length-1]);
		}
		es.addEnterprises(ev);
		return SUCCESS;
	}
/**
 * ��̨ɾ�����ݷ���
 * @return
 */
	public String deleteEnterprises(){
		//��������,ɾ����ǰ����
		EnterprisesService es = new EnterprisesService();
		es.deleteEnterprises(Integer.parseInt(eid));
		return SUCCESS;
	}
}