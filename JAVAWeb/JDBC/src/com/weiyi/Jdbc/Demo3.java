package com.weiyi.Jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javafx.scene.control.SplitPane.Divider;

public class Demo3 {
	/**
	 * JDBC 连接参数采用 Properties配置文件进行导入
	 * @param args
	 */
	 //使用静态代码块读取属性(当类加载的时候执行)
	static String driverClass = null;
	static String url = null;
	static String user = null;
	static String pass = null;
	
	static {
		try {
			//Step1.创建一个属性配置对象
			Properties prop = new Properties();
		
			//Step2.打开配置文件
			//InputStream ins = new FileInputStream("jdbc.properties");
			InputStream ins = Demo3.class.getClassLoader().getResourceAsStream("jdbc.properties");

			//Step3.导入输入流
			prop.load(ins);
		
			//Step4.属性读取		
			driverClass = prop.getProperty("jdbc.driverClassName");
			url = prop.getProperty("jdbc.url");
			user = prop.getProperty("jdbc.username");
			pass = prop.getProperty("jdbc.password");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println(" - #ProPerties配置文件读取完成!");
		}
		
	}
	
	public static void main(String[] args) {
		//JDB连接标准文档
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//1.驱动注册
			Class.forName(driverClass); //实际上这句话都可以免了在JDBC4.0之后他会自动在jdbc.jar中元数据进行查看
			//2.建立连接
			conn = DriverManager.getConnection(url, user, pass);
			//3.建立statement对象
			st = conn.createStatement();
			//4.构建SQL语句并且执行
			rs = st.executeQuery("SELECT * FROM Persons WHERE (ID = 100)"); //Retrieve
			//5.获取数据
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData(); //获取源数据
			int len = rsmd.getColumnCount();  //字段梳理
			int count = 1;
			while(count <= len) {
				System.out.print(rsmd.getColumnName(count) + " | ");
				count++;
			}
			System.out.println("");
			while (rs.next()) {
				System.out.println(rs.getInt("ID") + "| " + rs.getString("LastName"));
			}
			
			//6.数据库的CRUD;
			String sql = "INSERT INTO Persons VALUE (NULL,'Weiyi')";  //主要Primary Key 插入主键的时候可以用null代替 
			int result = st.executeUpdate(sql); //该方法主要执行 INSERT, UPDATE or DELETE 等语句，返回影响的行数
			//如果返回值大于0则表明操作成功,否则失败;
			if(result > 0) {
				System.out.println("插入成功 : "+ sql);
			}else {
				System.out.println("插入失败");
			}
			
			// U :
			String sqlUpdate = "UPDATE Persons SET LastName = 'Whoami' WHERE ID = 100";
			result = st.executeUpdate(sqlUpdate);
			if(result > 0) {
				System.out.println("更新成功 : " + sqlUpdate);
			}else {
				System.out.println("更新失败");
			}
				
			
			// D:
			String sqlDelete = "DELETE FROM Persons WHERE LastName = 'Weiyi'";
			result = st.executeUpdate(sqlDelete);
			if( result > 0) {
				System.out.println("删除成功 : " + sqlDelete);
			}else {
				System.out.println("删除失败");
			}
				
				
			
		} catch (Exception e) {
			// TODO: handle exception
			
		} finally {
			//End.释放资源
			JDBCUtil.release(conn, st, rs);
		}
	}
}
