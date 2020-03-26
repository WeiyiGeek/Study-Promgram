package top.weiyigeek.Util;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @Desc: 扩充JDBC自定义连接数据库，通用方法执行增删改查
 * @author WeiyiGeek
 * @CreatTime 下午9:51:05
 */
public class DBUtilTools {
	/**
	 * @Desc: 通用方法进行 插入 删除 与 更新 (DML)
	 * @param sql : INSERT INTO / DELETE FROM / UPDATE
	 * @param args : 可变参数（重要）
	 * @return 
	 */
	public static int update(String sql,Object...args) {
		int flag = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = db1.getConn();
			ps = conn.prepareStatement(sql);
			//利用参数元数据获取执行SQL语句中的参数个数（即有几个问号）
			ParameterMetaData metaData = ps.getParameterMetaData();
			int count = metaData.getParameterCount();
			
			//进行SQL执行的参数绑定，因为不知道是什么类型的数据所以都使用setObject来处理
			for(int i = 0; i < count; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			//执行CURD语句()
			flag = ps.executeUpdate();
			return flag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db1.release(conn, ps, null);
		}
		return -1;
	}
	

	/**
	 * @Desc: 通用方法进行 数据库数据的查询 并让调用者自己实现数据的封装（接口实现类对象）
	 * @param <T>
	 * @param sql
	 * @param handler
	 * @param args
	 * @return
	 */
	public static <T> T query(String sql, ResultSetHandler<T> handler,Object...args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = db1.getConn();
			ps = conn.prepareStatement(sql);
			//利用参数元数据获取执行SQL语句中的参数个数（即有几个问号）
			ParameterMetaData metaData = ps.getParameterMetaData();
			int count = metaData.getParameterCount();
			
			//进行SQL执行的参数绑定，因为不知道是什么类型的数据所以都使用setObject来处理
			for(int i = 0; i < count; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			//执行CURD语句
			rs = ps.executeQuery();
			T t = handler.sethandler(rs);
			return t;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db1.release(conn, ps, null);
		}
		return null;
	}
	
}
