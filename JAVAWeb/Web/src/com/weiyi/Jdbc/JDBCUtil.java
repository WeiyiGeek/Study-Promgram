//该包下的类可以通过静态类 类.方法()进行调用
package com.weiyi.Jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	// 注意点:导包需要查看是哪一个包的返回值
	public static void release(Connection conn, Statement st, ResultSet rs) {
		//注意点:关闭的顺序
		closeRs(rs);
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
