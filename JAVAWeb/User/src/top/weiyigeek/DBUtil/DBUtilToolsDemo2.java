package top.weiyigeek.DBUtil;

import java.sql.ResultSet;

import top.weiyigeek.Util.DBUtilTools;
import top.weiyigeek.Util.ResultSetHandler;

public class DBUtilToolsDemo2 {

	public static void main(String[] args) {
		//1.测试DML语句
		//int flag = DBUtilTools.update("INSERT INTO account value(null,?,?)", "法外狂徒",50);
		//System.out.println("影响条数:"+flag);
		
		//int flag = DBUtilTools.update("UPDATE account SET name = ?,money = money + ? WHERE id = ?", "法外狂徒",150,4);
		//System.out.println("影响条数:"+flag);
		
		//2.测试QUERY语句
		Account a = DBUtilTools.query("SELECT * FROM account where id = ?", new ResultSetHandler<Account>() {
			@Override
			public Account sethandler(ResultSet rs) {
				// TODO Auto-generated method stub
				Account work = new Account();
				try {
					while(rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						int money = rs.getInt("money");
						work.setId(id);
						work.setName(name);
						work.setMoney(money);
					}
					return work;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return null;
				}
			}
			
		}, 4);
		
		System.out.println(a.toString());
	}
}
