package com.dhee.action;

import java.util.ArrayList;

import com.dhee.pageutils.PageInfo;
import com.dhee.service.NoticesService;
import com.dhee.service.studentService;
import com.dhee.vo.NoticesVO;
import com.dhee.vo.studentVo;
import com.opensymphony.xwork2.ActionSupport;

public class studentAction extends ActionSupport{
	private ArrayList<studentVo> list;
	private studentVo sv;
	private String id;//主键
	//分页
		private PageInfo info;
		
		public ArrayList<studentVo> getList() {
			return list;
		}

		public void setList(ArrayList<studentVo> list) {
			this.list = list;
		}

		public studentVo getSv() {
			return sv;
		}

		public void setSv(studentVo sv) {
			this.sv = sv;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public PageInfo getInfo() {
			return info;
		}

		public void setInfo(PageInfo info) {
			this.info = info;
		}

		public String selectall() {	
			//通过service层调用DAO层拿到装有12个对象的集合
			studentService ss = new studentService();
			if(info==null){
				info = new PageInfo();
			}
			list = ss.selectAll(info);
			System.out.println(list+"action ");
			return SUCCESS;
		}
		public String a(){
			return SUCCESS;
		}
		
}
