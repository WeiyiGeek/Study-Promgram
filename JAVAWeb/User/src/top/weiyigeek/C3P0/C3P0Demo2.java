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
 * @Desc: C3P0 ͨ��xml�ļ����ö�ȡ���ݿ������Լ����ӳ�����(ʵ����Demo1�����)
 * @author WeiyiGeek
 * @CreatTime ����2:38:55
 */
public class C3P0Demo2 {
	
	@Test
	public void demo2() throws SQLException {
		//1.����DataSource���Ҷ�ȡ�������ݿ�������Ϣ��c3p0-config.xml��
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		//ComboPooledDataSource cpds = new ComboPooledDataSource("oracle"); //����ָ�������ļ�������ָ�������ݿ�
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		//2.�õ����Ӷ���
		conn = cpds.getConnection();
		ps = conn.prepareStatement("SELECT count(*) FROM user");

		//3.ִ��SQL��ѯ
		rs = ps.executeQuery();
		System.out.println("��� - ���� - �꼶");
		while (rs.next()) {
			System.out.println("ѧ������: "+rs.getInt(1) );
		}
		
		//4.�ر�����
		db.release(conn, ps, rs);
	}
}
