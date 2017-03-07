package com.dhee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dhee.db.DBConnection;
import com.dhee.db.MyProperties;
import com.dhee.dto.TownDTO;
import com.dhee.interfaces.TownDAOInterface;
/**
 * 城市表操作的所有方法的DAO类
 * @author wuzhihui
 */
public class TownDAO extends DBConnection implements TownDAOInterface{
/**
 * 删除TOWN表的某一条数据
 */
	@Override
	public int deleteTown(TownDTO town) {
		int result = 0;
		String sql =  MyProperties.getPropertices("town_delete");
		Connection conn = this.getConnectin();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, town.getTid());
			result = ps.executeUpdate();
			conn.commit();
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
 * 将信息插入到TOWN表
 */
	@Override
	public int insertTown(TownDTO town) {
		int result = 0;
		String sql =  MyProperties.getPropertices("town_insert");
		Connection conn = this.getConnectin();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, town.getTname());
			ps.setInt(2, town.getState());
			result = ps.executeUpdate();
			conn.commit();
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
 * 查询TOWN表的所有信息
 */
	@Override
	public ArrayList<TownDTO> selectTown() {
		ArrayList<TownDTO> list = new ArrayList<TownDTO>();
		String sql =  MyProperties.getPropertices("town_select");
		Connection conn = this.getConnectin();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				TownDTO td = new TownDTO();
				td.setTid(rs.getInt(1));
				td.setTname(rs.getString(2));
				td.setState(rs.getInt(3));
				list.add(td);
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
	public int updateTown(TownDTO town) {
		int result = 0;
		String sql =  MyProperties.getPropertices("town_update");
		Connection conn = this.getConnectin();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, town.getTname());
			ps.setInt(2, town.getState());
			ps.setInt(3, town.getTid());
			result = ps.executeUpdate();
			conn.commit();
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
}