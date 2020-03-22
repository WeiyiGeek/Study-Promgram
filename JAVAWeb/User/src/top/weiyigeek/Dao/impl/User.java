package top.weiyigeek.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import top.weiyigeek.Dao.UserDao;
import top.weiyigeek.Util.db;
import top.weiyigeek.entity.UserInfo;

/**
 * @Desc:�û���¼��֤ʵ��
 * @author WeiyiGeek
 * @CreatTime ����12:46:54
 */
public class User implements UserDao {

	@Override
	public boolean loginVerity(String name, String pass) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//���ݿ����Ӷ���
			conn = db.getConn();
			String sql = "SELECT * FROM manager_user WHERE username = ? and password = MD5(?)";
			
			//����Ԥ�������
			ps = conn.prepareStatement(sql);
			System.out.println("\n�˺�:" + name  + ",����:" + pass);
			ps.setString(1, name);
			ps.setString(2, pass);

			//ִ�в�ѯ���ؽ����
			rs = ps.executeQuery();
			
			//�ж��Ƿ��ƶ���һ���ж��û���¼��Ϣ�Ƿ���ȷ
			return rs.next();
		} finally {
			//ִ�н����ͷ�
			db.release(conn, ps, rs);
		}
	}

	@Override
	public List<UserInfo> infoQuery() {
		ArrayList<UserInfo> info = new ArrayList<UserInfo>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//���ݿ����Ӷ���
			conn = db.getConn();
			String sql = "SELECT * FROM manager_user";
			
			//����Ԥ�������
			ps = conn.prepareStatement(sql);
		
			//ִ�в�ѯ���ؽ����
			rs = ps.executeQuery();
			
			//��������
			while(rs.next()) {
				UserInfo ui = new UserInfo();
				ui.setId(rs.getInt("id"));
				ui.setUsername(rs.getString("username"));
				ui.setPassword(rs.getString("password"));
				ui.setAge(rs.getInt("age"));
				ui.setAddress(rs.getString("address"));
				
				info.add(ui);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//ִ�н����ͷ�
			db.release(conn, ps, rs);
		}
		
		// TODO Auto-generated method stub
		return info;
	}

}
