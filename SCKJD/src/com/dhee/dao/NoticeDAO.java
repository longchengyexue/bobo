package com.dhee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dhee.db.DBConnection;
import com.dhee.db.MyProperties;
import com.dhee.dto.NoticeDTO;
import com.dhee.interfaces.NoticeDAOInterface;
/**
 * 最新公告表操作的所有方法的DAO类
 * @author dongjianmin
 */
public class NoticeDAO extends DBConnection implements NoticeDAOInterface{
/**
 * 删除Notice表的某一条数据
 */
	@Override
	public int deleteNotice(NoticeDTO notice) {
		int result = 0;
		String sql =  MyProperties.getPropertices("notice_delete");
		Connection conn = this.getConnectin();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, notice.getNid());
			result = ps.executeUpdate();
			conn.commit();  //无异常则提交
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			this.closePreparedStatement(ps);
			this.closeConnection(conn);
		}
			return result;
	}
/**
 * 将信息插入到Notice表
 */	
	@Override
	public int insertNotice(NoticeDTO notice) {
		int result = 0;
		String sql =  MyProperties.getPropertices("notice_insert");
		Connection conn = this.getConnectin();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, notice.getNtitle());
			ps.setString(2, notice.getNcontent());
			ps.setString(3, notice.getNdate());
			result = ps.executeUpdate();
			conn.commit();  //无异常则提交
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			this.closePreparedStatement(ps);
			this.closeConnection(conn);
		}
		return result;
	}
/**
 * 查询Notice表的所有信息
 */	
	@Override
	public ArrayList<NoticeDTO> selectNotice() {
		ArrayList<NoticeDTO> list = new ArrayList<NoticeDTO>();
		String sql =  MyProperties.getPropertices("notice_select");
		Connection conn = this.getConnectin();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				NoticeDTO nd = new NoticeDTO();
				nd.setNid(rs.getInt(1));
				nd.setNtitle(rs.getString(2));
				nd.setNcontent(rs.getString(3));
				nd.setNdate(rs.getString(4));	
				list.add(nd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResult(rs);
			this.closeStatement(st);
			this.closeConnection(conn);
		}
			return list;
		}
/**
 * 更新TOWN表的信息
 */
	@Override
	public int updateNotice(NoticeDTO notice) {
		int result = 0;  //最后的判断结果
		String sql =  MyProperties.getPropertices("notice_update");
		Connection conn = this.getConnectin();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, notice.getNtitle());
			ps.setString(2, notice.getNcontent());
			ps.setString(3, notice.getNdate());
			ps.setInt(4, notice.getNid());
			result = ps.executeUpdate();
			conn.commit();  //无异常则提交
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
			e1.printStackTrace();
			}
				e.printStackTrace();
		}finally{
			this.closePreparedStatement(ps);
			this.closeConnection(conn);
		}
		return result;
	}
/**
 * 前台2Notices页面对应的查询前12条信息的方法
 * @return 载有12个含有公告名称和日期的NoticeDTO对象的集合
 */
	public ArrayList<NoticeDTO> selectNotices(){
		ArrayList<NoticeDTO> list = new ArrayList<NoticeDTO>();
		String sql =  MyProperties.getPropertices("notice_selectnotices");
		Connection conn = this.getConnectin();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				NoticeDTO ed = new NoticeDTO();
				ed.setNid(rs.getInt(1));
				ed.setNtitle(rs.getString(2));
				ed.setNdate(rs.getString(3));
				list.add(ed);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResult(rs);
			this.closeStatement(st);
			this.closeConnection(conn);
		}
		return list;
	}
/**
 * 前台3Notice页面对应的查询具体某一条信息的方法
 */
	public NoticeDTO selectnoticedetail(int nid){
		NoticeDTO notice = new NoticeDTO();
		String sql =  MyProperties.getPropertices("notice_selectnticedetail");
		Connection conn = this.getConnectin();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1 , nid);
			rs = ps.executeQuery();
			while(rs.next()){
				notice.setNid(nid);
				notice.setNtitle(rs.getString(1));
				notice.setNcontent(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notice;
	}
	/**
	 * 后台详细信息
	 */
	public NoticeDTO selectn(int nid){
		NoticeDTO notice = new NoticeDTO();
		String sql =  MyProperties.getPropertices("notice_selectn");
		Connection conn = this.getConnectin();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1 , nid);
			rs = ps.executeQuery();
			while(rs.next()){
				notice.setNid(nid);
				notice.setNtitle(rs.getString(1));
				notice.setNcontent(rs.getString(2));
				notice.setNdate(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notice;
	}
}