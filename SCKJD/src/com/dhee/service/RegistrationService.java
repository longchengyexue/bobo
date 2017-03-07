package com.dhee.service;

import java.util.ArrayList;

import com.dhee.dao.EnterprisesDAO;
import com.dhee.dto.BaseDTO;
import com.dhee.dto.EnterprisesDTO;
import com.dhee.vo.EnterprisesVO;
/**
 * RegistrationServiceע���ҵ���߼���
 * @author wuzhihui
 */
public class RegistrationService {
	//װ�ض���ļ���
	EnterprisesVO ev;
	EnterprisesDAO ed;
	EnterprisesDTO edto;
/**
 * ע����ʾ�������Ƶ��õķ���
 * @return
 */
	public ArrayList<BaseDTO> regist(){
		ArrayList<BaseDTO> list = new ArrayList<BaseDTO>();
		ed = new EnterprisesDAO();
		list = ed.selectBase();
		return list;
	}
/**
 * ע�������õķ���
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