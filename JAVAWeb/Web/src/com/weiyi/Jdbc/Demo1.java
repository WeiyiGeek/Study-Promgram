package com.weiyi.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {
		//Step 1.驱动注册
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		
		//Step 2.构建连接字符串和建立链接
		
		String urlFormat = "jdbc:mysql://%s:%d/%s?useUnicode=true&characterEncoding=UTF-8";
		String connectionUrl = String.format(urlFormat, "113.62.177.230", 9001, "Demo");
		Connection conn = DriverManager.getConnection(connectionUrl, "root", "WeiyiGeek@2020");
		Statement st = conn.createStatement();
		String sql = "SELECT * FROM Persons WHERE ID <> 102";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())
		{
			System.out.println("ID: " + rs.getInt("ID") + " , LastName = " + rs.getString("LastName"));
		}
	}
}
