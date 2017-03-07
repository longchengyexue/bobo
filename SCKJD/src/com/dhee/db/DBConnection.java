package com.dhee.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ���ݿ������
 * @author wuzhihui
 */
public class DBConnection {
/**
 * �����ݿ⽨������
 * @return Connection
 */
	public Connection getConnectin(){
		String url = "jdbc:mysql://172.16.68.145:3306/mysql";
		String username = "root";
		String password = "123456";
		Connection conn = null;
		try {
			Class.forName("com.informix.jdbc.IfxDriver");
			conn = DriverManager.getConnection(url,username,password);
		//	conn.setAutoCommit(false); //���ύ�޸�Ϊfalse
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
/**
 * �ر�ResultSet
 * @param rs
 */
	public void closeResult(ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
/**
 * �ر�Statement
 * @param st
 */
	public void closeStatement(Statement st){
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
/**
 * �ر�Connection
 * @param conn
 */
	public void closeConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
/**
 * �ر�PreparedStatement
 * @param ps
 */
	public void closePreparedStatement(PreparedStatement ps){
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
}