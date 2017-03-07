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
 * ������ҵ����������з�����DAO��
 * @author wuzhihui
 */
public class EnterprisesDAO extends DBConnection implements EnterprisesDAOInterface{
/**
 * ɾ��Enterprises���ĳһ������
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
			conn.commit();  //���쳣���ύ
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
 * ע����Ϣʱ������Ϣ���뵽Enterprises��
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
			conn.commit();  //���쳣���ύ
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
 * �����Ϣʱ������Ϣ���뵽Enterprises��
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
			conn.commit();  //���쳣���ύ
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
 * ��ѯEnterprises���������Ϣ
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
 * ����Enterprises�����Ϣ
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
			conn.commit();  //���쳣���ύ
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
 * �����¼�ķ������ɹ�����true��ʧ�ܷ���false
 * @param username
 * @param password
 * @return ���ݿ����Ƿ��д�����Ϣ���жϵ�¼�Ƿ�ɹ�
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
 * ǰ̨2Company_REҳ���Ӧ�Ĳ�ѯǰ12����Ϣ�ķ���
 * @return ����12��������������ҵͼƬ·����ͼƬ���Ƶ�EnterprisesDTO����ļ���
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
 * ǰ̨3Company_REҳ���Ӧ�Ĳ�ѯ����ĳһ����Ϣ�ķ���
 * @return ���о�����Ϣ�Ķ���
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
 * ��̨2Company_REҳ���Ӧ�Ĳ�ѯ��Ϣ�ķ���
 * @return ������ҵ���Ƶļ���
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
 * ע��ҳ���е�������صļ���
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