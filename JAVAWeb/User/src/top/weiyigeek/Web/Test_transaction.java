package top.weiyigeek.Web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import top.weiyigeek.Util.db;

public class Test_transaction {
	@Test
	public void transaction() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = db.getConn();
			
			//1.连接:事务默认就是自动提交的。 关闭自动提交。
			conn.setAutoCommit(false);
			
			String sql = "update account set money = money - ? where id = ?";
			ps = conn.prepareStatement(sql);
			
			//2.扣钱:扣ID为1 的100块钱
			ps.setInt(1, 100);
			ps.setInt(2, 1);
			ps.executeUpdate();
			
			//3.设置的异常，查看事务提交的影响
			//int a = 10 /0 ;
			
			//4.加钱， 给ID为2 加100块钱
			ps.setInt(1, -100);
			ps.setInt(2, 2);
			ps.executeUpdate();
			
			//5.成功： 提交事务。
			conn.commit();
			
		} catch (SQLException e) {
			try {
				//6.在3步骤会产生异常则进入catch{} 将回滚事务
				conn.rollback();
				System.out.println("\nSQL 事务提交异常，已自动回滚事务!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		}finally {
			db.release(conn, ps, rs);
		}
	}
}
