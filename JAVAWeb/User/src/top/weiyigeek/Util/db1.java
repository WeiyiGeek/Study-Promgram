package top.weiyigeek.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/***
 * @Desc: ���ݿ����ӹ��������c3p0�ķ�ʽ���������ǵĴ��룩
 * @author WeiyiGeek
 * @CreatTime ����1:28:57
 */
public class db1 {
	static ComboPooledDataSource cpds = null;
	static {
		cpds = new ComboPooledDataSource();
	}
	
	/**
	 * ��ȡC3P0�е����Ӷ���
	 * @return Connection
	 */
	public static Connection getConn() throws SQLException {
		return cpds.getConnection();
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
