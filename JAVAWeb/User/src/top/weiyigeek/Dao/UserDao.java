package top.weiyigeek.Dao;

import java.sql.SQLException;
import java.util.List;

import top.weiyigeek.entity.UserInfo;

/**
 * 描述:Dao 定义对用户相关请求的数据查询验证
 * 注意:需要集成JDBC
 * @author WeiyiGeek
 *
 */
public interface UserDao {
	/**
	 * Desc:用户登录验证
	 * @return true or False
	 * @throws SQLException 
	 */

	boolean loginVerity(String name, String pass) throws Exception;
	List<UserInfo> infoQuery();
}
