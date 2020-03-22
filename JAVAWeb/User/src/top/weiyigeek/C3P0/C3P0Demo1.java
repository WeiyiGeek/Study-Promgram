package top.weiyigeek.C3P0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;


import top.weiyigeek.Util.db;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Demo1 {
	@Test
	public void Demo1() throws PropertyVetoException,Exception {
		//1.创建DataSource
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//2.设置数据库连接信息
		cpds.setDriverClass("org.mariadb.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mariadb://127.0.0.1:3306/student");
		cpds.setUser("root");
		cpds.setPassword("");

		//3.得到连接对象
		conn = cpds.getConnection();
		ps = conn.prepareStatement("SELECT * FROM user LIMIT 0,?");
		ps.setInt(1, 20);

		//4.执行SQL查询
		rs = ps.executeQuery();
		System.out.println("序号 - 姓名 - 年级");
		while (rs.next()) {
			System.out.println(rs.getInt("id") + " - " + rs.getString("name") + " - " + rs.getShort("grade"));
		}
		
		//5.关闭连接
		db.release(conn, ps, rs);
	}
}
