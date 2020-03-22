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
 * @Desc:用户登录验证实现
 * @author WeiyiGeek
 * @CreatTime 下午12:46:54
 */
public class User implements UserDao {

	@Override
	public boolean loginVerity(String name, String pass) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//数据库连接对象
			conn = db.getConn();
			String sql = "SELECT * FROM manager_user WHERE username = ? and password = MD5(?)";
			
			//创建预处理对象
			ps = conn.prepareStatement(sql);
			System.out.println("\n账号:" + name  + ",密码:" + pass);
			ps.setString(1, name);
			ps.setString(2, pass);

			//执行查询返回结果集
			rs = ps.executeQuery();
			
			//判断是否移动下一条判断用户登录信息是否正确
			return rs.next();
		} finally {
			//执行结束释放
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
			//数据库连接对象
			conn = db.getConn();
			String sql = "SELECT * FROM manager_user";
			
			//创建预处理对象
			ps = conn.prepareStatement(sql);
		
			//执行查询返回结果集
			rs = ps.executeQuery();
			
			//迭代数据
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
			//执行结束释放
			db.release(conn, ps, rs);
		}
		
		// TODO Auto-generated method stub
		return info;
	}

}
