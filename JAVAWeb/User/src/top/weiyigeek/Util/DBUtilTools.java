package top.weiyigeek.Util;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @Desc: ����JDBC�Զ����������ݿ⣬ͨ�÷���ִ����ɾ�Ĳ�
 * @author WeiyiGeek
 * @CreatTime ����9:51:05
 */
public class DBUtilTools {
	/**
	 * @Desc: ͨ�÷������� ���� ɾ�� �� ���� (DML)
	 * @param sql : INSERT INTO / DELETE FROM / UPDATE
	 * @param args : �ɱ��������Ҫ��
	 * @return 
	 */
	public static int update(String sql,Object...args) {
		int flag = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = db1.getConn();
			ps = conn.prepareStatement(sql);
			//���ò���Ԫ���ݻ�ȡִ��SQL����еĲ������������м����ʺţ�
			ParameterMetaData metaData = ps.getParameterMetaData();
			int count = metaData.getParameterCount();
			
			//����SQLִ�еĲ����󶨣���Ϊ��֪����ʲô���͵��������Զ�ʹ��setObject������
			for(int i = 0; i < count; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			//ִ��CURD���()
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
	 * @Desc: ͨ�÷������� ���ݿ����ݵĲ�ѯ ���õ������Լ�ʵ�����ݵķ�װ���ӿ�ʵ�������
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
			//���ò���Ԫ���ݻ�ȡִ��SQL����еĲ������������м����ʺţ�
			ParameterMetaData metaData = ps.getParameterMetaData();
			int count = metaData.getParameterCount();
			
			//����SQLִ�еĲ����󶨣���Ϊ��֪����ʲô���͵��������Զ�ʹ��setObject������
			for(int i = 0; i < count; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			//ִ��CURD���
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
