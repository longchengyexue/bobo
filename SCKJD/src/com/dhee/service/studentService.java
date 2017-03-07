package com.dhee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dhee.dao.BaseDAO;
import com.dhee.dao.studentDao;
import com.dhee.dto.BaseDTO;
import com.dhee.dto.studentDto;
import com.dhee.pageutils.PageInfo;
import com.dhee.pageutils.PageUtils;
import com.dhee.vo.BaseVO;
import com.dhee.vo.studentVo;

public class studentService {
	public PageInfo info;
	public PageInfo getInfo() {
		return info;
	}
	public void setInfo(PageInfo info) {
		this.info = info;
	}
	public ArrayList<studentVo> selectAll(PageInfo info){
		ArrayList<studentVo> svolist = new ArrayList<studentVo>();
		studentDao sdao = new studentDao();
		ArrayList<studentDto> sdtolist = new ArrayList<studentDto>();
		sdtolist = sdao.select();
		//分页
		Map<String,Integer> pageInfos = PageUtils.getInstance().getPageCutInfo(info,sdtolist.size());
		//每页的起始位置
		int startPosition = (Integer) pageInfos.get("startPosition");
		//每页的结束位置
		int endPosition = (Integer) pageInfos.get("endPosition");
		for(int i = 0; i < sdtolist.size(); i++){
			if(i >= startPosition && i< endPosition){
			studentVo svo = new studentVo();
			studentDto sdto = new studentDto();
			sdto = sdtolist.get(i);
			svo.setId(sdto.getId());
			svo.setName(sdto.getName());
			svo.setSex(sdto.getSex());
			svo.setRoom(sdto.getRoom());
			svo.setParty(sdto.getParty());
			svo.setProfession(sdto.getProfession());
			svo.setDemo(sdto.getDemo());
			svolist.add(svo);
			}
		}
		return  svolist;
	}
	public static void main(String[]args){
		
		studentService ss=new studentService();
		List<studentVo> list=new ArrayList<studentVo> ();
		list=ss.selectAll(ss.info);
		System.out.println(list+"*****");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getId()+"id");
		}
		
	}
}
