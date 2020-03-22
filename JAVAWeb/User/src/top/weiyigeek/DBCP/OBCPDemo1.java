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
 * @Desc: OBCP Apache ��Դ�������ӹ����ܵ�ʹ��
 * @author WeiyiGeek
 * @CreatTime ����12:45:22
 */
public class OBCPDemo1 {
	@SuppressWarnings("resource")
	@Test
	public void testOBCP () {
		//1.��������Դ����
		BasicDataSource dataSource = new BasicDataSource();
		
		//2.�õ����Ӷ���
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//3.���ݿ����ã��ֶ���
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		//��Э�� ��Э�� ���ݿ�IP:Port ���ݿ�
		dataSource.setUrl("jdbc:mariadb://127.0.0.1:3306/student");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		try {
			conn = dataSource.getConnection();
			//4.����SQL���
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
			//�ͷ���Դ������дclose����
		}
		
	}
}
