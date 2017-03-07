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
 * ���ڻ���ҵ���߼���
 * @author zhongcngxiang
 */
public class BaseService {
/**
 * ��ѯȫ�����ڻ���
 */
	public ArrayList<BaseVO> selectBase(PageInfo info){
		ArrayList<BaseVO> bvolist = new ArrayList<BaseVO>();
		BaseDAO bdao = new BaseDAO();
		ArrayList<BaseDTO> bdtolist = new ArrayList<BaseDTO>();
		bdtolist = bdao.selectBase();
		//��ҳ
		Map<String,Integer> pageInfos = PageUtils.getInstance().getPageCutInfo(info,bdtolist.size());
		//ÿҳ����ʼλ��
		int startPosition = (Integer) pageInfos.get("startPosition");
		//ÿҳ�Ľ���λ��
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
 * �����ݿ��л�ȡ���ݣ�װ�����ݵ���ͼ�еĳ�����
 */
	public Map<Integer,List<Object>>basemap(){
		Map<Integer,List<Object>> map = new HashMap<Integer,List<Object>>();
		BaseDAO dao = new BaseDAO();
		List<BaseDTO> listdto = dao.selectBase();
		for(BaseDTO dto:listdto){
			int tid = dto.getTid();
			if(map.containsKey(tid)){     //������ڳ�����Ϣ ��ȡ���ó��е�List����
			List<Object> baseCity = map.get(tid);
			BaseVO vo = new BaseVO();
			String time = dto.getBdate();    //��ȡ�ַ�����Ϣ �ж���Ϣ�Ƿ�Ϊ��
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
			}else{                       //��������ڸó��е���Ϣ�����ó��е�List����
			List<Object> baseCity = new ArrayList<Object>();
			BaseVO vo = new BaseVO();
			String time = dto.getBdate();      //��ȡ�ַ�����Ϣ �ж���Ϣ�Ƿ�Ϊ��
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
 * ���ڻ��ر༭��ť
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
 * ���ڻ���ɾ����ť
 */
	public void basedel(int bid){
		BaseDAO bdao = new BaseDAO();
		bdao.deleteBase(bid);
	}
/**
 * ���ڻ��ر༭�����ύ��ť
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
 * ���ڻ�������ҳ���ύ��ť
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
 * ����������ڻ�����ϸ��Ϣ
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