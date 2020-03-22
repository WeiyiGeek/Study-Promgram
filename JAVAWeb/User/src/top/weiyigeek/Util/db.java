package top.weiyigeek.Util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/***
 * 
 * @Desc: 数据库连接工具类
 * @author WeiyiGeek
 * @CreatTime 下午1:28:57
 */
public class db {
	/**
	 * 预读取Properties设置JDBC连接（注意这里采用Mariadb做为测试）
	 */
	static String driverClass = null;
	static String url = null;
	static String user = null;
	static String pass = null;
	static {
		try {
			Properties prop = new Properties();
			InputStream is = db.class.getClassLoader().getResourceAsStream("jdbc.properties");
			prop.load(is);
			driverClass=prop.getProperty("mysql.driverClass");
			url=prop.getProperty("mysql.url");
			user=prop.getProperty("mysql.user");
			pass=prop.getProperty("mysql.pass");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Msg#Properties 文件预读取成功!");
		}
	}
	
	/**
	 * Fun:驱动注册和建立链接
	 * @return Connection
	 */
	public static Connection getConn() throws SQLException {
		Connection conn = null;
		System.out.println("Msg#驱动注册和建立链接:"+url);
		//坑啊:驱动注册必须写上
		DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
		try {
			//防止驱动二次注册自动注册驱动与建立连接		
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * Fun:关闭数据库连接并释放资源 （注意点:关闭的顺序）
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void release(Connection conn,Statement st, ResultSet rs) {
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
		System.out.println("\n已关闭数据库连接并释放资源");
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
		
	//私有静态方法-关闭数据库连接
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
