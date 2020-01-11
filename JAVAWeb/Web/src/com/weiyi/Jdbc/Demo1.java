package com.weiyi.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Demo1 {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {
		
		//JDB连接标准文档
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//Step 1.驱动注册
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			//Step 2.构建连接字符串和建立链接
			String urlFormat = "jdbc:mysql://%s:%d/%s?useUnicode=true&characterEncoding=UTF-8";
			String connectionUrl = String.format(urlFormat, "113.100.177.1", 3306, "Demo");
			conn = DriverManager.getConnection(connectionUrl, "root", "WeiyiGeek");
			
			//Step 3.创建statement
			st = conn.createStatement();
			
		
			//Step 4.构建SQL语句以及执行语句
			String sql = "SELECT ID AS '序号',LastName AS '名称' FROM Persons WHERE ID <> 102";
			rs = st.executeQuery(sql);
			
			//Step 5.遍历数据库
			while(rs.next()){
				//System.out.println("ID: " + rs.getInt("ID") + " , LastName = " + rs.getString("LastName"));  //注意此处使用别名的时候(不能采用字段名进行获取数据库返回的值);
				System.out.println("ID: " + rs.getInt("序号") + " , LastName = " + rs.getString("名称"));
			}
			
			//Step 6.获取元数据metadate
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			int numCols = rsmd.getColumnCount(); //获取列元素数据量
			int count = 1;
			while(count <= numCols) {
				System.out.printf("第 %d 列： 列名: %s , AS别名: %s , 类型:%s \n",count, rsmd.getColumnName(count), rsmd.getColumnLabel(count), rsmd.getColumnType(count));
				count++;
			}
		
		} catch (SQLException sqlEx) {
			// TODO: handle exception
			sqlEx.printStackTrace();
		} finally {
			//Step 7.释放资源(非常重要) - 从后往前
			System.out.println("Start-释放资源中");
			//结果集对象
			try {
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
			
			//statement对象
			try {
				if(st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				st = null;
			}
			
			//数据库连接对象
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
			System.out.println("Successful-资源释放完成!");

			//当然您也可以采用自己封装后的JDBC工具类(非常注意释放的顺序)
			//JDBCUtil.release(conn,st,rs);
		}
	}
}
