package com.dhee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dhee.db.DBConnection;
import com.dhee.db.MyProperties;
import com.dhee.dto.BaseDTO;
import com.dhee.dto.EnterprisesDTO;
import com.dhee.interfaces.EnterprisesDAOInterface;
/**
 * 基地企业表操作的所有方法的DAO类
 * @author wuzhihui
 */
public class EnterprisesDAO extends DBConnection implements EnterprisesDAOInterface{
/**
 * 删除Enterprises表的某一条数据
 */
	@Override
	public int deleteEnterprises(EnterprisesDTO enterprises) {
		int result = 0;
		String sql =  MyProperties.getPropertices("enterprises_delete");
		Connection conn = this.getConnectin();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, enterprises.getEid());
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
 * 注册信息时，将信息插入到Enterprises表
 */
	public int addEnterprises(EnterprisesDTO enterprises) {
		int result = 0;
		String sql =  MyProperties.getPropertices("enterprises_insert");
		Connection conn = this.getConnectin();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, enterprises.getUsername());
			ps.setString(2, enterprises.getPassword());
			ps.setString(3, enterprises.getEname());
			ps.setString(4, enterprises.getMobile());
			ps.setString(5, enterprises.getEmail());
			ps.setInt(6, enterprises.getBid());
			ps.setString(7 ,enterprises.getElogopath());
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
 * 添加信息时，将信息插入到Enterprises表
 */
	@Override
	public int insertEnterprises(EnterprisesDTO enterprises) {
		int result = 0;
		String sql =  MyProperties.getPropertices("enterprises_add");
		Connection conn = this.getConnectin();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1 , enterprises.getEname());
			ps.setInt(2 , enterprises.getBid());
			ps.setString(3 , enterprises.getMobile());
			ps.setString(4 , enterprises.getElogopath());
			ps.setString(5 , enterprises.getUsername());
			ps.setString(6 , enterprises.getPassword());
			ps.setString(7 , enterprises.getEmail());
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
 * 查询Enterprises表的所有信息
 */
	@Override
	public ArrayList<EnterprisesDTO> selectEnterprises() {
		ArrayList<EnterprisesDTO> list = new ArrayList<EnterprisesDTO>();
		String sql =  MyProperties.getPropertices("enterprises_select");
		Connection conn = this.getConnectin();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				EnterprisesDTO ed = new EnterprisesDTO();
				ed.setEid(rs.getInt(1));
				ed.setUsername(rs.getString(2));
				ed.setPassword(rs.getString(3));
				ed.setEname(rs.getString(4));
				ed.setMobile(rs.getString(5));
				ed.setEmail(rs.getString(6));
				ed.setElogopath(rs.getString(7));
				ed.setElogoname(rs.getString(8));
				ed.setBid(rs.getInt(9));
				ed.setCid(rs.getInt(10));
				ed.setWeb(rs.getString(11));
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
 * 更新Enterprises表的信息
 */
	@Override
	public int updateEnterprises(EnterprisesDTO enterprises) {
		int result = 0;
		String sql =  MyProperties.getPropertices("enterprises_update");
		Connection conn = this.getConnectin();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, enterprises.getEname());
			ps.setInt(2, enterprises.getBid());
			ps.setString(3, enterprises.getMobile());
			ps.setString(4, enterprises.getUsername());
			ps.setString(5, enterprises.getPassword());
			ps.setString(6, enterprises.getEmail());
			ps.setInt(7, enterprises.getEid());
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
 * 处理登录的方法，成功返回true，失败返回false
 * @param username
 * @param password
 * @return 数据库中是否有此条信息，判断登录是否成功
 */
	public boolean Login(String username , String password){
		boolean flag = false;
		String sql =  MyProperties.getPropertices("enterprises_login");
		Connection conn = this.getConnectin();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1 , username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
/**
 * 前台2Company_RE页面对应的查询前12条信息的方法
 * @return 载有12个含有主键和企业图片路径和图片名称的EnterprisesDTO对象的集合
 */
	public ArrayList<EnterprisesDTO> selectCompanyRE(){
		ArrayList<EnterprisesDTO> list = new ArrayList<EnterprisesDTO>();
		String sql =  MyProperties.getPropertices("enterprises_selectcompanyre");
		Connection conn = this.getConnectin();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				EnterprisesDTO ed = new EnterprisesDTO();
				ed.setEid(rs.getInt(1));
				ed.setElogopath(rs.getString(2));
				ed.setElogoname(rs.getString(3));
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
 * 前台3Company_RE页面对应的查询具体某一条信息的方法
 * @return 载有具体信息的对象
 */
	public EnterprisesDTO selectcompanydetail(int eid){
		String sql =  MyProperties.getPropertices("enterprises_selectcompanydetail");
		Connection conn = this.getConnectin();
		PreparedStatement ps = null;
		ResultSet rs = null;
		EnterprisesDTO edto = new EnterprisesDTO();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1 , eid);
			rs = ps.executeQuery();
			while(rs.next()){
				edto.setEid(eid);
				edto.setEname(rs.getString(1));
				edto.setWeb(rs.getString(2));
				edto.setMobile(rs.getString(3));
				edto.setElogopath(rs.getString(5));
				edto.setUsername(rs.getString(6));
				edto.setPassword(rs.getString(7));
				edto.setEmail(rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return edto;
	}
/**
 * 后台2Company_RE页面对应的查询信息的方法
 * @return 载有企业名称的集合
 */
	public ArrayList<EnterprisesDTO> selectEname(){
		ArrayList<EnterprisesDTO> li = new ArrayList<EnterprisesDTO>();
		String sql =  MyProperties.getPropertices("enterprises_selectename");
		Connection conn = this.getConnectin();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				EnterprisesDTO edto = new EnterprisesDTO();
				edto.setEid(rs.getInt(1));
				edto.setEname(rs.getString(2));
				li.add(edto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResult(rs);
			this.closeStatement(st);
			this.closeConnection(conn);
		}
		return li;
	}
/**
 * 注册页面中的所需基地的集合
 * @return
 */
	public ArrayList<BaseDTO> selectBase(){
		ArrayList<BaseDTO> li = new ArrayList<BaseDTO>();
		String sql =  MyProperties.getPropertices("enterprises_selectbase");
		Connection conn = this.getConnectin();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				BaseDTO bdto = new BaseDTO();
				bdto.setBid(rs.getInt(1));
				bdto.setBname(rs.getString(2));
				li.add(bdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResult(rs);
			this.closeStatement(st);
			this.closeConnection(conn);
		}
		return li;
	}
}