package com.dhee.action;

import java.util.Map;

import com.dhee.service.EnterprisesService;
import com.dhee.vo.EnterprisesVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 处理登录的Action
 * @author wuzhihui
 */
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport{
	//EnterprisesVO的对象
	private EnterprisesVO ev;
	public EnterprisesVO getEv() {
		return ev;
	}
	public void setEv(EnterprisesVO ev) {
		this.ev = ev;
	}
/**
 * 登录检查方法
 * @return
 */
	public String login(){
		boolean flag = false;
		EnterprisesService es = new EnterprisesService();
		flag = es.login(ev);
		if(flag == true){
			System.out.println("********* "+ev.getUsername()+" 成功登录网站!***********");
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