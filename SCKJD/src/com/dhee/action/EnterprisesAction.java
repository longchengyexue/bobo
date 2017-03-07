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
 * EnterprisesAction，Enterprises表对应的Action类，处理基地企业所需的方法
 * @author wuzhihui
 */
@SuppressWarnings("serial")
public class EnterprisesAction extends ActionSupport {
	//装载数据对象的集合
	private ArrayList<EnterprisesVO> list ;
	//EnterprisesVO的对象
	private EnterprisesVO ev;
	private String eid;
	//分页
	private PageInfo info;
	private Map<Integer , String> bnamemap;
	//上传下载中需要的属性
	private File myfile;
	private String myfileFileName;
	private String myfileContentType;
	//数据库中的存的图片根路径
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
 * 前台2Company_RE页面的方法,通过service层调用DAO层拿到装有12个对象的集合
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
 * 前台根据主键查询详细信息方法
 * @return 对象
 */
	public String selectcompanydetail(){
		EnterprisesService es = new EnterprisesService();
		ev = new EnterprisesVO();
		ev = es.selectcompanydetail(eid);
		return SUCCESS;
	}
/**
 * 后台2Company_RE页面的方法
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
 * 后台根据主键查询详细信息方法
 * @return 对象
 */
	public String managercompanydetail(){
		//取到主键,然后可以调用DAO中的方法进行查询一条详细数据
		EnterprisesService es = new EnterprisesService();
		ev = new EnterprisesVO();
		ev = es.selectcompanydetail(eid);
		return SUCCESS;
	}
/**
 * 后台根据主键显示修改信息方法
 * @return 对象
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
 * 后台根据主键修改信息方法
 * @return 对象
 */
	public String resetEnterprises(){
		//拿到各个属性值，然后可以调用DAO中的方法进行修改数据
		EnterprisesService es = new EnterprisesService();
		es.resetEnterprises(ev);
		return SUCCESS;
	}
/**
 * 后台添加数据的方法
 * @return
 */
	public String addEnterprises(){
		EnterprisesService es = new EnterprisesService();
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
		es.addEnterprises(ev);
		return SUCCESS;
	}
/**
 * 后台删除数据方法
 * @return
 */
	public String deleteEnterprises(){
		//根据主键,删除当前数据
		EnterprisesService es = new EnterprisesService();
		es.deleteEnterprises(Integer.parseInt(eid));
		return SUCCESS;
	}
}