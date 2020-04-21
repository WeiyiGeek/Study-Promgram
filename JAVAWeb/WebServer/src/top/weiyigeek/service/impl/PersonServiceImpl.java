package top.weiyigeek.service.impl;

import java.sql.SQLException;
import java.util.List;

import top.weiyigeek.dao.PersonDao;
import top.weiyigeek.dao.impl.PersonDaoImpl;
import top.weiyigeek.main.Person;
import top.weiyigeek.service.PersonService;
/**
 * @Desc: �����ľ���ʵ�ִ���
 * @author WeiyiGeek
 */
public class PersonServiceImpl implements PersonService {

	@Override
	public List<Person> findAll() throws SQLException {
		PersonDao person = new PersonDaoImpl();  //��������ָ���������
		return person.findall(); //���ز�ѯ��������List����
	}
	
	@Override
	public void addPerson(Person person) throws SQLException {
		PersonDao addps = new PersonDaoImpl();
		addps.insert(person);
	}

	@Override
	public void delPerson(int sid) throws SQLException {
		// TODO Auto-generated method stub
		PersonDao delps = new PersonDaoImpl();
		delps.delete(sid);
	}

	@Override
	public Person getInfoById(int sid) throws SQLException {
		PersonDao delps = new PersonDaoImpl();
		return delps.getInfoById(sid);
	}

	@Override
	public void updatePerson(Person person) throws SQLException {
		PersonDao delps = new PersonDaoImpl();
		delps.updatePerson(person);
	}

	@Override
	public List<Person> searchPerson(String sname, String gender) throws SQLException {
		return new PersonDaoImpl().searchPerson(sname,gender);
	}

}
