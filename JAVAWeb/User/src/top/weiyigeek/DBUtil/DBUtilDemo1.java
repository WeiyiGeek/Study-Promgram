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
 * Function: DButil CURD 案例实现 
 */
public class DBUtilDemo1 {
	//调用实现
	public static void main(String[] args) throws SQLException {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		//示例1.插入测试
		if(insert(cpds)>0) {
			System.out.println("插入成功");
		}else {
			System.err.println("插入失败");
		}
		
		//示例2.测试删除
		if(delete(cpds)>0) {
			System.out.println("删除成功");
		}else {
			System.err.println("删除失败");
		}
		
		//示例3.测试更新
		if(update(cpds)>0) {
			System.out.println("更新成功");
		}else {
			System.err.println("更新失败");
		}
		
		
		//示例4.测试匿名实现类进行返回查询结果
		Account account = queryone(cpds);
		System.out.println(account.toString());
		
		
		//示例5.通过DBuntil中ResultSetHandler实现接口来返回结果;
		List<Account> ls = querytwo(cpds);
		for(Account worker:ls) {
			System.out.println(worker.toString());
		}

	}
	
	//（1）Function:如方法名称测试SQL插入语句
	public static int insert(DataSource cpds) throws SQLException {
		QueryRunner qr = new QueryRunner(cpds);
		int flag = qr.update("INSERT INTO account VALUES (null,?,?)","张伟",1024);
		return flag;
	}
	
	//（2）Function:如方法名称测试SQL删除语句
	public static int delete(DataSource cpds) throws SQLException {
		QueryRunner qr = new QueryRunner(cpds);
		int flag = qr.update("DELETE FROM account where name = ?","张伟");
		return flag;
	}
	
	//（3）Function:如方法名称测试SQL更新语句
	public static int update(DataSource cpds) throws SQLException {
		QueryRunner qr = new QueryRunner(cpds);
		int flag = qr.update("UPDATE account SET money=money+100 where id = ? and name = ?",1,"WeiyiGeek");
		return flag;
	}
	
	//（4）Function:如方法名称测试SQL查询语句
	public static Account queryone(DataSource cpds) throws SQLException {
		QueryRunner qr = new QueryRunner(cpds);
		//匿名类实现
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
	
	//（5）采用ResultSetHandler中的，resultset转换为其他对象进行实现。
	public static List<Account> querytwo(DataSource cpds) throws SQLException {
		QueryRunner qr = new QueryRunner(cpds);
		//- BeanHander - 返回一个对象;
		//- BeanListHander - 返回一个装有对象的集合;
		List<Account> list= qr.query("SELECT * FROM account", new BeanListHandler<Account>(Account.class));
		return list;
	}
}
