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
		//ע��������Ҫ�����ظ��������������Ҫʹ�õ���;
		CustomDatasource ds = CustomDatasource.getInstance();
		try {
			//��ȡ��Դ�ص����Ӷ���
			conn = ds.getConnection();
			String sql = "SELECT * FROM user LIMIT 0,10";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + " , Name = " + rs.getString("name")+", ��¼ʱ�� = " + rs.getDate("uptime"));
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				//�ر�PreparedStatementd����
				ps.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			//�黹����
			//ds.addBack(conn); //����װ�κ�㲻ʹ�ô��ַ���
			conn.close();
		}
	}
}
