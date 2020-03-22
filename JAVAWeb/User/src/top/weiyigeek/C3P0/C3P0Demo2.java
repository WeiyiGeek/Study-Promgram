package top.weiyigeek.C3P0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import top.weiyigeek.Util.db;

/**
 * 
 * @Desc: C3P0 通过xml文件配置读取数据库连接以及连接池配置(实际与Demo1差不不大)
 * @author WeiyiGeek
 * @CreatTime 下午2:38:55
 */
public class C3P0Demo2 {
	
	@Test
	public void demo2() throws SQLException {
		//1.创建DataSource并且读取设置数据库连接信息（c3p0-config.xml）
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		//ComboPooledDataSource cpds = new ComboPooledDataSource("oracle"); //可以指定配置文件中连接指定的数据库
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		//2.得到连接对象
		conn = cpds.getConnection();
		ps = conn.prepareStatement("SELECT count(*) FROM user");

		//3.执行SQL查询
		rs = ps.executeQuery();
		System.out.println("序号 - 姓名 - 年级");
		while (rs.next()) {
			System.out.println("学生总数: "+rs.getInt(1) );
		}
		
		//4.关闭连接
		db.release(conn, ps, rs);
	}
}
