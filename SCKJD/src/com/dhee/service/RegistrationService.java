package com.dhee.service;

import java.util.ArrayList;

import com.dhee.dao.EnterprisesDAO;
import com.dhee.dto.BaseDTO;
import com.dhee.dto.EnterprisesDTO;
import com.dhee.vo.EnterprisesVO;
/**
 * RegistrationService注册的业务逻辑层
 * @author wuzhihui
 */
public class RegistrationService {
	//装载对象的集合
	EnterprisesVO ev;
	EnterprisesDAO ed;
	EnterprisesDTO edto;
/**
 * 注册显示基地名称调用的方法
 * @return
 */
	public ArrayList<BaseDTO> regist(){
		ArrayList<BaseDTO> list = new ArrayList<BaseDTO>();
		ed = new EnterprisesDAO();
		list = ed.selectBase();
		return list;
	}
/**
 * 注册插入调用的方法
 * @return
 */	
	public boolean registration(EnterprisesVO ev){
		EnterprisesDTO edto = new EnterprisesDTO();
		ed = new EnterprisesDAO();
		edto = new EnterprisesDTO();
		edto.setUsername(ev.getUsername());
		edto.setPassword(ev.getPassword());
		edto.setEname(ev.getEname());
		edto.setMobile(ev.getMobile());
		edto.setEmail(ev.getEmail());
		edto.setBid(Integer.parseInt(ev.getBid()));
		edto.setElogopath(ev.getElogopath());
		int result = ed.addEnterprises(edto);
		if(result == 1){
			return true;
		}else{
			return false;
		}
	}
}