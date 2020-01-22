package com.weiyi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.weiyi.Jdbc.JDBCUtil;
import com.weiyi.dao.userDao;

public class userDaoImpl implements userDao{
	//JDBC连接标准文档
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	@Override
	public void findAll() {
		try {
			//1.驱动加载和建立链接
			conn = JDBCUtil.getConn();
			//2.建立流对象statement
			st = conn.createStatement();
			//3.构建执行SQL语句
			rs = st.executeQuery("SELECT * FROM user_log");
			while(rs.next())
			{
				System.out.println(rs.getInt("id") + " " + rs.getString("userLogin") + " " + rs.getDate("loginTime"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, st, rs);
		}
	}
	
	/**
	 *  创建PreparedStatement预处理对象
	 */

	@Override
	public void psLogin(String user,String pass, int x) {
		try {
			//1.载入数据库驱动建立链接
			conn = JDBCUtil.getConn();
			//2.构建SQL语句以及预处理SQL语句
			String sql = "SELECT * FROM user_log WHERE userLogin = ? AND userPass = md5(?) AND id = ?";  //? 占位符合后面会将绑定的参数进行格式化后传入
			PreparedStatement ps = conn.prepareStatement(sql); //关键点1:对我们的SQL语句进行预处理如果SQL语法错误的将不能通过解析
			ps.setString(1, user);  //关键点2:进行传入参数的位置开始绑定从,1代表第一个问号,2同理;
			ps.setString(2, pass);  //关键点3:注意传入的类型是可以根据需要来设置的;
			ps.setInt(3, x);
			//3.执行预处理好的的对象
			rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("登陆成功!");
				System.out.println("欢迎您" + rs.getString("userLogin") + "管理员, 注册时间: " + rs.getTimestamp("loginTime"));
			} else {
				System.out.println("登陆失败");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, st, rs);
		}
	}
	
	
	@Override
	public void psInsert(String user, String pass) {
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "INSERT INTO user_log(userLogin,userPass) VALUES (?,md5(?))";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			int result = ps.executeUpdate();
			if(result > 0) {
				System.out.println("成功添加" + user + "用户!");
			}else {
				System.out.println("用户注册失败!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps);
		}
	}

	@Override
	public void psUpdate(String user, int id) {
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "UPDATE user_log SET userLogin = ? WHERE id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setInt(2, id);
			int result = ps.executeUpdate();
			if(result>0) {
				System.out.println("更新用户ID = " + id + ", 为 " + user+"用户成功!");
			}else {
				System.out.println("更新失败");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps);
		}
		
	}

	@Override
	public void psDelete(String user, String pass)  {
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "DELETE FROM user_log WHERE userLogin = ? AND userPass = md5(?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			int result = ps.executeUpdate();
			if(result > 0){
				System.out.println("用户 " + user +" 删除成功!");
			}else {
				System.out.println("删除失败");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps);
		}
	
	}

}
