package top.weiyigeek.dao;

import java.sql.SQLException;
import java.util.List;

import top.weiyigeek.main.Person;

public interface PersonDao {
	//1.��ѯ������Ա��Ϣ
	List <Person> findall() throws SQLException;
	
	//2.�����Ա��Ϣ
	void insert(Person person) throws SQLException;

	//3.ɾ����Ա����
	void delete(int sid) throws SQLException;

	//4.��idΪ�������в��Ҳ���
	Person getInfoById(int sid) throws SQLException;

	//5.������Ա����
	void updatePerson(Person person) throws SQLException;
	
	//6.ģ����ѯ
	List<Person> searchPerson(String sname, String gender) throws SQLException;
}
