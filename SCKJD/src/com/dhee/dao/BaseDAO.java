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
import com.dhee.interfaces.BaseDAOInterface;
/**
 * ���ر���������з�����DAO��
 * @author zhoucngxiang
 */
public class BaseDAO extends DBConnection implements BaseDAOInterface{
	@Override
	/**
	 * ɾ�����ڻ���
	 */
	public int deleteBase(int bid) {
	    int result = 0;
		Connection con = null ;
		DBConnection dbcom = new DBConnection();
		con = dbcom.getConnectin();
		PreparedStatement ps = null;
		String sql = MyProperties.getPropertices("base_deleteBase");
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1,bid);
			result = ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return result;
	}
	@Override
	//���ӳ��ڻ���
	public int insertBase(BaseDTO base) {
		int result = 0;
		Connection con = null ;
		PreparedStatement ps = null;
		DBConnection dbcom = new DBConnection();
		con = dbcom.getConnectin();
		String sql = MyProperties.getPropertices("base_insertBase");
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,base.getBname());
			ps.setString(2,base.getBintroduction());
			ps.setInt(3,base.getTid());
			result = ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	@Override
	//��ѯ���г��ڻ���
	public ArrayList<BaseDTO> selectBase() {
		Connection con = null ;
		DBConnection dbcom = new DBConnection();
		con = dbcom.getConnectin();
		ResultSet rs = null;
		String sql = MyProperties.getPropertices("base_selectBase");
		ArrayList<BaseDTO> l = new ArrayList<BaseDTO>();
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				BaseDTO bdto = new BaseDTO();
				bdto.setBid(rs.getInt(1));
				bdto.setBname(rs.getString(2));
				bdto.setBdate(rs.getString(3));
				bdto.setBintroduction(rs.getString(4));
				bdto.setTid(rs.getInt(5));
				bdto.setBimagepath(rs.getString(6));
				bdto.setBimage1(rs.getString(7));
				bdto.setBimage2(rs.getString(8));
				l.add(bdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return l;
	}
	
	public static void main(String[] args) {
		BaseDAO bdao = new BaseDAO();
		BaseDTO bdto = new BaseDTO();
		bdto.setBname("aaaaaaaaaa");
		bdto.setBintroduction("aaaaaaaaaaaaa");
		bdto.setTid(1000);
		bdto.setBid(1021);
		bdao.updateBase(bdto);
	}
	
	@Override
	//�༭���ڻ���
	public int updateBase(BaseDTO base) {
		int result=0;
		Connection con = null ;
		DBConnection dbcom = new DBConnection();
		con = dbcom.getConnectin();
		PreparedStatement ps = null;
		String sql = MyProperties.getPropertices("base_updateBase");
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,base.getBname());
			ps.setString(2,base.getBintroduction());
			ps.setInt(3,base.getTid());
			ps.setInt(4,base.getBid());
			result = ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return result;                                                           
	}
	
	//��ѯ��һҳ12�����ڻ���
	public ArrayList<BaseDTO> selectFirstPageBase() {
		Connection con = null ;
		DBConnection dbcom = new DBConnection();
		con = dbcom.getConnectin();
		ResultSet rs = null;
		String sql = MyProperties.getPropertices("base_selectfirstBase");
		ArrayList<BaseDTO> l = new ArrayList<BaseDTO>();
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				BaseDTO bdto = new BaseDTO();
				bdto.setBname(rs.getString(1));
				bdto.setBdate(rs.getString(2));
				l.add(bdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return l;
	}
	
	//��ѯ����������ҵ
	public BaseDTO selectSingleBase(int bid){
		ResultSet rs = null;
		DBConnection dbc = new DBConnection();
		Connection con = dbc.getConnectin();
		PreparedStatement ps = null;
		BaseDTO bdto = new BaseDTO();
		String sql = MyProperties.getPropertices("base_selectSingleBase");
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1,bid);
			rs = ps.executeQuery();
			rs.next();
			bdto.setBid(bid);
			bdto.setBname(rs.getString(1));
			bdto.setBimagepath(rs.getString(2));
			bdto.setBintroduction(rs.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bdto;
	}
}