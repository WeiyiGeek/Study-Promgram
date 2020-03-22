package top.weiyigeek.Web;
import top.weiyigeek.pool.CustomDatasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class Test_Pool {
	@Test
	public void testPool() throws SQLException {
		Connection conn = null;
		PreparedStatement ps =null;
		//注意这里需要避免重复申请对象所以需要使用单例;
		CustomDatasource ds = CustomDatasource.getInstance();
		try {
			//获取资源池的链接对象
			conn = ds.getConnection();
			String sql = "SELECT * FROM user LIMIT 0,10";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + " , Name = " + rs.getString("name")+", 登录时间 = " + rs.getDate("uptime"));
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				//关闭PreparedStatementd对象
				ps.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			//归还对象
			//ds.addBack(conn); //采用装饰后便不使用此种方法
			conn.close();
		}
	}
}
