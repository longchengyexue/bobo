package com.dhee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dhee.dao.BaseDAO;
import com.dhee.dto.BaseDTO;
import com.dhee.pageutils.PageInfo;
import com.dhee.pageutils.PageUtils;
import com.dhee.vo.BaseVO;

/**
 * 出口基地业务逻辑层
 * @author zhongcngxiang
 */
public class BaseService {
/**
 * 查询全部出口基地
 */
	public ArrayList<BaseVO> selectBase(PageInfo info){
		ArrayList<BaseVO> bvolist = new ArrayList<BaseVO>();
		BaseDAO bdao = new BaseDAO();
		ArrayList<BaseDTO> bdtolist = new ArrayList<BaseDTO>();
		bdtolist = bdao.selectBase();
		//分页
		Map<String,Integer> pageInfos = PageUtils.getInstance().getPageCutInfo(info,bdtolist.size());
		//每页的起始位置
		int startPosition = (Integer) pageInfos.get("startPosition");
		//每页的结束位置
		int endPosition = (Integer) pageInfos.get("endPosition");
		for(int i = 0; i < bdtolist.size(); i++){
			if(i >= startPosition && i< endPosition){
			BaseVO bvo = new BaseVO();
			BaseDTO bdto = new BaseDTO();
			bdto = bdtolist.get(i);
			bvo.setBid(bdto.getBid());
			bvo.setBname(bdto.getBname());
			bvo.setBdate(bdto.getBdate().substring(0, 11));
			bvo.setBintroduction(bdto.getBintroduction());
			bvo.setTid(bdto.getTid());
			bvo.setBimagepath(bdto.getBimagepath());
			bvolist.add(bvo);
			}
		}
		return  bvolist;
	}
/**
 * 从数据库中获取数据，装载数据到地图中的城市中
 */
	public Map<Integer,List<Object>>basemap(){
		Map<Integer,List<Object>> map = new HashMap<Integer,List<Object>>();
		BaseDAO dao = new BaseDAO();
		List<BaseDTO> listdto = dao.selectBase();
		for(BaseDTO dto:listdto){
			int tid = dto.getTid();
			if(map.containsKey(tid)){     //如果存在城市信息 则取出该城市的List集合
			List<Object> baseCity = map.get(tid);
			BaseVO vo = new BaseVO();
			String time = dto.getBdate();    //截取字符串信息 判断信息是否为空
			if(time!=null && time.length()>10){
				time = time.substring(0, 10);
			}
			vo.setBdate(time);
			vo.setBid(dto.getBid());
			vo.setBimage1(dto.getBimage1());
			vo.setBimage2(dto.getBimage2());
			vo.setBimagepath(dto.getBimagepath());
			vo.setBintroduction(dto.getBintroduction());
			String name = dto.getBname();
			if(name!=null && name.length()>10){
				name = name.substring(0,10);
			}
			vo.setBname(name);
			vo.setTid(dto.getTid());
			baseCity.add(vo);
			map.put(tid, baseCity);
			}else{                       //如果不存在该城市的信息创建该城市的List集合
			List<Object> baseCity = new ArrayList<Object>();
			BaseVO vo = new BaseVO();
			String time = dto.getBdate();      //截取字符串信息 判断信息是否为空
			vo.setBdate(time);
			vo.setBid(dto.getBid());
			vo.setBimage1(dto.getBimage1());
			vo.setBimage2(dto.getBimage2());
			vo.setBimagepath(dto.getBimagepath());
			vo.setBintroduction(dto.getBintroduction());
			vo.setBname(dto.getBname());
			vo.setTid(dto.getTid());
			baseCity.add(vo);
			map.put(tid, baseCity);
			}
		}
		return map;
	}
/**
 * 出口基地编辑按钮
 */
	public BaseVO baseedit(int bid){
		BaseDAO bdao = new BaseDAO();
		BaseDTO bdto = new BaseDTO();
		BaseVO  bvo  = new BaseVO ();
		bdto = bdao.selectSingleBase(bid);
		bvo.setBid(bdto.getBid());
		bvo.setBname(bdto.getBname());
		bvo.setBintroduction(bdto.getBintroduction());
		return bvo;
	}
/**
 * 出口基地删除按钮
 */
	public void basedel(int bid){
		BaseDAO bdao = new BaseDAO();
		bdao.deleteBase(bid);
	}
/**
 * 出口基地编辑界面提交按钮
 * @param bvo
 */
	public void update(BaseVO bvo){
		BaseDAO bdao = new BaseDAO();
		BaseDTO bdto = new BaseDTO();
		bdto.setBid(bvo.getBid());
		bdto.setBname(bvo.getBname());
		bdto.setBintroduction(bvo.getBintroduction());
		bdto.setBdate(bvo.getBdate());
		bdto.setTid(bvo.getTid());
		bdao.updateBase(bdto);
	}
/**
 * 出口基地增加页面提交按钮
 * @param bvo
 */
	public void add(BaseVO bvo){
		BaseDAO bdao = new BaseDAO();
		BaseDTO bdto = new BaseDTO();
		bdto.setBname(bvo.getBname());
		bdto.setBintroduction(bvo.getBintroduction());
		bdto.setTid(bvo.getTid());
		bdao.insertBase(bdto);
	}
/**
 * 单个点入出口基地详细信息
 * @param bid
 * @return
 */
	public BaseVO  select(int bid){
		BaseDAO bdao = new BaseDAO();
		BaseDTO bdto = new BaseDTO();
		BaseVO  bvo  = new BaseVO ();
		bdto = bdao.selectSingleBase(bid);
		bvo.setBname(bdto.getBname());
		bvo.setBintroduction(bdto.getBintroduction());
		return bvo;
	}
}