package com.dhee.action;

import java.util.Map;

import com.dhee.service.EnterprisesService;
import com.dhee.vo.EnterprisesVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * �����¼��Action
 * @author wuzhihui
 */
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport{
	//EnterprisesVO�Ķ���
	private EnterprisesVO ev;
	public EnterprisesVO getEv() {
		return ev;
	}
	public void setEv(EnterprisesVO ev) {
		this.ev = ev;
	}
/**
 * ��¼��鷽��
 * @return
 */
	public String login(){
		boolean flag = false;
		EnterprisesService es = new EnterprisesService();
		flag = es.login(ev);
		if(flag == true){
			System.out.println("********* "+ev.getUsername()+" �ɹ���¼��վ!***********");
			Map<String , Object> session = (Map<String , Object>)ActionContext.getContext().getSession();
			if(session.size() == 0){
				session.put("Usersession", ev);
			}
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}