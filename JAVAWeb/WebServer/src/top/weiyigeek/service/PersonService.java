package top.weiyigeek.service;

import java.sql.SQLException;
import java.util.List;

import top.weiyigeek.main.Person;

/**
 * @Desc:��Ա��ҵ����淶-Service��
 * @author WeiyiGeek
 */
public interface PersonService {
	
	List <Person> findAll() throws SQLException;


	void delPerson(int sid) throws SQLException;
	
	void addPerson(Person person) throws SQLException;
	
	Person getInfoById(int sid) throws SQLException;

	void updatePerson(Person person) throws SQLException;

	List<Person> searchPerson(String sname, String gender) throws SQLException;
}
