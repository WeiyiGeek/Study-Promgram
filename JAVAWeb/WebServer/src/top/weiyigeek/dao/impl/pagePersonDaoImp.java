package top.weiyigeek.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import top.weiyigeek.dao.pagePersonDao;
import top.weiyigeek.main.Person;
import top.weiyigeek.utils.DB;

public class pagePersonDaoImp implements pagePersonDao {

	@Override
	public List<Person> pagePersonData(int page, int count) throws SQLException {
		QueryRunner runner = new QueryRunner(DB.getConn());
		//����1.��ʾ������������2����ʾ�ڼ�ҳ������(��offset����ʾǰ�������)
		return runner.query("SELECT * FROM person Limit ? offset ?", new BeanListHandler<Person>(Person.class),count, (page - 1) * count);
	}

	@Override
	public int dataCount() throws SQLException {
		QueryRunner runner = new  QueryRunner(DB.getConn());
		Long count = (Long)runner.query("SELECT COUNT(*) FROM person",new ScalarHandler());
		return count.intValue();
	}
}
