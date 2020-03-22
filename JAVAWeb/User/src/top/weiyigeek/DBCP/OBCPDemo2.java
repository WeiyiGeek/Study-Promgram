package top.weiyigeek.DBCP;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

/**
 * 
 * @Desc: OBCP读取配置文件来配置数据库连接
 * @author WeiyiGeek
 * @CreatTime 下午1:26:18
 */
public class OBCPDemo2 {
	
	@Test
	public void testDemo2() throws Exception {
		//1.利用Properties读取配置文件中数据
		Properties prop = new Properties();
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("dbcp.properties");  //将项目中的jdbc.properties读取进输入流
		prop.load(is);

		//2.构建连接对象
		BasicDataSourceFactory factory = new BasicDataSourceFactory();
		DataSource  datasource = factory.createDataSource(prop); //引入properties文件
		
		//3.得到连接对象
		Connection conn = datasource.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM user LIMIT 0,10");
		ResultSet rs = ps.executeQuery();
		
		//4.打印出来从数据库中读取的数据
		while(rs.next()) {
			System.out.println(rs.getInt("id") + " ---- " + rs.getString("name") +  " ---- " + rs.getInt("grade"));
		}
		
		//5.关闭连接
		System.out.println("连接关闭");
		rs.close();
		ps.close();
		conn.close();
	}
}
