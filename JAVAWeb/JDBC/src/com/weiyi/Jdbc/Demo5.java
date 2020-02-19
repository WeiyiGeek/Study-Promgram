package com.weiyi.Jdbc;

import java.sql.PreparedStatement;
import com.weiyi.dao.userDao;
import com.weiyi.dao.impl.userDaoImpl;

/**
 * JDBC预处理SQL语句案例演示
 * @author WeiyiGeek
 */
public class Demo5 {
	public static void main(String[] args) {
		//实例化接口
		userDao dao = new userDaoImpl();
		
		//查询案例 - 登陆
		dao.psLogin("WeiyiGeek", "123456" , 1);
		
		//ProPareStatement CRUD 实现演示
		//插入案例
		//dao.psInsert("Administrator", "123456");
		
		//更新案例
		dao.psUpdate("Admin",2);
		
		//删除案例
		dao.psDelete("Admin", "123456");
		
	}
}
