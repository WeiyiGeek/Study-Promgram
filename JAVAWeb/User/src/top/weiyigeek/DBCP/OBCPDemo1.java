package top.weiyigeek.DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

import top.weiyigeek.Util.db;

/**
 * 
 * @Desc: OBCP Apache 开源数据连接管理框架的使用
 * @author WeiyiGeek
 * @CreatTime 下午12:45:22
 */
public class OBCPDemo1 {
	@SuppressWarnings("resource")
	@Test
	public void testOBCP () {
		//1.构建数据源对象
		BasicDataSource dataSource = new BasicDataSource();
		
		//2.得到连接对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//3.数据库配置（手动）
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		//主协议 子协议 数据库IP:Port 数据库
		dataSource.setUrl("jdbc:mariadb://127.0.0.1:3306/student");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		try {
			conn = dataSource.getConnection();
			//4.解析SQL语句
			ps = conn.prepareStatement("SELECT * FROM user ORDER BY id DESC LIMIT 0,?");
			ps.setInt(1, 10);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id") + " ---- " + rs.getString("name") +  " ---- " + rs.getInt("grade"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//db.release(conn, ps, rs);
			//释放资源建议重写close方法
		}
		
	}
}
