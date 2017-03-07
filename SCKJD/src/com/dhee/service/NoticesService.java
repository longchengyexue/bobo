package com.dhee.service;

import java.util.ArrayList;
import java.util.Map;

import com.dhee.dao.NoticeDAO;
import com.dhee.dto.NoticeDTO;
import com.dhee.pageutils.PageInfo;
import com.dhee.pageutils.PageUtils;
import com.dhee.vo.NoticesVO;
/**
 * 最新公告的业务逻辑层
 * @author dongjianmin
 */
public class NoticesService {
	// 装载对象的集合
	private ArrayList<NoticeDTO> listdto;
	private ArrayList<NoticesVO> listvo;
	private NoticeDAO ndao;
	private NoticeDTO ndto;
	private NoticesVO nvo;
	/**
	 *  首页最新公告
	 */
	public ArrayList<NoticesVO> selectindex() { 
		// 调用DAO的查询6条数据方法
		ndao = new NoticeDAO();
		listdto = ndao.selectNotices();
		listvo = new ArrayList<NoticesVO>();
		if (listdto.size() <= 6) {
			for (int i = 0; i < listdto.size(); i++) {
				ndto = listdto.get(i);
				nvo = new NoticesVO();
				nvo.setNid(ndto.getNid() + "");
				nvo.setNtitle(ndto.getNtitle());
				nvo.setNdate(ndto.getNdate());
				nvo.setNcontent(ndto.getNcontent());
				listvo.add(nvo);
			}
		} else {
			for (int i = 0; i < 6; i++) {
				ndto = listdto.get(i);
				nvo = new NoticesVO();
				nvo.setNid(ndto.getNid() + "");
				nvo.setNtitle(ndto.getNtitle());
				nvo.setNdate(ndto.getNdate());
				nvo.setNcontent(ndto.getNcontent());
				listvo.add(nvo);
			}
		}
		return listvo;
	}
	/**
	 * 前台最新公告
	 * @return
	 */
	public ArrayList<NoticesVO> select2Notices(PageInfo info) { 
		// 调用DAO的查询数据方法
		ndao = new NoticeDAO();
		listdto = ndao.selectNotices();
		listvo = new ArrayList<NoticesVO>();
		//分页
		Map<String,Integer> pageInfos = PageUtils.getInstance().getPageCutInfo(info, listdto.size());
		int startPosition = (Integer) pageInfos.get("startPosition");
		int endPosition = (Integer) pageInfos.get("endPosition");
		for(int i = 0; i < listdto.size(); i++){
			if(i >= startPosition && i< endPosition){
				ndto = listdto.get(i);
				nvo = new NoticesVO();
				nvo.setNid(ndto.getNid() + "");
				nvo.setNtitle(ndto.getNtitle());
				nvo.setNdate(ndto.getNdate());
				listvo.add(nvo);
			}
		}
		return listvo;
	}
	/**
	 *前台详细最新公告
	 * @return
	 */
	public NoticesVO selectnoticedetail(int nid) {

		ndao = new NoticeDAO();
		ndto = ndao.selectnoticedetail(nid);
		nvo = new NoticesVO();
		nvo.setNtitle(ndto.getNtitle());
		nvo.setNcontent(ndto.getNcontent());
		return nvo;
	}
	/**
	 * 进入后台2Notices页面
	 * @return
	 */
	public ArrayList<NoticesVO> managerNotices(PageInfo info){
		// 调用DAO的查询12条数据方法
		ndao = new NoticeDAO();
		listdto = ndao.selectNotices();
		listvo = new ArrayList<NoticesVO>();
		//分页
		Map<String,Integer> pageInfos = PageUtils.getInstance().getPageCutInfo(info, listdto.size());
		int startPosition = (Integer) pageInfos.get("startPosition");
		int endPosition = (Integer) pageInfos.get("endPosition");
		for(int i = 0; i < listdto.size(); i++){
			if(i >= startPosition && i< endPosition){
				ndto = listdto.get(i);
				nvo = new NoticesVO();
				nvo.setNid(ndto.getNid() + "");
				nvo.setNtitle(ndto.getNtitle());
				nvo.setNdate(ndto.getNdate());
				nvo.setNcontent(ndto.getNcontent());
				listvo.add(nvo);
			}
		}
		return listvo;
	}
	/**
	 * 后台最新公告查询，进入后台3Notices页面
	 * @return
	 */
	public NoticesVO manager3Notices(int nid) {
		ndao = new NoticeDAO();
		ndto = ndao.selectnoticedetail(nid);
		nvo = new NoticesVO();
		nvo.setNtitle(ndto.getNtitle());
		nvo.setNcontent(ndto.getNcontent());
		return nvo;
	}
	/**
	 *  后台最新公告增加
	 * @return
	 */
	public void manageradd(String ntitle,String ndate,String ncontent) {
		nvo = new NoticesVO();
		nvo.setNtitle(ntitle);
		nvo.setNdate(ndate);
		nvo.setNcontent(ncontent);
		ndto = new NoticeDTO();	
		ndto.setNtitle(nvo.getNtitle());
		ndto.setNdate(nvo.getNdate());
		ndto.setNcontent(nvo.getNcontent());
		ndao = new NoticeDAO();
		ndao.insertNotice(ndto);
	}
	/**
	 *  进入后台最新公告修改
	 * @return
	 */
	 public NoticesVO update(int nid) {
			ndao = new NoticeDAO();
			ndto = ndao.selectn(nid);
			nvo = new NoticesVO();
			nvo.setNtitle(ndto.getNtitle());
			nvo.setNcontent(ndto.getNcontent());
			nvo.setNdate(ndto.getNdate().substring(0,10));
			nvo.setNid(ndto.getNid()+"");
			return nvo;
		}
	 /**
	  *  后台最新公告修改
	  * 
	  */
	 public void managerupdate(NoticesVO nv){
		 ndto=new NoticeDTO();
		 ndto.setNid(Integer.parseInt(nv.getNid()));
		 ndto.setNtitle(nv.getNtitle());
		 ndto.setNcontent(nv.getNcontent());
		 ndto.setNdate(nv.getNdate());
		 ndao = new NoticeDAO();
		 ndao.updateNotice(ndto);
		}
	/**
	 *  后台最新公告修改
	*/
	 public void date(NoticesVO nv){
		 ndto = new NoticeDTO();
		 ndto.setNid(Integer.parseInt(nv.getNid()));
		 ndao = new NoticeDAO();
		 ndao.deleteNotice(ndto);
	 }
}