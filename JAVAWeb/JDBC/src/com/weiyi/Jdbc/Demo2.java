package com.weiyi.Jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/** 验证 工具集  **/
public class Demo2 {
	public static void main(String[] args) {
		//JDB连接标准文档
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
				
		try {
			//Step1.注册驱动和建立连接
			JDBCUtil JDBC = new JDBCUtil("113.62.177.230",9001,"Demo");
			conn = JDBC.getConn();
			//Step2.创建Statement流
			st = conn.createStatement();
			//Step3.构造SQL语句
			String sql = "SELECT ID,NAME,BIR AS '出生日期' FROM Aggregate LIMIT 0,2";
			//Step4.执行SQL语句
			rs = st.executeQuery(sql);
			//Step5.获取结果集
			while(rs.next())
			{
				//注意:采用别名后获取columns字段也是采用别名
				System.out.println("ID = " + rs.getInt("ID") +", 姓名:" + rs.getString("NAME") + ", 出生日期:" + rs.getDate("出生日期"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, st, rs);
			System.out.println("成功释放资源完成！");
		}		
	}
	
	

}
