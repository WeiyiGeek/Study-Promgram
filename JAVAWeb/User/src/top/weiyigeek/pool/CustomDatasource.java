package top.weiyigeek.pool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import top.weiyigeek.Util.db;

public class CustomDatasource implements DataSource {
	// ���ݿ���Դ�ؽ����ķ���
	//0.������������Ҷ����ṩ�����ķ��ʷ���
	private static CustomDatasource s = new CustomDatasource();
	public static CustomDatasource getInstance() {
		return s;
	}
	// 1.�����洢���ӳض���ļ���
	List <Connection> list = new ArrayList<Connection>();
	
	 public CustomDatasource()  {
		 //2.�������Ӷ���洢����Դ����
		 for(int i = 0; i < 10;i++) {
			Connection conn;
			try {
				conn = db.getConn();
				list.add(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	}

	
	//3.���ӳض��⹫���Ļ�ȡ���ӵķ��� 
	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		//4.�ж���Դ���Ƿ������������3�����Ӷ�����Դ��(��Ȼ��Դ���������Ƶ�)
		 if (list.size() == 0 ) {
			 try {
				 for(int i = 0; i < 5; i++)
					 list.add(db.getConn());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
		//�������Ƴ���һ��Ԫ��
		Connection conn = list.remove(0); 
		//����ģʽ�ڰ���������׳�ȥ��ʱ�� �����������а�װ��(�ص�ֵ��ѧϰ)
		Connection connection = new ConnectionWrap(conn, list);
		return connection;
	}

	
	//5.�黹���Ӷ���
	public void addBack(Connection conn) {
		list.add(conn);
	}
	

	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
