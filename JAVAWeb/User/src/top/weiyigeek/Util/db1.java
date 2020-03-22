package top.weiyigeek.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/***
 * @Desc: 数据库连接工具类采用c3p0的方式（精简我们的代码）
 * @author WeiyiGeek
 * @CreatTime 下午1:28:57
 */
public class db1 {
	static ComboPooledDataSource cpds = null;
	static {
		cpds = new ComboPooledDataSource();
	}
	
	/**
	 * 获取C3P0中的链接对象
	 * @return Connection
	 */
	public static Connection getConn() throws SQLException {
		return cpds.getConnection();
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
