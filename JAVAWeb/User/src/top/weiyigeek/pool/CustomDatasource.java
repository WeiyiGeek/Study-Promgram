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
	// 数据库资源池建立的方法
	//0.创建本类对象并且对外提供公共的访问方法
	private static CustomDatasource s = new CustomDatasource();
	public static CustomDatasource getInstance() {
		return s;
	}
	// 1.建立存储连接池对象的集合
	List <Connection> list = new ArrayList<Connection>();
	
	 public CustomDatasource()  {
		 //2.建立连接对象存储到资源池中
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

	
	//3.连接池对外公布的获取连接的方法 
	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		//4.判断资源池是否用完是则添加3个连接对象到资源池(当然资源池是有限制的)
		 if (list.size() == 0 ) {
			 try {
				 for(int i = 0; i < 5; i++)
					 list.add(db.getConn());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
		//返还并移出第一个元素
		Connection conn = list.remove(0); 
		//修饰模式在把这个对象抛出去的时候， 对这个对象进行包装。(重点值得学习)
		Connection connection = new ConnectionWrap(conn, list);
		return connection;
	}

	
	//5.归还连接对象
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
