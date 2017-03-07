package com.dhee.db;

import java.util.Map;

import com.dhee.vo.EnterprisesVO;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class MyInterceptor implements Interceptor {
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
	}
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map<String , Object> session = (Map<String , Object>)ActionContext.getContext().getSession();
		EnterprisesVO ev = (EnterprisesVO)session.get("Usersession");
		if(ev == null){
			//未登录，回到登录界面
			return Action.LOGIN;
		}
		return invocation.invoke();
	}
}