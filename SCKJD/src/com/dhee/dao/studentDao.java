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
import com.dhee.dto.studentDto;
import com.dhee.interfaces.studentInterface;

public class studentDao extends DBConnection implements studentInterface {

	@Override
	public ArrayList<studentDto> select() {
		ArrayList<studentDto> list = new ArrayList<studentDto>();
		String sql =  MyProperties.getPropertices("student_select");
		Connection conn = this.getConnectin();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				studentDto sd = new studentDto();
				sd.setId(rs.getString(1));
				sd.setName(rs.getString(2));
				sd.setSex(rs.getString(3));
				sd.setParty(rs.getString(4));
				sd.setRoom(rs.getString(5));
				sd.setProfession(rs.getString(6));
				sd.setDemo(rs.getString(7));
				 
				list.add(sd);
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

	@Override
	public int update(studentDto student) {
		int result = 0;  //最后的判断结果
		String sql =  MyProperties.getPropertices("student_update");
		Connection conn = this.getConnectin();
		PreparedStatement ps = null;
		try {//UPDATE student SET name=?,sex=?,party=?,room=?,profession=?,demo=?
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setString(2, student.getSex());
			ps.setString(3, student.getParty());
			ps.setString(4, student.getRoom());
			ps.setString(5, student.getProfession());
			ps.setString(6, student.getDemo());
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

	@Override
	public int insert(studentDto student) {
		int result = 0;
		String sql =  MyProperties.getPropertices("student_insert");
		Connection conn = this.getConnectin();
		PreparedStatement ps = null;
		try {//INSERT INTO STUDENT (id,name,sex,party,room,profession,demo
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getSex());
			ps.setString(4, student.getParty());
			ps.setString(5, student.getRoom());
			ps.setString(6, student.getProfession());
			ps.setString(7, student.getDemo());
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

	@Override
	public int delete(studentDto student) {
		// TODO Auto-generated method stub
		return 0;
	}

}
