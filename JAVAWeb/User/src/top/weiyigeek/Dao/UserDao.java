package top.weiyigeek.Dao;

import java.sql.SQLException;
import java.util.List;

import top.weiyigeek.entity.UserInfo;

/**
 * ����:Dao ������û������������ݲ�ѯ��֤
 * ע��:��Ҫ����JDBC
 * @author WeiyiGeek
 *
 */
public interface UserDao {
	/**
	 * Desc:�û���¼��֤
	 * @return true or False
	 * @throws SQLException 
	 */

	boolean loginVerity(String name, String pass) throws Exception;
	List<UserInfo> infoQuery();
}
