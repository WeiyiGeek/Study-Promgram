package top.weiyigeek.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * Function: DButil CURD ����ʵ�� 
 */
public class DBUtilDemo1 {
	//����ʵ��
	public static void main(String[] args) throws SQLException {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		//ʾ��1.�������
		if(insert(cpds)>0) {
			System.out.println("����ɹ�");
		}else {
			System.err.println("����ʧ��");
		}
		
		//ʾ��2.����ɾ��
		if(delete(cpds)>0) {
			System.out.println("ɾ���ɹ�");
		}else {
			System.err.println("ɾ��ʧ��");
		}
		
		//ʾ��3.���Ը���
		if(update(cpds)>0) {
			System.out.println("���³ɹ�");
		}else {
			System.err.println("����ʧ��");
		}
		
		
		//ʾ��4.��������ʵ������з��ز�ѯ���
		Account account = queryone(cpds);
		System.out.println(account.toString());
		
		
		//ʾ��5.ͨ��DBuntil��ResultSetHandlerʵ�ֽӿ������ؽ��;
		List<Account> ls = querytwo(cpds);
		for(Account worker:ls) {
			System.out.println(worker.toString());
		}

	}
	
	//��1��Function:�緽�����Ʋ���SQL�������
	public static int insert(DataSource cpds) throws SQLException {
		QueryRunner qr = new QueryRunner(cpds);
		int flag = qr.update("INSERT INTO account VALUES (null,?,?)","��ΰ",1024);
		return flag;
	}
	
	//��2��Function:�緽�����Ʋ���SQLɾ�����
	public static int delete(DataSource cpds) throws SQLException {
		QueryRunner qr = new QueryRunner(cpds);
		int flag = qr.update("DELETE FROM account where name = ?","��ΰ");
		return flag;
	}
	
	//��3��Function:�緽�����Ʋ���SQL�������
	public static int update(DataSource cpds) throws SQLException {
		QueryRunner qr = new QueryRunner(cpds);
		int flag = qr.update("UPDATE account SET money=money+100 where id = ? and name = ?",1,"WeiyiGeek");
		return flag;
	}
	
	//��4��Function:�緽�����Ʋ���SQL��ѯ���
	public static Account queryone(DataSource cpds) throws SQLException {
		QueryRunner qr = new QueryRunner(cpds);
		//������ʵ��
		Account account = qr.query("SELECT * FROM account WHERE id = ?", new ResultSetHandler<Account>() {
			@Override
			public Account handle(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				Account account = new Account();
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					float money = (float)rs.getInt("money");
					account.setId(id);
					account.setName(name);
					account.setMoney(money);
				}
				return account;
			}
		}, 1);
		
		return account;
	}
	
	//��5������ResultSetHandler�еģ�resultsetת��Ϊ�����������ʵ�֡�
	public static List<Account> querytwo(DataSource cpds) throws SQLException {
		QueryRunner qr = new QueryRunner(cpds);
		//- BeanHander - ����һ������;
		//- BeanListHander - ����һ��װ�ж���ļ���;
		List<Account> list= qr.query("SELECT * FROM account", new BeanListHandler<Account>(Account.class));
		return list;
	}
}
