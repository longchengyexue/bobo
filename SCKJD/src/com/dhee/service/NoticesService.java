package com.dhee.service;

import java.util.ArrayList;
import java.util.Map;

import com.dhee.dao.NoticeDAO;
import com.dhee.dto.NoticeDTO;
import com.dhee.pageutils.PageInfo;
import com.dhee.pageutils.PageUtils;
import com.dhee.vo.NoticesVO;
/**
 * ���¹����ҵ���߼���
 * @author dongjianmin
 */
public class NoticesService {
	// װ�ض���ļ���
	private ArrayList<NoticeDTO> listdto;
	private ArrayList<NoticesVO> listvo;
	private NoticeDAO ndao;
	private NoticeDTO ndto;
	private NoticesVO nvo;
	/**
	 *  ��ҳ���¹���
	 */
	public ArrayList<NoticesVO> selectindex() { 
		// ����DAO�Ĳ�ѯ6�����ݷ���
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
	 * ǰ̨���¹���
	 * @return
	 */
	public ArrayList<NoticesVO> select2Notices(PageInfo info) { 
		// ����DAO�Ĳ�ѯ���ݷ���
		ndao = new NoticeDAO();
		listdto = ndao.selectNotices();
		listvo = new ArrayList<NoticesVO>();
		//��ҳ
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
	 *ǰ̨��ϸ���¹���
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
	 * �����̨2Noticesҳ��
	 * @return
	 */
	public ArrayList<NoticesVO> managerNotices(PageInfo info){
		// ����DAO�Ĳ�ѯ12�����ݷ���
		ndao = new NoticeDAO();
		listdto = ndao.selectNotices();
		listvo = new ArrayList<NoticesVO>();
		//��ҳ
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
	 * ��̨���¹����ѯ�������̨3Noticesҳ��
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
	 *  ��̨���¹�������
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
	 *  �����̨���¹����޸�
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
	  *  ��̨���¹����޸�
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
	 *  ��̨���¹����޸�
	*/
	 public void date(NoticesVO nv){
		 ndto = new NoticeDTO();
		 ndto.setNid(Integer.parseInt(nv.getNid()));
		 ndao = new NoticeDAO();
		 ndao.deleteNotice(ndto);
	 }
}