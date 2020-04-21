package top.weiyigeek.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import top.weiyigeek.dao.PersonDao;
import top.weiyigeek.main.Person;
import top.weiyigeek.utils.DB;

public class PersonDaoImpl implements PersonDao {

	/*
	 * Desc:���ز�ѯ��������Ա��Ϣ
	 */
	@Override
	public List<Person> findall() throws SQLException {
		QueryRunner runner = new QueryRunner(DB.getConn());
		return runner.query("SELECT * FROM person", new BeanListHandler<Person>(Person.class));
	}
	
	/*
	 * @Desc: ִ����Ա���������
	 */
	@Override
	public void insert(Person person) throws SQLException {
		QueryRunner runner = new QueryRunner(DB.getConn());
		int flag = runner.update("INSERT INTO person VALUES (NULL,?,?,?,?,?,?)", person.getSname(),person.getGender(),person.getTelephone(),person.getJob(),person.getInfo(),person.getJointime());
		if(flag > 0) {
			System.out.println("#����ɹ�");
		}else {
			System.out.println("#���ʧ��");
		}
	}

	/*
	 * @Desc: ִ����Աɾ������
	 */
	@Override
	public void delete(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(DB.getConn());
		int flag = runner.update("DELETE FROM person WHERE sid = ?", sid );
		if(flag > 0) {
			System.out.println("#ɾ���ɹ�");
		}else {
			System.out.println("#ɾ��ʧ��");
		}
	}

	/**
	 * @throws SQLException 
	 * @Desc �� ��IDΪ�������в���
	 */
	@Override
	public Person getInfoById(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(DB.getConn());
		return runner.query("SELECT * FROM person WHERE sid = ?", new BeanHandler<Person>(Person.class) ,sid);
	}

	/**
	 * @throws SQLException 
	 * @Desc:������Ա���޸�
	 */
	@Override
	public void updatePerson(Person person) throws SQLException {
		QueryRunner runner = new QueryRunner(DB.getConn());
		int flag = runner.update("UPDATE person SET sname = ?,gender = ?,telephone = ?, job = ? , jointime = ?, info = ? WHERE sid = ?", person.getSname(), person.getGender(),person.getTelephone(),person.getJob(),person.getJointime(),person.getInfo(),person.getSid());		
		if(flag > 0) {
			System.out.println("#���³ɹ�");
		}else {
			System.out.println("#����ʧ��");
		}
	}

	public List<Person> searchPerson(String sname, String gender) throws SQLException {
		QueryRunner runner = new QueryRunner(DB.getConn());
		//���1.����������Ա�ûѡ��ʱ��Ĭ����ʾȫ��
		String sql = "SELECT * FROM person WHERE 1 = 1";
		List<String> param = new ArrayList<String> (); //�������鼯��

// 		�жϴ���Ĳ����Ƿ�Ϊ��;
//		public static boolean isEmpty(CharSequence s){
//			return s==null || s.length() == 0;
//		}
		
		//�ж���û�������� ����У�����ƴ��sql�������
		if(sname.length()>0){
			sql = sql + "  and sname like ?";
			param.add("%"+sname+"%"); //ģ����ѯ����֮��
		}
		
		//�ж���û���Ա��еĻ�������ƴ��sql������档
		if(gender.length()>0){
			sql = sql + " and gender = ?";
			param.add(gender);
		}
		System.out.println("ִ�е�SQL: " + sql);
		runner.getDataSource().getLogWriter();
		return runner.query(sql , new BeanListHandler<Person>(Person.class) ,param.toArray());
	}
}
