package com.dhee.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dhee.pageutils.PageInfo;
import com.dhee.service.BaseService;
import com.dhee.vo.BaseVO;
import com.dhee.vo.EnterprisesVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 出口基地前后台Action
 * @author Administrator
 */
@SuppressWarnings("serial")
public class ExportBaseAction extends ActionSupport {
	private BaseVO vo; 
	private ArrayList<BaseVO> list ;
	private int bid;
	private EnterprisesVO ev;
	private PageInfo info;
	
	public PageInfo getInfo() {
		return info;
	}
	public void setInfo(PageInfo info) {
		this.info = info;
	}
	public ArrayList<BaseVO> getList() {
		return list;
	}
	public void setList(ArrayList<BaseVO> list) {
		this.list = list;
	}
	public int  getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public EnterprisesVO getEv() {
		return ev;
	}
	public void setEv(EnterprisesVO ev) {
		this.ev = ev;
	}
	public BaseVO getVo() {
		return vo;
	}
	public void setVo(BaseVO vo) {
		this.vo = vo;
	}
	public String findEntrepriseByBaseId(){
		return SUCCESS;
	}
/**
 * 出口基地地图
 */
	@SuppressWarnings("unchecked")
	public String basemap(){
		Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		
		BaseService service = new BaseService();
		//向request对象中传递值
		Map<Integer,List<Object>> map = service.basemap();
		Set<Integer> key = map.keySet();
		for(int i:key){
			request.put("listbase"+i,map.get(i));
		}
		return SUCCESS;
	}
/**
 * 出口基地后台检索页面
 */
	public String selectexportbase(){
		list = new ArrayList<BaseVO>();
		BaseService bs = new BaseService();
		if(info==null){
			info = new PageInfo();
		}
		list = bs.selectBase(info);

		return SUCCESS;
	}
/**
 * 出口基地编辑界面提交按钮
 */
	public String baseupdatesubmit(){
		BaseService bs = new BaseService();
		System.out.println(vo.getTid());
		bs.update(vo);
		return SUCCESS;
	}
/**
 * 出口基地检索页面编辑按钮
 */
	public String exportupdatebutton(){
		vo = new BaseVO();
		BaseService bs = new BaseService();
		vo = bs.baseedit(bid);
		return SUCCESS;
	}
/**
 * 出口基地检索页面删除按钮
 */
	public String base_deletet(){
		BaseService bs = new BaseService();
		bs.basedel(bid);
		return SUCCESS;
	}
/**
 * 出口基地检索页面增加按钮
 */
	public String base_add(){
		return SUCCESS;
	}
/**
 * 出口基地增加页面提交按钮
 */
	public String baseaddsubmit(){
		BaseService bs = new BaseService();
		bs.add(vo);
		return SUCCESS;
	}
/**
 * 出口基地单个查询
 */
	public String singleread(){
		vo = new BaseVO();
		BaseService bs = new BaseService();
		vo.setBintroduction(bs.select(bid).getBintroduction());
		vo.setBname(bs.select(bid).getBname());
		return SUCCESS;
	}
}