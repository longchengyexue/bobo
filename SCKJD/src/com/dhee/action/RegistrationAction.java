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
import com.dhee.service.RegistrationService;
import com.dhee.vo.EnterprisesVO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ����ע���Action
 * @author wuzhihui
 */
@SuppressWarnings("serial")
public class RegistrationAction extends ActionSupport{
	private EnterprisesVO ev;
	//װ�л��������ͻ������Ƶ�map����
	private Map<Integer , String> bnamemap;
	//�ϴ���������Ҫ������
	private File myfile;
	private String myfileFileName;
	private String myfileContentType;
	//���ݿ��еĴ��ͼƬ��·��
	String databasePath = "http://192.168.1.65:8083/SCKJD/images/";
	
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
/**
 * ע��ҳ��װ�����ݵķ���
 * @return
 */
	public String regist(){
		RegistrationService rs = new RegistrationService();
		ArrayList<BaseDTO> list = rs.regist();   //�з���ֵ
		bnamemap = new HashMap<Integer , String>();
		for(int i = 0; i < list.size(); i++){
			BaseDTO bdto = new BaseDTO();
			bdto = list.get(i);
			if(bdto.getBname().length() > 12){
				bnamemap.put(bdto.getBid(), bdto.getBname().substring(0, 12));   //װ������ , װ������
			}else{
				bnamemap.put(bdto.getBid(), bdto.getBname());   //װ������ , װ������
			}
		}
		return SUCCESS;
	}
/**
 * ע�᷽��,��������
 * @return
 */
	public String registration(){
		RegistrationService rs = new RegistrationService();
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
		rs.registration(ev);   //�з���ֵ
		//�ɹ�SUCCESS�����ò��뷽��
		return SUCCESS;
	}
}