//该包下的类可以通过静态类 类.方法()进行调用
package com.weiyi.Jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	static String connUrl = "jdbc:mysql://%s:%d/%s?useUnicode=true&characterEncoding=UTF-8";
	static String connIp = "113.62.1.1";
	static int connPort = 3001;
	static String conndatabase = "Demo";
	static String driverClass = null;  //使用的时候添加
	static String url = null;
	static String user = null;
	static String pass = null;
	
	//静态代码块,加载类的时候执行
	static {
		try {
			//Step1.创建一个属性配置对象
			Properties prop = new Properties();
		
			//Step2.打开配置文件
			//InputStream ins = new FileInputStream("jdbc.properties");
			InputStream ins = Demo3.class.getClassLoader().getResourceAsStream("jdbc.properties");

			//Step3.导入输入流
			prop.load(ins);
		
			//Step4.属性读取		
			driverClass = prop.getProperty("jdbc.driverClassName");
			url = String.format(prop.getProperty("jdbc.url"),connIp,connPort,conndatabase);
			user = prop.getProperty("jdbc.username");
			pass = prop.getProperty("jdbc.password");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Properties配置已经加载!");
		}
	}
	
	public JDBCUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JDBCUtil(String ip,int port,String database) {
		connIp = ip;
		connPort = port;
		conndatabase = database;
	}

	//注册工具方法
	/**
	 * 驱动注册和建立链接
	 * @param user
	 * @param password
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection getConn() throws SQLException {
		Connection conn = null;
		System.out.println("连接字符串:" + url);
		try {
			//防止驱动二次注册自动注册驱动与建立连接			
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;	
	}
	
	
	/**
	 * 释放工具类
	 * @param conn
	 * @param st
	 * @param rs
	 */
	
	// 注意点:导包需要查看是哪一个包的返回值
	public static void release(Connection conn, Statement st, ResultSet rs) {
		//注意点:关闭的顺序
		closeRs(rs);
		closeSt(st);
		System.out.println("END-资源释放完成!");
	}

	public static void release(Connection conn, Statement st) {
		//注意点:关闭的顺序
		closeSt(st);
		closeConn(conn);
		System.out.println("END-资源释放完成!");
	}

	//私有静态方法-释放查询结果集
	private static void closeRs(ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}
	}
	
	//私有静态方法-释放statement对象
	private static void closeSt(Statement st) {
		try {
			if(st != null)
				st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st = null;
		}
	}
	
	//私有静态方法-
	private static void closeConn(Connection conn) {
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
	
}
