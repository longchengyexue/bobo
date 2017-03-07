package com.dhee.service;

import java.util.ArrayList;
import java.util.Map;

import com.dhee.dao.EnterprisesDAO;
import com.dhee.dto.EnterprisesDTO;
import com.dhee.pageutils.PageInfo;
import com.dhee.pageutils.PageUtils;
import com.dhee.vo.EnterprisesVO;
/**
 * EnterprisesService基地企业业务逻辑层
 * @author wuzhihui
 */
public class EnterprisesService {
	//装载对象的集合
	private ArrayList<EnterprisesVO> list ;
	EnterprisesVO ev;
	EnterprisesDAO ed;
	EnterprisesDTO edto;
/**
 * 前台2Company_RE页面的方法
 * @return
 */
	public ArrayList<EnterprisesVO> selectCompanyRE(PageInfo info){
		//调用DAO的查询12条数据方法
		ed = new EnterprisesDAO();
		ArrayList<EnterprisesDTO> dtolist = ed.selectEnterprises();
		list = new ArrayList<EnterprisesVO>();
		//分页
		Map<String,Integer> pageInfos = PageUtils.getInstance().getPageCutInfo(info, dtolist.size());
		int startPosition = (Integer) pageInfos.get("startPosition");
		int endPosition = (Integer) pageInfos.get("endPosition");
		for(int i = 0; i < dtolist.size(); i++){
			//符合条件装载数据
			if(i >= startPosition && i< endPosition){
				edto = dtolist.get(i);
				
				ev = new EnterprisesVO();
				ev.setEid(edto.getEid()+"");
				ev.setEname(edto.getEname());
				ev.setElogoname(edto.getElogoname());
				ev.setElogopath(edto.getElogopath());
				list.add(ev);
			}
		}
		return list;
	}
/**
 * 前台根据主键查询详细信息方法
 * @return 对象
 */
	public EnterprisesVO selectcompanydetail(String eid){
		ed = new EnterprisesDAO();
		edto = ed.selectcompanydetail(Integer.parseInt(eid));
		ev = new EnterprisesVO();
		ev.setEid(edto.getEid()+"");
		ev.setEname(edto.getEname());
		ev.setWeb(edto.getWeb());
		ev.setMobile(edto.getMobile());
		ev.setElogopath(edto.getElogopath());
		ev.setUsername(edto.getUsername());
		ev.setPassword(edto.getPassword());
		ev.setEmail(edto.getEmail());
		return ev;
	}
/**
 * 后台2Company_RE页面的方法
 */	
	public ArrayList<EnterprisesVO> managerCompanyRE(PageInfo info){
		//调用DAO的查询12条数据方法
		list = new ArrayList<EnterprisesVO>();
		ed = new EnterprisesDAO();
		ArrayList<EnterprisesDTO> dtolist = ed.selectEname();
		//分页
		Map<String,Integer> pageInfos = PageUtils.getInstance().getPageCutInfo(info, dtolist.size());
		int startPosition = (Integer) pageInfos.get("startPosition");
		int endPosition = (Integer) pageInfos.get("endPosition");
		for(int i = 0; i < dtolist.size(); i++){
			if(i >= startPosition && i< endPosition){
				edto = dtolist.get(i);
				ev = new EnterprisesVO();
				ev.setEid(edto.getEid()+"");
				ev.setEname(edto.getEname());
				list.add(ev);
			}
		}
		return list;
	}
/**
 * 后台根据主键修改信息方法
 * @return 对象
 */
	public int resetEnterprises(EnterprisesVO ev){
		int flag = 0;
		ed = new EnterprisesDAO();
		edto = new EnterprisesDTO();
		edto.setEid(Integer.parseInt(ev.getEid()));
		edto.setEname(ev.getEname());
		edto.setBid(Integer.parseInt(ev.getBid()));
		edto.setMobile(ev.getMobile());
		edto.setUsername(ev.getUsername());
		edto.setPassword(ev.getPassword());
		edto.setEmail(ev.getEmail());
		flag = ed.updateEnterprises(edto); 
		return flag;
	}
/**
 * 后台删除数据方法
 * @return
 */	
	public int deleteEnterprises(int eid){
		int flag = 0;
		ed = new EnterprisesDAO();
		edto = new EnterprisesDTO();
		edto.setEid(eid);
		flag = ed.deleteEnterprises(edto);
		return flag;
	}
/**
 * 后台添加数据的方法
 * @return
 */	
	public int addEnterprises(EnterprisesVO ev){
		int flag = 0;
		ed = new EnterprisesDAO();
		edto = new EnterprisesDTO();
		edto.setEname(ev.getEname());
		edto.setBid(Integer.parseInt(ev.getBid()));
		edto.setUsername(ev.getUsername());
		edto.setPassword(ev.getPassword());
		edto.setMobile(ev.getMobile());
		edto.setEmail(ev.getEmail());
		edto.setElogopath(ev.getElogopath());
		flag = ed.insertEnterprises(edto);
		return flag;
	}
/**
 * 登录检查方法
 * @return
 */
	public boolean login(EnterprisesVO ev){
		boolean flag = false;
		ed = new EnterprisesDAO();
		flag = ed.Login(ev.getUsername(), ev.getPassword());
		return flag;
	}
}