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
 * 处理注册的Action
 * @author wuzhihui
 */
@SuppressWarnings("serial")
public class RegistrationAction extends ActionSupport{
	private EnterprisesVO ev;
	//装有基地主键和基地名称的map集合
	private Map<Integer , String> bnamemap;
	//上传下载中需要的属性
	private File myfile;
	private String myfileFileName;
	private String myfileContentType;
	//数据库中的存的图片根路径
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
 * 注册页面装载数据的方法
 * @return
 */
	public String regist(){
		RegistrationService rs = new RegistrationService();
		ArrayList<BaseDTO> list = rs.regist();   //有返回值
		bnamemap = new HashMap<Integer , String>();
		for(int i = 0; i < list.size(); i++){
			BaseDTO bdto = new BaseDTO();
			bdto = list.get(i);
			if(bdto.getBname().length() > 12){
				bnamemap.put(bdto.getBid(), bdto.getBname().substring(0, 12));   //装载主键 , 装载名称
			}else{
				bnamemap.put(bdto.getBid(), bdto.getBname());   //装载主键 , 装载名称
			}
		}
		return SUCCESS;
	}
/**
 * 注册方法,插入数据
 * @return
 */
	public String registration(){
		RegistrationService rs = new RegistrationService();
		//上传图片的相对根路径
		String path = ServletActionContext.getServletContext().getRealPath("/")+"images\\";
		//利用UUID产生随机的文件名称,解决文件名冲突问题
		String fileName = UUID.randomUUID().toString();
		
		if(myfile == null){
			//如果没有上传图片
			ev.setElogopath(databasePath + "blank.jpg");
		}else{
			//对 传过来的文件名称进行拆分，然后取出文件后缀名
			String [] fileNames = myfileFileName.split("\\.");
			//完整的路径+图片名称+图片格式
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
		rs.registration(ev);   //有返回值
		//成功SUCCESS，调用插入方法
		return SUCCESS;
	}
}