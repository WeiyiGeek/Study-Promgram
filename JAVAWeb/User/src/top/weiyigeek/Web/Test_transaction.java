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
			
			//1.����:����Ĭ�Ͼ����Զ��ύ�ġ� �ر��Զ��ύ��
			conn.setAutoCommit(false);
			
			String sql = "update account set money = money - ? where id = ?";
			ps = conn.prepareStatement(sql);
			
			//2.��Ǯ:��IDΪ1 ��100��Ǯ
			ps.setInt(1, 100);
			ps.setInt(2, 1);
			ps.executeUpdate();
			
			//3.���õ��쳣���鿴�����ύ��Ӱ��
			//int a = 10 /0 ;
			
			//4.��Ǯ�� ��IDΪ2 ��100��Ǯ
			ps.setInt(1, -100);
			ps.setInt(2, 2);
			ps.executeUpdate();
			
			//5.�ɹ��� �ύ����
			conn.commit();
			
		} catch (SQLException e) {
			try {
				//6.��3���������쳣�����catch{} ���ع�����
				conn.rollback();
				System.out.println("\nSQL �����ύ�쳣�����Զ��ع�����!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		}finally {
			db.release(conn, ps, rs);
		}
	}
}
