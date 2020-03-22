package top.weiyigeek.Util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/***
 * 
 * @Desc: ���ݿ����ӹ�����
 * @author WeiyiGeek
 * @CreatTime ����1:28:57
 */
public class db {
	/**
	 * Ԥ��ȡProperties����JDBC���ӣ�ע���������Mariadb��Ϊ���ԣ�
	 */
	static String driverClass = null;
	static String url = null;
	static String user = null;
	static String pass = null;
	static {
		try {
			Properties prop = new Properties();
			InputStream is = db.class.getClassLoader().getResourceAsStream("jdbc.properties");
			prop.load(is);
			driverClass=prop.getProperty("mysql.driverClass");
			url=prop.getProperty("mysql.url");
			user=prop.getProperty("mysql.user");
			pass=prop.getProperty("mysql.pass");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Msg#Properties �ļ�Ԥ��ȡ�ɹ�!");
		}
	}
	
	/**
	 * Fun:����ע��ͽ�������
	 * @return Connection
	 */
	public static Connection getConn() throws SQLException {
		Connection conn = null;
		System.out.println("Msg#����ע��ͽ�������:"+url);
		//�Ӱ�:����ע�����д��
		DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
		try {
			//��ֹ��������ע���Զ�ע�������뽨������		
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * Fun:�ر����ݿ����Ӳ��ͷ���Դ ��ע���:�رյ�˳��
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void release(Connection conn,Statement st, ResultSet rs) {
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
		System.out.println("\n�ѹر����ݿ����Ӳ��ͷ���Դ");
	}
	
	//˽�о�̬����-�ͷŲ�ѯ�����
	private static void closeRs(ResultSet rs) {
			try {
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		
	//˽�о�̬����-�ͷ�statement����
	private static void closeSt(Statement st) {
			try {
				if(st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				st = null;
			}
		}
		
	//˽�о�̬����-�ر����ݿ�����
	private static void closeConn(Connection conn) {
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
}
