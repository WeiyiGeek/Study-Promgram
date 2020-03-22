package top.weiyigeek.DBCP;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

/**
 * 
 * @Desc: OBCP��ȡ�����ļ����������ݿ�����
 * @author WeiyiGeek
 * @CreatTime ����1:26:18
 */
public class OBCPDemo2 {
	
	@Test
	public void testDemo2() throws Exception {
		//1.����Properties��ȡ�����ļ�������
		Properties prop = new Properties();
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("dbcp.properties");  //����Ŀ�е�jdbc.properties��ȡ��������
		prop.load(is);

		//2.�������Ӷ���
		BasicDataSourceFactory factory = new BasicDataSourceFactory();
		DataSource  datasource = factory.createDataSource(prop); //����properties�ļ�
		
		//3.�õ����Ӷ���
		Connection conn = datasource.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM user LIMIT 0,10");
		ResultSet rs = ps.executeQuery();
		
		//4.��ӡ���������ݿ��ж�ȡ������
		while(rs.next()) {
			System.out.println(rs.getInt("id") + " ---- " + rs.getString("name") +  " ---- " + rs.getInt("grade"));
		}
		
		//5.�ر�����
		System.out.println("���ӹر�");
		rs.close();
		ps.close();
		conn.close();
	}
}
