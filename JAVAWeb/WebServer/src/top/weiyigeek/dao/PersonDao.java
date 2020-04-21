package top.weiyigeek.dao;

import java.sql.SQLException;
import java.util.List;

import top.weiyigeek.main.Person;

public interface PersonDao {
	//1.查询所有人员信息
	List <Person> findall() throws SQLException;
	
	//2.添加人员信息
	void insert(Person person) throws SQLException;

	//3.删除人员操作
	void delete(int sid) throws SQLException;

	//4.以id为条件进行查找操作
	Person getInfoById(int sid) throws SQLException;

	//5.更新人员操作
	void updatePerson(Person person) throws SQLException;
	
	//6.模糊查询
	List<Person> searchPerson(String sname, String gender) throws SQLException;
}
