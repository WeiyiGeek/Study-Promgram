package top.weiyigeek.dao;
/**
 * ��ҳ Dao ģ�ͽӿ�
 * @author WeiyiGeek
 */

import java.sql.SQLException;
import java.util.List;

import top.weiyigeek.main.Person;

public interface pagePersonDao {
	List<Person> pagePersonData (int page,int count) throws SQLException; 
	int dataCount() throws SQLException;
}
