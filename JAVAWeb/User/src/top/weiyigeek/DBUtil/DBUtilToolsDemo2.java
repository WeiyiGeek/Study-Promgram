package top.weiyigeek.DBUtil;

import java.sql.ResultSet;

import top.weiyigeek.Util.DBUtilTools;
import top.weiyigeek.Util.ResultSetHandler;

public class DBUtilToolsDemo2 {

	public static void main(String[] args) {
		//1.����DML���
		//int flag = DBUtilTools.update("INSERT INTO account value(null,?,?)", "�����ͽ",50);
		//System.out.println("Ӱ������:"+flag);
		
		//int flag = DBUtilTools.update("UPDATE account SET name = ?,money = money + ? WHERE id = ?", "�����ͽ",150,4);
		//System.out.println("Ӱ������:"+flag);
		
		//2.����QUERY���
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
